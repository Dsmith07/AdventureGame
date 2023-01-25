package game;

import globals.WT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {

    static HashMap<String, WT> vocab = new HashMap<>();

    static void initVocab() {
        vocab.put("acorn", WT.NOUN);
        vocab.put("bed", WT.NOUN);
        vocab.put("bone", WT.NOUN);
        vocab.put("bowl", WT.NOUN);
        vocab.put("box", WT.NOUN);
        vocab.put("button", WT.NOUN);
        vocab.put("carrot", WT.NOUN);
        vocab.put("chest", WT.NOUN);
        vocab.put("coin", WT.NOUN);
        vocab.put("coins", WT.NOUN);
        vocab.put("door", WT.NOUN);
        vocab.put("dust", WT.NOUN);
        vocab.put("ring", WT.NOUN);
        vocab.put("wombat", WT.NOUN);
        vocab.put("strangebook", WT.NOUN);
        vocab.put("dirtybook", WT.NOUN);
        vocab.put("gardenia", WT.NOUN);
        vocab.put("key", WT.NOUN);
        vocab.put("knife", WT.NOUN);
        vocab.put("lamp", WT.NOUN);
        vocab.put("leaflet", WT.NOUN);
        vocab.put("lever", WT.NOUN);
        vocab.put("paper", WT.NOUN);
        vocab.put("pencil", WT.NOUN);
        vocab.put("sack", WT.NOUN);
        vocab.put("sausage", WT.NOUN);
        vocab.put("relic", WT.NOUN);
        vocab.put("sign", WT.NOUN);
        vocab.put("slot", WT.NOUN);
        vocab.put("squirrel", WT.NOUN);
        vocab.put("tree", WT.NOUN);
        vocab.put("wombat", WT.NOUN);
        vocab.put("test", WT.VERB);
        vocab.put("buy", WT.VERB);
        vocab.put("from", WT.PREPOSITION);
        vocab.put("trader", WT.NOUN);
        vocab.put("merchant", WT.NOUN);
        vocab.put("ancientbook", WT.NOUN);
        vocab.put("wizard", WT.NOUN);
        vocab.put("shop", WT.VERB);
        vocab.put("lol", WT.NOUN);
        vocab.put("get", WT.VERB);
        vocab.put("i", WT.VERB);
        vocab.put("inventory", WT.VERB);
        vocab.put("play", WT.VERB);
        vocab.put("take", WT.VERB);
        vocab.put("read", WT.VERB);
        vocab.put("talk", WT.VERB);
        vocab.put("use", WT.VERB);
        vocab.put("tetris", WT.NOUN);
        vocab.put("to", WT.PREPOSITION);
        vocab.put("drop", WT.VERB);
        vocab.put("put", WT.VERB);
        vocab.put("l", WT.VERB);
        vocab.put("secretchest", WT.NOUN);
        vocab.put("cartridge", WT.NOUN);
        vocab.put("look", WT.VERB);
        vocab.put("open", WT.VERB);
        vocab.put("close", WT.VERB);
        vocab.put("pull", WT.VERB);
        vocab.put("push", WT.VERB);
        vocab.put("superdupersecretdeveasteregglol", WT.VERB);
        vocab.put("n", WT.VERB);
        vocab.put("s", WT.VERB);
        vocab.put("w", WT.VERB);
        vocab.put("e", WT.VERB);
        vocab.put("up", WT.VERB);
        vocab.put("down", WT.VERB);
        vocab.put("q", WT.VERB);
        vocab.put("quit", WT.VERB);
        vocab.put("a", WT.ARTICLE);
        vocab.put("an", WT.ARTICLE);
        vocab.put("the", WT.ARTICLE);
        vocab.put("in", WT.PREPOSITION);
        vocab.put("into", WT.PREPOSITION);
        vocab.put("at", WT.PREPOSITION);
        vocab.put("on", WT.PREPOSITION);

    }

    static String processVerbNounPrepositionNoun(List<WordAndType> command) {
        WordAndType wt = command.get(0);
        WordAndType wt2 = command.get(1);
        WordAndType wt3 = command.get(2);
        WordAndType wt4 = command.get(3);
        String msg = "";
        
        if ((wt.getWordtype() != WT.VERB) || (wt3.getWordtype() != WT.PREPOSITION)) {
            msg = "Can't do this because I don't understand how to '" + wt.getWord() + " something " + wt3.getWord() + "' something!";
        } else if (wt2.getWordtype() != WT.NOUN) {
            msg = "Can't do this because '" + wt2.getWord() + "' is not an object!\r\n";
        } else if (wt4.getWordtype() != WT.NOUN) {
            msg = "Can't do this because '" + wt4.getWord() + "' is not an object!\r\n";
        } else {
            switch (wt.getWord() + wt3.getWord()) {
                case "putin":
                case "putinto":
                    msg = AdventureGame.game.putObInContainer(wt2.getWord(), wt4.getWord());
                    break;
                case "buyfrom":
                    msg = AdventureGame.game.buy(wt2.getWord(), wt4.getWord());
                    break;
                case "useon":
                    msg = AdventureGame.game.use(wt2.getWord(), wt4.getWord());
                    break;
                default:
                    msg = "I don't know how to " + wt.getWord() + " " + wt2.getWord() + " " + wt3.getWord() + " " + wt4.getWord() + "!";
                    break;
            }
        }
        return msg;
    }

    static String processVerbPrepositionNoun(List<WordAndType> command) {
        // "look at" is the only implemented command of this type
        WordAndType wt = command.get(0);
        WordAndType wt2 = command.get(1);
        WordAndType wt3 = command.get(2);
        String msg = "";
        
        if ((wt.getWordtype() != WT.VERB) || (wt2.getWordtype() != WT.PREPOSITION)) {
            msg = "Can't do this because I don't understand '" + wt.getWord() + " " + wt2.getWord() + "' !";
        } else if (wt3.getWordtype() != WT.NOUN) {
            msg = "Can't do this because '" + wt3.getWord() + "' is not an object!\r\n";
        } else {
            switch (wt.getWord() + wt2.getWord()) {
                case "lookat":
                    msg = AdventureGame.game.lookAtOb(wt3.getWord());
                    break;
                case "lookin":
                    msg = AdventureGame.game.lookInOb(wt3.getWord());
                    break;
                case "talkto":
                    msg = AdventureGame.game.playerTalkTo(wt3.getWord());
                    break;
                default:
                    msg = "I don't know how to " + wt.getWord() + " " + wt2.getWord() + " " + wt3.getWord() + "!";
                    break;
            }
        }
        return msg;
    }

    static String processVerbNoun(List<WordAndType> command) {
        WordAndType wt = command.get(0);
        WordAndType wt2 = command.get(1);
        String msg = "";

        if (wt.getWordtype() != WT.VERB) {
            msg = "Can't do this because '" + wt.getWord() + "' is not a command!";
        } else if (wt2.getWordtype() != WT.NOUN) {
            msg = "Can't do this because '" + wt2.getWord() + "' is not an object!";
        } else {
            switch (wt.getWord()) {
                case "take":
                case "get":
                    msg = AdventureGame.game.takeOb(wt2.getWord());
                    break;
                case "drop":
                    msg = AdventureGame.game.dropOb(wt2.getWord());
                    break;
                case "open":
                    msg = AdventureGame.game.openOb(wt2.getWord());
                    break;
                case "close":
                    msg = AdventureGame.game.closeOb(wt2.getWord());
                    break;
                case "play":
                    msg = AdventureGame.game.play(wt2.getWord());
                    break;
                case "read":
                    msg = AdventureGame.game.read(wt2.getWord());
                    break;
                default:
                    msg += " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    static String processVerb(List<WordAndType> command) {
        WordAndType wt = command.get(0);
        String msg = "";

        if (wt.getWordtype() != WT.VERB) {
            msg = "Can't do this because '" + wt.getWord() + "' is not a command!";
        } else {
            switch (wt.getWord()) {
                case "n":
                    AdventureGame.game.goN();
                    break;
                case "s":
                    AdventureGame.game.goS();
                    break;
                case "w":
                    AdventureGame.game.goW();
                    break;
                case "e":
                    AdventureGame.game.goE();
                    break;
                case "up":
                    AdventureGame.game.goUp();
                    break;
                case "down":
                    AdventureGame.game.goDown();
                    break;
                case "l":
                case "look":
                    AdventureGame.game.look();
                    break;
                case "inventory":
                case "i":
                    AdventureGame.game.showInventory();
                    break;
                case "superdupersecretdeveasteregglol":
                    AdventureGame.game.easterEgg();
                    break;
                default:
                    msg = wt.getWord() + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }

    static String processCommand(List<WordAndType> command) {
        String s = "";
        
        if (command.size() == 0) {
            s = "You must write a command!";
        } else if (command.size() > 4) {
            s = "That command is too long!";
        } else {           
            switch (command.size()) {
                case 1:
                    s = processVerb(command);
                    break;
                case 2:
                    s = processVerbNoun(command);
                    break;
                case 3:
                    s = processVerbPrepositionNoun(command);
                    break;
                case 4:
                    s = processVerbNounPrepositionNoun(command);
                    break;
                default:
                    s = "Unable to process command";
                    break;
            }
        }
        return s;
    }

    static String parseCommand(List<String> wordlist) {
        List<WordAndType> command = new ArrayList<>();
        WT wordtype;
        String errmsg = "";
        String msg;

        for (String k : wordlist) {
            if (vocab.containsKey(k)) {
                wordtype = vocab.get(k);
                if (wordtype == WT.ARTICLE) {       // ignore articles             
                } else {
                    command.add(new WordAndType(k, wordtype));
                }
            } else { // if word not found in vocab
                command.add(new WordAndType(k, WT.ERROR));
                errmsg = "Sorry, I don't understand '" + k + "'";
            }
        }
        if (!errmsg.isEmpty()) {
            msg = errmsg;
        } else {
            msg = processCommand(command);
        }
        return msg;
    }

    static List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> strlist = new ArrayList<>();
        String[] words = input.split(delims);

        for (String word : words) {
            strlist.add(word);
        }
        return strlist;
    }
}
