/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;


import java.util.ArrayList;
import java.util.HashMap;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javax.swing.JOptionPane;

/**
 *
 * @author karim
 */
public class Initiate {
private Pane appPane = new Pane();
private Pane gamePane = new Pane();
boolean canJump = true;
HashMap<KeyCode,Boolean> keys = new HashMap<KeyCode,Boolean>(); 
private Node player;
Point2D playerVelocity = new Point2D(0,0);
Forrest charc;
Jinny charc2 ;
int flag; 
int levelWidth = LevelData.level1.length;
private ArrayList<Node> platforms = new ArrayList<>();
private ArrayList<Node> coins = new ArrayList<>(); 
private ArrayList<Node> InvPlatforms = new ArrayList<>();
private ArrayList<Node> GAMEOVER = new ArrayList<>();
Score score = new Score();

 public Initiate(int flag) {
        if(flag==1)
            charc= new Forrest();
        else if(flag ==2)
            charc2 = new Jinny();
    }


public void initialize ()
{
   // PlayMusic.playSoundtrack("Music/Super Mario Bros. Soundtrack.mp3");
    Rectangle bg = new Rectangle(1800,820);
    bg.setFill(Color.LIGHTBLUE);
    levelWidth = LevelData.level1[0].length() * 60;
    player = charc.getPlayer();
    player.translateXProperty().addListener((obs,old,newValue)->{
       //JOptionPane.showMessageDialog(null, "obs"+obs);
       int offset = newValue.intValue();
       if(offset>640 && offset<levelWidth-640)
           gamePane.setLayoutX(-(offset-640));
       
    });
    
    gamePane.getChildren().add(player);
    

        for (int i=0; i< LevelData.level1.length; i++){
            String line = LevelData.level1[i];
            for (int j=0; j <line.length();j++){
                switch (line.charAt(j)){
                    case '0':
                        break;
                    case '1':
                        Node platform = new CreateEntity().createGround(j*60, i *60, 60, 60);
                        gamePane.getChildren().add(platform);
                        platforms.add(platform);
                        break;
                    case '2':
                       Node cloud = new CreateEntity().createCloud(j*60, i*60, 180, 180);
                        gamePane.getChildren().add(cloud);
                        platforms.add(cloud);
                        break;
                    case '3':
                       Node coin = new CreateEntity().createCoin(j*60, i*60, 60, 60);
                        gamePane.getChildren().add(coin);
                        coins.add(coin);
                        
                        break;
                    case '4':
                       Node InvPlatform = new CreateEntity().createGround(j*60, i *60, 60, 60);
                        gamePane.getChildren().add(InvPlatform);
                        InvPlatforms.add(InvPlatform);
                        break;
                    case '5':
                       Node coinz = new CreateEntity().createCoin(j*60, i*60, 60, 60);
                        gamePane.getChildren().add(coinz);
                        GAMEOVER.add(coinz);
                        break;    
                            
                }
            }
        }
        appPane.getChildren().addAll(bg,gamePane);
}

public void update(){     
    if (isPressed(KeyCode.UP) && player.getTranslateY() >= 5){
      
        if(!(charc==null))
        {
            if (charc.r==1)
                charc.playerJump();
            else 
                charc.playerjumpLeft();
        }
        else if(!(charc==null))
             {
            if (charc2.r==1)
                charc2.playerJump();
            else 
                charc2.playerjumpLeft();
        }
        
           jumpPlayer();           
    }
    
        if (isPressed(KeyCode.LEFT) && player.getTranslateX() >=5){
            if(!(charc==null))
            charc.playermoveLeft();
            if(!(charc2==null))
            charc2.playermoveLeft();
            System.out.print(player.getTranslateY());
            movePlayerX(-5);
        }
        if (isPressed(KeyCode.RIGHT) && player.getTranslateX() + 50 <=levelWidth-5){
            if(!(charc==null))
            charc.playermoveRight();
            if(!(charc2==null))
            charc2.playermoveRight();
            movePlayerX(5);
            
        }
        
        if (playerVelocity.getY() < 10){
            playerVelocity = playerVelocity.add(0, 1);
        }
        movePlayerY((int)playerVelocity.getY());
        }



private void jumpPlayer(){
    if(canJump){
        playerVelocity = playerVelocity.add(0, -30);
        canJump = false;
        }
    }

    private void movePlayerX(int value){
    boolean movingRight = value > 0;
    for (int i=0; i < Math.abs(value);i++){
        for (Node platform : platforms){
            if(player.getBoundsInParent().intersects(platform.getBoundsInParent())){
                
                if(movingRight){
                    if (player.getTranslateX() + 50 == platform.getTranslateX()){
                        return;
                    }
                }else {
                    if (player.getTranslateX() == platform.getTranslateX() + 60) {
                        return;
                    }
                }
            }
        }
        for (Node InvPlatform : InvPlatforms){
            if(player.getBoundsInParent().intersects(InvPlatform.getBoundsInParent())){
                
                if(movingRight){
                    if (player.getTranslateX() + 50 == InvPlatform.getTranslateX()){
                        player.setTranslateX(player.getTranslateX() - 1);
                                
                    }
                }else {
                    if (player.getTranslateX() == InvPlatform.getTranslateX() + 60) {
                        return;
                    }
                }
            }
        }
         for (Node coin : coins){
            if(player.getBoundsInParent().intersects(coin.getBoundsInParent())){
                
                if(movingRight){
                    if (player.getTranslateX() + 50 == coin.getTranslateX()){
                        coin.setVisible(false);
                        score.scoresum();
                    }
                }else {
                    if (player.getTranslateX() == coin.getTranslateX() + 60) {
                        coin.setVisible(false);
                    }
                }
            }
        }
        for (Node coinz : GAMEOVER){
            if(player.getBoundsInParent().intersects(coinz.getBoundsInParent())){
                
                if(movingRight){
                    if (player.getTranslateX() + 50 == coinz.getTranslateX()){
                        Image image = new Image("images/winner.png");
                        gamePane.getChildren().add(new ImageView(image));
                        coinz.setVisible(false);
                        
                    }
                }else {
                    if (player.getTranslateX() == coinz.getTranslateX() + 60) {
                        Image image = new Image("images/winner.png");
                        gamePane.getChildren().add(new ImageView(image));
                        coinz.setVisible(false);
                    }
                }
            }
        }
        
         
        player.setTranslateX(player.getTranslateX() + (movingRight ? 1 : -1));
        }
    score.write(score.scoresum()-2);
    }

        private void movePlayerY(int value){
        boolean movingDown = value > 0;
        for (int i=0; i < Math.abs(value);i++){
            for (Node platform : platforms){
                if(player.getBoundsInParent().intersects(platform.getBoundsInParent())){
                    if(movingDown){
                        if (player.getTranslateY() + 50 == platform.getTranslateY()){
                               
                                player.setTranslateY(player.getTranslateY()-1);
                                canJump = true;
                                return;
                        }
                    }else {
                        if (player.getTranslateY() == platform.getTranslateY() + 60) {
                            return;
                        }
                    }
                }
            }
                     for (Node coin : coins){
            if(player.getBoundsInParent().intersects(coin.getBoundsInParent())){
                
                if(movingDown){
                    if (player.getTranslateY() + 50 == coin.getTranslateY()){
                        coin.setVisible(false);
                    }
                }else {
                    if (player.getTranslateY() == coin.getTranslateY() + 60) {
                        coin.setVisible(false);
                    }
                }
            }
        }
            player.setTranslateY(player.getTranslateY() + (movingDown ? 1 : -1));
        }
    }
    
   private boolean isPressed(KeyCode key){
    return keys.getOrDefault(key, false);
    }

    public Pane getAppPane() {
        return appPane;
    }
   
  



    
}
