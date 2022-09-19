import java.lang.Math;
import java.util.Arrays;
public class Person {
    private String name;
    private String nationality;
    private String dateOfBirth;
    private String[] passport;
    private int seatNumber;
   
    public Person(String name, String nationality, String dateOfBirth,  int seatNumber) {
	    this.name = name;
	    this.nationality = nationality;
	    this.dateOfBirth = dateOfBirth;
	    this.passport = new String[3];
	    this.seatNumber = seatNumber;
    }
    // add applyPassport() method 
    public boolean applyPassport() {
	    double answer = Math.random();
	    if (answer >= 0.5) {
		    return true;
	    }
	    else {
		    return false;
	    }
    }	    
    // add chooseSeat() method
    public void chooseSeat() {
	    int seat = (int)((Math.random() * 11) + 1);
	    this.seatNumber = seat;
    }
    public String getName() {
	    return name; 
    }

    public String getNationality() {
	    return nationality;
    }

    public String getDateOfBirth() {
	    return dateOfBirth;
    } 

    public int getSeatNumber() {
	    return this.seatNumber;
    }

    public String[] getPassport() {
        return Arrays.copyOf(passport, passport.length); 
    }
    // add setters
    public void setName(String name) {
	    this.name = name; 
    }

    public void setNationality(String nationality) {
	    this.nationality = nationality; 
    }

    public void setDateOfBirth(String dateOfBirth) {
	    this.dateOfBirth = dateOfBirth;
    }

    public void setSeatNumber(int seatNumber) {
	    this.seatNumber = seatNumber;
    }

    public void setPassport() {
        this.passport = new String[] {name, nationality, dateOfBirth};
    }
    // add copy constructor
    public Person(Person source) {
	    this.name = source.name;
	    this.nationality = source.nationality;
	    this.dateOfBirth = source.dateOfBirth;
	    this.seatNumber = source.seatNumber;
        this.passport = Arrays.copyOf(source.passport, source.passport.length);
    } 

    public String toString() {
        return "Name: " + this.name + "\n" + "Nationality: " + 
        this.nationality + "\n" + "Date of Birth: " + 
        this.dateOfBirth + "\n" + "Seat Number: " +
        this.seatNumber;
    }



}

