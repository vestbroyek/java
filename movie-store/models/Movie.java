package models;

public class Movie {
    private String name; 
    private String format;
    private double rating; 
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;


    // constructor
    public Movie(String name, String format, double rating) {
        // if (name == null || name.isBlank() || !format.equalsIgnoreCase("DVD") || !format.equalsIgnoreCase("Blu-Ray") || rating < 0 || rating > 10) {
        //     throw new IllegalArgumentException("Illegal argument");
        // }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;

        // selling and rental price
        this.sellingPrice = (this.format.equals("DVD")) ? 2.25 : 4.25;
        this.rentalPrice = (this.format.equals("DVD")) ? 0.99 : 1.99;
    }

    // copy constructor
    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format; 
        this.rating = source.rating; 
        this.isAvailable = source.isAvailable;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
    }

    // toString
    public String toString() {
        String availability = (isAvailable) ? "In stock" : "Rented"; 

        return "\t Name: " + this.name + "\n" +
        "\t Format: " + this.format + "\n" + 
        "\t Rating: " + this.rating + "\n" + 
        "\t Selling Price: " + this.sellingPrice + "\n" +
        "\t Rental Price: " + this.rentalPrice + "\n" +
        "\t Availability: " + availability + "\n";    
    }

    // getters
    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // setters
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public void setRating(int rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10"); 
        }
        this.rating = rating;
    }

    public void setFormat(String format) {
        if (!format.equalsIgnoreCase("DVD") || !format.equalsIgnoreCase("Blu-Ray")) {
            throw new IllegalArgumentException("Invalid format"); 
        }
        this.format = format;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


}
