/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;


import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author karim
 */
public class Jinny extends Character{

   
       Image image;
    ImageView imageview ;
    static int r =1;
    public Jinny () {
        image = new Image("Images/girl.png");
        imageview = new ImageView(image);
        imageview.setFitHeight(50);
        imageview.setFitWidth(50);
    }
    
           public Node getPlayer()
    {
        r=1;
        return imageview;
    }
           
    
    public Node playerJump()
    {
        this.imageview.setImage(new Image("Images/girl2.png"));
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(50);
        imageview.setFitWidth(50);
        r=1;
       return imageview;
    }

     public Node playermoveRight()
    {
        this.imageview.setImage(new Image("Images/girl3.png"));
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(50);
        imageview.setFitWidth(50);
        r=1;
       return imageview;
    } 
     public Node playermoveLeft()
    {
        this.imageview.setImage(new Image("Images/girl10.png"));
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(50);
        imageview.setFitWidth(50);
        r=0;
       return imageview;
    } 
     
         public Node playerjumpLeft()
    {
        this.imageview.setImage(new Image("Images/girl2f.png"));
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(50);
        imageview.setFitWidth(50);
       return imageview;
    } 
    
    }

   
    

