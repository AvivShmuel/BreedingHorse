package content;

import utils.*;

import java.sql.Time;
import java.util.Date;

/**
 * Represents the properties and the methods of any Equestrian
 * @author user
 *
 */
public class Equestrian extends Person {

	/**
	 * rank of this Equestrian
	 */
	private Rank rank;
	
	/**
	 * equestHours total riding on a horse
	 */
	private Time equestHours;
	
	/**
	 * the Equestrian's horse
	 */
	private Horse horse;

	/**
	 * Full Constructor for Equestrian object
	 * @param id
	 * @param fullName
	 * @param bithDate
	 * @param rank
	 * @param equestHours
	 */
	public Equestrian(String id, String fullName, Date bithDate, Rank rank
			,Time equestHours) {
		super(id, fullName, bithDate);
		this.setRank(rank);
		
		
	}

	/**
	 * Partial Constructor for Equestrian object
	 * @param id
	 * 
	 * 
	 */
	public Equestrian(String id) {
		super(id);		
	}
	
	/**
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	
	public Time getEquestHours() {
		return equestHours;
	}

	public void setEquestHours(Time equestHours) {
		this.equestHours = equestHours;
	}
	
	/**
	 * @return the horse
	 */
	public Horse getHorse() {
		return horse;
	}

	/**
	 * @param horse the horse to set
	 */
	private  void setHorse(Horse horse) {
		
		this.horse = horse;
	}

	/**
	 * Add Horse to Equestrian object
	 * @param horse
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean addHorse(Horse horse) {
		if (this.getHorse() == null) {
			this.setHorse(horse);
			return true;
		}
		return false;
	}

	/**
	 * Removes horse from Equestrian object
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean removeHorse() {
		if (this.getHorse() != null) {
			this.setHorse(null);
			return true;
		}
		return false;
	}
	
	
	/**
	 * @return a string containing the details of the object 
	 */
	public String toString() {
		if (this.getHorse() != null) {
			return "Equestrian details:\n"+super.toString()
					+ "\nHorse name:"
					+ this.getHorse().getNickName()
					+ "\nRank: "
					+ this.getRank().toString();
		}

		return "Equestrian details:\n"+ super.toString()
				+ "\nHorse name: currently does not have a horse"				
				+ "\nRank: " + this.getRank().toString();

	}
	
}
