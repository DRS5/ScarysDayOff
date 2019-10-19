package org.academiadecodigo.splicegirls;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Music {

    public void playMusic(String musicLocation) {
        try
            { File musicPath = new File("/Users/codecadet/Desktop/WorkSpace/SpliceEmUp/resources/music/Spice Girls Wannabe 8 Bit.wav");

                if(musicPath.exists()) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);

                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } else {
                    System.out.println("BZZT ERROR BZZT FILE NOT FOooooouund.....d...bzzt... boop");
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
    }
    public void playSound(String musicLocation) {
        try
            { File musicPath = new File("/Users/codecadet/Desktop/WorkSpace/SpliceEmUp/resources/sounds/punch 8bit1.wav");

            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);

                clip.start();

            } else {
                System.out.println("BZZT ERROR BZZT FILE NOT FOooooouund.....d...bzzt... boop");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
