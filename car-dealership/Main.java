import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		

		Car[] cars = new Car[] {
		new Car("Nissan", 5000, 2020, "red", new String[] {"tires, keys"}),
		new Car("Dodge", 8500, 2019, "blue", new String[] {"tires", "keys"}),
		new Car("Nissan", 5000, 2017, "yellow", new String[] {"tires", "filter"}),
		new Car("Honda", 7000, 2019, "orange", new String[] {"tires", "filter"}),
		new Car("Mercedes", 12000, 2015, "Jet Black", new String[] {"tires", "filter", "transmission"} )
		};
		Dealership dealership = new Dealership(cars); 
		
		System.out.println("\n ****** JAVA DEALERSHIP! ****** \n");
		// init scanner
		Scanner scan = new Scanner(System.in);

		// Ask questions
		System.out.println("Welcome! Enter the type of car you're looking for: ");
		String makeAnswer = scan.next();
		System.out.println("Enter your budget: ");
		int budgetAnswer = scan.nextInt();

		// perform search
		int searchResult = dealership.search(makeAnswer, budgetAnswer); 

		String decision = "";

		if (searchResult == 404) {
			System.out.println("Feel free to browse through our collection of cars. \n");
			System.out.println(dealership);
		} else {
			decision = scan.next(); 
		}

		if (decision.equalsIgnoreCase("yes")) {
			dealership.sellCar(searchResult); 
		}
		scan.close();
    }
	
}
