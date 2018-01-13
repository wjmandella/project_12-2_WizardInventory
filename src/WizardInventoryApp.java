import java.util.ArrayList;
import java.util.Scanner;

public class WizardInventoryApp {
	
	private static ArrayList<String> wizardCollection = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("The Wizard Inventory game");
		wizardCollection.add("wooden staff");
		wizardCollection.add("wizard hat");
		wizardCollection.add("cloth shoes");
		
		Scanner sc = new Scanner(System.in);
		
		displayCommandMenu();
		
		String command = "";
		
		while (!command.equalsIgnoreCase("exit")) {
			command = ConsoleWizInv.getString("Command: ", "show","grab","edit","drop","exit", "menu");

			if (command.equalsIgnoreCase("show")) {
				showWizardCollection();
			}
			else if (command.equalsIgnoreCase("grab")) {
				if (wizardCollection.size() == 4) {
					System.out.println("You can't carry any more items. Drop something first.");
					System.out.println();
				}
				else {
				command = ConsoleWizInv.getString("Name: ");
				grabWizardItem(command);
				}
			}
			else if (command.equalsIgnoreCase("edit")) {
				int number = ConsoleWizInv.getInt("Number: ", 1, 4);
				editWizardCollection(number);
			}		
			else if (command.equalsIgnoreCase("drop")) {
				int number = ConsoleWizInv.getInt("Number: ", 1, 4);
				dropWizardItem(number);
			}
			else if (command.equalsIgnoreCase("menu")) {
				displayCommandMenu();
			}
		}	
		System.out.println("Bye!");
		sc.close();	
	}
	
	public static void displayCommandMenu() {
		
		System.out.println("\nCOMMAND MENU");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit - Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit program");
		System.out.println("menu - display menu\n");
	}
	
	public static void showWizardCollection() {
		for (int i = 0; i < wizardCollection.size(); i++) {
		System.out.println((i+1)+ ".  " + wizardCollection.get(i));	
		}
		System.out.println();
	}
	
	public static void grabWizardItem(String item) {
			wizardCollection.add(item);
			System.out.println("\"" + item + "\" was successfully added.");	
			System.out.println();
	}
	
	public static void editWizardCollection(int number) {
		String choice = ConsoleWizInv.getString("Would you like to update " 
						+ wizardCollection.get(number-1)+ "? (y/n): ", "y", "n");
		if (choice.equalsIgnoreCase("y")) {
			String temp = wizardCollection.get(number-1);
			String change = ConsoleWizInv.getString("Updated name: ");
			wizardCollection.set(number-1,change);	
			System.out.println("\"" + temp + "\" was successfully updated to " + "\"" + change + "\".");
			System.out.println();
		}
	}	
		
	public static void dropWizardItem(int number) {
		String choice = ConsoleWizInv.getString("Would you like to drop " 
								+ wizardCollection.get(number-1)+ "? (y/n): ", "y", "n");
		if (choice.equalsIgnoreCase("y")) {
			choice = wizardCollection.get(number-1);
			wizardCollection.remove(number-1);
			System.out.println("Item " + number + " (" + choice +") was dropped.");	
			System.out.println();
			}			
	}

}
