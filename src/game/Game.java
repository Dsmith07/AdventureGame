package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;     // required for ArrayList

import gameobjects.*;
import globals.Dir;
import globals.ThingAndThingHolder;

import javax.swing.*;

public class Game implements java.io.Serializable {

    private ArrayList<Room> map; // the map - an ArrayList of Rooms    
    public Actor player;  // the player - provides 'first person perspective'
    public Actor trader;

    public Game() {
        Parser.initVocab();
        initGame();
    }

    private void initGame() {
        this.map = new ArrayList<Room>();
        // --- construct a new adventure ---

        ThingList trollRoomList = new ThingList("trollRoomList");
        ThingList forestList = new ThingList("forestList");
        ThingList caveList = new ThingList("caveList");
        ThingList dungeonList = new ThingList("dungeonList");
        ThingList rainbowList = new ThingList("rainbowList");
        ThingList playerList = new ThingList("playerList");
        ThingList traderList = new ThingList("traderList");
        ThingList sackList = new ThingList("sackList");
        ThingList chestList = new ThingList("chestList");
        //ThingList gameList = new ThingList("gameList");


        Room trollRoom = new Room();
        Room forest = new Room();
        Room cave = new Room();
        Room shed = new Room();
        Room dungeon = new Room();
        Room rainbow = new Room();
        Room sack = new Room();
        Room chest = new Room();

        Treasure gameBoy = new Treasure("relic", "a strange device with with a fluorescent hum, it seems like you can play this device", 50, trader);
        Treasure traderTest = new Treasure("lol", "a test for trader items",100, trader);
        ContainerThing sackCont = new ContainerThing("sack", "a smelly old sack", true, true, true, false, sackList, trollRoom);
        Treasure inSack = new Treasure("bone", "a crisp bone", 10, sack);

        ContainerThing chestContainer = new ContainerThing("chest", " sparkly, shiny chest", false, true,true, false, chestList, trollRoom);
        Treasure coins1 = new Treasure("coins", "shiny gold coins", 25, chest);
        Treasure coins3 = new Treasure("coins", "shiny gold coins", 25, trollRoom);
        Treasure coins2 = new Treasure("coins", "shiny gold coins", 50, chest);

        trollRoomList.add(new Treasure("carrot", "It is a very crunchy carrot", 1, trollRoom));
        trollRoomList.add(new Thing("tree", "It is a very big tree", false, false, trollRoom));
        trollRoomList.add(sackCont);
        trollRoomList.add(chestContainer);
        trollRoomList.add(coins3);
        trollRoomList.add(new ContainerThing("bowl", "a brass bowl", true, true, false, true, new ThingList("bowlList"), trollRoom));
        trollRoomList.add(new ContainerThing("box", "a cardboard box", true, true, true, true, new ThingList("boxList"), trollRoom));


        traderList.add(gameBoy);
        traderList.add(traderTest);

        chestList.add(coins1);
        chestList.add(coins2);

        sackList.add(inSack);

        forestList.add(new Treasure("sausage", "It is a plump pork sausage", 10, forest));

        caveList.add(new Treasure("paper", "Someone has written a message on the scrap of paper using a blunt pencil. It says 'This space is intentionally left blank'", 1, cave));
        caveList.add(new Treasure("pencil", "This pencil is so blunt that it can no longer be used to write.", 1, cave));

        dungeonList.add(new Treasure("ring", "It is a ring of great power.", 500, dungeon));
        dungeonList.add(new Treasure("wombat", "It's a cuddly little wombat. It is squeaking gently to itself.", 700, dungeon));
        
        
        // Map:
        //
        //                                                              Troll Room --- Forest
        //                                                                |
        //                                                              Cave --------- Shed
        //                                                               |
        //                                                              V
        //Rainbow room ---------Dungeon
        //                 Room( name,   description,                                                                                                               N,        S,      W,      E,  [Up], [Down])
        trollRoom.init("Troll Room", "A dank room that smells of troll", null, cave, null, forest, null, null, trollRoomList);
        forest.init("Forest", "A leafy woodland", null, null, trollRoom, null, null, null, forestList);
        cave.init("Cave", "A dismal cave with walls covered in luminous moss. It looks like there may be a hole in the ground. Try going `down`", trollRoom, null, null, shed, null, dungeon, caveList);
        shed.init("Shed", "An old, wooden shed", null, null, cave, null, null, null, new ThingList("shedList"));
        dungeon.init("Dungeon", "A nasty, dark cell", null, null, rainbow, null, cave, null, new ThingList("dungeonList"));
        rainbow.init("Rainbow", "A extremely shiny room that smells strangely of flowers. You notice a strange figure in the corner", null, null, null, dungeon, null, null, rainbowList);
        map.add(trollRoom);
        map.add(forest);
        map.add(cave);
        map.add(shed);
        map.add(dungeon);

        // create player and set location
        player = new Actor("player", "a loveable game-player", playerList, trollRoom);

        trader = new Actor("merchant", "has his knee bandaged. I wonder why?", traderList, rainbow);
        rainbowList.add(trader);
    }

    // access methods     

    public String putObInContainer(String obname, String containername) {
        return player.putInto(obname, containername);
    }


    public String playerTalkTo(String npc)
    {
        String s;

        if (trader.getName().equals(npc))
        {
            if (trader.getLocation() == player.getLocation())
            {
                System.out.println("Ah hello see my wares:");
                s = "I hope you enjoy what you see";
                showInventory(npc);
                return s;
            } else {
                s = "Cannot see trader here";
                return s;
            }

        } else {
            s = "(npc not implemented yet)";
            return s;
        }
    }


    /*
    public String use(String cartridge, String obname)
    {
        String s;
        ThingAndThingHolder t_th = player.isThingInInventory(cartridge);
        ThingHolder th;
        ThingList tl;
        Thing t;
        if (t_th == null)
        {
            s = "you do not have the " + cartridge + " to use on the " + obname;
            return s;
        }
        th = t_th.getThingHolder();

        tl = th.getThings();
        System.out.println(tl.get(0).getName());
        s = "test";
        return s;
    }

     */


    public String  play (String obname)
    {

        String s;
        ThingAndThingHolder t_th = player.isThingInInventory(obname);
        if (t_th == null)
        {
            s = "you must buy the " + obname +" from the trader first";
            return s;
        }
        String[] args = {"lol"};
        if (obname.equals("relic"))
        {
            Tetris.main(args);
            s = "the game boots up";
            return s;
        } else {
            s = "you must buy the " + obname +" from the trader first";
            return s;
        }
    }

    public String openOb(String obname) {
        return player.openOb(obname);
    }

    public String closeOb(String obname) {
        return player.closeOb(obname);
    }

    String takeOb(String obname) {
        String retStr;
        
        retStr = player.take(obname);
        return retStr;
    }

    //String takeObIn(String )

    String dropOb(String obname) {
        String retStr;
        
        retStr = player.drop(obname);
        return retStr;
    }

    void movePlayerTo(Dir dir) {                
        if (player.moveTo(dir)) {
            look();            
        } else {
            showStr("No Exit!");
        }
    }

    void goN() {
        movePlayerTo(Dir.NORTH);
    }

    void goS() {
        movePlayerTo(Dir.SOUTH);
    }

    void goW() {
        movePlayerTo(Dir.WEST);
    }

    void goE() {
        movePlayerTo(Dir.EAST);
    }

    void goUp() {
        movePlayerTo(Dir.UP);
    }

    void goDown() {
        movePlayerTo(Dir.DOWN);
    }

    void look() {
        showStr("You are in the " + player.describeLocation());
    }

    // utility method to display string if not empty
    // stripping any trailing newlines
    void showStr(String s) {
        if (s.endsWith("\n")) {
            s = s.substring(0, s.length() - 1);
        }
        if (!s.isEmpty()) {
            System.out.println(s);
        }
    }

    void showInventory() {
        showStr(player.inventory());
    }
    void showInventory(String actorName) {
        if (actorName.equals(trader.getName()))
        {
            showStr(trader.inventory());
        }
    }

    String buy(String obname, String npc)
    {
        String s = "ok";
        ThingAndThingHolder t_th;
        ThingList tl;
        Thing t;
        t_th = trader.isThingHere(obname);
        t = t_th.getThing();
        if (npc.equals(trader.getName()))
        {
            if (trader.getLocation() == player.getLocation())
            {
                if (t instanceof Treasure && player.coins >= ((Treasure) t).getValue())
                {
                    player.coins -= ((Treasure) t).getValue();
                    trader.drop(obname);
                    player.take(obname);
                    s = "you buy the " + obname + " from the " + trader.getName();
                    return s;
                } else {
                    s = "You do not have the correct amount of coins to buy " + obname + ", the cost is: " + ((Treasure) t).getValue();
                    return s;
                }
            } else {
                s = "You cannot see the " + trader.getName() + " here";
                return s;
            }

        } else {
            s = "(npc not implemented yet)";
            return s;
        }
    }


    String lookAtOb(String obname) {
        return player.lookAt(obname);
    }

    String lookInOb(String obname) {
        return player.lookIn(obname);
    }

    public void showIntro() {
        String s;

        s = "You have fallen down a rabbit hole and arrived in\n"
                + "an underground cavern that smells strongly of troll.\n"
                + "Where do you want to go?\n"
                + "Enter: n, s, w, e, up, down\n"
                + "or q to quit.";
        showStr(s);
        look();
    }

    public String runCommand(String inputstr) {
        List<String> wordlist;
        String s;
        String lowstr;

        s = "ok";
        lowstr = inputstr.trim().toLowerCase();
        
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = Parser.wordList(lowstr);
                s = Parser.parseCommand(wordlist);
            }
        }
        return s;
    }

    // Test..... BEGIN
    void showTest(String s) {
        showStr("> " + s);
        showStr(runCommand(s));

    }

    void test() {
        // utility method to let me try out bits of code while developing the game            
        showStr("---BEGIN TEST---");
        //  showThingsInRoom(); // this works ok when no objects are in containers
        showTest("get carrot");
        showTest("get bowl");
        showTest("get sack");
        showTest("get box");
        showTest("put carrot in bowl");
        showTest("put bowl in sack");
        showTest("put sack in box");
        showTest("put box in bowl");
        showTest("put sack in bowl");
        showTest("put carrot in box");
        showTest("i");
        showStr("---END TEST---");

    }
    // Test..... END

}
