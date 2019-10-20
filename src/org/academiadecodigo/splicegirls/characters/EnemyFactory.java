package org.academiadecodigo.splicegirls.characters;
        import org.academiadecodigo.splicegirls.Random;

public class EnemyFactory {

    public static Enemy createEnemy() throws InterruptedException {

        int randomNumber = Random.getRandom(2);

        if (randomNumber == 0) {
            return new Paparazzi(randomCol(), 2, "resources/enemy/enemy2 idle.png");
        }
        if (randomNumber == 1) {
            return new Fan(randomCol(), 2, "resources/enemy/enemy1 idle.png");
        }
        return null;
    }

    public static int randomCol() {

        int randomNumber = Random.getRandom(2);

        if (randomNumber == 0) {
            return -1;

        } else {
            return 14;
        }
    }
}







