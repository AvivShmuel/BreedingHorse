package content;

import java.sql.Time;
import java.util.Calendar;

import utils.Medal;

/**
 * Represents the properties and the methods of any assositiation calss -HorseInCompetition
 * @author user
 *
 */
public class HorseInCompetition {

	/**
	 * a Horse object
	 */
	private Horse horse;
	/**
	 * a Competition object
	 */
	private Competition competition;
	
	/**Total point of horse in competition**/
	private double totalPoints;
	
	/**The medal of the Horse in Competition**/
	private Medal medal;
	
	/** The finishing time of Horse in this Competition**/
	private Time finishingTime;
	
	/** The position in Competition of Horse**/
	private int positionNo;

	
	/**
	 * Full Constructor of HorseInCompetition object
	 * Set also the Medal to it deafult value (NONE)
	 * @param horse
	 * @param competition
	 * @param finishingTime
	 */
	
	public HorseInCompetition(Horse horse, Competition competition,
			 Time finishingTime) {
	
		this.setHorse(horse);
		this.setCompetition(competition);		
		this.setMedal(Medal.NONE);
		this.setFinishingTime(finishingTime);
		
	}
	

	/**
	 * partial constructor of HorseInCompetition object
	 * @param horse
	 * @param competition
	 */
	public HorseInCompetition(Horse horse, Competition competition) {
		this.setHorse(horse);
		this.setCompetition(competition);
		
		this.setMedal(Medal.NONE);
		
		Time temp=new Time(((long)(horse.hashCode()+competition.hashCode()+Math.random()*10)));
		//System.out.println(horse.getIdentifierSerial() +"  "+temp+ " C"+ competition.getSerialNum());
		this.setFinishingTime(temp);
	}


	public Horse getHorse() {
		return horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}

	public Medal getMedal() {
		return medal;
	}

	public void setMedal(Medal medal) {
		this.medal = medal;
	}

	public Time getFinishingTime() {
		return finishingTime;
	}

	public void setFinishingTime(Time finishingTime) {
		this.finishingTime = finishingTime;
	}

	public int getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}

	
	/**
	 * Checks if the primary keys of (competition and horse) is equal  to
	 * that of the given obj
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HorseInCompetition other = (HorseInCompetition) obj;
		if (competition == null) {
			if (other.competition != null)
				return false;
		} else if (!competition.equals(other.competition))
			return false;
		if (horse == null) {
			if (other.horse != null)
				return false;
		} else if (!horse.equals(other.horse))
			return false;
		return true;
	}

	/**
	 * computes the hash code using the primary keys of both competition and horse objects
	 */
	public int hashCode() {

		return 31 * (7 + ((horse == null) ? 0 : horse.hashCode()))
				+ (7 + ((competition == null) ? 0 : competition.hashCode()));

	}
	
	

}
