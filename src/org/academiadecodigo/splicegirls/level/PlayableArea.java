package org.academiadecodigo.splicegirls.level;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayableArea {

    private int x;
    private int y;
    private int width;
    private int height;
    private Rectangle playableArea;


    public PlayableArea(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void init(){
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
