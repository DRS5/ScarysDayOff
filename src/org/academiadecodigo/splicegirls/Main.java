package org.academiadecodigo.splicegirls;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {

        Game game = new Game();
        game.start();

        String filepath = "/Users/codecadet/Desktop/WorkSpace/SpliceEmUp/resources/music/Spice Girls Wannabe 8 Bit.wav";
        Music musicObject = new Music();
        musicObject.playMusic(filepath);


    }

}
