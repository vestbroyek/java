import java.util.Arrays;
import java.util.Scanner;

import javax.xml.namespace.QName;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        // initialise scanner
        Scanner scan = new Scanner(System.in); 

        System.out.println("Let's play hangman!");
        // need to pick a word
        String wordToGuess = randomWord(words);
        // get the length of the word
        int wordLength = wordToGuess.length();
        // first turn, print the gallows, placeholder, plus guesses
        System.out.println(gallows[0]);
        // initialise placeholders for word and empty guesses, as well as gallowcounter
        String[] wordPlaceholder = new String[wordLength];
        String[] stringPlaceholder = new String[6];
        int gallowCounter = 0;
        int turnCounter = 0;

        // fill word placeholder with underscores
        for (int i = 0; i < wordLength; i ++ ) {
            wordPlaceholder[i] = "_ ";
        }

        // fill guesses placeholder with six underscores
        for (int i = 0; i < 6; i ++ ) {
            stringPlaceholder[i] = "_ ";
        }
        
        // print initial state
        System.out.println("Word: " + Arrays.toString(wordPlaceholder));
        System.out.println("Guesses: " + Arrays.toString(stringPlaceholder));

        String guess = "";

        while (gallowCounter < 6) {

            // turn sequence: they guess a letter, you check whether it is correct
            System.out.println("Please take a guess...");
            guess = scan.next().toLowerCase();
            turnCounter += 1;
            int index = correctGuess(guess, wordToGuess);

            if (index != -1) {
                System.out.println("Correct!");
                wordPlaceholder[index] = guess;
            } else {
                System.out.println("Wrong!");
                stringPlaceholder[gallowCounter] = guess;
                gallowCounter += 1;
            }

            // start of new turn: print board and updated placeholders
            System.out.println(gallows[gallowCounter]);
            System.out.println("Word: " + Arrays.toString(wordPlaceholder));
            System.out.println("Guesses: " + Arrays.toString(stringPlaceholder));

            if (gallowCounter == 6) {
                System.out.println("You lose!");
                System.exit(0);
            }

            boolean haswon = checkWin(wordPlaceholder, wordToGuess);
            if (haswon) {
                System.out.println("You win! Congratulations!");
                System.exit(0);
            } else {
                System.out.println("The game continues...");
            }

            

        } 

        

        scan.close();

        }


    // pick a word
    public static String randomWord(String[] wordArray) {
        int position = (int)(Math.random() * wordArray.length);
        return wordArray[position];
    }

    // verify guess
    public static int correctGuess(String guess, String wordToGuess) {
        // check if guess in word
        int charIndex = wordToGuess.indexOf(guess);
        return charIndex;
    }

    // check if won 
    public static boolean checkWin(String[] guesses, String word) {
        String[] arrayToGuess = word.split("");
        if (Arrays.equals(guesses, arrayToGuess)) {
            return true;
        } else {
            return false;
        }
    }
    

    

}





