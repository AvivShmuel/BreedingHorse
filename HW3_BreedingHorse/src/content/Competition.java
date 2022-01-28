package content;

import java.util.*;

import utils.HorseInCompetitionByFinishingTime;
import utils.Medal;
import utils.Rank;
import utils.Typee;

/**
 * Represents the properties and the methods of any Competition
 * @author Administrator
 * 
 */
public class Competition {

	/** 
	 * The primary key of Competition is serialNum and typee 
	 **/
	private Integer serialNum;
	
	/** 
	 * The typee of this Competition 
	 **/
	private Typee typee;
	
	/**
	 *  The Horse object that win this Competition
	  **/
	private Horse winner;
	
	/** 
	 * The place that this competition is held
	**/
	private String placeOfCompetitions;
	
	/** 
	 * The start date of this Competition 
	 **/
	private Date startDate;
	
	/**
	 * The level of this competition the level could be 1 or 2 or 3
	 **/
	private short level;
	
	/**
	 * The Collection<Set>of bets on Horses of this competitions by bookmaker
	 * and gamblers
	 **/
	private Set<GamblingBetsForCompetition> bookmakerBets;
	
	/** 
	 * The Collection<Set>of Horses of this Competitions 
	 **/
	private Set<HorseInCompetition> participants;

	/**
	 * The Full Constructor of Competition Object
	 * 
	 * @param serialNum
	 * @param placeOfCompetitions
	 * @param typee
	 * @param startDate
	 * @param level
	 */
	public Competition(int serialNum, String placeOfCompetitions, Typee typee,
			Date startDate, short level) {
		this.setSerialNum(serialNum);
		this.setPlaceOfCompetitions(placeOfCompetitions);
		this.setType(typee);
		this.setStartDate(startDate);
		this.setLevel(level);
		this.participants = new HashSet<HorseInCompetition>();
		this.bookmakerBets = new HashSet<GamblingBetsForCompetition>();
	}

	/**
	 * The partial constructor of Competition object
	 * 
	 * @param serialNum
	 * @param typee
	 */
	public Competition(int serialNum, Typee typee) {
		this.setSerialNum(serialNum);
		this.setType(typee);
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public short getLevel() {
		return level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Typee getType() {
		return typee;
	}

	public void setType(Typee typee) {
		this.typee = typee;
	}

	public Set<GamblingBetsForCompetition> getBookmakerBets() {
		return bookmakerBets;
	}

	public Set<HorseInCompetition> getParticipants() {
		return participants;
	}

	public Horse getWinner() {
		return winner;
	}

	private void setWinner(Horse winner) {
		this.winner = winner;
	}

	public String getPlaceOfCompetitions() {
		return placeOfCompetitions;
	}

	public void setPlaceOfCompetitions(String placeOfCompetitions) {
		this.placeOfCompetitions = placeOfCompetitions;
	}

	/**
	 * Returns the Primary key of Competition object
	 * 
	 * @return primary key
	 */
	public String getPrimaryKey() {
		return this.getSerialNum() + this.getType().toString();
	}

	/**
	 * Calculates the winner horse by using a PriorityQueue on the finishing
	 * time field (the horse with the smallest finishing time is the winner so
	 * he must get a gold medal and his position must be 1 and so on)
	 * The method also updates the position number of each Horse in this Competition 
	 * and update Medal for evrey horse
	 * 
	 * The method updates also the total points for evrey horse by the follwing rule:
	 *  
	 * The winner horse (the horse with the smallest finishing time) got 100 points
	 * The second horse got 5% lower than the winner horse points 
	 * The third horse got 5% lower than the second horse points and so on 
	 * 
	 * 
	 */
	
	private void calculateWinner() {
		
		PriorityQueue<HorseInCompetition> pQ = new PriorityQueue<HorseInCompetition>(1,
				new HorseInCompetitionByFinishingTime());
		
		pQ.addAll(getParticipants());
		
		Set<HorseInCompetition> tempParticipants = new HashSet<HorseInCompetition>();
		
		double beforePoints = 0;
		int position = 0;
		
		while (!pQ.isEmpty()) {
			
			HorseInCompetition hic = pQ.poll();
			hic.setPositionNo(++position);
			hic.setTotalPoints(100 - (beforePoints * 0.05));
			beforePoints = hic.getTotalPoints();
			switch (position) {
			case 1:
				hic.setMedal(Medal.GOLD);
				this.setWinner(hic.getHorse());
				break;
			case 2:
				hic.setMedal(Medal.SILVER);
				break;
			case 3:
				hic.setMedal(Medal.BRONZE);
				break;
			default:
				hic.setMedal(Medal.NONE);
			}
			tempParticipants.add(hic);
		}
		getParticipants().clear();
		getParticipants().addAll(tempParticipants);
		tempParticipants = null;
		pQ = null;
		//System.out.println("Win "+ getWinner().getIdentifierSerial()+" in: "+ this.getSerialNum());
	}

	/**
	 * Checks if the primary key (serialNum and typee) is equal to to that of the
	 * given obj
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Competition))
			return false;
		Competition other = (Competition) obj;
		if (serialNum == null) {
			if (other.serialNum != null)
				return false;
		} else if (!serialNum.equals(other.serialNum))
			return false;
		if (typee == null) {
			if (other.typee != null)
				return false;
		} else if (!typee.equals(other.typee))
			return false;
		return true;
	}

	/**
	 * returns the hashCode of Competition by primary keys fields
	 * 
	 * */
	public int hashCode() {

		return 31 * (7 + ((serialNum == null) ? 0 : serialNum.hashCode()))
				+ (7 + ((typee == null) ? 0 : typee.hashCode()));

	}
	
	
	
	
	
	
	
	

	/**
	 * Checks the horse fitness. There are conditions participating in a competition:
	 * 
	 * Participating in a competition of typee SHOW_JUMPING:
	 * Only for horses above the age of one year with and Equestrian with a JUNIOR rank 
	 * 
	 * Participating in a competition of typee CROSS_COUNTRY: opened for all horses
	 * 
	 * Participating in a competition of typee BARELL:
	 * Only for a horse with age of less than one year and Equestrian with a MASTER or EXPERT rank 
	 * 
	 * Participating in a competition of typee TROT:
	 * Only for a horse that his trainer has a success rate above 300 points
	 * 
	 * Participating in a competition of typee GALLOP:
	 * Only for a horse that his trainer's rank is JUNIOR, BEGGINER or PUNK 
	 * 
	 * @param horse
	 * @return true if the Horse Fitness is OK otherwise returns false
	 */
	public boolean checkHorseFitness(Horse horse) {

		if (this.getType().equals(Typee.SHOW_JUMPING)
				&& horse.calculateHorseAge() > 1
				&& horse.getEquestrian().getRank().equals(Rank.JUNIOR)) {
			return true;
			
		} else if (this.getType().equals(Typee.BARELL)
				&& horse.calculateHorseAge() < 1
				&& (horse.getEquestrian().getRank().equals(Rank.MASTER) || horse
						.getEquestrian().getRank().equals(Rank.EXPERT))) {
			return true;

		} else if (this.getType().equals(Typee.TROT)
				&& horse.getTrainer().getSuccessRate() >= 300) {
			return true;
			
		} else if (this.getType().equals(Typee.GALLOP)
				&& (horse.getTrainer().getRank().equals(Rank.JUNIOR)
						|| horse.getTrainer().getRank().equals(Rank.BEGGINER) || horse
						.getTrainer().getRank().equals(Rank.PUNK))) {
			return true;

		} else if (this.getType().equals(Typee.CROSS_COUNTRY)) {
			return true;
		}
		return false;

	}

	/**
	 * Adds a Horse to Competition if and only if the Horse is Fitted to
	 * the Competition conditions. It also updates the winner filed. 
	 * 
	 * @param hic
	 * @return true if succeed otherwise returns false
	 */
	public boolean addHorseToCompetition(HorseInCompetition hic) {
		
		if (this.checkHorseFitness(hic.getHorse())
				&& this.getParticipants().add(hic)) {
			this.calculateWinner();
			return true;

		}
		return false;
	}
	
	
	

	/**
	 * Removes a Horse from a Competition. It also updates the winner filed. 
	 * 
	 * @param hic
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeHorseFromCompetition(HorseInCompetition hic) {
		
		if (this.getParticipants().remove(hic)) {
			this.calculateWinner();
			return true;
		}
		return false;
	}

	
	/**
	 * Adds a new bet of a Bookmaker for a Gambler to this Competition
	 * 
	 * @param gbfc
	 * @return true if succeed otherwise returns false
	 */
	public boolean addBetToCompetition(GamblingBetsForCompetition gbfc) {
		return this.bookmakerBets.add(gbfc);
	}

	/**
	 * Removes a bet of a Bookmaker for a Gambler from this Competition
	 * 
	 * @param gbfc
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeBetFromCompetition(GamblingBetsForCompetition gbfc) {
		return this.bookmakerBets.remove(gbfc);
	}

	/**
	 * @return a string containing the details of the object 
	 */
	public String toString() {
		return "\nThe Competition serialNum is: " + this.getSerialNum()
				+ "\nThe Competition typee is: " + this.getType().toString()
				+ "\nThe Competition level is: " + this.getLevel()
				+ "\nThe Competition place is: "
				+ this.getPlaceOfCompetitions()
				+ "\nThe Competition start date is: "
				+ this.getStartDate().toString();
	}

}
