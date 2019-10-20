package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {

    Picture screen;

    public void createIntroScreen(){
        screen = new Picture(10, 10, "/Users/codecadet/Desktop/WorkSpace/SpliceEmUp/resources/screens/intro com tutorial.png");
        screen.draw();
    }

    public void createGameOverScreen(){
        Picture intro = new Picture(10, 10, "/Users/codecadet/Desktop/WorkSpace/SpliceEmUp/resources/screens/game over.png");
        intro.draw();
    }


    public void eraseMenu(){
        screen.delete();
        screen = new Picture(10, 10, "/Users/codecadet/Desktop/WorkSpace/SpliceEmUp/resources/screens/BlankScreen.png");
        screen.draw();
    }

}
