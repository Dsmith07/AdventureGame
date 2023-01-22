package gameobjects;

import game.AdventureGame;
import globals.ThingAndThingHolder;

import java.util.Objects;

public class ThingHolder extends Thing implements java.io.Serializable {

    private ThingList things;
    private ThingAndThingHolder t_and_th = null;
    private String thingStr = "";

    public ThingHolder(String aName, String aDescription, ThingList tl,
            ThingHolder aContainer) {
        super(aName, aDescription, aContainer);
        things = tl;
    }

    public ThingHolder(String aName, String aDescription, boolean canTake,
            boolean canMove, ThingList tl,
            ThingHolder aContainer) {
        super(aName, aDescription, canTake, canMove, aContainer);
        things = tl;
    }




    public static ContainerThing toContainerThing(Thing t) {
        ContainerThing ct = null;

        if (t instanceof ContainerThing) {
            ct = (ContainerThing) t;
        }
        return ct;
    }

    public int numberOfThings(){
        return things.size();
    }
    /*
     * Thing is 'here' if it is visible (e.g. it's in a Room if it is an object
     * in that room or an object in an open container in that room).
     *
     * Recursively look for a Thing called obname in the list maintained by the
     * ThingHolder th. If found in that list any list 'branching off' it, the
     * object variable t_and_th is initialized with the Thing and the
     * ThingHolder which 'contains' it.
     */
    private void findThingInAnyList(ThingHolder th, String obname) {
        boolean found = false;
        ContainerThing container;

        for (Thing t : th.getThings()) {
            if (t.getName().equals(obname)) {
                t_and_th = new ThingAndThingHolder(t, th);
                found = true;
            }
            if (!found) {
                container = toContainerThing(t);
                if ((container != null) && (container.isOpen())){
                    findThingInAnyList(container, obname);
                }             
            }
        }
    }

    private void doDescribeThings(ThingHolder th) {
        ThingList tlist = th.getThings();
        ContainerThing container;
        String npcName;

        for (Thing t : tlist) {
            String containerName = "";
            if (t.getContainer() instanceof ContainerThing) {
                containerName = " [ in " + t.getContainer().getName() + " ]";
            }
            if (t instanceof Treasure && !(t.getContainer() instanceof Room))
            {
                if (t.getName().equals("coins"))
                {

                    int value = AdventureGame.game.player.coins;
                    String coinsCoin;
                    coinsCoin = (value > 1 || value == 0) ? ("coins"):("coin");
                    thingStr += t.getName() + containerName + ": "+ value + " " + coinsCoin + "\n";

                } else {
                    int value = ((Treasure) t).getValue();
                    String coinsCoin;
                    coinsCoin = (value > 1 || value == 0) ? ("coins"):("coin");
                    thingStr += t.getName() + containerName + ": "+ value + " " + coinsCoin + "\n";
                }
            }else {
                thingStr += t.getName() + containerName + "\n";
            }

            container = toContainerThing(t);
            if ((container != null) && (container.isOpen())) {
                if (container.numberOfThings() > 0) {
                    doDescribeThings(container);
                }
            }
        }        
    }

    public String describeThings() {
        thingStr = "";
        doDescribeThings(this);
        return thingStr;
    }

    public boolean containsThing(Thing t) {
        return getThings().contains(t);
    }

    public ThingAndThingHolder findThing(String obname) {
        t_and_th = null;
        findThingInAnyList(this, obname);
        return t_and_th;
    }

    public ThingList getThings() {
        return things;
    }

    public void setThings(ThingList things) {
        this.things = things;
    }

    public void remove(Thing t) {
        things.remove(t);
    }

    public void add(Thing t) {
        things.add(t);
    }

    protected void transferOb(Thing t, ThingHolder fromTH, ThingHolder toTH) {
        fromTH.remove(t);
        toTH.add(t);
        t.setContainer(toTH);
    }



}
