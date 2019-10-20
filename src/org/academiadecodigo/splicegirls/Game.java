package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.splicegirls.characters.Enemy;
import org.academiadecodigo.splicegirls.characters.EnemyFactory;
import org.academiadecodigo.splicegirls.characters.Scary;
import org.academiadecodigo.splicegirls.level.Grid;
import org.academiadecodigo.splicegirls.level.Stage;


public class Game {

    public int delay = 600;
    private int waveCounter;

    private Stage stage;
    private Grid grid;
    private Scary scary;
    private Controls controls;
    private Enemy[] enemies;
    private int numberOfEnemies;
    private Screen screen;

    public Game() {

        stage = new Stage();
        stage.buildStage();
        grid = new Grid(13, 2);
        scary = new Scary(6, 1);
        screen = new Screen();
        controls = new Controls(scary, grid, screen);
    }


    public void start() throws InterruptedException {

        while (controls.getMenuIsOn()) {
            screen.createIntroScreen();
        }
        screen.eraseMenu();

        spawnEnemies(3);
        waveCounter++;
        Thread.sleep(200);
        spawnEnemies(5);
        waveCounter++;
        Thread.sleep(200);
        spawnEnemies(7);
        waveCounter++;
        Thread.sleep(200);
        spawnEnemies(1);
    }

    public void spawnEnemies(int numberOfEnemies) throws InterruptedException {


        Thread.sleep(delay * 4);
        enemies = new Enemy[numberOfEnemies];
        Enemy enemy;
        Enemy enemy2;


        for (int i = 0; i < numberOfEnemies; i++) {

            enemy = EnemyFactory.createEnemy();
            controls.setEnemy(enemy);
            enemy.setGrid(grid);
            animateEnemies(enemy);
            enemies[i] = enemy;

        }

    }

    public void animateEnemies(Enemy enemy) {

        while (enemy.getIsAlive()) {
            enemy.move(scary);
            try {
                enemy.attack(scary);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
