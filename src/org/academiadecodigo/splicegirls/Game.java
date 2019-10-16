package org.academiadecodigo.splicegirls;

import org.academiadecodigo.splicegirls.characters.Enemy;
import org.academiadecodigo.splicegirls.characters.Scary;
import org.academiadecodigo.splicegirls.level.Stage;

public class Game {

    public void start() throws InterruptedException {

        Stage stage = new Stage();
        Scary scary = new Scary();
        Enemy enemy = new Enemy(scary);

        scary.setEnemy(enemy);

        while (enemy.getIsAlive()){
            enemy.move();
            Thread.sleep(500);
        }
    }
}
