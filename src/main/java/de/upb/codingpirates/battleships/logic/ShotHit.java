package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Represents the result of a hit on a {@link Field}
 *
 * @author Paul Becker
 */
public class ShotHit {

    /**
     * The {@link HitType} of the hit
     */
    @Nonnull
    private HitType hitType;
    /**
     * The {@link Ship} if the {@link Shot} hits a @link Ship}
     */
    @Nullable
    private Ship ship;
    /**
     * The {@link Shot} if it hits a {@link Ship}
     */
    @Nullable
    private Shot shot;

    public ShotHit(@Nonnull HitType hitType) {
        this.hitType = hitType;
    }

    public ShotHit(@Nonnull Ship ship, @Nonnull Shot shot, @Nonnull HitType hitType) {
        this.ship = ship;
        this.shot = shot;
        this.hitType = hitType;
    }

    /**
     * @return {@link #ship}
     */
    @Nullable
    public Ship getShip() {
        return ship;
    }

    /**
     * @return {@link #shot}
     */
    @Nullable
    public Shot getShot() {
        return shot;
    }

    /**
     * @return {@link #hitType}
     */
    @Nonnull
    public HitType getHitType() {
        return hitType;
    }
}
