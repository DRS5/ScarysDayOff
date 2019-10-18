package org.academiadecodigo.splicegirls.characters;
        import org.academiadecodigo.splicegirls.Random;

public class EnemyFactory {

    public static Enemy createEnemy() throws InterruptedException {

        return new Enemy(14, 1);
    }
}
