package content;

import java.util.*;

import utils.Gainable;
import utils.Medal;

/**
 * Represents the properties and the methods of any BookMaker
 * @author Administrator
 * 
 */
public class BookMaker extends Person implements Comparable<BookMaker>,Gainable {

	/** The Primary key of BookMaker is licenseNo and Id **/
	private String licenseNo;
	
	/** The percent that BookMaker get for his Job from Bet **/
	private double percentToBet;
	
	/**
	 * The Collection <Set> of Bets of Specific BookMaker on specific
	 * Competition from Specific Gambler
	 **/
	private Set<GamblingBetsForCompetition> gamblers;
	
	/**
	 * The gain of bookMaker The gain is calculating field
	 **/
	private double gain;

	/**
	 * The Full Constructor of BookMaker Object
	 * 
	 * @param licenseNo
	 * @param id
	 * @param fullName
	 * @param bithDate
	 * @param percentToBet
	 */
	public BookMaker(String licenseNo, String id, String fullName,
			Date bithDate, double percentToBet) {
		super(id, fullName, bithDate);
		this.setLicenseNo(licenseNo);
	
		setPercentToBet(percentToBet);
		this.gamblers = new HashSet<GamblingBetsForCompetition>();
		this.setGain(0);
	}

	/**
	 * The Partial Constructor of BookMaker Object
	 * 
	 * @param licenseNo
	 * @param id
	 */
	public BookMaker(String licenseNo, String id) {
		super(id);
		this.setLicenseNo(licenseNo);
	}

	/**
	 * Calculates the gain of the BookMaker from gambling 
	 * 
	 * 1) If the bet Horse come first the gain calculated as betAmount * percentToBet * 3.5 
	 * 2) If the bet Horse come second the gain calculated as betAmount * percentToBet * 2.5 
	 * 3) If the bet Horse come third the gain calculated as betAmount * percentToBet * 1.5 
	 * 4) Otherwise the gain calculating from betAmount * percentToBet
	 */
	public void calculateGain() {
		
		Iterator<GamblingBetsForCompetition> itr = this.gamblers.iterator();
		
		while (itr.hasNext()) {
			GamblingBetsForCompetition temp = itr.next();
			Competition competition = temp.getCompetition();
			Horse betHorse = temp.getBetsHorse();
			if (competition.getWinner().equals(betHorse)) {
				this.setGain(this.getGain()
						+ (temp.getBetAmount() * this.getPercentToBet())* 3.5);
				break;
			}
			
			Iterator<HorseInCompetition> horseIterator = competition.getParticipants().iterator();
			
			while (horseIterator.hasNext()) {
				
				HorseInCompetition hic = horseIterator.next();
				Horse raceHorse = hic.getHorse();
				
				if (raceHorse.equals(betHorse)) {
					Medal horseMedal = hic.getMedal();
					if (horseMedal.equals(Medal.NONE)) {
						
						this.setGain(this.getGain()
								+ (itr.next().getBetAmount() * this
										.getPercentToBet()));
					} 
					 else if (horseMedal.equals(Medal.SILVER)) {
							
							this.setGain(this.getGain()
									+ (itr.next().getBetAmount() * this
											.getPercentToBet()) * 2.5);
					}
					else if (horseMedal.equals(Medal.BRONZE)) {
						
						this.setGain(this.getGain()
								+ (itr.next().getBetAmount() * this
										.getPercentToBet()) * 1.5);

					}
				}
			}

		}

	}

	/**
	 *Get the Primary key of BookMaker object
	 */
	public String getPrimaryKey() {
		return this.getId() + this.getLicenseNo();
	}

	/**
	 * @return the licenseNo
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * @param licenseNo
	 *            the licenseNoto set
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
	 * @return the Set of GamblingBetsForCompetition
	 */
	public Set<GamblingBetsForCompetition> getGamblers() {
		return gamblers;
	}

	/**
	 * @return the gain
	 */
	public double getGain() {
		return gain;
	}

	/**
	 * @param gain
	 *            the gain to set
	 */
	private void setGain(double gain) {
		this.gain = gain;
	}

	
	/**
	 * @return the percentToBet
	 */
	public double getPercentToBet() {
		return percentToBet;
	}

	/**
	 * @param percentToBet
	 *            the percentToBet to set
	 */
	public void setPercentToBet(double percentToBet) {
		this.percentToBet = percentToBet;
	}

	

	/**
	 * 
	 * Adds the GamblingBetsForCompetition object to GamblingBetsForCompetition Collection 
	 * and updates the gain field of this BookMaker
	 * @param gbfc
	 * @return true if succeed otherwise returns false
	 */
	public boolean addBetToBookMaker(GamblingBetsForCompetition gbfc) {
		
		if(this.gamblers.add(gbfc)){
			this.calculateGain();
			return true;
		}
		
		return false;
	}

	/**
	 * Removes the GamblingBetsForCompetition object from GamblingBetsForCompetition Collection
	 * and updates the gain field of this BookMaker
	 * @param gbfc
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeBetFromBookMaker(GamblingBetsForCompetition gbfc) {
		
		if( this.gamblers.remove(gbfc)){
			this.calculateGain();
			return true;
		}
		return false;

	}


	/**
	 * overrides the compareTo method by comparing the primary fields
	 */
	@Override
	public int compareTo(BookMaker bookMaker) {
		
		int comp = getId().compareTo(bookMaker.getId());
		if (comp != 0)
			return comp;
		return getLicenseNo().compareTo(bookMaker.getLicenseNo());
	}
	
	/**
	 * Checks if the primary key (licenseNo and id) is equal to that of the
	 * given obj
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BookMaker))
			return false;
		BookMaker other = (BookMaker) obj;
		if (licenseNo == null) {
			if (other.licenseNo != null)
				return false;
		} else if (!licenseNo.equals(other.licenseNo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 *returns the hashcode of given object by primary fields
	 */
	public int hashCode() {

		return 31 * (7 + ((licenseNo == null) ? 0 : licenseNo.hashCode()))
				+ (7 + ((id == null) ? 0 : id.hashCode()));

	}
	
	
	/**
	 * @return a string containing the details of the object
	 */
	public String toString() {
		return super.toString() + "\nThe BookMaker licenseNo is: "
				+ this.getLicenseNo() + "\nThe BookMaker Maximum Bet is: "
				+ "\nThe BookMaker persent to bet is: "
				+ this.getPercentToBet() + "%\nThe BookMaker gain is: "
				+ this.getGain();
	}
}
