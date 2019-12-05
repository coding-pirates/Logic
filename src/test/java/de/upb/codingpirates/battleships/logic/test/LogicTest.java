package de.upb.codingpirates.battleships.logic.test;

import com.google.common.collect.HashBasedTable;
import de.upb.codingpirates.battleships.logic.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class LogicTest {

    public static void main(String[] args){

        //create all possible points on the field (to make things easier later)
        HashBasedTable<Integer, Integer, Point2D> point2ds = HashBasedTable.create();
        for (int w=0; w<15; w++) {
            for (int h = 0; h < 10; h++) {
                point2ds.put(w, h, new Point2D(w, h));
            }
        }

        //create a shipType
        ArrayList<Point2D> positionsForShipType1 = new ArrayList<>();
        positionsForShipType1.add(point2ds.get(0,0));
        positionsForShipType1.add(point2ds.get(1,0));
        positionsForShipType1.add(point2ds.get(1,1));
        positionsForShipType1.add(point2ds.get(1,2));
        ShipType shipType1 = new ShipType(positionsForShipType1);

        //create map of all shipTypes
        HashMap<Integer, ShipType> shipTypes = new HashMap<Integer, ShipType>();
        shipTypes.put(1, shipType1);

        //create configuration
        Configuration config = new Configuration(3, 10, 15, 2, 5,7, 10, 1, shipTypes, 1, PenaltyType.POINTLOSS);

        Game game = new Game("Testspiel", 1, GameState.IN_PROGRESS, config, false);

        Client player1 = new Client(1, "Player1");
        Client player2 = new Client(2, "Player2");
        Client player3 = new Client(3, "Player3");

        Client spectator1 = new Client(1, "Spectator1");

        game.addPlayer();
        game.addPlayer();
        game.addPlayer();

        Field field1 = new Field(config.getHeight(), config.getWidth(),1);
        Field field2 = new Field(config.getHeight(), config.getWidth(),2);
        Field field3 = new Field(config.getHeight(), config.getWidth(),3);

        PlacementInfo placementInfo1 = new PlacementInfo(new Point2D(2,5), Rotation.COUNTERCLOCKWISE_90);
        Ship ship1 = field1.placeShip(shipType1, placementInfo1);
        System.out.println("field is empty "+field1.getField().isEmpty());
        System.out.println(field1.getField().toString());

        Shot shot1 = new Shot(1, point2ds.get(7,8));
        Shot shot2 = new Shot(1,new Point2D(15,46));
        Shot shot3 = new Shot(1, point2ds.get(2,5));
        Shot shot4 = new Shot(1, point2ds.get(3,5));
        Shot shot5 = new Shot(1, point2ds.get(4,4));
        Shot shot6 = new Shot(1, point2ds.get(4,5));

        System.out.println(field1.hit(shot1).getHitType());
        System.out.println(field1.hit(shot2).getHitType());
        System.out.println(field1.hit(shot3).getHitType());

        ship1.hit(point2ds.get(2,5));
        System.out.println(field1.hit(shot4).getHitType());
        ship1.hit(point2ds.get(3,5));
        System.out.println(field1.hit(shot5).getHitType());
        ship1.hit(point2ds.get(4,4));
        ship1.hit(point2ds.get(4,5));
        System.out.println(field1.hit(shot6).getHitType());
    }


    @Test
    public void test(){

    }
}
