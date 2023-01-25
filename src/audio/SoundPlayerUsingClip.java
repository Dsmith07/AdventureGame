package audio;

import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class SoundPlayerUsingClip {
    private Clip clip;
    public synchronized void playSound(String fileName) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try
                {
                    clip = AudioSystem.getClip();
                    File musicPath = new File("res\\sfx\\" + fileName);

                    if (musicPath.exists())
                    {
                        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                        clip.open(audioInput);
                        if (fileName.equals("music.wav"))
                        {
                            setVolume(clip, 0.07F);
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        } else {
                            setVolume(clip, 0.3F);
                        }
                        clip.start();



                    } else {
                        System.out.println("Cant find file");
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }


    public float getVolume(Clip clip)  {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        return (float) Math.pow(10f, gainControl.getValue() / 20f);
    }

    public void setVolume(Clip clip, float volume) {
        if (volume < 0f || volume > 1f)
            throw new IllegalArgumentException("Volume not valid: " + volume);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(volume));
    }

}