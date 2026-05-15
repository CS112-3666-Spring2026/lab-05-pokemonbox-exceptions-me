import java.util.Scanner;
import java.util.InputMismatchException;

class Main {
	public static void main(String[] args) {
		// DECLARATION + INITIALIZATION
		int choice = -1;
		boolean tryAgain = true;
		Scanner keyboard = new Scanner(System.in);
		Pokemon[] caught = {
			new Pokemon("Pikachu", "Electric"),
			new Pokemon("Bulbasaur", "Grass", "Poison"),
			new Pokemon("Charmeleon", "Fire"),
			new Pokemon("Squirtle", "Water"),
			new Pokemon("Butterfree", "Bug", "Flying"),
			new Pokemon("Pidgeotto", "Normal", "Flying")
		};

		// WELCOME
		System.out.println("Preloading Pokemon Box...");
		PokemonBox myBox = new PokemonBox(caught);
		System.out.println("...Done!\n");

		System.out.println("---------------------------");
		System.out.println("| Welcome to Pokemon Box! |");
		System.out.println("---------------------------\n");
		System.out.println(myBox);

		//INPUT + PROCESSING + OUTPUT
		do {
			try {
				System.out.println("\nMAIN MENU\nWhat would you like to do?");
				System.out.println("\t1) Add a New Pokemon \n\t2) List All Pokemon \n\t3) Exit Program \n");
				System.out.print("Enter choice number> ");

				choice = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println();

				if (choice == 1) {
					boolean added = false;

					while(!added) {
						try {
							System.out.println("Enter Pokemon Info to be added:");
							System.out.print("Enter Pokemon Name> ");
							String name = keyboard.nextLine();

							System.out.print("Enter Pokemon Type #1> ");
							String type1 = keyboard.nextLine();

							System.out.print("Enter Pokemon Type #2 (none if no second type)> ");
							String type2 = keyboard.nextLine();
							type2 = (type2.equalsIgnoreCase("none")) ? null : type2;

							Pokemon p = new Pokemon(name, type1, type2);
							myBox.add(p);

							System.out.println("\n" + name + " added!");
							added = true;

						} catch(IllegalArgumentException e) {
							System.out.println("\nInvalid Pokemon data: " + e.getMessage());
							System.out.println("Please reenter valid Pokemon data.\n");

						} catch(PokemonAlreadyExistsException e) {
							System.out.println("\n" + e.getMessage());
							System.out.println("Our region's sustainability efforts in reducing habitat loss and environmental impacts require a max of 1 of the same type of Pokemon in the Box.");
							System.out.println("Please try adding a different Pokemon.\n");
						}
					}

				} else if (choice == 2) {
					System.out.println(myBox);

				} else if (choice == 3) {
					keyboard.close();
					tryAgain = false;

				} else {
					System.out.println("Invalid choice, please pick a valid option from the menu.\n");
				}

			} catch(InputMismatchException e) {
				System.out.println("\nInvalid input. Please enter a valid menu option as an integer.\n");
				keyboard.nextLine();
			}

		} while (tryAgain);

		System.out.println("Thank you for using the Pokemon Box program :D see you later!");
	}
}