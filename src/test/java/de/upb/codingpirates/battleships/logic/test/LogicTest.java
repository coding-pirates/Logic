package de.upb.codingpirates.battleships.logic.test;

import de.upb.codingpirates.battleships.logic.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class LogicTest {

    @Test
    public void test_ship_placement(){

        //create a shipType
        ArrayList<Point2D> positionsForShipType1 = new ArrayList<>();
        positionsForShipType1.add(new Point2D(0, 0));
        positionsForShipType1.add(new Point2D(1, 0));
        positionsForShipType1.add(new Point2D(1, 1));
        positionsForShipType1.add(new Point2D(1, 2));
        ShipType shipType1 = new ShipType(positionsForShipType1);

        //create map of all shipTypes
        HashMap<Integer, ShipType> shipTypes = new HashMap<Integer, ShipType>();
        shipTypes.put(1, shipType1);

        //create configuration
        Configuration config = new Configuration(3, 10, 15, 2, 5, 7, 10, 1, shipTypes, 1, PenaltyType.POINTLOSS);

        Game game = new Game(1, "Testspiel", GameState.IN_PROGRESS, config, false);

        Client player1 = new Client(1, "Player1");
        Client player2 = new Client(2, "Player2");
        Client player3 = new Client(3, "Player3");

        Client spectator1 = new Client(1, "Spectator1");


        Field field1 = new Field(config.getHeight(), config.getWidth(), 1);
        Field field2 = new Field(config.getHeight(), config.getWidth(), 2);
        Field field3 = new Field(config.getHeight(), config.getWidth(), 3);

        //create placementInfo
        PlacementInfo placementInfo1 = new PlacementInfo(new Point2D(10, 3), Rotation.NONE);
        PlacementInfo placementInfo2 = new PlacementInfo(new Point2D(10, 3), Rotation.CLOCKWISE_90);
        PlacementInfo placementInfo3 = new PlacementInfo(new Point2D(10, 3), Rotation.CLOCKWISE_180);
        PlacementInfo placementInfo4 = new PlacementInfo(new Point2D(10, 3), Rotation.COUNTERCLOCKWISE_90);

        Ship ship1 = field1.placeShip(shipType1, placementInfo1);
        System.out.println(field1.getField());
        /*assert(field1.getField().contains(2,5));
        assert(field1.getField().contains(2,6));
        assert(field1.getField().contains(3,6));
        assert(field1.getField().contains(4,6));*/

        Ship ship2 = field2.placeShip(shipType1, placementInfo2);
        System.out.println(field2.getField());
        /*assert(field2.getField().contains(2,5));
        assert(field2.getField().contains(2,6));
        assert(field2.getField().contains(2,7));
        assert(field2.getField().contains());*/

        Ship ship3 = field3.placeShip(shipType1, placementInfo3);
        System.out.println(field3.getField().toString());
    }

   /* @Test
    public void test_shooting(){
        //create a shipType
        ArrayList<Point2D> positionsForShipType1 = new ArrayList<>();
        positionsForShipType1.add(new Point2D(0, 0));
        positionsForShipType1.add(new Point2D(1, 0));
        positionsForShipType1.add(new Point2D(1, 1));
        positionsForShipType1.add(new Point2D(1, 2));
        ShipType shipType1 = new ShipType(positionsForShipType1);

        //create map of all shipTypes
        HashMap<Integer, ShipType> shipTypes = new HashMap<Integer, ShipType>();
        shipTypes.put(1, shipType1);

        //create configuration
        Configuration config = new Configuration(3, 10, 15, 2, 5, 7, 10, 1, shipTypes, 1, PenaltyType.POINTLOSS);

        Game game = new Game(1, "Testspiel", GameState.IN_PROGRESS, config, false);

        Client player1 = new Client(1, "Player1");
        Client player2 = new Client(2, "Player2");
        Client player3 = new Client(3, "Player3");

        Client spectator1 = new Client(1, "Spectator1");


        Field field1 = new Field(config.getHeight(), config.getWidth(), 1);
        Field field2 = new Field(config.getHeight(), config.getWidth(), 2);
        Field field3 = new Field(config.getHeight(), config.getWidth(), 3);

        //create placementInfo
        PlacementInfo placementInfo1 = new PlacementInfo(new Point2D(2, 5), Rotation.NONE);
        PlacementInfo placementInfo2 = new PlacementInfo(new Point2D(2, 5), Rotation.CLOCKWISE_90);
        PlacementInfo placementInfo3 = new PlacementInfo(new Point2D(2, 5), Rotation.CLOCKWISE_180);
        PlacementInfo placementInfo4 = new PlacementInfo(new Point2D(2, 5), Rotation.COUNTERCLOCKWISE_90);

        Ship ship1 = field1.placeShip(shipType1, placementInfo1);

        //create shots
        Shot shot1 = new Shot(1, new Point2D(7,8));
        Shot shot2 = new Shot(1, new Point2D(15, 46));
        Shot shot3 = new Shot(1, new Point2D(2,5));
        Shot shot4 = new Shot(1, new Point2D(2,6));
        Shot shot5 = new Shot(1, new Point2D(3,6));
        Shot shot6 = new Shot(1, new Point2D(3,7));

        assert(field1.hit(shot1).getHitType()==HitType.NONE);
        assert(field1.hit(shot2).getHitType()==HitType.FAIL);
        assert(field1.hit(shot3).getHitType()==HitType.HIT);
        assert(field1.hit(shot4).getHitType()==HitType.HIT);
        assert(field1.hit(shot5).getHitType()==HitType.HIT);
        assert(field1.hit(shot6).getHitType()==HitType.SUNK);

        assert(ship1.hit(new Point2D(2,5)));
        assert(ship1.hit(new Point2D(2,6)));
        assert(ship1.hit(new Point2D(3,6)));
        assert(ship1.hit(new Point2D(3,7)));

    }*/

}
