package gameobjects;

import globals.Dir;

public class Room extends ThingHolder implements java.io.Serializable {

    private Room n, s, w, e, up, down;

    public Room() {
        super("New Room", "", null, null); // init superclass
        this.n = null;
        this.s = null;
        this.w = null;
        this.e = null;
        this.up = null;
        this.down = null;
    }   
    
    public void init(String aName, String aDescription,
            Room aN, Room aS, Room aW, Room aE, Room anUp, Room aDown,
            ThingList tl) {
        setName(aName);
        setDescription(aDescription);
        this.n = aN;
        this.s = aS;
        this.w = aW;
        this.e = aE;
        this.up = anUp;
        this.down = aDown;
        setThings(tl);
    }

    // --- accessor methods ---
    // n
    public Room getN() {
        return n;
    }

    public void setN(Room aN) {
        this.n = aN;
    }

    // s
    public Room getS() {
        return s;
    }

    public void setS(Room aS) {
        this.s = aS;
    }

    // e
    public Room getE() {
        return e;
    }

    public void setE(Room aE) {
        this.e = aE;
    }

    // w
    public Room getW() {
        return w;
    }

    void setW(Room aW) {
        this.w = aW;
    }

    public Room getUp() {
        return up;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public Room getDown() {
        return down;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public String describe() {
        String roomdesc;
        String thingsdesc;

        roomdesc = String.format("%s. %s.", getName(), getDescription());
        thingsdesc = describeThings();
        if (!thingsdesc.isEmpty()) {
            roomdesc += "\nThings here:\n" + thingsdesc;
        } else {
            roomdesc += "\nThere is nothing here.\n";
        }
        return roomdesc;
    }
}
