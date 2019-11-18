package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.HashBasedTable;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

public class Field {
    private int id;
    private int height;
    private int width;
    private Player correspondingPlayer;
    private HashBasedTable<Integer, Integer, Point2D> field = HashBasedTable.create();

    public Field(int height, int width, Player player){
        this.height = height;
        this.width = width;
        this.correspondingPlayer = player;
        this.id = correspondingPlayer.getId();
    }
    public void fillField(int x, int y, Point2D point){
        field.put(x,y,point);
    }

    public boolean placeShip(Ship ship, Point2D position, int rotation){
        Collection<Point2D> p = ship.getPositions();
        if (rotation == 0)//0Grad gedreht
        {
            for (Iterator it = p.iterator(); it.hasNext(); ){
                    ;
            }
        }
        else //noinspection StatementWithEmptyBody
            if (rotation ==1) //90Grad nach rechts gedreht
        {
            ;
        }
        else if(rotation == 2) //180Grad nach rechts gedreht
        {
            ;
        }
        else //90grad nach links
            {
                ;
        }
    return true;
    }


    public boolean hitField(Point2D point){
        if (field.contains(point.getX(), point.getY())){
            Point2D position = field.get(point.getX(), point.getY());
            if (position != null && point.isHit() == false){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setCorrespondingPlayer(Player correspondingPlayer) {
        this.correspondingPlayer = correspondingPlayer;
    }

    public void setField(HashBasedTable<Integer, Integer, Point2D> field) {
        this.field = field;
    }

    public int getWidth() {
        return width;
    }

    public Player getCorrespondingPlayer() {
        return correspondingPlayer;
    }

    public HashBasedTable<Integer, Integer, Point2D> getField() {
        return field;
    }
}
