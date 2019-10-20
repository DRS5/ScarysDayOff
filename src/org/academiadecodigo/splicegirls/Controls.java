package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.characters.Direction;
import org.academiadecodigo.splicegirls.characters.Enemy;
import org.academiadecodigo.splicegirls.characters.EnemyFactory;
import org.academiadecodigo.splicegirls.characters.Scary;
import org.academiadecodigo.splicegirls.level.Grid;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Controls implements KeyboardHandler {

    private Scary scary;
    private Grid grid;
    private Enemy enemy;
    private Music punch;
    private boolean menuIsOn = true;
    private Screen screen;


    public Controls(Scary scary, Grid grid, Screen screen) {
        this.scary = scary;
        this.grid = grid;
        this.screen = screen;

        String filepath = "resources/sounds/punch 8bit1.wav";
        punch = new Music();
        punch.playMusic(filepath);

        keyboardInit();
    }


    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setMenuIsOn(boolean menu) {
        this.menuIsOn = menu;
    }

    public boolean getMenuIsOn() {
        return menuIsOn;
    }

    private void keyboardInit() {
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

        KeyboardEvent sPressed = new KeyboardEvent();
        sPressed.setKey(KeyboardEvent.KEY_S);
        sPressed.setKeyboardEventType((KeyboardEventType.KEY_PRESSED));

        keyboard.addEventListener(sPressed);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_S:
                this.menuIsOn = false;
                screen.eraseMenu();
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (menuIsOn) {
                    break;
                }
                if (scary.getCol() >= grid.getCols()) {
                    return;
                }
                scary.setDirection(Direction.RIGHT);
                scary.getPicture().delete();
                scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/walk right scary.png"));
                scary.getPicture().draw();
                scary.getPicture().translate(+scary.getCellSize(), 0);// foto vai andar 50 pixeis para a direita
                scary.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
                if (menuIsOn) {
                    break;
                }
                if (scary.getCol() <= 0) {
                    return;
                }
                scary.setDirection(Direction.LEFT);
                scary.getPicture().delete();
                scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/walk left scary.png"));
                scary.getPicture().draw();
                scary.getPicture().translate(-scary.getCellSize(), 0);// foto vai andar 50 pixeis para a esquerda
                scary.moveLeft();
                break;

            case KeyboardEvent.KEY_DOWN:
                if (menuIsOn) {
                    break;
                }
                if (scary.getRow() >= grid.getRows()) {
                    break;
                }
                if (scary.getDirection() == Direction.RIGHT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/walk right scary.png"));
                    scary.getPicture().draw();
                    scary.getPicture().translate(0, +scary.getCellSize());
                    scary.moveDown();
                    break;
                }
                if (scary.getDirection() == Direction.LEFT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/walk left scary.png"));
                    scary.getPicture().draw();
                    scary.getPicture().translate(0, +scary.getCellSize());
                    scary.moveDown();
                    break;
                }
            case KeyboardEvent.KEY_UP:
                if (menuIsOn) {
                    break;
                }
                if (scary.getRow() <= 0) {
                    break;
                }
                if (scary.getDirection() == Direction.RIGHT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/walk right scary.png"));
                    scary.getPicture().draw();
                    scary.getPicture().translate(0, -scary.getCellSize());
                    scary.moveUp();
                    break;
                }
                if (scary.getDirection() == Direction.LEFT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/walk left scary.png"));
                    scary.getPicture().draw();
                    scary.getPicture().translate(0, -scary.getCellSize());
                    scary.moveUp();
                    break;
                }

            case KeyboardEvent.KEY_SPACE:
                if (menuIsOn) {
                    break;
                }
                if (scary.getDirection() == Direction.RIGHT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/punch right scary.png"));
                    scary.getPicture().draw();
                    scary.attack(enemy);
                    punch.playSound("/Users/codecadet/Desktop/WorkSpace/SpliceEmUp/resources/sounds/punch 8bit1.wav");
                    break;
                }
                scary.getPicture().delete();
                scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/punch left scary.png"));
                scary.getPicture().draw();
                scary.attack(enemy);
                punch.playSound("/Users/codecadet/Desktop/WorkSpace/SpliceEmUp/resources/sounds/punch 8bit1.wav");
                break;

            default:
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if (menuIsOn) {

            } else {
                if (scary.getDirection() == Direction.RIGHT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/idle right scary.png"));
                    scary.getPicture().draw();
                } else {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/idle left scary.png"));
                    scary.getPicture().draw();
                }
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            if (menuIsOn) {

            } else {
                scary.getPicture().delete();
                scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/idle right scary.png"));
                scary.getPicture().draw();
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            if (menuIsOn) {

            } else {
                scary.getPicture().delete();
                scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/idle left scary.png"));
                scary.getPicture().draw();
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            if (menuIsOn) {

            } else {
                if (scary.getDirection() == Direction.RIGHT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/idle right scary.png"));
                    scary.getPicture().draw();
                }
                if (scary.getDirection() == Direction.LEFT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/idle left scary.png"));
                    scary.getPicture().draw();
                }
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            if (menuIsOn) {

            } else {
                if (scary.getDirection() == Direction.LEFT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/idle left scary.png"));
                    scary.getPicture().draw();
                }
                if (scary.getDirection() == Direction.RIGHT) {
                    scary.getPicture().delete();
                    scary.setPicture(new Picture(scary.getStartingPointCol() + (scary.getCol() * 80 + 10), scary.getStartingPointRow() + (scary.getRow() * 80 + 10), "scary/idle right scary.png"));
                    scary.getPicture().draw();
                }
            }
        }
    }
}