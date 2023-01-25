package game;

import audio.SoundPlayerUsingClip;
import game.Game;
import gameobjects.Treasure;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.util.Objects;

public class AdventureGame {



    public static SoundPlayerUsingClip sp = new SoundPlayerUsingClip();
    public static Game game;
    public static Treasure treasure;


    public static void saveGame() {
        try {
            FileOutputStream fos = new FileOutputStream("Adv.sav");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game); // game
            oos.flush(); // write out any buffered bytes
            oos.close();
            System.out.print("Game saved\n");
        } catch (Exception e) {
            System.out.print("Serialization Error! Can't save data.\n"
                    + e.getClass() + ": " + e.getMessage() + "\n");
        }
    }

    public static void loadGame() {
        try {
            FileInputStream fis = new FileInputStream("Adv.sav");
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
            ois.close();
            System.out.print("\n---Game loaded---\n");
        } catch (Exception e) {
            System.out.print("Serialization Error! Can't load data.\n");
            System.out.print(e.getClass() + ": " + e.getMessage() + "\n");
        }
    }





    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output = "";
        game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.showIntro();
        sp.playSound("music.wav");
        do {
            System.out.print("\u001b[38;5;93m~\u001b[38;5;231m ");
            input = in.readLine();
            switch (input) {
                case "save" -> saveGame();
                case "load" -> loadGame();
                default -> output = game.runCommand(input);
            }
            if (!output.trim().isEmpty()) {
                game.showStr(output);
            }
        } while (!"q".equals(input));
    }

}
