package org.academiadecodigo.splicegirls.characters;
        import org.academiadecodigo.splicegirls.Random;

public class EnemyFactory {

    public static Enemy createEnemy() throws InterruptedException {

        int randomNumber = Random.getRandom(10);

        if (randomNumber <= 5){
            return new Paparazzi(14, 2, "enemy/enemy2 idle.png");
        }

        else {
            return new Fan(- 1, 2, "enemy/enemy1 idle.png");
        }
    }
}
