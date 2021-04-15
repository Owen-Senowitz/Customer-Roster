/**
 * @author Owen - Senowitz
 * class that handles the methods for the tree
 */
package assg8_senowitzo19;
import java.util.*;
import java.io.*;

public class CustomerRoster {
	final String fileName = "assg8_CustomerRoster.txt";
	BinarySearchTree<Customer, String> bst = new BinarySearchTree<Customer, String>();
	TreeIterator<Customer> ti = new TreeIterator<Customer>(bst);
	/**
	 * loads the data from the file
	 * @param fileName
	 */
	public void loadData(String fileName) {
		try {
			Scanner reader = new Scanner(new File(fileName));

			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				String split[] = line.split("\t");
				Customer Customer = new Customer(String.valueOf(split[0]), split[1], split[2]);
				bst.insert(Customer);
			}
			// closes the reader
			reader.close();
		}
		/**
		 * if the file is not found then we print a error message and exit the program
		 */
		catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
			System.exit(0);
		}
	}
	/**
	 * displays all the customers in the tree
	 */
	public void displayCustomer() {
		ti.setInorder();
		while (ti.hasNext()) {
			System.out.println(ti.next());
		}
	}
	/**
	 * adds a customer to the tree
	 * @param newKey
	 * @param newName
	 * @param newNumber
	 */
	public void addCustomer(String newKey, String newName, String newNumber) {
		Customer Customer = new Customer(newKey, newName, newNumber);
		bst.insert(Customer);
	}
	/**
	 * deletes a customer from the tree
	 * @param searchKey
	 */
	public void deleteCustomer(String searchKey) {
		if (bst.retrieve(searchKey) == null) {
			System.out.println("Could not find customer");
		}
		else {
		bst.delete(searchKey);
		}
	}
	/**
	 * search for a customer by id
	 * @param searchKey
	 */
	public void searchCustomer(String searchKey) {
		if (bst.retrieve(searchKey) == null) {
			System.out.println("Could not find customer");
		}
		else {
			System.out.println(bst.retrieve(searchKey));
			System.out.println("Customer Deleted");
		}
	}
	/**
	 * updates the customers information
	 * @param searchKey
	 * @param newName
	 * @param newNumber
	 */
	public void updateCustomer(String searchKey, String newName, String newNumber) {
		if (bst.retrieve(searchKey) == null) {
			System.out.println("Could not find customer");
		}
		else {
		bst.delete(searchKey);
		Customer Customer = new Customer(searchKey, newName, newNumber);
		bst.insert(Customer);
		System.out.println("Customer Information Updated");
		}
	}
	/**
	 * saves the data to the file
	 * @param fileName
	 */
	public void Save(String fileName) {
		Customer cus;
		ti.setInorder();
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileName);
		}
		catch (IOException e) {
			System.out.println("ERROR: File not found");
		}
		while (ti.hasNext()) {
			cus = (Customer) ti.next();
			pw.println(cus.getKey() + "\t" + cus.getName() + "\t" + cus.getNumber());
		}
		pw.close();
	}
}
