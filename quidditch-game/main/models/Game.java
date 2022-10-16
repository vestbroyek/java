package src.main.models;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Game {

    private HashMap<Team, Integer> scoreboard; 
    private static int gameCount;
    private static final int QUAFFLE_POINTS = 20; 
    private static final int SNITCH_POINTS = 150; 

    // simulator
    public String simulate(String play) {
        String placeholder = getPlaceholder(play); 
        Team team = getRandomTeam(); 

        if (placeholder.equals(Team.getPositionChaser())) {
            quaffleScore(team);
            String chaser = team.getChasers()[random(team.getChasers().length)]; 
            return replacePlaceholder(play, placeholder, chaser); 
        }

        else if (placeholder.equals(Team.getPositionSeeker())) {
            catchSnitch(team); 
            return replacePlaceholder(play, placeholder, team.getSeeker());
        }

        else { 
            return replacePlaceholder(play, placeholder, team.getKeeper()); 
        }
    }


    // get random Team
    public Team getRandomTeam() {
        Object[] teams = scoreboard.keySet().toArray(); 
        return (Team)teams[random(teams.length)]; 
    }

    public int random(int range) {
        return (int)(Math.random() * range); 
    }

    // constructor
    public Game(Team home, Team away) {
        scoreboard = new HashMap<Team, Integer>();
        scoreboard.put(new Team(home), 0); 
        scoreboard.put(new Team(away), 0); 
        gameCount++; 
    }

    // getter
    public int getScore(Team team) {
        return scoreboard.get(team); 

    }

    public static int getQuafflePoints() {
        return QUAFFLE_POINTS; 
    }

    public static int getSnitchPoints() {
        return SNITCH_POINTS; 
    }

    public Team getTeam(String name) {
        return scoreboard.keySet().stream()
        .filter((key) -> key.getHouse().equals(name))
        .findFirst()
        .orElse(null); 
        }

    public static int getGameCount() {
        return gameCount; 
    }

    public String getPlaceholder(String play) {
        return play.substring(play.indexOf("<") +1, play.indexOf(">"));
    }

    public String replacePlaceholder(String play, String placeholder, String value) {
        return play.replace("<" + placeholder + ">", value); 
    }

    public void quaffleScore(Team team) {
        this.setScore(team, this.getScore(team) + QUAFFLE_POINTS); 
    }

    public void catchSnitch(Team team) { 
        this.setScore(team, SNITCH_POINTS); 
    }

    // setter
    public void setScore(Team team, Integer score) {
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null"); 
        }
        scoreboard.put(team, score); 
    }


}
