package org.academiadecodigo.splicegirls;

import org.academiadecodigo.splicegirls.characters.Enemy;
import org.academiadecodigo.splicegirls.level.Stage;
import org.academiadecodigo.splicegirls.characters.Scary;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        System.out.println(Random.getRandomRow(3));
        System.out.println(Random.getRandomRow(3));
        System.out.println(Random.getRandomRow(3));
        System.out.println(Random.getRandomRow(3));
        System.out.println(Random.getRandomRow(3));
        System.out.println(Random.getRandomRow(3));
        System.out.println(Random.getRandomRow(3));
        game.start();


    }

}
