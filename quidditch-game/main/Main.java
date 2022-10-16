package src.main;
import src.main.models.Game;
import src.main.models.Team;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit; 

public class Main {

    static Game game;
    static final String TEAMS_FILE = "src/main/teams.txt";
    static final String PLAYS_FILE = "src/main/plays.txt";

    public static void main(String[] args) {

        try {
            String[][] data = getData(); 
            game = new Game(
                new Team(data[0][0], data[0][1], data[0][2], new String[] {data[0][3], data[0][4], data[0][5]}),
                new Team(data[1][0], data[1][1], data[1][2], new String[] {data[1][3], data[1][4], data[1][5]})
            );
        } catch (FileNotFoundException e ) {
            System.out.println(e.getMessage());
        }


        startGame(); 
        printResult();


    }

    /**
     * Function name: getData
     * @return (String[][])
     * @throws FileNotFoundException
     * 
     * Inside the function:
     *   1. Returns data from TEAMS_FILE as a String[][] array
     */
    public static String[][] getData() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(TEAMS_FILE)); 
        String[] lines = {sc.nextLine(), sc.nextLine()}; 

        return new String[][] {
            lines[0].split(","), 
            lines[1].split(",")
        }; 
        
    }


    /** Function name: startGame
     * 
     * Inside the function:
     *    1. Grabs each play from plays.txt and calls game.simulate(play);
     *    2. Prints the return from game.simulate(play)
     *        - println("\n" + <return> + "\n");
     */
    public static void startGame() {
        try {
        Scanner sc = new Scanner(new FileInputStream(PLAYS_FILE));
        while (sc.hasNextLine()) {
            String play = sc.nextLine();
            wait(2); 
            System.out.println(game.simulate(play));
        } 
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }


    /** Function name: printResult()
     * 
     * Inside the function:
     *    1. Prints the final score: println("\nGRYFFINDOR: " + <gryffindor score> + " SLYTHERIN: " + <slytherin score>);
     *    2. Prints the winner: println("\n" + <winner team name> + " WINS!");
     *  
     */
    public static void printResult() {
        System.out.println("GRYFFINDOR: " + game.getScore(game.getTeam("GRYFFINDOR")));
        System.out.println("SLYTHERIN: " + game.getScore(game.getTeam("SLYTHERIN")));

        if (game.getScore(game.getTeam("GRYFFINDOR")) > game.getScore(game.getTeam("SLYTHERIN"))) {
            System.out.println("GRYFFINDOR WINS!");
        } else {
            System.out.println("SLYTHERIN WINS!");
        }
    }

    /**
     * Function name: wait
     * @param sec
     * 
     * Inside the function:
     *  1. Make the code sleep for X seconds.
     */
    public static void wait(int sec) {
        try {
        TimeUnit.SECONDS.sleep(sec); 
        } catch (InterruptedException e ) {
            System.out.println(e.getMessage());
        }
    }
    


  }
