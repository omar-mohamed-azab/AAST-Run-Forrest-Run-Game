/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

import java.io.File;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author omar azab
 */
public class GameFinal extends Application {
    
   VBox vb = new VBox(10);
    Button play = new Button("Play");
    Button score = new Button("Score");
    Button exit =  new Button("Exit");
    @Override
    public void start(Stage primaryStage) {
    
    vb.setAlignment(Pos.CENTER);
    vb.getChildren().addAll(play,score,exit);
    StackPane sp = new StackPane(vb);
    MainMenu mm = new MainMenu();
    Scene scene = new Scene(sp);
    primaryStage.setScene(scene);
    play.setOnAction(e -> {
        /*db.DBconnect();
        db.insertData(us, fn, ln, s, character);*/
        Thread thread = new Thread();
        primaryStage.setScene(mm.Menu());
    });
    score.setOnAction(e->{
        
         try
        {
            File file = new File("score.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext())
            {
                String username = scanner.next();
                String firstname = scanner.next();
                String lastname = scanner.next();
                //int score = scanner.nextInt();
                System.out.println(username+" "+firstname+" "+lastname/*+" "+score*/);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    });
    exit.setOnAction(e->{
        primaryStage.close();
    });
    primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
