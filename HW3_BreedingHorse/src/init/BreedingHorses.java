package init;

import java.awt.Color;

import java.util.*;

import content.BookMaker;
import content.Competition;
import content.Equestrian;
import content.Gambler;
import content.GamblingBetsForCompetition;
import content.Horse;
import content.HorseInCompetition;
import content.Person;
import content.Trainer;
import content.Veterinarian;

import utils.*;

/**
 * This class is the system of the BreedingHorses - contains all methods (and
 * queries) of the BreedingHorses application
 * 
 * @author Administrator
 * 
 */
public class BreedingHorses {

	/**
	 * Map of horses
	 */
	private Map<String, Horse> horses;

	/**
	 * Map of persons
	 */
	private Map<String, Person> persons;

	/**
	 * 
	 * Breading Horses Constructor
	 * initializing the maps objects.
	 */
	public BreedingHorses() {
		horses = new HashMap<String, Horse>();
		persons = new HashMap<String, Person>();
	}
	
	/**
	 * METHOD TO LOAD ALL THE DATA FROM DATABASE USING 2 ARRAYLIST FOR TRAINERS AND HORSES 
	 */
	public void getdatafromdb() {
		ArrayList<Trainer> trainers = new ArrayList<Trainer>();
		ArrayList<Horse> horses = new ArrayList<Horse>();
		trainers = MainMenu.mysqlCon.getTrainers();
		horses= MainMenu.mysqlCon.getHorses();
		if(trainers.size() >0) {
			for(Trainer t : trainers) {
				if(!this.persons.containsKey(t.getPrimaryKey()))
					this.persons.put(t.getPrimaryKey(), t);
			}
		}
		if(horses.size() >0) {
			for(Horse h : horses) {
				if(!this.horses.containsKey(h.getPrimaryKey()))
					this.horses.put(h.getPrimaryKey(), h);
			}
		}
	}
	/**
	 * Adds a given person to the Persons Map & Trainer on DATA BASE.
	 * it also checks if the object is already exist before adding
	 * 
	 * @param person
	 * @return true if succeed otherwise returns false
	 */
	public boolean addPerson(Person person) {
		
		if (!persons.containsKey(person.getPrimaryKey())) {
			//this.persons.put(person.getPrimaryKey(), person);
			if(person instanceof Trainer) {
				Trainer t = (Trainer) person;
				MainMenu.mysqlCon.AddTrainer(t);
			}
			if(person instanceof Equestrian) {
				Equestrian e = (Equestrian) person;
				this.persons.put(person.getPrimaryKey(), person);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Removes a given person from persons map 
	 * It also checks if the object is already exist before removing
	 * @param person
	 * @return true if succeed otherwise returns false
	 */
	public boolean removePerson(Person person) {
		if (this.persons.containsKey(person.getPrimaryKey())) {
			this.persons.remove(person.getPrimaryKey());
			return true;
		}
		return false;
	}


	/**
	 * 
	 * Adds new horse to horses map & Horse table on database return true if the adding process success
	 * return false if the horse already exist 
	 * 
	 * @param hid
	 * @param name
	 * @param birthDate
	 * @param weight
	 * @param gender
	 * @param color
	 * @param price
	 * @param genre
	 * @param revenue
	 * @param totalParticipatesTimes
	 * @return true if succeed otherwise returns false
	 */
	public boolean addHorse(String hid, String name, Date birthDate,
			double weight, Character gender, Color color, double price,
			Genre genre, double revenue, int totalParticipatesTimes) {
	
		if(!name.matches("[A-Z][a-zA-Z]*")) {
			return false;
		}
		Horse newHorse = new Horse(hid, name);
		Horse newhorse1 = new Horse(hid, name,birthDate, weight, gender, color, price, genre, revenue,totalParticipatesTimes);
		if (!horses.containsKey(newHorse.getPrimaryKey())) {
			horses.put(newHorse.getPrimaryKey(), new Horse(hid, name,
					birthDate, weight, gender, color, price, genre, revenue,
					totalParticipatesTimes));
			MainMenu.mysqlCon.AddHorse(newhorse1);
			return true;
		}
		
		return false;
	}

	
	/**
	 * 
	 * Removes Horse from horses map. When removing a horse succeed 
	 * this method must also take care of:
	 * 
	 * 1) The related trainer if exists
	 * (NOTE: updates the trainer object that this horse was removed. 
	 *        THIS METHOD DOESN'T REMOVE THE TRAINER OBJECT FROM PERSONS MAP)
	 *         
	 * 2) The related Equestrian if exists
	 * 3) The related Veterinarians if exist
	 *
	 * Otherwise this method makes a roll-back (i.e don't removes the Horse )
	 * if the removing is not completly succeded
	 *         
	 * @param hId
	 * 
	 * @param hName
	 * 
	 * @return true if succeed otherwise returns false
	 **/
	public boolean removeHorse(String hId, String hName) {
		
		Horse horse = new Horse(hId, hName);
		
		if (horses.containsKey(horse.getPrimaryKey())) {
			
			horse = horses.get(horse.getPrimaryKey());
			Trainer trainer = horse.getTrainer();
			Equestrian equestrian = horse.getEquestrian();

			if (trainer != null && trainer.removeHorse(horse)
					&& horse.removeTrainer()) {
				
				if (equestrian != null && horse.removeEquestrian()
						&& equestrian.removeHorse()) {
					if (horse.removeAllVeterinarians()) {
						horses.remove(horse.getPrimaryKey());
						return true;
					} else {
						horse.addTrainer(trainer);
						horse.addEquestrian(equestrian);
						return false;
					}
				} else {
					horse.addTrainer(trainer);
					return false;
				}
			} else {
				horse.addTrainer(trainer);
				return false;
			}
		}
		return false;
	}

	
	
	
	
	/**
	 * Adds an existed trainer to an existed horse returns true if the adding
	 * process succeed, otherwise returns false if: 
	 * 1) The horse is not exists in the horses map 
	 * 2) The trainer is not exists in the persons map 
	 * 3) The existed trainer is already added to the existed horse 
	 * 4) The existed horse is already has a trainer
	 * 
	 * Otherwise this method makes a roll-back (i.e don't adds the Trainer to the existed horse)
	 * if the adding is not completly succeded
	 * 
	 * @param trId
	 * @param trSerialId
	 * @param hId
	 * @param hName
	 * @return true if succeed otherwise returns false
	 */
	public void addTrainerToHorse(String trId, String trSerialId,
			String hId, String hName) {
		
		/*
		 * Trainer trainer = new Trainer(trId, trSerialId); Horse horse = new Horse(hId,
		 * hName);
		 * 
		 * if (horses.containsKey(horse.getPrimaryKey()) &&
		 * persons.containsKey(trainer.getPrimaryKey())) {
		 * 
		 * trainer = (Trainer) persons.get(trainer.getPrimaryKey()); horse =
		 * horses.get(horse.getPrimaryKey()); if (horse.addTrainer(trainer) &&
		 * trainer.addHorse(horse)) {
		 */
				MainMenu.mysqlCon.AddTrainerToHorse(hId, trId);
				/*
				 * return true; } else { horse.removeTrainer(); return false; } } return false;
				 */
	}
	
	/**
	 * Removes an existed Trainer from an existed horse returns true if the
	 * removing process succeed, otherwise returns false if: 
	 * 1) The horse is not exists in the horses map 
	 * 2) The Trainer is not exists in the persons map 
	 * 3) The existed horse does not have this Trainer
	 * 
	 * Otherwise this method makes a roll-back (i.e don't removes the Trainer from the existed horse)
	 * if the removing is not completly succeded
	 * 
	 * @param gId
	 * @param gSerialId
	 * @param hId
	 * @param hName
	 * @return true if succeed otherwise returns false
	 **/

	public boolean removeTrainerFromHorse(String gId, String gSerialId,
			String hId, String hName) {
		
		Trainer trainer = new Trainer(gId, gSerialId);
		Horse horse = new Horse(hId, hName);

		if (persons.containsKey(trainer.getPrimaryKey())
				&& horses.containsKey(horse.getPrimaryKey())) {

			trainer = (Trainer) persons.get(trainer.getPrimaryKey());
			horse = horses.get(horse.getPrimaryKey());
			if (horse.removeTrainer() && trainer.removeHorse(horse)) {
				return true;
			} else {
				horse.addTrainer(trainer);
				return false;
			}
		}
		return false;
	}


	/**
	 * Adds an existed Equestrian to an existed horse returns true if the adding
	 * process succeed, otherwise returns false if: 
	 * 1) The horse is not exists in the horses 
	 * 2) The Equestrian is not exists in the persons map
	 * 3) The existed Equestrian is already added to the existed horse 
	 * 4) The existed horse is already has a Equestrian
	 * 
	 * Otherwise this method makes a roll-back (i.e don't removes the Equestrian to the existed horse)
	 * if the adding is not completly succeded
	 * 
	 * @param eId
	 * @param hId
	 * @param hName
	 * @return true if succeed otherwise returns false
	 */
	public boolean addEquestrianToHorse(String eId, String hId, String hName) {
		if(!eId.matches("[A-Za-z]{3}[^e]{1}"))return false;
		Equestrian equestrian = new Equestrian(eId);
		Horse horse = new Horse(hId, hName);
		
		if (persons.containsKey(equestrian.getPrimaryKey())
				&& horses.containsKey(horse.getPrimaryKey())) {
			equestrian = (Equestrian) persons.get(equestrian.getPrimaryKey());
			horse = horses.get(horse.getPrimaryKey());
			if (horse.addEquestrian(equestrian) && equestrian.addHorse(horse)) {
				return true;
			} else {
				horse.removeEquestrian();
				return false;
			}
		}
		return false;

	}
	
	/**
	 * 
	 * Removes an exised Equestrian From an exised Horse and return false if: 
	 * 1) The horse is not exists in the horses 
	 * 2) The Equestrian is not exists in the persons map
	 * 3) The existed Equestrian doesn't related to the existed horse 
	 * 4) The existed horse doesn't has the given Equestrian
	 * 
	 * Otherwise this method makes a roll-back (i.e don't add the Equestrian from an existed horse)
	 * if the removing is not completly succeded
	 * 
	 * @param pId
	 * @param hId
	 * @param hName
	 * @return true if succeed otherwise returns false
	 **/
	public boolean removeEquestrianFromHorse(String pId,
			String hId, String hName) {
		
		Equestrian equestrian = new Equestrian(pId);
		Horse horse = new Horse(hId, hName);
		
		if (persons.containsKey(equestrian.getPrimaryKey())
				&& horses.containsKey(horse.getPrimaryKey())) {
			
			equestrian = (Equestrian) persons.get(equestrian.getPrimaryKey());
			horse = horses.get(horse.getPrimaryKey());
			
			if (horse.removeEquestrian() && equestrian.removeHorse()) {
				return true;
			} else {
				horse.addEquestrian(equestrian);
				return false;
			}
		}
		return false;
	}


	/**
	 * Adds an existed Veterinarian to an existed horse returns true if the
	 * adding process succeed, otherwise returns false if:
	 *  1) The horse is not exists in the horses map 
	 *  2) The Veterinarian is not exists in the persons map 
	 *  3) The existed Veterinarian is already added to the existed horse 
	 *  4) The existed horse is already has a three Veterinarians
	 *  
	 * otherwise this method makes a roll-back (i.e don't add the Veterinarian to an existed horse)
	 * if the adding is not completly succeded
	 * 
	 * @param vId
	 * @param vSerialId
	 * @param hId
	 * @param hName
	 * @return true if succeed otherwise returns false
	 */
	public boolean addVeterinarianToHorse(String vId, String vSerialId,
			String hId, String hName) {
		
		Veterinarian veterinar = new Veterinarian(vId, vSerialId);
		Horse horse = new Horse(hId, hName);
		
		if (persons.containsKey(veterinar.getPrimaryKey())
				&& horses.containsKey(horse.getPrimaryKey())) {
			
			veterinar = (Veterinarian) persons.get(veterinar.getPrimaryKey());
			horse = horses.get(horse.getPrimaryKey());
			
			if (horse.addVeterinarian(veterinar) && veterinar.addHorse(horse)) {
				return true;
			} else {
				horse.removeVeterinarian(veterinar);
				return false;
			}
		}
		return false;
	}
	

	
	/**
	 * Removes an existed Veterinarian from an existed horse returns true if the
	 * removing process succeed, otherwise returns false if: 
	 * 1) The horse is not exists in the horses map
	 * 2) The Veterinarian is not exists in the persons map
	 * 3) The existed horse does not have this Veterinarian
	 * 
	 * otherwise this method makes a roll-back (i.e don't remove the Veterinarian from an existed horse)
	 * if the removing is not completly succeded
	 * 
	 * @param vId
	 * @param vSerialId
	 * @param hId
	 * @param hName
	 * @return true if succeed otherwise returns false
	 * 
	 **/
	public boolean removeVeterinarianFromHorse(String vId, String vSerialId,
			String hId, String hName) {
		
		Veterinarian veterinar = new Veterinarian(vId, vSerialId);
		Horse horse = new Horse(hId, hName);

		if (persons.containsKey(veterinar.getPrimaryKey())
				&& horses.containsKey(horse.getPrimaryKey())) {
			veterinar = (Veterinarian) persons.get(veterinar.getPrimaryKey());
			horse = horses.get(horse.getPrimaryKey());

			if (horse.removeVeterinarian(veterinar)
					&& veterinar.removeHorse(horse)) {
				return true;
			} else {
				horse.addVeterinarian(veterinar);
				return false;
			}
		}
		return false;
	}
	
	
	/**
	 * Adds a Horse to a Competition. return false if: 
	 * 1) There given horse is not existed in the horses map 
	 * 2) The Horse does not have an Equestrian
	 * 3) The Horse already participate in the given Competition 
	 * 
	 * otherwise this method makes a roll-back (i.e don't add the horse to the Competition)
	 * if the adding is not completly succeded
	 * 
	 * @param hIdentificalNo
	 * @param nickName
	 * @param serialNum
	 * @param placeOfCompetitions
	 * @param typee
	 * @param startDate
	 * @param level
	 * @return true if succeed otherwise returns false
	 */
	public boolean addHorseToCompetition(String hIdentificalNo,
			String nickName, int serialNum, String placeOfCompetitions,
			Typee typee, Date startDate, short level) {
		
		Horse horse = new Horse(hIdentificalNo, nickName);
		
		if (horses.containsKey(horse.getPrimaryKey())) {
			
			horse = horses.get(horse.getPrimaryKey());
			
			if (horse.getEquestrian() != null) {
				
				Competition competition = new Competition(serialNum,
						placeOfCompetitions, typee, startDate, level);
				if (!horse.getCompetitions().contains(competition)) {
					
					

					HorseInCompetition hic = new HorseInCompetition(horse,competition);
					
					if (competition.addHorseToCompetition(hic) && horse.addCompetitionToHorse(hic)) {
						return true;
					} else {
						competition.removeHorseFromCompetition(hic);
						return false;
					}
				}
			}

		}

		return false;
		
		
		
		
	}

	/**
	 * Removes Horse from Competition the method return false if:
	 * 
	 * 1) The Horse is not exist in the horse map 
	 * 2) The Horse is not participated in the given Competition
	 * 
	 * Otherwise this method makes a roll-back (i.e don't remove the horse from the Competition)
	 * if the removing is not completly succeded
	 * 
	 * @param hIdentificalNo
	 * @param nickName
	 * @param serialNum
	 * @param typee
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeHorseFromCompetition(String hIdentificalNo,
			String nickName, int serialNum, Typee typee) {
		
		Horse horse = new Horse(hIdentificalNo, nickName);
		
		if (this.horses.containsKey(horse.getPrimaryKey())) {
			
			horse = horses.get(horse.getPrimaryKey());
			
			Competition competition = new Competition(serialNum, typee);
			HorseInCompetition hic = new HorseInCompetition(horse, competition);
			
			if (horse.getCompetitions().contains(hic))

			{
				for(HorseInCompetition c:horse.getCompetitions()){
					if(c.equals(competition)){
							competition=c.getCompetition();
						if (competition.removeHorseFromCompetition(hic)
								&& horse.removeCompetitionFromHorse(hic))
							return true;
						else {
							competition.addHorseToCompetition(hic);
							return false;
						}
					}
				}
				Iterator<HorseInCompetition> itr = horse.getCompetitions().iterator();
				while (itr.hasNext()) {
					hic = itr.next();
					if (hic.getCompetition().equals(competition)) {
						competition = hic.getCompetition();
						if (competition.removeHorseFromCompetition(hic)
								&& horse.removeCompetitionFromHorse(hic))
							return true;
						else {
							competition.addHorseToCompetition(hic);
							return false;
						}
					}
				}

			}
		}
		return false;

	}

	/**
	 * Adds a Gambler bet on a Horse in a Competition throuth the Bookmaker
	 * The method return false if: 
	 * 
	 * 1) The given bookmaker is not exists in persons map
	 * 2) The given gambler is not exists in persons map
	 * 3) The given Competition is not exists
	 * 4) The given horse is not exists in horses map
	 * 
	 * Otherwise this method makes a roll-back (i.e don't adds the bet)
	 * if the adding is not completly succeded
	 * 
	 * @param bId
	 * @param bLicenseNo
	 * @param gId
	 * @param hIdentificationNo
	 * @param hNickName
	 * @param cIdNumber
	 * @param cType
	 * @param betAmount
	 * @return true if succeed otherwise returns false
	 */
	public boolean addGamblingBetsForCompetition(String bId, String bLicenseNo,
			String gId, String hIdentificationNo, String hNickName,
			int cIdNumber, Typee cType, double betAmount) {
		if(!bLicenseNo.matches("[0-9][^0][0-9]*{6}"))return false;
		BookMaker bookMaker = new BookMaker(bId, bLicenseNo);
		Gambler gambler = new Gambler(gId);
		Horse horse = new Horse(hIdentificationNo, hNickName);
		Competition competition = new Competition(cIdNumber, cType);
		HorseInCompetition hic = new HorseInCompetition(horse, competition);
		
		if (persons.containsKey(bookMaker.getPrimaryKey())
				&& persons.containsKey(gambler.getPrimaryKey())
				&& horses.containsKey(horse.getPrimaryKey())
				&& horses.get(horse.getPrimaryKey()).getCompetitions()
						.contains(hic)) {
		
			bookMaker = (BookMaker) persons.get(bookMaker.getPrimaryKey());
			gambler = (Gambler) persons.get(gambler.getPrimaryKey());
			horse = horses.get(horse.getPrimaryKey());
			
			if (!horse.getCompetitions().isEmpty()
					&& horse.getCompetitions().contains(hic)) {
				
				Iterator<HorseInCompetition> itr = horse.getCompetitions().iterator();
				
				while (itr.hasNext()) {
					hic = itr.next();
					if (hic.getCompetition().equals(competition)) {
						competition = hic.getCompetition();
						break;
					}
				}

				GamblingBetsForCompetition gbfc = new GamblingBetsForCompetition(
						bookMaker, gambler, betAmount, competition, horse);
				
				if (bookMaker.addBetToBookMaker(gbfc)) {
					if (competition.addBetToCompetition(gbfc)) {
						if (gambler.addBetsInCompetition(gbfc)) {
							return true;
						} else {
							bookMaker.removeBetFromBookMaker(gbfc);
							competition.removeBetFromCompetition(gbfc);
							return false;
						}

					} else {
						bookMaker.removeBetFromBookMaker(gbfc);
						return false;
					}

				}
			}
		}

		return false;
	
	}
	
	
	
	

	/**
	 * Removes Gambler's bet for a Horse in a Competition 
	 * It returns false if: 
	 * 
	 * 1) The given bookmaker is not exists in persons map
	 * 2) The given gambler is not exists in persons map
	 * 3) The given Competition is not exists
	 * 4) The given horse is not exists in horses map
	 * 
	 * Otherwise this method makes a roll-back (i.e don't Removes the bet)
	 * if the removing is not completly succeded
	 * 
	 * @param bId
	 * @param bLicenseNo
	 * @param gId
	 * @param hIdentificationNo
	 * @param hNickName
	 * @param cIdNumber
	 * @param cType
	 * @return true if succeed otherwise returns false
	 */
	public boolean removeGamblingBetsForCompetition(String bId,
			String bLicenseNo, String gId, String hIdentificationNo,
			String hNickName, int cIdNumber, Typee cType) {

		BookMaker bookMaker = new BookMaker(bId, bLicenseNo);
		Gambler gambler = new Gambler(gId);
		Horse horse = new Horse(hIdentificationNo, hNickName);
		Competition competition = new Competition(cIdNumber, cType);
		HorseInCompetition hic = new HorseInCompetition(horse, competition);
		
		if (persons.containsKey(bookMaker.getPrimaryKey())
				&& persons.containsKey(gambler.getPrimaryKey())
				&& horses.containsKey(horse.getPrimaryKey())
				&& horses.get(horse.getPrimaryKey()).getCompetitions()
						.contains(hic)) {
			
			bookMaker = (BookMaker) persons.get(bookMaker.getPrimaryKey());
			gambler = (Gambler) persons.get(gambler.getPrimaryKey());
			horse = horses.get(horse.getPrimaryKey());
			
			if (!horse.getCompetitions().isEmpty()
					&& horse.getCompetitions().contains(hic)) {
				
				Iterator<HorseInCompetition> itr = horse.getCompetitions().iterator();
				
				while (itr.hasNext()) {
					hic = itr.next();
					if (hic.getCompetition().equals(competition)) {
						competition = hic.getCompetition();
						break;
					}
				}

				GamblingBetsForCompetition gbfc = 
					new GamblingBetsForCompetition(bookMaker, gambler, competition, horse);
					
				if (bookMaker.removeBetFromBookMaker(gbfc)) {
						
					  if (competition.removeBetFromCompetition(gbfc)) {
							gambler.removeBetsInCompetition();
							return true;

						} else {
							bookMaker.addBetToBookMaker(gbfc);
							return false;
						}

					}

				}
			}
		
		return false;
	}
	
	
	
	/**
	 * Finds the best horse
	 * The method got as parameters the weights of wining Times, total points,and the popularity rate
	 * Use an apropriate comparator in order to compare the
	 * horses
	 * for evrey horse the method calculate the total weighted score as: 
	 * 
	 *     TotalPoints * weightOfTotalPoints + 
	 *     WiningTimes * weightOfWiningTimes + 
	 *     popularityRate() * weightOfPopularityRate
	 * 
	 * according to this score the horses are compared and the method returns the horse with the maximal score
	 * 
	 * NOTE: The complexity of this method must be O(N) and required to use comparator
	 *
	 * @param weightOfWiningTimes
	 * @param weightOfTotalPoints
	 * @param weightOfPopularityRate
	 * @return the best horse
	 */
	public Horse findTheBestHorse(double weightOfWiningTimes,
			double weightOfTotalPoints, double weightOfPopularityRate) {
		Horse bestHorse = null;
		HorseComparator hc = new HorseComparator(weightOfWiningTimes,
				weightOfTotalPoints, weightOfPopularityRate);
	    for (Horse h : horses.values()) {
			if (bestHorse == null) {
				bestHorse = h;
			} else {
				if (hc.compare(bestHorse, h) > 0) {
					bestHorse = h;
				}
			}
		}
		 
		return bestHorse;
	}

	
	/**
	 * Finds the Most unlucky Gambler
	 * i.e The one that have the smallest gain
	 * 
	 * @return The most unlucky gambler object
	 */
	public Gambler findTheMostUnluckyGambler() {
		
		List<Gambler> gamblers = new ArrayList<Gambler>();
		Gambler unluckyGambler = null;
		
		for (Person p : persons.values()) {
			if (p instanceof Gambler) {
				gamblers.add((Gambler) p);
			}
		}
		
		for (Gambler g : gamblers) {
			if (unluckyGambler == null) {
				unluckyGambler = g;
			} else {
				if (unluckyGambler.getGain() >= g.getGain()) {
					unluckyGambler = g;
				}
			}
		}
		
		return unluckyGambler;
	}

	
	/**
	 * Prints (to the output.txt file) the top ten trainers report according to
	 * their success rate sorted from the highest trainers to the lowest one by
	 * NOTE: You must use a comparator object on 
	 * the successRate field and use the Collections.sort method
	 */
	
	
	public List<Trainer> printTop10TrainersRankedReport() {

		List<Trainer> templist = new ArrayList<Trainer>();
		List<Trainer> retlist = new ArrayList<Trainer>();

		for (Person p : persons.values())
			if (p instanceof Trainer) {
				templist.add((Trainer) p);
			}
		// using stream to sorting list...
		templist.stream().sorted((t1,t2) -> (int)(t2.getSuccessRate() - t1.getSuccessRate()));
		if(templist.size() >= 10) {
		for(int i =0; i < 10 ; i++) {
			retlist.add(templist.get(i));
			}
		
		return retlist;
		}
		return templist;
		
	}
	
	
	/**
	 * updates the salaries of veterinarians by a given bonusPersent if that
	 * veterinarian works more than a given totalTreatmentHours and treats more
	 * than given totalTreatmentHorses.
	 * 
	 * @param totalTreatmentHours
	 * @param totalTreatmentHorses
	 * @param bonusPersent
	 *        
	 */
	public void giveBonusToVeterinarians(int totalTreatmentHours,
			int totalTreatmentHorses, double bonusPersent) {

		// TODO complete the implementation of this method.

		for (Person p : persons.values()) {

			if (p instanceof Veterinarian) {
				Veterinarian tempVeterinar = (Veterinarian) p;

				if (tempVeterinar.getTotalTreatmentHours() > totalTreatmentHours
						&& tempVeterinar.getHorsesCount() > totalTreatmentHorses) {
					tempVeterinar.setSalary(tempVeterinar.getSalary()
							* (1.0 + bonusPersent));
				}
			}
		}
	}
	
	
	/**
	 * The method prints all the persons in the persons-map into the text-file.
	 */
	public Map<String, Person> printAllPersons() {

	
		return this.persons;
	}

	// get the horses list for database
	public String[][] printAllHorses() {
		return MainMenu.mysqlCon.PrintAllHorses();
	}



	
	/**
	 * The method prints all the Gamblers in the persons-map into the text-file.
	 * must use printCollection method to print the objects to the text-file
	 */
	public void printAllGamblers() {
	
		ArrayList<Gambler> arr = new ArrayList<Gambler>();
		for (Person p : persons.values()) {
			if (p instanceof Gambler) {
				Gambler g = (Gambler) p;
				arr.add(g);
			}
		}
		printCollection(arr);
	}

	/**
	 * The method prints a sorted BookMaker list (according to the primary key fields) into the
	 * text-file.
	 * NOTE: you must use a TreeSet for sorting
	 * must use printCollection method to print the objects to the text-file
	 */
	public void printAllBookMakers() {
		
		SortedSet<BookMaker> sorted = null;
		List<BookMaker> bookMakers = new ArrayList<BookMaker>();
		for (Person p : persons.values()) {
			if (p instanceof BookMaker) {
				bookMakers.add((BookMaker) p);
			}
		}
		sorted = new TreeSet<BookMaker>(bookMakers);
		
		printCollection(sorted);
		
	}
	
	/**
	  This generic method prints the given collection to the text-file
	*/
	private <T> void printCollection(Collection<? extends T> collection){
		for (T t : collection) {
			SaveLineToFile.writeToFileInSeparateLine(t.toString()+"\n");
		}
	}
	
	
}
