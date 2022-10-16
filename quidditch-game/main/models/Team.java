package src.main.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects; 
public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers; 

    // methods
    public static boolean hasNull(String[] array) {
        return Arrays.stream(array).anyMatch((element) -> element == null); 
    }

    public static boolean hasBlank(String[] array) {
        return Arrays.stream(array).anyMatch((element) -> element.isBlank()); 
    }

    public void checkParam(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null or blank"); 
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Team)) {
            return false;
        }

        // cast
        Team newobj = (Team)obj; 

        return 
        this.seeker.equals(newobj.seeker) &&
        this.keeper.equals(newobj.keeper) &&
        Arrays.toString(this.chasers).equals(Arrays.toString(newobj.chasers)); 
    }

    // hashCode
    public int hashCode() { 
        return Objects.hash(this.house, this.keeper, this.seeker, Arrays.toString(this.chasers)); 
    }

    // constructor
    public Team(String house, String keeper, String seeker, String[] chasers) {
        if (house == null || keeper == null || seeker == null || chasers == null || 
            house.isBlank() || keeper.isBlank() || seeker.isBlank() || chasers.length != 3) {
                throw new IllegalArgumentException();
            }

        if (hasNull(chasers) || hasBlank(chasers)) {
            throw new IllegalArgumentException(); 
        }
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = chasers; 
    }

    // copy constructor
    public Team(Team source) { 
        this.house = source.house; 
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = source.chasers; 

    }

    // getters
    public String getHouse() {
        return house;
    }

    public String getKeeper() {
        return keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public String[] getChasers() {
        return chasers;
    }

    // setters
    public void setHouse(String house) {
        checkParam(house); 
        this.house = house;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper); 
        this.keeper = keeper;
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public void setChasers(String[] chasers) {
        this.chasers = chasers;
    }

    // toString
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "House: " + this.house + "\n" +
        "Keeper: " + this.keeper + "\n" +
        "Seeker: " + this.seeker + "\n" +
        "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

     public static String getPositionChaser() {
         return POSITION_CHASER;
     }

     public static String getPositionSeeker() {
         return POSITION_SEEKER;
     }

     public static String getPositionKeeper() {
         return POSITION_KEEPER;
     }

}
