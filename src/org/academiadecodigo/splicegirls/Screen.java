package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {

    private Picture screen;
    private boolean isScreenOn;
    private boolean tutorialIsOn;

    public Screen(){
        createIntroScreen();
    }

    public void createIntroScreen(){
        screen = new Picture(10, 10, "/Users/codecadet/SpliceEmUp/resources/screens/intro screen s q.png");
        screen.draw();
        this.isScreenOn = true;

    }

    public void createGameOverScreen(){
        Picture gameOverScreen = new Picture(10, 10, "/Users/codecadet/SpliceEmUp/resources/screens/game over.png");
        gameOverScreen.draw();
    }

    public void createVictoryScreen(){
        Picture victoryScreen = new Picture(10, 10, "/Users/codecadet/SpliceEmUp/resources/screens/congratulations.png");
        victoryScreen.draw();
    }

    public void createTutorialScreen() throws InterruptedException {
        Picture tutorialScreen = new Picture(10, 10, "/Users/codecadet/SpliceEmUp/resources/screens/tutorial com quit.png");
        tutorialScreen.draw();
        Thread.sleep(8000);
        tutorialScreen.delete();

    }



    public void eraseMenu(){
        isScreenOn = !isScreenOn;
        screen.delete();
    }

    public boolean getIsScreenOn(){
        return isScreenOn;
    }

    public void setTutorialIsOn(boolean tutorialIsOn) {
        this.tutorialIsOn = tutorialIsOn;
    }

    public boolean isTutorialIsOn() {
        return tutorialIsOn;
    }
}

