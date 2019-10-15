package org.academiadecodigo.splicegirls.characters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.position.Position;

public class Enemy extends Character {

    private Rectangle rectangle;
    private Position pos;
    private int health = 50;
    private int distance = 40;
    private boolean isAlive = true;
    Scary scary = new Scary();

    public Enemy() throws InterruptedException {

        rectangle = new Rectangle(1100,500, 80, 197);
        pos = new Position(1100, 500);
        rectangle.setColor(Color.ORANGE);
        rectangle.fill();

        while (isAlive){
            move();
            Thread.sleep(500);
        }


    }

    public void move(){

            int x = (scary.getPos().getX()) - (pos.getX() - distance);// isto vai dar pixeis X que Enemie tem de andar
            int y = (scary.getPos().getY()) - (pos.getY() - distance);// isto vai dar pixeis Y que Enemie tem de andar

            if (x < 0){
                pos.moveLeft();
                rectangle.translate(-distance, 0);
            }
            if (x > 0){
                pos.moveRight();
                rectangle.translate(+distance, 0);
            }

            if (y < 0 ){
                pos.moveUp();
                rectangle.translate(0, -distance);
            }

            if (y > 0 ){
                pos.moveDown();
                rectangle.translate(0, +distance);
            }

        }

    }
