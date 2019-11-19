package de.upb.codingpirates.battleships.logic;

import java.util.List;

public class Configuration {
    //TODO DefaultConfiguration
    enum PenaltyType{NOTHING, KICK, POINTLOSS}
    public final int MAXPLAYERCOUNT;
    public final int FIELDHEIGHT;
    public final int FIELDWIDTH;
    public final int SHOTCOUNT;
    public final float HITPOINTS;
    public final float SUNKPOINTS;
    public final long ROUNDTIMER;
    public final long VISUALIZATIONTIME;
    public final List<ShipType> SHIPTYPES;
    public final float PENALTYMINUSPOINTS;
    public final PenaltyType PENALTYTYPE;

    public Configuration(int MAXPLAYERCOUNT, int FIELDHEIGHT, int FIELDWIDTH, int SHOTCOUNT, float HITPOINTS, float SUNKPOINTS, long ROUNDTIMER, long VISUALIZATIONTIME, List<de.upb.codingpirates.battleships.logic.ShipType> SHIPTYPES, float PENALTYMINUSPOINTS, PenaltyType PENALTYTYPE) {
        this.MAXPLAYERCOUNT = MAXPLAYERCOUNT;
        this.FIELDHEIGHT = FIELDHEIGHT;
        this.FIELDWIDTH = FIELDWIDTH;
        this.SHOTCOUNT = SHOTCOUNT;
        this.HITPOINTS = HITPOINTS;
        this.SUNKPOINTS = SUNKPOINTS;
        this.ROUNDTIMER = ROUNDTIMER;
        this.VISUALIZATIONTIME = VISUALIZATIONTIME;
        this.SHIPTYPES = SHIPTYPES;
        this.PENALTYMINUSPOINTS = PENALTYMINUSPOINTS;
        this.PENALTYTYPE = PENALTYTYPE;
    }

}
