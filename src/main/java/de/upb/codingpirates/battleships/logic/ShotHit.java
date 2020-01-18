package de.upb.codingpirates.battleships.logic;

/**
 * Represents the action of the shot
 *
 * @author
 */
public class ShotHit {

    /**
     * the type of the shot
     */
    private HitType hitType;
    /**
     * the ship, which was hit by this shot
     */
    private Ship ship;
    /**
     * the shot itself
     */
    private Shot shot;

    /**
     * Constructor of the class ShotHit
     * @param hitType type of the hit
     */
    public ShotHit(HitType hitType) {
        this.hitType = hitType;
    }

    /**
     * Constructor of the class ShotHit
     * @param ship ship, which was hit
     * @param shot shot, itself
     * @param hitType type of the shot
     */
    public ShotHit(Ship ship, Shot shot, HitType hitType) {
        this.ship = ship;
        this.shot = shot;
        this.hitType = hitType;
    }

    /**
     * Return ship, which was hit
     * @return {@link #ship}
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Return shot, which was played
     * @return {@link #shot}
     */
    public Shot getShot() {
        return shot;
    }

    /**
     * Return type of the Hit
     * @return {@link #hitType}
     */
    public HitType getHitType() {
        return hitType;
    }
}
