package de.upb.codingpirates.battleships.logic;

import java.util.List;
import de.upb.codingpirates.battleships.logic.util.Pair;

public class Game {

    private int id;
    private String name;
    private int playerCount;
    private GameState gameState;
    private GameConfiguration config;
    private List<Player> players;
    private List<Field> fields;
    private long timeLeft;
    private int round;


    public Game(GameConfiguration config) // unsicher ob Datentyp Gameconfiguration or Configuration
    {

        this.config = config;
    }

    public boolean areShotsLeft(Player player)
    {
        //TODO
        return false;

    }
    public boolean areAllShipsSunken(Player player)
    {
        //TODO
        return false;
    }
    public boolean isTimeLeft()
    {
        //TODO
        return false;
    }

    public boolean areShipsIndepentent(List<Ship> Ships)
    {
        //TODO
        return false;
    }
    public void addPlayer(Player player)
    {
        //TODO
    }

    private void addField(Player player)
    {
        //TODO
    }
    public List<Pair<Player,String>> getFinalScore()
    {
        //TODO
        return null;

    }
    
      public int getId() { //getter ID
        return id;
    }

    public String getName() {//getter Name
        return name;
    }

    public void setName(String name) {//setter Name
        this.name = name;
    }

    public int getCurrentPlayerCount() {//getter Playercount
        return currentPlayerCount;
    }

    public void setCurrentPlayerCount(int currentPlayerCount) { //setter Playercount
        this.currentPlayerCount = currentPlayerCount;
    }

    public boolean isTournament() { //getter Tournament
        return tournament;
    }

    public void setTournament(boolean tournament) { //setter Tournament
        this.tournament = tournament;
    }

    public List<Player> getPlayers() { //getter Players from game
        return players;
    }

    public int getRound() { //getter Roundnumber
        return round;
    }

    public GameState getState() { //getter Gamestate
        return state;
    }

    public Configuration getConfig() { //getter Configuration
        return config;
    }

    public List<Field> getFields() {//getter fields
        return fields;
    }

    public long getTimeLeft() { //getter left time
        return timeLeft;
    }

}
