package org.academiadecodigo.splicegirls.level;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Stage {

    private Picture stage;

    public void buildStage(){
        stage = new Picture(10, 10, "levelBackground/fundobarcos.jpg");
        stage.draw();
    }


}
