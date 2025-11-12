/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

import java.io.File;
import java.io.PrintWriter;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author omar azab
 */
public class MainMenu {
    int flag=1;
        public Scene Menu()
    {
    //DataBase db = new DataBase();
        GridPane gp = new GridPane();
        StackPane sp = new StackPane();
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        Label l1 = new Label("User name:");
        Label l2 = new Label("First name:");
        Label l3 = new Label("Last name:");
        Label l4 = new Label("Choose your character:");
        RadioButton rb3 = new RadioButton("Forrest");
        RadioButton rb4 = new RadioButton("Jinny");
        ToggleGroup tg1 = new ToggleGroup();
        ToggleGroup tg2 =  new ToggleGroup();
        rb3.setToggleGroup(tg1);
        rb4.setToggleGroup(tg1);
        Button b1 = new Button("Next");
      
        gp.addRow(0,l1,tf1 );
        gp.addRow(1,l2,tf2 );
        gp.addRow(2,l3,tf3 );
        gp.addRow(3,l4 );
        gp.addRow(4,rb3,rb4 );
        gp.addRow(6,b1);
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        
       
        Scene scene = new Scene(gp);

        
        b1.setOnAction(e->{
            try
            {
                File file = new File("score.txt");
                PrintWriter pr = new PrintWriter(file);
                pr.print(tf1.getText()+" "+tf2.getText()+" "+tf3.getText());
                pr.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            
             Thread thread = new Thread (){
              @Override
              public void run()
              {
              new PlayMusic().play();
              }
            };
            thread.start();
            Initiate i = new Initiate(flag);
            i.initialize();
            scene.setRoot(i.getAppPane());
            scene.setOnKeyPressed(ev -> i.keys.put(ev.getCode(), true));
            scene.setOnKeyReleased(ev -> i.keys.put(ev.getCode(), false));
                    AnimationTimer timers = new AnimationTimer() {
            @Override
            public void handle(long now) {
                i.update();
            }
        };
        timers.start();
        });

        return scene;
    }   
}
