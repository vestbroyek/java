package src.test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Game;
import src.main.models.Team;


public class GameTest {

    Game game;
    Team home; 
    Team away; 

    @Before
    public void setup() {
        home = new Team("GRYFFINDOR", "Oliver", "Harry", 
        new String[] {"Angelina", "Ginny", "Katie"});
      
        away = new Team("SLYTHERIN", "Vincent",  "Draco", 
        new String[] {"Bridget", "Harper", "Malcolm"});

        game = new Game(
            new Team(home), 
            new Team(away));
    }
    
    @Test 
    public void getPlaceholderTest() {
        assertEquals(game.getPlaceholder("<chaser> gets the next pass"), "chaser");
    }

    @Test
    public void replacePlaceholderTest() {
        assertEquals(game.replacePlaceholder("<chaser> gets the next pass", "chaser", "Katie"), "Katie gets the next pass");
    }

    @Test 
    public void quaffleScoreTest() {
        Team team = game.getTeam("GRYFFINDOR"); 
        game.quaffleScore(team); 
        assertEquals(game.getScore(team), Game.getQuafflePoints()); 
    }

    @Test 
    public void catchSnitchTest() {
        Team team = game.getTeam("SLYTHERIN"); 
        game.catchSnitch(team); 
        assertEquals(game.getScore(team), Game.getSnitchPoints()); 
    }

}
