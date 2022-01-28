package content;

/**
 * Represents the properties and the methods of any assositiation calss -GamblingBetsForCompetition
 * @author user
 *
 */
public class GamblingBetsForCompetition {

	/** The BookMaker object for this Object **/
	private BookMaker bookMaker;
	
	/** The Gambler object for this Object **/
	private Gambler gambler;
	
	/** The Competition object for this Object **/
	private Competition competition;
	
	/** The Horse object for this Object **/
	private Horse betsHorse;
	
	/** The bet on Horse in Competition **/
	private double betAmount;

	/**
	 * Full Constructor for GamblingBetsForCompetition Object
	 * 
	 * @param bookMaker
	 * @param gambler
	 * @param betAmount
	 * @param competition
	 * @param betsHorse
	 */
	public GamblingBetsForCompetition(BookMaker bookMaker, Gambler gambler,
			double betAmount, Competition competition, Horse betsHorse) {

		this.setBetAmount(betAmount);
		this.setBookmaker(bookMaker);
		this.setGambler(gambler);
		this.setCompetition(competition);
		this.setBetsHorse(betsHorse);

	}

	/**
	 * The partial constructor for GamblingBetsForCompetition object
	 * 
	 * @param bookMaker
	 * @param gambler
	 * @param competition
	 * @param horse
	 */
	public GamblingBetsForCompetition(BookMaker bookMaker, Gambler gambler,
			Competition competition, Horse horse) {

		this.setBookmaker(bookMaker);
		this.setGambler(gambler);
		this.setCompetition(competition);
		this.setBetsHorse(horse);
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Horse getBetsHorse() {
		return betsHorse;
	}

	public void setBetsHorse(Horse equestrianOnHorse) {
		this.betsHorse = equestrianOnHorse;
	}

	public BookMaker getBookmaker() {
		return bookMaker;
	}

	public void setBookmaker(BookMaker bookMaker) {
		this.bookMaker = bookMaker;
	}

	public Gambler getGambler() {
		return gambler;
	}

	public void setGambler(Gambler gambler) {
		this.gambler = gambler;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmmount) {
		this.betAmount = betAmmount;
	}

	public Competition getHeat() {
		return competition;
	}

	

	
	/**
	 * Checks if the primary keys ( of BookMaker, Competition, and Gambler) is equal to to that of the
	 * given obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GamblingBetsForCompetition other = (GamblingBetsForCompetition) obj;
		if (bookMaker == null) {
			if (other.bookMaker != null)
				return false;
		} else if (!bookMaker.equals(other.bookMaker))
			return false;
		if (competition == null) {
			if (other.competition != null)
				return false;
		} else if (!competition.equals(other.competition))
			return false;
		if (gambler == null) {
			if (other.gambler != null)
				return false;
		} else if (!gambler.equals(other.gambler))
			return false;
		return true;
	}
	
	/** 
	 * return the hasCode of object computed from the primary keys of BookMaker, Competition, and Gambler
	 **/
	public int hashCode() {

		return 31 * (7 + ((bookMaker == null) ? 0 : bookMaker.hashCode()))
				+ (7 + ((competition == null) ? 0 : competition.hashCode()))
				+ (7 + ((gambler == null) ? 0 : gambler.hashCode()));

	}


}
