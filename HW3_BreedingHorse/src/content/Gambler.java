package content;

import java.util.Date;
import java.util.Iterator;

import utils.Gainable;
import utils.Medal;

/**
 * Represents the properties and the methods of any Gambler
 * @author user
 *
 */
public class Gambler extends Person implements Gainable{

	/** The Class Primary Key is super class primary key id **/
	/** Account of this Gambler **/
	private double account;
	
	/** The GamblingBetsForCompetition Object of Gambler **/
	private GamblingBetsForCompetition betsInCompetition;
	
	/** Total gambler gain from his Bets **/
	private double gain;

	/**
	 * Full Constructor of Gambler Object
	 * 
	 * @param id
	 * @param fullName
	 * @param bithDate
	 * @param account
	 */
	public Gambler(String id, String fullName, Date bithDate, double account) {
		super(id, fullName, bithDate);
		setAccount(account);
		this.setGain(0);
	}

	/**
	 * The partial Constructor of Gambler Object
	 * 
	 * @param id
	 */
	public Gambler(String id) {
		super(id);

	}

	/**
	 *Calculates he gain for this Gambler by the following rules: 
	 * 
	 * 1) If the betHorse came at the first position then the gambler got his bet * 10
	 *  
	 * 2) If the betHorse came at the second position then  the gambler got his bet * 5 
	 * 
	 * 3) If the betHorse came at the third position then the gambler got his bet * 2 
	 * 
	 * 4) Otherwise the gambler lose only his bet from his amount. 
	 * 
	 * It also updates the gambler account after evrey winning and losing
	 * 
	 * The Account updated as: 
	 * Account= current gambler Account + allGain from all Competitions
	 */
	public void calculateGain() {
		
		Horse betHorse = this.getBetsInCompetition().getBetsHorse();
		
		Competition competition = this.getBetsInCompetition().getCompetition();
		
		if (competition.getWinner().equals(betHorse)) {
			this.setGain(this.getBetsInCompetition().getBetAmount() * 10);
			this.setAccount(getAccount() + getGain());
		} else {
			
			Iterator<HorseInCompetition> horseIterator = competition
					.getParticipants().iterator();
			while (horseIterator.hasNext()) {
				HorseInCompetition hic = horseIterator.next();
				Horse raceHorse = hic.getHorse();
				if (raceHorse.equals(betHorse)) {
					Medal horseMedal = hic.getMedal();
					
					if (horseMedal.equals(Medal.NONE)) {
						
						this.setGain(getGain()-getBetsInCompetition().getBetAmount());
						this.setAccount(getAccount()-getBetsInCompetition().getBetAmount());
					
					} else if (horseMedal.equals(Medal.BRONZE)) {
						this
								.setGain(this.getBetsInCompetition()
										.getBetAmount() * 5);
						this.setAccount(getAccount() + getGain());

					} else if (horseMedal.equals(Medal.SILVER)) {
						this
								.setGain(this.getBetsInCompetition()
										.getBetAmount() * 2);
						this.setAccount(getAccount() + getGain());

					} 
				}
			}
		}
	}

	public double getGain() {
		return gain;
	}

	private void setGain(double gain) {
		this.gain = gain;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public GamblingBetsForCompetition getBetsInCompetition() {
		return betsInCompetition;
	}

	private void setBetsInCompetition(
			GamblingBetsForCompetition betsInCompetition) {
		this.betsInCompetition = betsInCompetition;
	}

	/**
	 * Adds GamblingBetsForCompetition to this Gambler object
	 * if adds succed then calculate also the gain of this Gambler
	 * 
	 * @param gamblingBetsForCompetition
	 * @return true if succeed otherwise returns false
	 */
	public boolean addBetsInCompetition(GamblingBetsForCompetition gamblingBetsForCompetition) {
		
		if(this.checkGamblerFitness(gamblingBetsForCompetition.getCompetition().getLevel())){
		this.setBetsInCompetition(gamblingBetsForCompetition);
		this.calculateGain();
		return true;
		}
		return false;
	}

	/**
	 * Removes GamblingBetsForCompetition from Gambler object
	 * and updates also the gain fieldand the Account fileds of this Gambler
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeBetsInCompetition() {
		
		if(getBetsInCompetition()!=null){
			this.setGain(getGain()- getBetsInCompetition().getBetAmount());
			this.setAccount(getAccount()-this.getGain());
			this.setBetsInCompetition(null);
			return true;
		}
		return false;
		
	}

	/**
	 * checks if this Gambler can gambling on a specific Competition according to the following rules:
	 * 
	 * If the level of the competition is 1 then the account must be >= 1000. 
	 * If the level of the competition is 2 then the account must be >= 2000. 
	 * If the level of the competition is 2 then the account must be >= 3000. 
	 * 
	 * @param level is the level
	 * @return true if the gambler is ansewring any of the condition, otherwise return false 
	 */
	private boolean checkGamblerFitness(short level) {
		if (level == 1 && this.account >= 1000) {
			return true;
		} else if (level == 2 && this.account >= 2000) {
			return true;
		} else if (level == 3 && this.account >= 3000) {
			return true;
		}
		return false;
	}

	/**
	 * @return a string containing the details of the object
	 */
	public String toString() {
		return super.toString() + "\nThe Gambler account is: "
				+ this.getAccount() + "NIS\nThe Gambler gain is: "
				+ this.getGain() + "NIS";
	}

}
