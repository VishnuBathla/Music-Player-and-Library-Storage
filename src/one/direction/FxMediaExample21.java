/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.direction;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FxMediaExample21 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
String fileNames;
String k1;
    @Override
    public void start(Stage stage) {
        SwingUtilities.invokeLater(JFXPanel::new);
         Statement n1=null;
        ResultSet b=null;
       fileNames=null;
        String query="select * from currently_playing";
    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=(Connection)
            DriverManager.getConnection("jdbc:mysql://localhost:3306/one_direction","root","anitaajay");
            n1=(Statement)c.createStatement();
            
           
            b=n1.executeQuery(query);
  while(b.next())       
  {k1=b.getString(1);
 fileNames=b.getString(2);
 
  }

        
        }catch(Exception bla)
        {JOptionPane.showMessageDialog(null,bla.getMessage());  }
    MediaPlayer mediaPlayer;

      
    
     mediaPlayer = new MediaPlayer(new Media(fileNames));
mediaPlayer.play();

        // Create a 400X300 MediaView
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitWidth(400);
        mediaView.setFitHeight(300);
        mediaView.setSmooth(true);
        mediaView.setLayoutX(200);
        mediaView.setLayoutY(200);
        // Create the DropShadow effect
        DropShadow dropshadow = new DropShadow();
        dropshadow.setOffsetY(5.0);
        dropshadow.setOffsetX(5.0);
        dropshadow.setColor(Color.RED);

        mediaView.setEffect(dropshadow);

        Rectangle rect4 = new Rectangle(35, 55, 95, 25);
        rect4.setFill(Color.RED);
        rect4.setStroke(Color.BLACK);
        rect4.setStrokeWidth(1);

        // Create the HBox
        // HBox controlBox = new HBox(5, null, null);

        // Create the VBox
        VBox root = new VBox(1, mediaView);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(95));
        gridpane.setHgap(1);
        gridpane.setVgap(10);

        GridPane.setHalignment(rect4, HPos.CENTER);

        Group grp = new Group();
        gridpane.add(root, 1, 1);

        grp.getChildren().add(gridpane);

        // Create the Scene
        Scene scene = new Scene(grp);

        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("A simple Media Example");
        // Display the Stage
        stage.show();
    }
}