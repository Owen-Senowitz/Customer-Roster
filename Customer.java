/**
 * @author Owen - Senowitz
 * class that handles the constructor, set/get methods, and the to string method
 */
package assg8_senowitzo19;

public class Customer extends KeyedItem<String>{
	/**
	 * Variables used
	 */
	private String name;
	private String number;
	/**
	 * constructor
	 * @param id
	 * @param name
	 * @param number
	 */
	public Customer(String id, String name, String number) {
		super(id);
		this.name = name;
		this.number = number;
	}
	public String getID() {
		return super.getKey();
	}
	/**
	 * gets the name
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets the name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets the number
	 * @return
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * sets the number
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * puts the object into a string
	 */
	@Override
	public String toString() {
		String print = "ID: " + super.getKey() + ", Name: " + name + ", Number: " + number;
		return print;
	}
}
