package content;

import java.awt.Color;
import java.util.*;
import java.text.SimpleDateFormat;

import utils.Constants;
import utils.Genre;
import utils.Medal;

/**
 * Represents the properties and the methods of any Horse
 * 
 * @author user
 * 
 */
public class Horse {

	/**
	 * primary key
	 */
	private String identifierSerial;
	
	/**
	 * primary key
	 */
	private String nickName;

	/**
	 * birthDate of this Horse
	 */
	private Date birthDate;
	
	/**
	 * weight of this Horse
	 */
	private double weight;
	
	/**
	 * gender of this Horse
	 */
	private char gender;
	
	/**
	 * Color of this Horse
	 */
	private Color hColor;
	
	/**
	 * price of this Horse
	 */
	private double price;
	
	/**
	 * genre of this Horse
	 */
	private Genre genre;
	
	/**
	 * revenue of this Horse
	 */
	private double revenue;
	
	/**
	 * totalParticipatesTimes of this Horse (a computed field)
	 */
	private int totalParticipatesTimes;
	
	/**
	 * popularityRate of this Horse (a computed field)
	 */
	private double popularityRate;

	/**
	 * trainer of this Horse
	 */
	private Trainer trainer;
	
	/**
	 * Veterinarians of this Horse
	 */
	private Veterinarian[] veterinarians;
	
	/**
	 * equestrian of this Horse
	 */
	private Equestrian equestrian;
	
	/**
	 * competitions that this Horse participates
	 */
	private Set<HorseInCompetition> competitions;

	
	/**
	 * Full Constructor for Horse Object
	 * 
	 * @param identifierSerial
	 * @param nickName
	 * @param birthDate
	 * @param weight
	 * @param gender
	 * @param color
	 * @param price
	 * @param genre
	 * @param revenue
	 * @param totalParticipatesTimes
	 * 
	 */
	public Horse(String identifierSerial, String nickName, Date birthDate,
			double weight, char gender, Color color, double price, Genre genre,
			double revenue, int totalParticipatesTimes) {
		setIdentifierSerial(identifierSerial);
		setNickName(nickName);
		setBirthDate(birthDate);
		setWeight(weight);
		setGender(gender);
		sethColor(color);
		setGenre(genre);
		setPrice(price);
		setRevenue(revenue);
		setTotalParticipatesTimes(totalParticipatesTimes);
		veterinarians = new Veterinarian[Constants.MAX_VETERINARIAN_PER_HORSE];
		this.competitions = new HashSet<HorseInCompetition>();
	}
	public Horse(String identifierSerial, String nickName, Date birthDate,
			double weight, char gender, double price, Genre genre,
			double revenue, int totalParticipatesTimes) {
		setIdentifierSerial(identifierSerial);
		setNickName(nickName);
		setBirthDate(birthDate);
		setWeight(weight);
		setGender(gender);
		setGenre(genre);
		setPrice(price);
		setRevenue(revenue);
		setTotalParticipatesTimes(totalParticipatesTimes);
		veterinarians = new Veterinarian[Constants.MAX_VETERINARIAN_PER_HORSE];
		this.competitions = new HashSet<HorseInCompetition>();
	}

	/**
	 * Partial constructor for Horse object
	 * 
	 * @param identifierSerial
	 * @param nickName
	 * 
	 */
	public Horse(String identifierSerial, String nickName) {
		super();
		setIdentifierSerial(identifierSerial);
		setNickName(nickName);
	}

	
	public Color getHColor() {
		return hColor;
	}

	public void setHColor(Color color) {
		hColor = color;
	}

	public Set<HorseInCompetition> getCompetitions() {
		return competitions;
	}

	/**
	 * @return the identifierSerial
	 */
	public String getIdentifierSerial() {
		return identifierSerial;
	}

	/**
	 * @param identifierSerial
	 *            the identifierSerial to set
	 */
	public void setIdentifierSerial(String identifierSerial) {
		this.identifierSerial = identifierSerial;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * @return the hColor
	 */
	public Color gethColor() {
		return hColor;
	}

	/**
	 * @param hColor
	 *            the hColor to set
	 */
	public void sethColor(Color hColor) {
		this.hColor = hColor;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
		updatePopularityRate();
	}

	/**
	 * @return the revenue
	 */
	public double getRevenue() {
		return revenue;
	}

	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(double revenue) {
		this.revenue = revenue;
		updatePopularityRate();
	}

	/**
	 * @return the totalParticipatesTimes
	 */
	public int getTotalParticipatesTimes() {
		return totalParticipatesTimes;
	}

	/**
	 * @param totalParticipatesTimes the totalParticipatesTimes to set
	 */
	private void setTotalParticipatesTimes(int totalParticipatesTimes) {
		this.totalParticipatesTimes = totalParticipatesTimes;
		updatePopularityRate();
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * @return the trainer
	 */
	public Trainer getTrainer() {
		return trainer;
	}

	/**
	 * @param trainer the trainer to set
	 */
	private void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	/**
	 * @return the equestrian
	 */
	public Equestrian getEquestrian() {
		return equestrian;
	}

	/**
	 * @param equestrian the equestrian to set
	 */
	private void setEquestrian(Equestrian equestrian) {
		this.equestrian = equestrian;
	}

	/**
	 * Gets the Primary Key of this horse
	 * @return Primary Key
	 */
	public String getPrimaryKey() {
		return this.getIdentifierSerial() + this.getNickName();
	}

	/**
	 * @return the popularityRate
	 */
	public double getPopularityRate() {
		return popularityRate;
	}

	/**
	 * @param popularityRate the popularityRate to set
	 */
	private void setPopularityRate(double popularityRate) {
		this.popularityRate = popularityRate;
	}

	/**
	 * Checks if the primary key (identifierSerial and nickName) is equal to to
	 * that of the given obj
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Horse))
			return false;
		Horse other = (Horse) obj;
		if (identifierSerial == null) {
			if (other.identifierSerial != null)
				return false;
		} else if (!identifierSerial.equals(other.identifierSerial))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}
	
	/**
	 * returns the hasCode of object computed from the primary keys
	 */
	public int hashCode() {

		return 31
				* (7 + ((identifierSerial == null) ? 0 : identifierSerial
						.hashCode()))
				+ (7 + ((nickName == null) ? 0 : nickName.hashCode()));

	}

	/**
	 * Adds a Trainer Object to Horse
	 * 
	 * @param trainer
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean addTrainer(Trainer trainer) {
		// TODO complete the implementation of this method.
		if (this.getTrainer() == null) {
			this.setTrainer(trainer);
			return true;
		}
		return false;
	}

	/**
	 * Removes a Trainer Object From Horse
	 * if the removing succeed then update the TotalWinnerHorses
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean removeTrainer() {
		if (this.getTrainer() != null) {
			this.getTrainer().updateTotalWinnerHorses();
			this.setTrainer(null);
			
			return true;
		}
		return false;

	}

	/**
	 * Adds an Equestrian object to Horse
	 * 
	 * @param equestrian
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean addEquestrian(Equestrian equestrian) {
		if (this.getEquestrian() == null) {
			this.setEquestrian(equestrian);
			return true;
		}
		return false;
	}

	/**
	 * Removes an Equestrian object from Horse
	 * 
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean removeEquestrian() {
		if (this.getEquestrian() != null) {
			this.setEquestrian(null);
			return true;
		}
		return false;

	}

	/**
	 * Adds a Veterinarian object to Horse
	 * 
	 * @param veterinar
	 * @return true if succeed otherwise returns false
	 * 
	 */
	public boolean addVeterinarian(Veterinarian veterinar) {

		int freeIndex = -1;
		for (int i = 0; i < veterinarians.length; i++) {
			if (veterinarians[i] != null) {
				if (veterinarians[i].equals(veterinar))
					return false;
			}
			if (veterinarians[i] == null) {
				freeIndex = i;
			}
		}
		if (freeIndex != -1) {
			veterinarians[freeIndex] = veterinar;
			return true;
		}
		return false;
	}
	


	/**
	 * Removes a Veterinarian object from Horse
	 * 
	 * @param veterinar
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeVeterinarian(Veterinarian veterinar) {

		for (int i = 0; i < veterinarians.length; i++) {
			if(veterinarians[i]!=null)
			if (veterinarians[i].equals(veterinar)) {
				veterinarians[i] = null;
				return true;
			}

		}
		return false;
	}

	/**
	 * Removes all the veterinarians assosiated with a given horse
	 * @return  true if succeed otherwise returns false
	 **/

	public boolean removeAllVeterinarians() {
		// TODO complete the implementation of this method.
		for (Veterinarian v : veterinarians) {
			if (v != null) {
				v.removeHorse(this);
			}
		}
		return true;
	}

	/**
	 * Calculates the age of this horse according to his birthDate 
	 * by using Instance of Calendar Object:
	 * Calendar calendar = Calendar.getInstance();
	 * the age calculated by: the current year - the year of the buithDate 
	 * 
	 * Please read the documentation of Calendar for more information
	 * 
	 * @return the age of the horse
	 */
	public int calculateHorseAge() {
		
		// TODO complete the implementation of this method.
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(this.getBirthDate());
		
		Calendar today = Calendar.getInstance();

		int age = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= calendar.get(Calendar.DAY_OF_YEAR))
			age--;
		return age;
	}

	/**
	 * Calculates the total points for this Horse in all Competitions
	 * @return the total points
	 */
	public int calculateTotalPoints() {
		// TODO complete the implementation of this method.
		
		int totalPoints = 0;
		for (HorseInCompetition hic : competitions) {
			totalPoints += hic.getTotalPoints();
		}
		return totalPoints;
	}

	/**
	 * Calculates the total wining times of this Horse in all competitions
	 * @return the number of wining times
	 */
	public int calculateWiningTimes() {
		// TODO complete the implementation of this method.
		
		int totalWinTimes = 0;		
		for (HorseInCompetition hic : competitions) {
			if (!hic.getMedal().equals(Medal.NONE)) 
				totalWinTimes++;
		}
		return totalWinTimes;

	}

	/**
	 * Updates the popularity rate of the Horse
	 */
	private void updatePopularityRate() {
		if (getPrice() != 0 && getRevenue() != 0)
			setPopularityRate((getRevenue() / getPrice())
					* getTotalParticipatesTimes());
	}

	
	

	/**
	 * Add Horse to a Competition and if succeed then updates also the 
	 * total participate times filed of this horse and update his trainer 
	 * TotalWinnerHorses filed's
	 * 
	 * @param hic
	 * @return true if succeed otherwise returns false
	 */
	public boolean addCompetitionToHorse(HorseInCompetition hic) {
		// TODO complete the implementation of this method.
		if (this.getCompetitions().add(hic)) {
			this.setTotalParticipatesTimes(this.getCompetitions().size());
			if(this.getTrainer()!=null)
			this.getTrainer().updateTotalWinnerHorses();
			return true;
		}
		return false;
	}

	/**
	 * Removes Horse from a Competition and update it participate times
	 * @param hic
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeCompetitionFromHorse(HorseInCompetition hic) {
		// TODO complete the implementation of this method.
		if (this.getCompetitions().remove(hic)) {
			this.setTotalParticipatesTimes(this.getCompetitions().size());
			return true;
		}
		return false;

	}
	
	
	/**
	 * @return a string containing the details of the object
	 */
	public String toString() {
		String str = "Horse details:\nIdentifier Serial: "
				+ this.getIdentifierSerial()
				+ "\nnick name: "
				+ this.getNickName()
				+ "\nBirtn date: "
				+ new SimpleDateFormat("dd/MM/yyyy")
						.format(this.getBirthDate()) + "\nGender: "
				+ this.getGender() + "\nGenre: " + this.getGenre().toString()
				+ "\nColor: " + this.gethColor().toString() + "\nWeight: "
				+ this.getWeight() + " kg" + "\nPopularity rate: "
				+ this.getPopularityRate() + " points" + "\nPrice: "
				+ this.getPrice() + " NIS" + "\nRevenue: " + this.getRevenue()
				+ "\nTotal participates times: "
				+ this.getTotalParticipatesTimes();

		if (this.getEquestrian() != null) {
			str += "\nEquestrian name: " + this.getEquestrian().getFullName();
		}
		if (this.getTrainer() != null) {
			str += "\nTrainer name: " + this.getTrainer().getFullName();
		}
		return str;

	}


}
