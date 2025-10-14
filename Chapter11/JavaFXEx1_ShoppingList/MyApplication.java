/*
 * JavaFXEx1: a simple shopping list application
 * UI controls: ListView, TextField, Button, and Text
 * Layout: GridPane and HBox
 * Event handling: Button click
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.cell.TextFieldListCell;

public class MyApplication extends Application {
    
    /**
     * Implement the necessary method to extend javafx.application.Application
     * This method determines how your application will START.
     */
    @Override
    public void start(Stage primaryStage) {
        /*
         * Knowledge Check 1 for JavaFX:
         * Add some code to MyApplication so that when the user adds a new item to the 
         * shopping list, a message will appear at the bottom of the screen letting the 
         * user know that a new item was successfully added.
         */
        
        /*
         * Knowledge Check 2 for JavaFX:
         * Add a “Clear” Button that will remove all the items of the shopping list when 
         * the user clicks on it.
         */
        
        primaryStage.setTitle("My Shopping List");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text title = new Text("Shopping List:");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);
        
        ObservableList<String> shoppingList = FXCollections.observableArrayList(
          "apples", "butter", "cheese");
        ListView<String> listView = new ListView<String>(shoppingList);
        grid.add(listView, 0, 1, 2, 1);
        
        TextField newItem = new TextField();
        grid.add(newItem, 0, 4, 2, 1);

        Button addButton = new Button("Add");
        HBox addButtonBox = new HBox(10);
        addButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        addButtonBox.getChildren().add(addButton);
        grid.add(addButtonBox, 1, 6);

        Button removeButton = new Button("Remove");
        HBox removeButtonBox = new HBox(10);
        removeButtonBox.setAlignment(Pos.BOTTOM_LEFT);
        removeButtonBox.getChildren().add(removeButton);
        grid.add(removeButtonBox, 0, 6); 
        
        final Text completedText = new Text();
        completedText.setWrappingWidth(250);
        grid.add(completedText, 0, 8);

        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());
        
        /*
         * Knowledge Check 2 for JavaFX: Solution
         * (1) create the "Clear" Button
         * (2) add the appropriate EventHandler to the "Clear" Button
         */
        /*Button clearButton = new Button("Clear");
        removeButtonBox.getChildren().add(clearButton);
        
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                listView.getItems().clear();
                completedText.setText("All items removed!");
            }
        });*/
        
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(!newItem.getText().equals(""))
                    listView.getItems().add(newItem.getText());
                
                // Knowledge Check 1 for JavaFX: Solution
                // completedText.setText("Item successfully added! " + newItem.getText());
            }
        });
        
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                final int selectedIdx = listView.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                    String itemToRemove = listView.getSelectionModel().getSelectedItem();
 
                    final int newSelectedIdx =
                        (selectedIdx == listView.getItems().size() - 1)
                        ? selectedIdx - 1
                        : selectedIdx;
 
                    listView.getItems().remove(selectedIdx);
                    listView.getSelectionModel().select(newSelectedIdx);
                    
                    completedText.setText("Completed! " + itemToRemove);
                }
            }
        });   
        
        Scene scene = new Scene(grid, 350, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Start the application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
