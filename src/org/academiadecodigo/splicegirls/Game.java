package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.characters.Boss;
import org.academiadecodigo.splicegirls.characters.Enemy;
import org.academiadecodigo.splicegirls.characters.EnemyFactory;
import org.academiadecodigo.splicegirls.characters.Scary;
import org.academiadecodigo.splicegirls.level.Grid;
import org.academiadecodigo.splicegirls.level.Stage;


public class Game {

    public int delay = 600;
    private int waveCounter = 1;

    private Stage stage;
    private Grid grid;
    private Scary scary;
    private Controls controls;
    private Enemy[] enemies;
    private int numberOfEnemies;
    private Screen screen;
    private Enemy enemy;
    private Boolean gameIsOver = false;
    private Picture picture;

    public Game() throws InterruptedException {

        screen = new Screen();
        screen.createIntroScreen();
        stage = new Stage();
        grid = new Grid(13, 2);
        scary = new Scary(6, 1);
        controls = new Controls(scary, grid, screen);

    }


    public void start() throws InterruptedException {

        screen.createTutorialScreen();
        screen.createIntroScreen();

        while (controls.getMenuIsOn()) { //nao funciona sem sout!!!!
            System.out.println("HELLO");
        }


        //WAVE 1


        picture = new Picture(10, 10, "/Users/codecadet/SpliceEmUp/resources/waves/wave1.png");
        picture.grow(-160, -100);
        picture.draw();
        Thread.sleep(2500);
        picture.delete();

        while (scary.isAlive() && waveCounter == 1) {
            spawnEnemies(3);
            waveCounter++;
            Thread.sleep(200);
        }
        if (!scary.isAlive()) {
            screen.createGameOverScreen();
            setGameIsOver(true);
            controls.isGameOverScreenOn(true);
        }


        //WAVE 2

        if (gameIsOver == false) {
            picture = new Picture(10, 10, "/Users/codecadet/SpliceEmUp/resources/waves/wave2.png");
            picture.grow(-160, -100);
            picture.draw();
            Thread.sleep(2500);
            picture.delete();
        }


        while (scary.isAlive() && waveCounter == 2) {
            spawnEnemies(4);
            waveCounter++;
            Thread.sleep(200);
        }
        if (!scary.isAlive()) {
            screen.createGameOverScreen();
            setGameIsOver(true);
            controls.isGameOverScreenOn(true);
        }

        //WAVE 3
        if (gameIsOver == false) {
            picture = new Picture(10, 10, "/Users/codecadet/SpliceEmUp/resources/waves/wave3.png");
            picture.grow(-160, -100);
            picture.draw();
            Thread.sleep(2500);
            picture.delete();
        }

        while (scary.isAlive() && waveCounter == 3) {
            spawnEnemies(5);
            waveCounter++;
            Thread.sleep(200);
        }
        if (!scary.isAlive()) {
            screen.createGameOverScreen();
            setGameIsOver(true);
            controls.isGameOverScreenOn(true);

        }

        //WAVE 4
        if (gameIsOver == false) {
            picture = new Picture(10, 10, "/Users/codecadet/SpliceEmUp/resources/waves/wave4.png");
            picture.grow(-160, -100);
            picture.draw();
            Thread.sleep(3000);
            picture.delete();
        }
        while (scary.isAlive() && waveCounter == 4) {
            spawnBoss();
            waveCounter++;
            Thread.sleep(200);
            screen.createVictoryScreen();
            setGameIsOver(true);
            controls.setMenuIsOn(true);
        }
        if (!scary.isAlive()) {
            screen.createGameOverScreen();
            setGameIsOver(true);
            controls.isGameOverScreenOn(true);
        }
    }

    public void end() {
        screen.createGameOverScreen();
    }


    public void spawnEnemies(int numberOfEnemies) throws InterruptedException {

        Thread.sleep(delay * 4);
        enemies = new Enemy[numberOfEnemies];
        Enemy enemy;


        for (int i = 0; i < numberOfEnemies; i++) {

            if (!scary.isAlive()) {
                screen.createGameOverScreen();
                return;
            }
            enemy = EnemyFactory.createEnemy();
            controls.setEnemy(enemy);
            enemy.setGrid(grid);
            enemies[i] = enemy;
            animateEnemies(enemy);
        }
    }

    public void spawnBoss() throws InterruptedException {

        enemy = EnemyFactory.createBoss();
        controls.setEnemy(enemy);
        enemy.setHealth(400);
        enemy.setDamage(10);
        enemy.setGrid(grid);
        animateEnemies(enemy);

    }

    public void animateEnemies(Enemy enemy) {

        while (enemy.isAlive()) {
            enemy.move(scary);
            try {
                enemy.attack(scary);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }

}