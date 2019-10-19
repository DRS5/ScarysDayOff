package org.academiadecodigo.splicegirls;
import org.academiadecodigo.splicegirls.characters.Enemy;
import org.academiadecodigo.splicegirls.characters.EnemyFactory;
import org.academiadecodigo.splicegirls.characters.Scary;
import org.academiadecodigo.splicegirls.level.Grid;
import org.academiadecodigo.splicegirls.level.Stage;

import java.util.LinkedList;

public class Game {

    public int delay = 600;
    private int waveCounter;

    private Stage stage;
    private Grid grid;
    private Scary scary;
    private Controls controls;
    private Enemy enemy;
    private Enemy[] enemies;
    private int numberOfEnemies = 3;

    public Game(
    ) throws InterruptedException {
        stage = new Stage();
        grid = new Grid(13,2);
        scary = new Scary(1,1);
        //enemy = new Enemy(14,2);
        controls = new Controls(scary, grid);


    }

    public void spawnEnemies() throws InterruptedException {

        enemies = new Enemy[numberOfEnemies];
        Enemy enemyX;
        int rowCounter = 1;

        for (int i = 0; i < numberOfEnemies; i++){
            if (rowCounter == 3){
                rowCounter = 1;
            }
            enemyX = EnemyFactory.createEnemy();
            controls.setEnemy(enemyX);
            enemyX.setGrid(grid);
            enemyX.getPicture().translate( 0, (rowCounter - 2) * grid.getCellSize());
            animateEnemies(enemyX);
            enemies[i] = enemyX;
            rowCounter++;

        }
    }


    public void start() throws InterruptedException {

        spawnEnemies();














    }

        public void animateEnemies(Enemy enemy){

            while(enemy.getIsAlive()){
                enemy.move(scary);
                try {
                    enemy.attack(scary);
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        //while (enemy.getIsAlive()){
        //    if(scary.getPos().getCol() == enemy.getPos().getCol() + 1
        //            || scary.getPos().getCol() == enemy.getPos().getCol() - 1 ) {
        //        enemy.attack();
        //        Thread.sleep(delay*2); // para demorar mais tempo a atacar
        //    }
        //}

}
