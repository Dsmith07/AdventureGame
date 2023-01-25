package gameobjects;

public class ContainerThing extends ThingHolder implements java.io.Serializable {

    private boolean openable;
    private boolean isopen;
    private boolean playable;

    // By default ContainerThings are open but not openable -
    // e.g. bowl, sack, basin
    public ContainerThing(String aName, String aDescription, ThingList tl,
            ThingHolder aContainer) {
        super(aName, aDescription, tl, aContainer);
        openable = false;
        isopen = true;        
    }

    // alternative constructor sets isopen and openable (e.g. something with lid)
    // e.g. chest, bottle, box
    public ContainerThing(String aName, String aDescription,
            boolean canTake, boolean canMove, boolean canOpen, boolean isOpen,
            ThingList tl, ThingHolder aContainer) {
        super(aName, aDescription, canTake, canMove, tl, aContainer);
        openable = canOpen;
        isopen = isOpen;
    }

    // alternative constructor sets canPlay on like a game
    // e.g. gameboy
    public ContainerThing(String aName, String aDescription,
                          boolean canTake, boolean canMove, boolean canPlay,
                          ThingList tl, ThingHolder aContainer) {
        super(aName, aDescription, canTake, canMove, tl, aContainer);
        playable = canPlay;
    }

    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public boolean isOpen() {
        return isopen;
    }

    public boolean requiresKey()
    {
        return getName().equals("chest") || getName().equals("door");
    }

    // --- actions on a Container
    @Override
    public String open() {
        String s;

        if (!openable) {
            s = "Can't open " + getName();
        } else {
            if (isopen) {
                s = "The " + getName() + " is already open.";
            } else {
                isopen = true;
                s = "You open the " + getName() + "\n" + "Things inside of the " + getName() + ":\n" + describeThings();

            }
        }
        return s;
    }

    @Override
    public String close() {
        String s;

        if (!openable) {
            s = "Can't close " + getName();
        } else {
            if (isopen) {
                isopen = false;
                s = "You close the " + getName();
            } else {
                s = "The " + getName() + " is already closed.";
            }
        }
        return s;
    }

    @Override
    public String describe() {
        String s;
        
        s = super.describe();
        if (openable) {
            if (isopen) {
                s += " (open)";
            } else {
                s += " (closed)";
            }
        }
        if (isopen) {
            if (getThings().size() > 0) {
                s += "\nThere is something in it.";
            }
        }
        return s;
    }

}
