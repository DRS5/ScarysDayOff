package org.academiadecodigo.splicegirls;

public class Random {

    public static int getRandom(int value){
        return (int) Math.floor(Math.random() * value);
    }

    public static int getRandomCol(int value){
        return (int) Math.floor(Math.random() * value);
    }

    public static int getRandomRow(int value){
        return (int) Math.floor(Math.random() * value);
    }

}
