/*
 * JavaFXEx2: demonstration of how to switch between Scenes
 * Tools: importing images, creating Polygons
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MyMultiSceneApplication extends Application {
    /*
     * Knowledge Check 3 for JavaFX:
     * Create a "Welcome" screen that appears when this application is launched.
     */
    
    // Knowledge Check 3 for JavaFX:
    // Scene welcomeScene;
    
    Scene imgScene, polygonScene;
    Image img;
    
    private static final String IMG_FILENAME = "files/java-logo.png";
    
    private static final int SCENE_WIDTH = 500;
    private static final int SCENE_HEIGHT = 400;
    
    private static final Font LABEL_FONT = Font.font("Arial", FontWeight.BOLD, 24);
    private static final Font BUTTON_FONT = Font.font("Arial", FontWeight.NORMAL, 16);
    
    @Override
    public void start(Stage primaryStage) {
        // Welcome Scene
        /*Label welcomeSceneLabel = new Label("Welcome!");
        welcomeSceneLabel.setFont(LABEL_FONT);
        Button startButton = new Button("START");
        startButton.setFont(BUTTON_FONT);
        startButton.setOnAction(event -> primaryStage.setScene(imgScene));
        VBox welcomeBox = new VBox(20);
        welcomeBox.setAlignment(Pos.CENTER);
        welcomeBox.getChildren().addAll(welcomeSceneLabel, startButton);
        welcomeScene = new Scene(welcomeBox, SCENE_WIDTH, SCENE_HEIGHT);*/
        
        // First Scene
        Label imgSceneLabel= new Label("Hello World!");
        imgSceneLabel.setFont(LABEL_FONT);
        Button nextButton = new Button();
        nextButton.setText("NEXT");
        nextButton.setFont(BUTTON_FONT);
        nextButton.setOnAction(event -> primaryStage.setScene(polygonScene));
        
        ImageView imgView = new ImageView();
        try {
            img = new Image(new FileInputStream(IMG_FILENAME));
            imgView.setImage(img);
        } catch (FileNotFoundException e) {
            imgSceneLabel.setText("Image file could not be found.");
        }
        
        VBox imgBox= new VBox(20);
        imgBox.setAlignment(Pos.CENTER);
        imgBox.getChildren().addAll(imgSceneLabel, imgView, nextButton);       
        imgScene = new Scene(imgBox, SCENE_WIDTH, SCENE_HEIGHT);    
        
        // Second Scene
        Label polygonSceneLabel= new Label("Hexagon is here!");
        polygonSceneLabel.setFont(LABEL_FONT);
        Button backButton = new Button("BACK");
        backButton.setFont(BUTTON_FONT);
        backButton.setOnAction(event -> primaryStage.setScene(imgScene));
        
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{ 
                100.0, 30.0,
                180.0, 30.0,
                230.0, 90.0,
                180.0, 150.0,
                100.0, 150.0,
                50.0, 90.0,
        }); 
        polygon.setFill(Color.GREEN);         
        Group polygonGroup = new Group(polygon);
        
        VBox polygonBox = new VBox(20);
        polygonBox.setAlignment(Pos.CENTER);
        polygonBox.getChildren().addAll(polygonSceneLabel, polygonGroup, backButton);
        polygonScene = new Scene(polygonBox, SCENE_WIDTH, SCENE_HEIGHT);
        
        primaryStage.setTitle("My Multi-Scene Application");
        primaryStage.setScene(imgScene);
        // primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}