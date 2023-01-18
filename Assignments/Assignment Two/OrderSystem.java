/* Joel Goode - CMIS 242/4010 - 6/6/22
 * OrderSystem class to test functionallity and display:
 * Snack type
 * Size
 * ID
 * Price
 */

import java.util.Scanner;

public class OrderSystem {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		// Variables.
		int id = 100;
		String menuChoice, snackChoice, size, snackSize, snackType, addCitrus, addNuts;
		
		// While Loop to display menu and determine choice.
		while (true) {

			System.out.println("\t ### MENU ###\n");
			System.out.println("(1) Order A Snack");
			System.out.println("(2) Exit");
			System.out.print("Enter Selection Here: ");
			menuChoice = input.nextLine();

			// Determine Choice of Snack.
			if (menuChoice.equals("1")) {

				System.out.print("What Type of Snack Do You Want:(1) Fruity Snack or (2) Salty Snack?: ");
				snackType = input.nextLine();
				
				if (snackType.equals("1") || snackType.equals("2"))
					snackChoice = snackType;
				
				else {
					
					System.err.println("Invalid Input! Try Again!");
					continue;
				}
				// Validate and determine size of snack.
				System.out.print("What size do you want? (S, M, L): ");
				snackSize = input.nextLine().toUpperCase();
				
				if (snackSize.equals("S")|| snackSize.equals("M")
						|| snackSize.equals("L"))
					size = snackSize;
				
				else {
					
					System.err.println("Invalid Input! Try Again!");
					continue;
				}
				// Determine if Citrus is to be added.
				if (snackChoice.equals("1")) {
					
					System.out.print("Do you want citrus included?(True/False): ");
					addCitrus = input.nextLine().toUpperCase();
					
					if (addCitrus.equals("TRUE") || addCitrus.equals("FALSE")) {

						FruitSnack fruitSnack = new FruitSnack(String.valueOf(id), size,
								Boolean.parseBoolean(addCitrus));
						fruitSnack.calculatePrice();
						fruitSnack.additional();
						System.out.println(fruitSnack);

						System.out.println();
						id++;
					}
					else {
						
						System.err.println("Invalid Input! Try Again!");
					}
					
				}
				// Determine if Nuts are to be added if salty snack is chosen.
				else if (snackChoice.equals("2")) {
					
					System.out.print("Do you want nut included?(True/False): ");
					addNuts = input.nextLine().toUpperCase();
					
					if (addNuts.equals("TRUE") || addNuts.equals("FALSE")) {

						SaltySnack saltySnack = new SaltySnack(String.valueOf(id), size, Boolean.parseBoolean(addNuts));
						
						saltySnack.calculatePrice();
						saltySnack.additional();
						System.out.println(saltySnack);

						System.out.println();
						id++;
						
					}
					else {
						
						System.err.println("Invalid Input! Try Again!");
					}
				}
				else {
					
					System.err.println("Invalid Input! Try Again!");
				}

			} 
			else if (menuChoice.equals("2")) {
				
				System.out.println("Goodbye!");
				input.close();
				System.exit(0);
				break;
			}
			else {
				System.err.println("Invalid Input! Try Again!");
			}
		}

	}

}