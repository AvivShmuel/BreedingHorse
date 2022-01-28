package content;

import utils.*;

import java.util.ArrayList;
import java.util.Date;


/**
 * Represents the properties and  methods of any Trainer
 * 
 * @author user
 * 
 */
public class Trainer extends Employee {

	private Rank rank;
	private int totalWinnerHorses;
	private double successRate;
	private ArrayList<Horse> horses;

	/**
	 * Full constructor for Trainer
	 * 
	 * @param id
	 * @param fullName
	 * @param bithDate
	 * @param workerId
	 * @param salary
	 * @param rank
	 * 
	 */
	public Trainer(String id, String fullName, Date bithDate, String workerId,
			double salary, Rank rank) {
		super(id, fullName, bithDate, workerId, salary);
		horses = new ArrayList<Horse>();
		this.setRank(rank);
		this.setTotalWinnerHorses(0);

	}

	/**
	 * Partial constructor of Trainer
	 * 
	 * @param id
	 * @param serialId
	 * 
	 */
	public Trainer(String id, String serialId) {
		super(id, serialId);
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

	/**
	 * @return the totalWinnerHorses
	 */
	public int getTotalWinnerHorses() {
		return totalWinnerHorses;
	}

	/**
	 * @param totalWinnerHorses  the totalWinnerHorses to set
	 */
	private void setTotalWinnerHorses(int totalWinnerHorses) {
		this.totalWinnerHorses = totalWinnerHorses;
		updateSuccessRate();
	}

	/**
	 * update Success Rate of Trainer
	 */
	private void updateSuccessRate() {
		int horseCount = getHorsesCount();
		if (horseCount != 0)
			setSuccessRate(((double) getTotalWinnerHorses() / horseCount) * 100);

	}

	/**
	 * Updates the total winner horses
	 * Count the number of horses that got a medal (Not NONE)
	 * then updates the totalWinnerHorses field
	 */
	public  void updateTotalWinnerHorses() {
		// TODO complete the implementation of this method.
		int countWinHorses=0;
		for (Horse h : horses) {
			if (h!=null&& h.getEquestrian() != null && h.getCompetitions() != null) {
				for(HorseInCompetition hic: h.getCompetitions())
					if (!hic.getMedal().equals(Medal.NONE)) {
						countWinHorses++;
				}
			}
		}
		this.setTotalWinnerHorses(countWinHorses);

	}

	/**
	 * Gets the total number of horses of this Trainer
	 * 
	 * @return total number of horses
	 */
	public int getHorsesCount() {
		int horseCount = 0;
		for (Horse h : horses)
			if (h != null)
				horseCount++;
		return horseCount;
	}

	/**
	 * @return the successRate
	 */
	public double getSuccessRate() {
		return successRate;
	}

	/**
	 * @param successRate the successRate to set
	 */
	private void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}

	/**
	 * Add Horse to trainer horses-array
	 * 
	 * @param horse
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean addHorse(Horse horse) {

		for (Horse horse2 : horses) {
			if (horse2.equals(horse))
				return false;
		}
		
		horses.add(horse);
		updateTotalWinnerHorses();
		updateSuccessRate();			
		return true;

	}

	

	/**
	 * Removes horse from trainer horse-array
	 * 
	 * @param horse
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean removeHorse(Horse horse) {
		
		if(horses.remove(horse)) {
			updateTotalWinnerHorses();
			updateSuccessRate();				
			return true;
		}
		
		return false;
	}

	/**
	 * @return a string containing the details of the object
	 */
	public String toString() {
		return "Trainer details:\n" + super.toString() + "\nRank: "
				+ this.getRank().toString() + "\nSuccess rate: "
				+ this.getSuccessRate() + " points" + "\nTotal winner horses: "
				+ this.getTotalWinnerHorses();
	}
	

}
