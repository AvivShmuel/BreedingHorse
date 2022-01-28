package content;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An abstract class that represents the properties and the methods of any Person
 * @author user
 *
 */
public abstract class Person {

	/**
	 * id is the primary key
	 */
	protected String id;
	
	/**
	 * full name
	 */
	protected String fullName;
	
	/**
	 * Date of birth
	 */
	protected Date bithDate;

	/**
	 * @param id
	 * @param fullName
	 * @param bithDate
	 * Full Constructor for Person object
	 */
	public Person(String id, String fullName, Date bithDate) {
		super();
		this.setId(id);
		this.setBithDate(bithDate);
		this.setFullName(fullName);
	}

	/**
	 * Partial Constructor for Person object
	 * @param id
	 * @param fullName
	 */
	public Person(String id, String fullName) {
		super();
		this.setId(id);
		this.setFullName(fullName);
	}
	
	/**
	 *  Partial Constructor for Person object
	 * @param id
	 */
	public Person(String id){
		super();
		this.setId(id);
	}
	
	/**
	 * Default constructor
	 */
	public Person() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the bithDate
	 */
	public Date getBithDate() {
		return bithDate;
	}

	/**
	 * @param bithDate the bithDate to set
	 */
	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}
	
	/**
	 * gets the Primary Key
	 * @return Primary Key
	 */
	public String getPrimaryKey(){
		return this.getId();
	}

	
	/**
     * Checks if the primary key (id) is equal to that of the given obj
    */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	/**
	 * returns the hasCode of object computed from the primary key
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	/**
	 * @return a string containing the details of the object 
	 */
	public String toString() {

		return "Id:" + this.getId() + "\nName: "
				+ this.getFullName() + "\nBirthDate: "
				+ new SimpleDateFormat("dd/MM/yyyy").format(bithDate);
	}
	
	
}
