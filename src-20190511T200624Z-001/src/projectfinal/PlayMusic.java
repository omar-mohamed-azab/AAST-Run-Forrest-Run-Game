/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

import javafx.scene.media.AudioClip;

/**
 *
 * @author karim
 */
public class PlayMusic {
    
 String string="game_t.mp3";
        AudioClip audio = new AudioClip(this.getClass().getResource(string).toString());
        public void play()
        {
        audio.setCycleCount(AudioClip.INDEFINITE);
        audio.play();   
        }
    
}
