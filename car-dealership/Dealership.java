import java.util.Arrays;

public class Dealership {
    private Car[] cars;

    // constructor
    public Dealership(Car[] cars) {
        this.cars = new Car[cars.length];
       for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]); 
       }
    }

    public void setCar(Car car, int index) {
        this.cars[index] = new Car(car);
    }

    public Car getCar(int index) {
        return new Car(this.cars[index]); 
    }

    public void sellCar(int index) {
        this.cars[index].drive();
        this.cars[index] = null; 
    }

    public int search(String make, int budget) {
        for (int i = 0; i < this.cars.length; i++) {
            if (this.cars[i] == null) {
                continue;
            }
            else if (this.cars[i].getMake().equalsIgnoreCase(make) && this.cars[i].getPrice() <= budget) {
                System.out.println("\n We found a car in spot " + i + "\n\n" + this.cars[i].toString());
                System.out.println("If you're interested, type 'yes': ");
                return i;
            }            
        }
        System.out.println("\n Your search did not yield any results. \n");
        return 404;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < cars.length; i++) {
            if (this.cars[i] == null) {
                temp += "Parking spot: " + i + "\n";
                temp += "Empty \n\n";

            } else {
            temp += "Parking spot: " + i + "\n";
            temp += this.cars[i].toString() + "\n\n"; 
            }
        }
        return temp; 
    }
}