package org.academiadecodigo.splicegirls.characters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.position.Position;

public class Enemy {

    private Picture picture;
    private Position pos;
    private int health;
    private int distance = 40;
    private boolean isAlive = true;
    private Scary scary;

    public Enemy(Scary scary) throws InterruptedException {

        picture = new Picture(1000,500, "enemy/enemy1 idle.png");
        picture.draw();
        pos = new Position(1000, 500);
        health = 50;
        this.scary = scary;


    }

    public void move(){

            int x = (scary.getPos().getX()) - (pos.getX() - distance *2);// isto vai dar pixeis X que Enemie tem de andar
            int y = (scary.getPos().getY()) - (pos.getY());// isto vai dar pixeis Y que Enemie tem de andar

            if (x < 0){
                pos.moveLeft();
                picture.translate(-distance, 0);
            }
            if (x > 0){
                pos.moveRight();
                picture.translate(+distance, 0);
            }

            if (y < 0 ){
                pos.moveUp();
                picture.translate(0, -distance);
            }

            if (y > 0 ){
                pos.moveDown();
                picture.translate(0, +distance);
            }

        }

     public void attack() {

        if((scary.getPos().getX() - pos.getX()) <= distance || (scary.getPos().getY() - pos.getY()) <= distance){
            scary.setHealth(10);
            //TODO put enemy attack animation here
        }
         //TODO put enemy attack animation here, in case he misses animation is still there

     }

    public void hit(int damage){
        this.health = health - damage;
    }

    public int getHealth(){
        return health;
    }

    public Position getPos(){
        return pos;
    }

    public boolean getIsAlive(){
        return isAlive;
    }

    public void killEnemy(){
        isAlive = false;
        this.picture.delete();
    }


    }
