package gameobjects;

public class Thing implements java.io.Serializable {

// Basic Thing type that defines all objects in the Adventure
    private String name;
    private String description;
    private boolean takable;
    private boolean movable;
    private ThingHolder container;

    public Thing(String aName, String aDescription, ThingHolder aContainer) {
        // constructor
        this.name = aName;
        this.description = aDescription;
        this.takable = true;
        this.movable = true;
        this.container = aContainer;

    }

    public Thing(String aName, String aDescription,
            boolean canTake, boolean canMove,
            ThingHolder aContainer) {
        // constructor
        this.name = aName;
        this.description = aDescription;
        this.takable = canTake;
        this.movable = canMove;
        this.container = aContainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public boolean isTakable() {
        return takable;
    }

    public void setTakable(boolean takable) {
        this.takable = takable;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public ThingHolder getContainer() {
        return container;
    }

    public void setContainer(ThingHolder container) {
        this.container = container;
    }

    public String open() {
        return "Cannot open " + name + " because it isn't a container.";
    }

    public String close() {
        return "Cannot close " + name + " because it isn't a container.";
    }

    public String describe() {
        return name + ": " + description;
    }




    // is this Thing inside aContainer?
    private boolean isInside(ContainerThing aContainer) {
        ThingHolder th; 
        Boolean isInContainer = false;

        th = this.getContainer();
        while (th != null) {
            if (th == aContainer) {
                isInContainer = true;               
            }             
            th = th.getContainer();
        }
        return isInContainer;
    }

    public boolean isIn(Thing t){
        return (t instanceof ContainerThing) && (this.isInside((ContainerThing) t));
    }
}
