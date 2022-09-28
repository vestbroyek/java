package models;

import java.util.ArrayList;

public class Store {
    
    private ArrayList<Movie> movies = new ArrayList<Movie>(); 

    // constructor
    public Store() {
        this.movies = new ArrayList<Movie>(); 
    }

    // getter
    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index)); 
    }

    // setter
    public void setMovie(int index, Movie movie) {
        movies.set(index, new Movie(movie)); 
    }

    // adding
    public void addMovie(Movie movie) {
        movies.add(movie); 
    }

    // selling
    public void sellMovie(String movieName) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(movieName)) {
                movies.remove(i); 
            }
        }
    }

    // renting
    public void rentMovie(String movieName) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(movieName)) {
                movies.get(i).setAvailable(false);  
            }
        }
    }

    // returning
    public void returnMovie(String movieName) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(movieName)) {
                movies.get(i).setAvailable(true);  
            }
        }
    }

    // action
    public void action(String name, String action) {
        if (action.equals("sell")) {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getName().equals(name)) {
                    movies.remove(i); 
                }
            } 
        }

        if (action.equals("rent")) {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getName().equals(name)) {
                    movies.get(i).setAvailable(false);  
                }
            } 
        }

        if (action.equals("return")) {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getName().equals(name)) {
                    movies.get(i).setAvailable(true);  
                }
            } 
        }
    }

    // toString
    public String toString() {
        String temp = "";
        for (int i = 0; i < movies.size(); i++) {
            temp += movies.get(i).toString();
            temp += "\n\n";  
        }
        return temp;
    }

}
