/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author karim
 */
public class CreateEntity {
     public Node createRect(int x,int y,int w,int h, Color color)
    {Rectangle rec = new Rectangle(w,h);
    rec.setTranslateX(x);
    rec.setTranslateY(y);
    rec.setFill(color);
    return rec;
        
    }
    public Node createGround(int x,int y,int w,int h)
    {
        Image image = new Image("Images/mario_bricks.png");
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(h);
        imageview.setFitWidth(w);
        imageview.setTranslateX(x);
        imageview.setTranslateY(y);
        return imageview;
    }
    
        public Node createCloud(int x,int y,int w,int h)
    {
        Image image = new Image("Images/kimo2.jpg");
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(h);
        imageview.setFitWidth(w);
        imageview.setTranslateX(x);
        imageview.setTranslateY(y);
        return imageview;
    }
        public Node createCoin(int x,int y,int w,int h)
    {
        Image image = new Image("Images/rvr.gif");
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(h);
        imageview.setFitWidth(w);
        imageview.setTranslateX(x);
        imageview.setTranslateY(y);
        return imageview;
    }        
    
}
