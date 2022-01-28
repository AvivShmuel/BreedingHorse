package content;

import utils.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents the properties and the methods of any Veterinarian
 * 
 * @author user
 * 
 */
public class Veterinarian extends Employee {

	private int totalTreatmentHours;
	private Genre mostHorseGenre;
	private ArrayList<Horse> vHorses;

	/**
	 * Full Constructor of Veterinarian
	 * 
	 * @param id
	 * @param fullName
	 * @param bithDate
	 * @param serialId
	 * @param salary
	 * @param totalTreatmentHours
	 * 
	 */
	public Veterinarian(String id, String fullName, Date bithDate,
			String serialId, double salary, int totalTreatmentHours) {
		super(id, fullName, bithDate, serialId, salary);
		vHorses = new ArrayList<Horse>();
		this.setTotalTreatmentHours(totalTreatmentHours);
		this.setMostHorseGenre(Genre.UNKNOWN);
	}

	/**
	 * Partial Constructor of Veterinarian
	 * 
	 * @param id
	 * @param serialId
	 */
	public Veterinarian(String id, String serialId) {
		super(id, serialId);
	}

	/**
	 * 
	 * @return the number of horses that this Veterinarian treats
	 */
	public int getHorsesCount() {
		return vHorses.size();
	}

	/**
	 * @return the totalTreatmentHours
	 */
	public int getTotalTreatmentHours() {
		return totalTreatmentHours;
	}

	/**
	 * @param totalTreatmentHours
	 *            the totalTreatmentHours to set
	 */
	public void setTotalTreatmentHours(int totalTreatmentHours) {
		this.totalTreatmentHours = totalTreatmentHours;
	}

	/**
	 * @return the mostHorseGenre
	 */
	public Genre getMostHorseGenre() {
		return mostHorseGenre;
	}

	/**
	 * @param mostHorseGenre
	 *            the mostHorseGenre to set
	 */
	public void setMostHorseGenre(Genre mostHorseGenre) {
		this.mostHorseGenre = mostHorseGenre;
	}

	/**
	 * Adds Horse to veterinarian horses-array
	 * 
	 * @param horse
	 * @return true if succeed otherwise returns false
	 */
	public boolean addHorse(Horse horse) {
		if(!vHorses.contains(horse)) {
			vHorses.add(horse);
			this.updateMostHorseGenre();
			return true;
		}
		return false;
	}

	/**
	 * Removes horse from veterinarian horses-array
	 * 
	 * @param horse
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeHorse(Horse horse) {
		if(vHorses.contains(horse)) {
			vHorses.remove(horse);
			this.updateMostHorseGenre();
			return true;
		}
		return false;
	}

	
	/**
	 * Updates most caring genre for this veterinarian
	 */
	private void updateMostHorseGenre() {

		int bestGenreCount = 0;
		int tempCount;

		for (Genre g : Genre.values()) {

			tempCount = 0;

			for (Horse h : vHorses) {
				if (h != null) {
					if (h.getGenre().equals(g)) {
						tempCount++;
					}
				}
			}

			if (tempCount > bestGenreCount) {
				bestGenreCount = tempCount;
				this.setMostHorseGenre(g);
			}
		}

		if (bestGenreCount == 0) {
			this.setMostHorseGenre(Genre.UNKNOWN);
		}

	}

	/**
	 * @return a string containing the details of the object
	 */
	public String toString() {
		return "Veterinarian details:\n" + super.toString()
				+ "\nMost Horses Genre: " + this.getMostHorseGenre().toString()
				+ "\nTotal treatment hours: " + +this.getTotalTreatmentHours();

	}

	
}
