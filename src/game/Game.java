package game;

import code.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;     // required for ArrayList

import audio.SoundPlayerUsingClip;
import gameobjects.*;
import globals.Dir;
import globals.ThingAndThingHolder;

import javax.swing.*;

public class Game implements java.io.Serializable {
    private ArrayList<Room> map; // the map - an ArrayList of Rooms    
    public Actor player;  // the player - provides 'first person perspective'
    public Actor trader;
    public Actor wizard;
    ThingList trollRoomList = new ThingList("trollRoomList");
    ThingList forestList = new ThingList("forestList");
    ThingList caveList = new ThingList("caveList");
    ThingList dungeonList = new ThingList("dungeonList");
    ThingList rainbowList = new ThingList("rainbowList");
    ThingList playerList = new ThingList("playerList");
    ThingList traderList = new ThingList("traderList");
    ThingList sackList = new ThingList("sackList");
    ThingList chestList = new ThingList("chestList");
    ThingList chest2List = new ThingList("chest2List");
    ThingList wizardList = new ThingList("wizardList");
    ThingList wizardTowerList = new ThingList("wizardTowerList");
    ThingList shedList = new ThingList("shedList");

    public Game() {
        Parser.initVocab();
        initGame();
    }

    private void initGame() {
        this.map = new ArrayList<Room>();
        // --- construct a new adventure ---

        //ThingList gameList = new ThingList("gameList");


        Room trollRoom = new Room();
        Room forest = new Room();
        Room cave = new Room();
        Room shed = new Room();
        Room dungeon = new Room();
        Room rainbow = new Room();
        Room sack = new Room();
        Room chest = new Room();
        Room wizardTower = new Room();

        Treasure gameBoy = new Treasure("relic", "a strange device with with a fluorescent hum, it seems like you can play this device", 50, trader);
        Treasure traderTest = new Treasure("lol", "a test for trader items",100, trader);
        ContainerThing sackCont = new ContainerThing("sack", "a smelly old sack", true, true, true, false, sackList, trollRoom);
        Treasure inSack = new Treasure("bone", "a crisp bone", 10, sack);
        Book book1 = new Book("strangebook", "a strange leather book. you notice faded text saying \"pok-\"", 0, dungeon);
        Book book2 = new Book("dirtybook", "a very strange and smelly book. you can barely make-out the text \"sel-\"", 0, rainbow);
        Book book3 = new Book("ancientbook", "a visually pleasing book. you stare at the lable just to make out \"idk-\"", 0 , shed);
        ContainerThing chestContainer = new ContainerThing("chest", " sparkly, shiny chest", false, true,true, false, chestList, trollRoom);
        Treasure coins1 = new Treasure("coins", "shiny gold coins", 25, chest);
        Treasure coins2 = new Treasure("coins", "shiny gold coins", 50, chest);
        Treasure coins3 = new Treasure("coins", "shiny gold coins", 25, trollRoom);
        Cartridge tetris = new Cartridge("cartridge", "a strange rectangle object with the faded letters of \"tet-\". it looks like it can be inserted into something", 0, wizard);

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
        dungeonList.add(book1);

        wizardList.add(tetris);


        shedList.add(book3);
        // Map:
        //                                                                                                      Wizard Tower
        //                                                                                                      |
        //                                                              Troll Room --- Forest
        //                                                                |
        //                                                              Cave --------- Shed
        //                                                               |
        //                                                              V
        //Rainbow room ---------Dungeon
        //                 Room( name,   description,                                                                                                               N,        S,      W,      E,  [Up], [Down])
        trollRoom.init("Troll Room", "A dank room that smells of troll", null, cave, null, forest, null, null, trollRoomList);
        forest.init("Forest", "A leafy woodland. It looks like the vines lead `up`", null, null, trollRoom, null, wizardTower, null, forestList);
        cave.init("Cave", "A dismal cave with walls covered in luminous moss. It looks like there may be a hole in the ground. Try going `down`", trollRoom, null, null, shed, null, dungeon, caveList);
        shed.init("Shed", "An old, wooden shed", null, null, cave, null, null, null, shedList);
        dungeon.init("Dungeon", "A nasty, dark cell", null, null, rainbow, null, cave, null, dungeonList);
        rainbow.init("Rainbow", "A extremely shiny room that smells strangely of flowers. You notice a strange figure in the corner", null, null, null, dungeon, null, null, rainbowList);
        wizardTower.init("Wizard Tower", "A tall tower that overlooks a beautiful beach.", null, null, null, null, null, forest, wizardTowerList);

        // create player and set location
        player = new Actor("player", "a loveable game-player", playerList, trollRoom);

        trader = new Actor("merchant", "has his knee bandaged. I wonder why?", traderList, rainbow);
        rainbowList.add(trader);
        rainbowList.add(book2);

        wizard = new Actor("wizard", "a creepy old man with a grey beard and a menacing stare", wizardList, wizardTower);
        wizardTowerList.add(wizard);

        map.add(trollRoom);
        map.add(forest);
        map.add(cave);
        map.add(shed);
        map.add(dungeon);
        map.add(rainbow);
        map.add(wizardTower);
    }

    // access methods     

    public String putObInContainer(String obname, String containername) {
        return player.putInto(obname, containername);
    }


    public String use(String ob1, String ob2)
    {
        String s;

        ThingAndThingHolder t_th;
        Thing t;

        t_th = player.isThingInInventory(ob1);
        if (t_th != null)
        {
            t = t_th.getThing();
            if (t instanceof Cartridge)
            {
                if (t.getDescription().contains("\"tet-\""))
                {
                   return  play(ob2);
                } else {
                    s = "game not implemented yet";
                    return s;
                }
            } else {
                s = "key system not implemented yet";
                return s;
            }
        } else {
            s = "you do not have anything in your inventory to use";
            return s;
        }
    }


    public String read(String book)
    {
        Scanner input = new Scanner(System.in);
        String[] lol = {};
        String s ;
        ThingAndThingHolder t_th = player.isThingInInventory(book);
        if (t_th == null)
        {
            s = "you do not have the " + book;
            return s;
        } else {
            Thing t = t_th.getThing();
            if (t instanceof Book) {
                if (t.getDescription().contains("\"pok-\"")) {
                    AdventureGame.saveGame();
                    System.out.println("WARNING THE GAME WILL CLOSE IF YOU DIE IN THIS GAME. DO YOU STILL WANT TO PROCEED? Y/N\n(Your current game state has been saved automatically, run `load` to keep all of your items and the room you were in when you reload)");
                    System.out.println("(Pokemon game made by David Smith)");
                    String yn = input.nextLine();
                    switch (yn.toUpperCase()) {
                        case "Y":
                            System.out.println("you open the book");
                            menu.main(lol);
                            return "";
                        default:
                            s = "you decide its best to leave the book shut";
                            return s;
                    }
                } else if (t.getDescription().contains("\"sel-\"")){
                    System.out.println("you open the book");
                    s = "you close the book, amazed at this new knowledge";
                    The_Self_Proclaimed_Giant.main(lol);
                    return s;
                } else {
                    s = "game not implemented yet.";
                    return s;
                }
            } else {
                s = "this is not a book, you cannot read this";
                return s;

            }
        }
    }

    public String playerTalkTo(String npc)
    {
        String s;

        if (trader.getName().equals(npc))
        {
            if (trader.getLocation() == player.getLocation())
            {
                if (!trader.inventory().contains("nothing"))
                {
                    AdventureGame.sp.playSound("talking.wav");
                    System.out.println("Ah hello see my wares:");
                    s = "I hope you enjoy what you see";
                    showInventory(npc);
                    return s;
                } else {
                    s = "you have bought all of my items. I must restock";
                    return s;
                }

            } else {
                s = "Cannot see trader here";
                return s;
            }

        } else if(wizard.getName().equals(npc)) {
            if (wizard.getLocation() == player.getLocation())
            {
                AdventureGame.sp.playSound("talking.wav");
                if (player.inventory().contains("strangebook") && player.inventory().contains("dirtybook") && player.inventory().contains("ancientbook"))
                {
                    if (!wizard.inventory().contains("cartridge"))
                    {
                        System.out.println("You have already received my reward. I have nothing left to give you");
                        return "";
                    } else {

                        System.out.println("AH. You have found my books. My old age is slowing me down you see.");
                        System.out.println("Im this close to retirement. How about you keep the books and become the future wizard.");
                        System.out.println("You can read every single one of these books using the `read` command.");
                        System.out.println("Oh i almost forgot. Here is your reward.");
                        try {
                            Thread.sleep(1000);

                        } catch (Exception e)
                        {

                        }
                        wizard.drop("cartridge");
                        player.take("cartridge");
                        System.out.println("The wizard handed you a strange cartridge.");
                        return "";
                    }
                } else {
                    System.out.println("Youngblood i sense. Come closer");
                    System.out.println("You smell like a traveller");
                    System.out.println("Say, traveller i have a quest for you.");
                    System.out.println("Find my 3 books i have misplaced and i may grant you a reward");
                    System.out.println("Come back when you have found all three books");
                    return "";
                }
            } else {
                return "cannot see";
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


    public String  play(String obname)
    {

        String s;
        ThingAndThingHolder t_th = player.isThingInInventory(obname);
        if (t_th == null)
        {
            s = "you must buy the relic from the trader first";
            return s;
        }
        String[] args = {"lol"};
        if (obname.equals("relic"))
        {
            Tetris.main(args);
            s = "the small cartridge fits perfectly into the relic.\nthe game boots up";
            return s;
        } else {
            s = "you must buy the relic from the trader first";
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


    public void easterEgg()
    {
        String s;
        ThingList secretChestList = new ThingList("secretChestList");
        Room secretChest = new Room();
        ContainerThing chestContainer = new ContainerThing("secretchest", "EXTRA sparkly, shiny chest", false, true,true, false, secretChestList, player.getLocation());
        player.getLocation().add(chestContainer);
        Treasure coins1 = new Treasure("coins", "EXTRA shiny gold coins", 9999, secretChest);
        secretChestList.add(coins1);


        AdventureGame.sp.playSound("reward.wav");
    }



}
