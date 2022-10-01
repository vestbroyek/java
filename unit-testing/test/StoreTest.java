package java.src.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.src.main.models.Movie;
import java.src.main.models.Store;

import org.junit.Before;
import org.junit.Test;

public class StoreTest {

    Store store;

    @Before
    public void setup() {
        store = new Store(); 
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "DVD", 9.1)); 
    }

    @Test
    public void movieAdded() {
        assertTrue(store.contains(new Movie("The Godfather", "DVD", 9.1))); 
    }

    @Test
    public void sellMovieTest() {
        store.sellMovie("The Godfather"); 
        assertFalse(store.contains(new Movie("The Godfather", "DVD", 9.1))); 
    }

    @Test
    public void rentMovieTest() {
        store.rentMovie("The Godfather"); 
        assertFalse(store.getMovie(1).isAvailable()); 
    }

    @Test 
    public void returnMovieTest() {
        store.rentMovie("The Godfather"); 
        store.returnMovie("The Godfather"); 
        store.assertTrue(store.getMovie(store.getMovieIndex("The Godfather")).isAvailable()); 
    }

    @Test(expected = IllegalStateException.class)
    public void movieNotInStock() {
        store.rentMovie("The Godfather"); 
        store.sellMovie("The Godfather"); 

    }

}
