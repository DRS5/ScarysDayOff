package org.academiadecodigo.splicegirls.characters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.position.Position;

public class Enemy {

    private Picture picture;
    private Position pos;
    private int health = 50;
    private int distance = 1;
    private int cellSize = 80;
    private final int PADDING = 10;
    private int startingPointCol = 80;
    private boolean isAlive = true;
    private int startingPointRow = 400;
    private int col;
    private int row;
    private Scary scary;

    public Enemy(int col, int row, Scary scary) throws InterruptedException {

        picture = new Picture(startingPointCol + (col * cellSize + PADDING),startingPointRow + (row * cellSize + PADDING), "enemy/enemy1 idle.png");
        picture.draw();
        this.scary = scary;
        this.col = col;
        this.row = row;
        pos = new Position(col, row);

    }

    public void move(){

            if(col > scary.getPos().getCol()){
                if((col - 1) == scary.getPos().getCol())  {
                    return;
                }
                col--;
                picture.translate(-cellSize, 0);

            }
            if(col < scary.getPos().getCol()){
                if((col + 1) == scary.getPos().getCol())  {
                    return;
                }
               col++;
               picture.translate(cellSize, 0);

            }

            if(row > scary.getPos().getRow()){
                 if((row - 1) == scary.getPos().getRow())  {
                     return;
                 }
                row--;
                picture.translate(0, -cellSize);
            }

            if (row < scary.getPos().getRow()){
                if((row + 1) == scary.getPos().getRow())  {
                     return;
                }
                row++;
                picture.translate(0, cellSize);
            }

        }

     public void attack() {

        if((scary.getPos().getCol() - pos.getCol()) <= distance || (scary.getPos().getRow() - pos.getRow()) <= distance){
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
