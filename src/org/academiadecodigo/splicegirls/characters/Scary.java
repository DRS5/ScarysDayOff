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
import java.util.concurrent.ExecutionException;

public class Scary implements KeyboardHandler {

        private Picture picture;
        private Position pos;
        private int distance = 40;
        private Direction direction;
        private int health = 100;
        private Enemy enemy;

    public Scary() {
            picture = new Picture(30,500, "scary/idle right scary.png");
            picture.draw();
            pos = new Position(30, 500);
            health = 100;

            keyboardInit();
    }

    public Position getPos(){
        return pos;
    }

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public void attack(){

            if(enemy.getHealth() > 0) {
                    enemy.hit(25);
            } else {
                enemy.killEnemy();
            }
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

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));

        keyboard.addEventListener((spacePressed));

        KeyboardEvent spaceReleased = new KeyboardEvent();
        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);
        spaceReleased.setKeyboardEventType((KeyboardEventType.KEY_RELEASED));

        keyboard.addEventListener((spaceReleased));

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType((KeyboardEventType.KEY_RELEASED));

        keyboard.addEventListener(rightReleased);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener((leftReleased));

        KeyboardEvent upReleased = new KeyboardEvent();
        upReleased.setKey(KeyboardEvent.KEY_UP);
        upReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener((upReleased));

        KeyboardEvent downReleased = new KeyboardEvent();
        downReleased.setKey(KeyboardEvent.KEY_DOWN);
        downReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener((downReleased));

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            if (pos.getX() >= 1130) {
                return;
            }
            direction = Direction.RIGHT;
            picture.delete();
            picture = new Picture(pos.getX(), pos.getY(), "scary/walk right scary.png");
            picture.draw();
            picture.translate(distance, 0);// foto vai andar 50 pixeis para a direita
            pos.increaseX(distance);

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            if (pos.getX() <= 100) {
                return;
            }
            direction = Direction.LEFT;
            picture.delete();
            picture = new Picture(pos.getX(), pos.getY(), "scary/walk left scary.png");
            picture.draw();
            picture.translate(-distance, 0);// foto vai andar 50 pixeis para a esquerda
            pos.decreaseX(distance);

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            if (pos.getY() >= 575) {
                return;
            }
            if(direction == Direction.RIGHT){
                picture.delete();
                picture = new Picture(pos.getX(), pos.getY(), "scary/walk right scary.png");
                picture.draw();
            }
            if (direction == Direction.LEFT){
                picture.delete();
                picture = new Picture(pos.getX(), pos.getY(), "scary/walk left scary.png");
                picture.draw();
            }
            picture.translate(0, distance);
            pos.increaseY(distance);

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            if (pos.getY() <= 450) {
                return;
            }
            if(direction == Direction.RIGHT){
                picture.delete();
                picture = new Picture(pos.getX(), pos.getY(), "scary/walk right scary.png");
                picture.draw();
            }
            if(direction == Direction.LEFT){
                picture.delete();
                picture = new Picture(pos.getX(), pos.getY(), "scary/walk left scary.png");
                picture.draw();
            }
            picture.translate(0, -distance);
            pos.decreaseY(distance);

        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (direction == Direction.RIGHT) {
                picture.delete();
                picture = new Picture(pos.getX(), pos.getY(), "scary/punch right scary.png");
                picture.draw();
                attack();
            } else {
                picture.delete();
                picture = new Picture(pos.getX() - 31, pos.getY(), "scary/punch left scary.png");
                picture.draw();
                attack();
            }

        }
    }




    @Override
        public void keyReleased (KeyboardEvent keyboardEvent){

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
                if (direction == Direction.RIGHT) {
                    picture.delete();
                    picture = new Picture(pos.getX(), pos.getY(), "scary/idle right scary.png");
                    picture.draw();
                } else {
                    picture.delete();
                    picture = new Picture(pos.getX(), pos.getY(), "scary/idle left scary.png");
                    picture.draw();
                }
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                picture.delete();
                picture = new Picture(pos.getX(), pos.getY(), "scary/idle right scary.png");
                picture.draw();
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                picture.delete();
                picture = new Picture(pos.getX(), pos.getY(), "scary/idle left scary.png");
                picture.draw();
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                if (direction == Direction.RIGHT){
                    picture.delete();
                    picture = new Picture(pos.getX(), pos.getY(), "scary/idle right scary.png");
                    picture.draw();
                }
                if (direction == Direction.LEFT) {
                    picture.delete();
                    picture = new Picture(pos.getX(), pos.getY(), "scary/idle left scary.png");
                    picture.draw();
                }
            }

            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                if (direction == Direction.LEFT){
                    picture.delete();
                    picture = new Picture(pos.getX(), pos.getY(), "scary/idle left scary.png");
                    picture.draw();
                }
                if (direction == Direction.RIGHT) {
                    picture.delete();
                    picture = new Picture(pos.getX(), pos.getY(), "scary/idle right scary.png");
                    picture.draw();
                }
            }
    }


    public void setHealth(int damage){
        this.health = health - damage;
    }







}

