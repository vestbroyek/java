import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");
        
        
        Item[][] items = new Item[][] {
             { new Item("Pepsi", 1.99, 3) , new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
             { new Item("Fanta", 1.99, 2) , new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
             { new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1) }
        };
        Scanner scan = new Scanner(System.in); 
        // create machine
        Machine machine = new Machine(items); 
        
        System.out.println(machine);
        while (true) {
            // pick up preferences
            System.out.println("Pick a row: ");
            int rowPref = scan.nextInt(); 
            System.out.println("Pick a spot: ");
            int spotPref = scan.nextInt(); 
            boolean dispenseResult = machine.dispense(rowPref, spotPref); 
            int reply = 1;
            if (dispenseResult) {
                System.out.println("Enjoy your drink! Press 1 to purchase another... ");
                reply = scan.nextInt();
            } else {
                System.out.println("Sorry, we are out of this item. Please press 1 to purchase another");
                reply = scan.nextInt(); 
            }
            if (reply != 1) {
                break; 
            }

            System.out.println(machine);
        }
        scan.close(); 
    }
}
