package gameobjects;

import game.AdventureGame;
import globals.Dir;
import globals.ThingAndThingHolder;

import java.util.concurrent.atomic.AtomicReference;

/*
TODO: ADD HEALTH AND MAKE MONSTERS, WEAPONS, DAMAGE
 */

public class Actor extends ThingHolder implements java.io.Serializable {
    public int coins = 0;
    //  private Room location; // the Room where the Person is at present
    public Actor(String aName, String aDescription, ThingList tl, Room aRoom) {
        super(aName, aDescription, tl, aRoom); // init super class
    }

    public void setLocation(Room aRoom) {
        setContainer(aRoom);
    }

    public Room getLocation() {
        return (Room) getContainer();
    }

    public String describeLocation() {
        return ((Room) getContainer()).describe();
    }


    public String inventory() {
        String s;

        s = describeThings();

        if (s.isEmpty()) {
            s = "coins: 0 coins\nnothing";
        }
        if (getName().equals("player"))
        {
            return "You have \n" + s;
        } else{
            return getName() + " has \n" + s;
        }
    }



    // is the thing found in any list (including 'nested' lists
    // either in the player's inventory or in the current location?
    // If so, return ThingAndThingHolder initialized with Thing/ThingHolder
    public ThingAndThingHolder isThingHere(String obname) {
        ThingAndThingHolder t_th;

        t_th = isThingInInventory(obname);
        if (t_th == null) {
            t_th = isThingInRoom(obname);
        }
        return t_th;
    }




    public ThingAndThingHolder isThingInInventory(String obname) {
        return this.findThing(obname);
    }

    public ThingAndThingHolder isThingInRoom(String obname) {
        //  return location.findThing(obname);
        return ((Room) getContainer()).findThing(obname);
    }

    public String closeOb(String obname) {
        ThingAndThingHolder t_th;
        Thing t;
        String s;

        if (obname.isEmpty()) {
            s = "You'll have to say what you want to close!";
        } else {
            t_th = isThingHere(obname);
            t = t_th.getThing();
            if (t == null) {
                s = "There is no " + obname + " here!";
            } else {
                if (t instanceof ContainerThing && t.getName().equals("chest"))
                {
                    AdventureGame.sp.playSound("closechest.wav");
                }
                s = t.close();
            }
        }
        return s;
    }

    public String openOb(String obname) {
        ThingAndThingHolder t_th;
        Thing t;
        String s;

        if (obname.isEmpty()) {
            s = "You'll have to say what you want to close!";
        } else {
            t_th = isThingHere(obname);
            t = t_th.getThing();
            if (t == null) {
                s = "There is no " + obname + " here!";
            } else {
                if (t.getName().equals("sack"))
                {
                    AdventureGame.sp.playSound("bag.wav");
                } else {
                    AdventureGame.sp.playSound("open.wav");
                }

                s = t.open();
            }
        }
        return s;
    }

    /*
    public String openOb(String obname, String ob) {
        ThingAndThingHolder t_th;
        ThingHolder th = t_th.getThingHolder();
        ContainerThing ct;
        Thing t;
        String s;
        ct.setContainer(th);

        if (obname.isEmpty()) {
            s = "You'll have to say what you want to open!";
        } else if (ob.isEmpty()){
            s = "You'll have to say what you want to open the " + obname + " with!";
        } else{
            t_th = isThingHere(obname);
            t = t_th.getThing();
            if (t == null) {
                s = "There is no " + obname + " here!";
            } else if (ct.requiresKey()){
                    t_th = isThingInInventory(ob);
                    t = t_th.getThing();

                    s = t.open();
                }
            }
        }
        return s;
    }

     */

    public String lookIn(String obname) {
        String s = "";
        ThingAndThingHolder t_th;
        Thing t;
        ContainerThing container;

        t_th = isThingHere(obname);
        if (t_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_th.getThing();
            container = toContainerThing(t);
            if (container == null) {
                s = "You can't look inside the " + t.getName() + ".";
            } else {
                if (container.isOpen()) {
                    s = container.describeThings();
                    if (s.isEmpty()) {
                        s = "There is nothing in the " + container.getName();
                    } else {
                        s = "The " + container.getName() + " contains:\n" + s;
                    }
                } else {
                    s += "The " + container.getName() + " isn't open.";
                }
            }
        }
        return s;
    }


    public String lookAt(String obname) {
        String s = "";
        ThingAndThingHolder t_th;
        Thing t;
        ThingHolder th;

        t_th = isThingHere(obname);
        if (t_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_th.getThing();
            th = t_th.getThingHolder();
            if (th instanceof ContainerThing) {
                s = "[The " + t.getName() + " is inside " + th.getName() + "]\n";
            }
            s += t.describe();
        }
        return s;
    }

    public String putInto(String obname, String containername) {
        String s;
        ThingAndThingHolder t_th;
        Thing t;
        ThingAndThingHolder cont_th;
        ContainerThing container;

        t_th = isThingInInventory(obname); // is it in player's inventory?
        cont_th = isThingHere(containername); // is it in room or inventory?

        if (t_th == null) {
            s = "You haven't got the " + obname;
        } else if (cont_th == null) {
            s = "There is no " + containername + " here!";
        } else { // if Thing and Container are found
            t = t_th.getThing();
            container = toContainerThing(cont_th.getThing());
            if ((container == null)) {      // container is not a ContainerThing
                s = "You can't put the " + obname + " into the " + containername + "!";
            } else if (t == container) {
                s = "You can't put the " + obname + " into itself!";
            } else if (container.containsThing(t)) {
                s = "The " + obname + " is already in the " + containername;
            } else if (!(container).isOpen()) {
                s = "You can't put the " + obname + " into a closed " + containername + "!";
            } else if (container.isIn(t)) {
                s = "You can't put the " + obname + " into the " + containername
                        + "\nbecause the " + containername + " is already in the " + obname + "!";
            } else {
                if(container.getName().equals("sack"))
                {
                    AdventureGame.sp.playSound("intosack.wav");
                }
                transferOb(t, t_th.getThingHolder(), container);
                s = "You put the " + obname + " into the " + containername + ".";
            }
        }
        return s;
    }

    public String take(String obname) {
        String s;
        ThingAndThingHolder t_th;
        Thing t;
        ThingList tl;
        ThingHolder th;


        if (obname.equals("coins"))
        {
            t_th = isThingInRoom(obname);
            if (t_th == null) {
                s = "Can't see " + obname + " here.";
                return s;
            } else {
                AdventureGame.sp.playSound("coin.wav");
                t = t_th.getThing();
                tl = t_th.getList();
                th = t_th.getThingHolder();
                if (th instanceof ContainerThing) {
                     s = "You take the " + obname + " from the " + th.getName();
                     coins += ((Treasure) t).getValue();

                     if (AdventureGame.game.player.isThingInInventory(obname) != null)
                     {
                         tl.remove(t);
                         ((Treasure) t).setValue(coins);
                     } else {
                         ((Treasure) t).setValue(coins);
                         transferOb(t, th, this);
                     }

                     return s;

                } else{
                    s = obname + " taken!";
                    coins += ((Treasure) t).getValue();
                    transferOb(t, th, this);
                    return s;
                }
            }

        }


        t_th = isThingHere(obname);
        if (t_th == null) {
            s = "Can't see " + obname + " here.";
        } else {
            t = t_th.getThing();
            tl = t_th.getList();
            th = t_th.getThingHolder();

            if (t instanceof Actor)
            {
                AdventureGame.sp.playSound("error.wav");
                s = "Cannot take " + obname;
                return s;
            }

            if (tl == this.getThings()) {
                AdventureGame.sp.playSound("error.wav");
                s = "You already have the " + obname;
            } else {
                if (t.isTakable()) {
                    AdventureGame.sp.playSound("take.wav");
                    transferOb(t, th, this);
                    if (th instanceof ContainerThing) {
                        s = "You take the " + obname + " from the " + th.getName();
                    } else{
                        s = obname + " taken!";
                    }
                } else {
                    AdventureGame.sp.playSound("error.wav");
                    s = "You can't take the " + t.getName() + "!";
                }
            }
        }
        return s;
    }

    public String drop(String obname) {
        String s;
        ThingAndThingHolder t_th;
        Thing t;

        t_th = this.findThing(obname);
        if (t_th == null) {
            s = "You don't appear to have the " + obname + ".";
        } else {
            if (t_th.getThingHolder().getName().equals("player"))
            {
                AdventureGame.sp.playSound("drop.wav");
            }
            t = t_th.getThing();
            transferOb(t, t_th.getThingHolder(), this.getLocation());
            s = obname + " dropped!";
        }
        return s;
    }

    public Boolean moveTo(Dir dir) {
        Room r;
        Room exit;
        Boolean moved = false;

        r = getLocation();
        switch (dir) {
            case NORTH:
                exit = r.getN();
                break;
            case SOUTH:
                exit = r.getS();
                break;
            case EAST:
                exit = r.getE();
                break;
            case WEST:
                exit = r.getW();
                break;
            case UP:
                exit = r.getUp();
                break;
            case DOWN:
                exit = r.getDown();
                break;
            default:
                exit = null; // noexit - stay in same room
                break;
        }
        if (exit != null) {
            setLocation(exit);
            moved = true;
        }
        return moved;
    }

}
