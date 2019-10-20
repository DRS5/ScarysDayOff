package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {

    private Picture screen;
    private boolean isScreenOn;

    public Screen(){
        createIntroScreen();
    }

    public void createIntroScreen(){
        screen = new Picture(10, 10, "resources/screens/intro com tutorial.png");
        screen.draw();
        this.isScreenOn = true;
    }

    public void createGameOverScreen(){
        Picture intro = new Picture(10, 10, "resources/screens/game over.png");
        intro.draw();
    }


    public void eraseMenu(){
        isScreenOn = !isScreenOn;
        screen.delete();
    }

    public boolean getIsScreenOn(){
        return isScreenOn;
    }
}
