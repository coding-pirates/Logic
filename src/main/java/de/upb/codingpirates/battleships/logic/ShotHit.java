package de.upb.codingpirates.battleships.logic;

public class ShotHit {

    private HitType hitType;
    private Ship ship;
    private Shot shot;

    public ShotHit(HitType hitType) {
        this.hitType = hitType;
    }

    public ShotHit(Ship ship, Shot shot, HitType hitType) {
        this.ship = ship;
        this.shot = shot;
        this.hitType = hitType;
    }

    public Ship getShip() {
        return ship;
    }

    public Shot getShot() {
        return shot;
    }

    public HitType getHitType() {
        return hitType;
    }
}

