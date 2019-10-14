package org.academiadecodigo.splicegirls.characters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.level.PlayableArea;
import org.academiadecodigo.splicegirls.position.Position;

import java.awt.*;

public class Scary extends Character implements KeyboardHandler {

        private Picture picture;
        private Position pos;
        private PlayableArea playableArea;
        private int distance = 50;
        private int PADDING = 10;
        private boolean isHittingWall;

    public Scary(){
            picture = new Picture(30,500, "scary/idle right scary.png");
            picture.draw();
            pos = new Position(30, 500);
            keyboardInit();
    }


    private void keyboardInit(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));

        keyboard.addEventListener(rightPressed);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener((leftPressed));

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener((downPressed));

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener((upPressed));

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            if (pos.getX() >= 1180) {
                return;
            }
            picture.translate(distance, 0);// foto vai andar 50 pixeis para a direita
            pos.increaseX(distance);

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            if (pos.getX() <= 30) {
                return;
            }
            picture.translate(-distance, 0);// foto vai andar 50 pixeis para a esquerda
            pos.decreaseX(distance);

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            if (pos.getY() >= 575) {
                return;
            }
            picture.translate(0, distance);
            pos.increaseY(distance);

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            if (pos.getY() <= 400) {
                return;
            }
            picture.translate(0, -distance);
            pos.decreaseY(distance);

        }//if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
                //por as picture de ataque aqui e if se a direction for esquerda ou direita
    //}
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
