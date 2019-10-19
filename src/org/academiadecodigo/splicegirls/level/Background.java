package org.academiadecodigo.splicegirls.level;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture port;

    public Background(){
        port = new Picture(10, 10, "levelBackground/fundobarcos.jpg");
        port.draw();
    }



}
