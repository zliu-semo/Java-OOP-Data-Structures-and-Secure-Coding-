/*
 * JavaFXEx3: demonstration of how to switch between Stages
 * Tools: StackPane
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MyMultiStageApplication extends Application {
    private static final int SCENE_WIDTH = 500;
    private static final int SCENE_HEIGHT = 400;
    
    private static final Font LABEL_FONT = Font.font("Arial", FontWeight.BOLD, 24);
    private static final Font BUTTON_FONT = Font.font("Arial", FontWeight.NORMAL, 16);
    
    @Override
    public void start(Stage primaryStage) {
      Button button = new Button("Open a New Window");
      button.setFont(BUTTON_FONT);
      
      button.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            Label newWindowLabel = new Label("Please type something");
            newWindowLabel.setFont(LABEL_FONT);
            TextField newWindowTextField = new TextField();
            
            VBox newWindowBox = new VBox();
            newWindowBox.setAlignment(Pos.CENTER);
            newWindowBox.getChildren().addAll(newWindowLabel, newWindowTextField); 
            Scene newWindowScene = new Scene(newWindowBox, SCENE_WIDTH, SCENE_HEIGHT);
 
            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("Secondary Stage");
            newWindow.setScene(newWindowScene);
            
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);//.NONE); //.WINDOW_MODAL);
            
            // Specifies the owner Window (parent) for new window.
            //newWindow.initOwner(primaryStage);
 
            // Set position of second window, relative to primary window.
            newWindow.setX(primaryStage.getX() + 200);
            newWindow.setY(primaryStage.getY() + 200); 
            newWindow.show();
         }
      });
 
      StackPane root = new StackPane();
      root.getChildren().add(button);
 
      Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
 
      primaryStage.setTitle("My Multi-Stage Application");
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}