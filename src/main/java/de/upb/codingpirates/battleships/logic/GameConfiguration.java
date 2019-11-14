package de.upb.codingpirates.battleships.logic;

import java.util.List;

public class GameConfiguration {
    //TODO DefaultConfiguration
    enum PenaltyType{NOTHING, KICK, POINTLOSS};
    public int MAXPLAYERCOUNT;
    public int FIELDHEIGHT;
    public int FIELDWIDTH;
    public int SHOTCOUNT;
    public float HITPOINTS;
    public float SUNKPOINTS;
    public long ROUNDTIMER;
    public long VISUALIZATIONTIME;
    public List<ShipType> SHIPTYPES;
    public float PENALTYMINUSPOINTS;
    public PenaltyType PENALTYTYPE;

    public GameConfiguration(int MAXPLAYERCOUNT, int FIELDHEIGHT, int FIELDWIDTH, int SHOTCOUNT, float HITPOINTS, float SUNKPOINTS, long ROUNDTIMER, long VISUALIZATIONTIME, List<de.upb.codingpirates.battleships.logic.ShipType> SHIPTYPES, float PENALTYMINUSPOINTS, PenaltyType PENALTYTYPE) {
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
