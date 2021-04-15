/**
 * @author Owen - Senowitz
 * class that handles the menu for the methods
 */
package assg8_senowitzo19;
import java.util.*;

public class CustomerMIS {

	public static void main(String[] args) {
		CustomerRoster CustomerRoster = new CustomerRoster();
		final String fileName = "assg8_CustomerRoster.txt";
		CustomerRoster.loadData(fileName);
		while (true) {
			System.out.println("1. Display the customer roster");
			System.out.println("2. Add a customer");
			System.out.println("3. Delete a customer");
			System.out.println("4. Search customer by ID");
			System.out.println("5. Update Information of a customer");
			System.out.println("6. Save and exit");
			System.out.println("7. Exit without saving");
			System.out.println("Enter Choice");
			Scanner console = new Scanner(System.in);
			int input = console.nextInt();
			String newKey = "", newName = "", newNumber = "", searchKey = "";
			switch (input) {
			/**
			 * displays tree
			 */
			case 1:
				CustomerRoster.displayCustomer();
				System.out.println("");
				break;
			/**
			 * add a customer
			 */
			case 2:
				System.out.println("Enter ID");
				while (newKey.length() == 0) {
					newKey = console.nextLine();
					if (newKey.length() != 0) {
						System.out.println("Enter Name");
						while (newName.length() == 0) {
							newName = console.nextLine();
							if (newName.length() != 0) {
								System.out.println("Enter Phone Number");
								while (newNumber.length() == 0) {
									newNumber = console.nextLine();
									if (newNumber.length() != 0) {
										CustomerRoster.addCustomer(newKey, newName, newNumber);
										System.out.println("Customer added");
										System.out.println("");
										break;
									}
								}
							}
						}
					}
				}
				break;
			/**
			 * deletes a customer
			 */
			case 3:
				System.out.println("Enter ID");
				while (searchKey.length() == 0) {
					searchKey = console.nextLine();
					if (searchKey.length() != 0) {
						CustomerRoster.deleteCustomer(searchKey);
						System.out.println("");
						break;
					}
				}
				break;
			/**
			 * search for customer by id
			 */
			case 4:
				System.out.println("Enter ID");
				while (searchKey.length() == 0) {
					searchKey = console.nextLine();
					if (searchKey.length() != 0) {
						CustomerRoster.searchCustomer(searchKey);
						System.out.println("");
						break;
					}
				}
				break;
			/**
			 * updates information of a customer
			 */
			case 5:
				System.out.println("Enter ID");
				while (searchKey.length() == 0) {
					searchKey = console.nextLine();
					if (searchKey.length() != 0) {
						System.out.println("Enter Name");
						while (newName.length() == 0) {
							newName = console.nextLine();
							if (newName.length() != 0) {
								System.out.println("Enter Phone Number");
								while (newNumber.length() == 0) {
									newNumber = console.nextLine();
									if (newNumber.length() != 0) {
										CustomerRoster.updateCustomer(searchKey, newName, newNumber);
										System.out.println("");
										break;
									}
								}
							}
						}
					}
				}
				break;
			/**
			 * save and exits
			 */
			case 6:
				CustomerRoster.Save(fileName);
	        	console.close();
	        	System.out.println("Exited nad Saved");
	        	System.exit(0);
			/**
			 * exits without saving
			 */
			case 7:
				System.out.println("Exited");
				console.close();
				System.exit(0);
			}
		}
	}
}
