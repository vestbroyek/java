public class Airline {
    private Person[] seats; 

    public Airline() {
        this.seats = new Person[11]; 
    }

    public Person getPerson(int index) {
        return new Person(seats[index]); 
    }

    public void setPerson(Person person) {
        this.seats[person.getSeatNumber() - 1] = new Person(person);
    }

    public void createReservation(Person person) {
        int seat = person.getSeatNumber();

        while (this.seats[seat - 1] != null) {
            System.out.println("Seat "+ person.getSeatNumber() +" is already taken");
            person.chooseSeat();
            seat = person.getSeatNumber();
        }


        this.seats[(seat - 1)] = new Person(person); 
        System.out.println("Thank you " + person.getName() +
        " for flying with Java airlines. Your seat number is " +
        seat + ".");
    }

    public String toString() {
        String temp = ""; 
        for (int i = 0; i < seats.length; i++) {
            if (this.seats[i] != null) {
                temp += this.seats[i].toString() + "\n\n";
            } else {
                temp += "Seat " + (i + 1) + " is empty. \n\n";
            }
        }
        return temp;
    }
}
