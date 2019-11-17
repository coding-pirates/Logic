package de.upb.codingpirates.battleships.logic;

import java.util.List;

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

}
