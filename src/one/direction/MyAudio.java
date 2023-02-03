/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.direction;

import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public class MyAudio { public static void main(String[] args) {
        new MyAudio().start();
    }

/**
 *
 * @author Mayank Aggarwal
 */
        
    
    
    public void start() {

        String fileName = null;
        //URL url;
        final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFXPanel(); // initializes JavaFX environment
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(MyAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "MP3 Files", "mp3");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().toURI().toString();
            System.out.println(fileName);
        }
        MediaPlayer mediaPlayer;
        mediaPlayer = new MediaPlayer(new Media(fileName));
       mediaPlayer.play();
        
    }}

    

