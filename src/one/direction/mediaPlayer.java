/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.direction;

import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

  public class mediaPlayer extends JFrame
    {
        public mediaPlayer() throws MalformedURLException
        {
            setLayout(new BorderLayout());
JFileChooser chooser = new JFileChooser();
    
        chooser.showOpenDialog(null);
 
                URL fileName = chooser.getSelectedFile().toURL();
           
        
            //file you want to play
            //Whatever
            //create the media player with the media url
            Player mediaPlayer = Manager.createRealizedPlayer(fileName);
            //get components for video and playback controls
            Component video = mediaPlayer.getVisualComponent();
            Component controls = mediaPlayer.getControlPanelComponent();
            add(video,BorderLayout.CENTER);
            add(controls,BorderLayout.SOUTH);
        }
    }

