package org.academiadecodigo.splicegirls.characters;
        import org.academiadecodigo.splicegirls.Random;

public class EnemyFactory {

    public static Enemy createEnemy() throws InterruptedException {

        int randomNumber = Random.getRandom(10);

        if (randomNumber <= 5){
            return new Enemy(14, 2);
        }

        else {
            return new Enemy (- 1, 2);
        }
    }
}
