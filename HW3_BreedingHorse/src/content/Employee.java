package content;

import java.util.Date;

/**
 * Represents the properties and the methods of an abstract Employee
 * 
 * @author Administrator
 * 
 */
public abstract class Employee extends Person {

	/**
	 * Both serialId and id is the primary key
	*/
	private String serialId;
	
	/**
	 * Salary of this Employee
	 */
	private double salary;

	
	/**
	 * Full Constructor for Employee Object
	 * @param id
	 * @param fullName
	 * @param bithDate
	 * @param serialId
	 * @param salary
	 * 
	 */
	public Employee(String id, String fullName, Date bithDate, String serialId,
			double salary) {
		super(id, fullName, bithDate);
		setSerialId(serialId);
		setSalary(salary);

	}

	/**
	 * Partial Constructor for Employee Object
	 * @param id
	 * @param serialId
	 * 
	 */
	public Employee(String id, String serialId) {
		super(id);
		setSerialId(serialId);
	}
	
	/**
	 * @return the serialId
	 */
	public String getSerialId() {
		return serialId;
	}

	/**
	 * @param serialId the serialId to set
	 */
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return Math.round(salary);
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getPrimaryKey(){
		return this.getId()+this.getSerialId();
	}

	/**
     * Checks if the primary key (serialId and id) is equal 
     * to to that of the given obj
    */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (serialId == null) {
			if (other.serialId != null)
				return false;
		} else if (!serialId.equals(other.serialId))
			return false;
		return true;
	}
	
	

	/**
	 *returns the hashcode of given object by primary fields
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((serialId == null) ? 0 : serialId.hashCode());
		return result;
	}


	/**
	 * @return a string containing the details of the object 
	 */
	public String toString() {
		return  super.toString()
				+ "\nSerialId: "
				+ getSerialId()
			    +"\nSalary: "
				+ getSalary()+" NIS";
	}
	
	
}
