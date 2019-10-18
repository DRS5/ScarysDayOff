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
    private int enemyDelay = 200;
    private int col;
    private int row;
    private Enemy enemy;

    public Enemy(int col, int row) throws InterruptedException {

        picture = new Picture(startingPointCol + (col * cellSize + PADDING), startingPointRow + (row * cellSize + PADDING), "enemy/enemy1 idle.png");
        picture.draw();
        this.col = col;
        this.row = row;
        pos = new Position(col, row);

    }

    public void move(Scary scary) {

        if (col > scary.getPos().getCol()) {
            if ((col - 1) == scary.getPos().getCol()) {
                if (row < scary.getPos().getRow()) {
                    row++;
                } else {
                    row--;
                }
                return;
            }
            col--;
            picture.translate(-cellSize, 0);

        }
        if (col < scary.getPos().getCol()) {
            if ((col + 1) == scary.getPos().getCol()) {
                if (row < scary.getPos().getRow()) {
                    row++;
                } else {
                    row--;
                }
                return;
            }
            col++;
            picture.translate(cellSize, 0);

        }

        if (row -1 > scary.getPos().getRow()) { //coloquei -1 aqui!!!
            row--;
            picture.translate(0, -cellSize);
        }

        if (row -1 < scary.getPos().getRow()) { //coloquei -1 aqui!!!
            row++;
            picture.translate(0, cellSize);
        }

    }

    public void enemyAnimation() throws InterruptedException {
        picture.delete();
        picture = new Picture(startingPointCol + (col * cellSize + PADDING), startingPointRow + (row * cellSize + PADDING), "enemy/enemy1 walk.png");
        picture.draw();

    }


    public void attack(Scary scary) throws InterruptedException {
        if (scary.getHealth() > 0) {
            if (scary.getPos().getCol() + 1 == col && scary.getPos().getRow() == row
                    || scary.getPos().getCol() - 1 == col && scary.getPos().getRow() == row) {
                Thread.sleep(600 * 2); // para demorar mais tempo a atacar
                scary.hit(25);
            }
        } else {
            scary.killScary();
        }
    }

    public void hit(int damage) {
        this.health = health - damage;
        System.out.println("Enemy health: " + health);
    }

    public int getHealth() {
        return health;
    }

    public Position getPos() {
        return pos;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void killEnemy() {
        isAlive = false;
        this.picture.delete();
    }

    public Picture getPicture(){
        return picture;
    }
}
