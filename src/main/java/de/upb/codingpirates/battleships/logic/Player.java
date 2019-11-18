package de.upb.codingpirates.battleships.logic;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String name;
    private float points;
    private Field ownField;
    private ArrayList<Ship> ships;

    enum Rotation {NONE,CLOCKWISE_90,CLOCKWISE_180,COUNTERCLOCKWISE_90};

    public Player(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void shoot(List<Shot> targets){

    }

    public void setField(Field field){

    }

    public void positionShip(Ship ship, Point2D position, Rotation rotation){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public float getPoints(){
        return points;
    }

    public void setPoints(float points){
        this.points = points;
    }

    public Field getOwnField(){
        return ownField;
    }
}
