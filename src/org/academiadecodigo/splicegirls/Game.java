package org.academiadecodigo.splicegirls;

import org.academiadecodigo.splicegirls.characters.Enemy;
import org.academiadecodigo.splicegirls.characters.Scary;
import org.academiadecodigo.splicegirls.level.Grid;
import org.academiadecodigo.splicegirls.level.Stage;

public class Game {

    public int delay = 500;

    public void start() throws InterruptedException {

        Stage stage = new Stage();
        Grid grid = new Grid(13,2);
        Scary scary = new Scary(1,1);
        Enemy enemy = new Enemy(13,2, scary);
        Controls controls = new Controls(scary, grid);

        scary.setEnemy(enemy);

        while (enemy.getIsAlive()){
            enemy.move();
            Thread.sleep(delay);
        }
    }
}
