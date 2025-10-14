/*
 * JavaFXEx4: Working with data, tables, and menus
 * Creating menus: Menu, MenuItem, MenuBar
 * Creating tables: TableView, TableColumn, TablePosition, 
 *                  PropertyValueFactory, TextFieldTableCell
 * Choosing files from local computer: FileChooser
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MyDataDrivenApplication extends Application {
    private ObservableList<SP500Record> data;    
    private Text actionStatus;
    
    @Override
    public void start(Stage primaryStage) {
        // Status message text
        actionStatus = new Text("Application started.");
        actionStatus.setFill(Color.FIREBRICK);
        
        Menu menu = new Menu("File");               // create a Menu
        MenuItem openItem = new MenuItem("Open");   // create MenuItems
        MenuItem closeItem = new MenuItem("Close"); // create MenuItems  
        menu.getItems().add(openItem);              // add MenuItems to Menu
        menu.getItems().add(closeItem);             // add MenuItems to Menu 
        MenuBar bar = new MenuBar();                // create MenuBar  
        bar.getMenus().add(menu);                   // add Menu to MenuBar      
           
        TableView<SP500Record> table = new TableView<SP500Record>();
        table.setEditable(true);
        
        // Create columns of the data display table.
        TableColumn<SP500Record, String> dateCol = new TableColumn<SP500Record, String>("Date");           
        TableColumn<SP500Record, Double> openCol = new TableColumn<SP500Record, Double>("Open");
        TableColumn<SP500Record, Double> highCol = new TableColumn<SP500Record,Double>("High");
        TableColumn<SP500Record, Double> lowCol = new TableColumn<SP500Record,Double>("Low");
        TableColumn<SP500Record, Double> closeCol = new TableColumn<SP500Record,Double>("Close");
        TableColumn<SP500Record, Double> adjcloseCol = new TableColumn<SP500Record,Double>("Adjclose");
        TableColumn<SP500Record, Long> volCol = new TableColumn<SP500Record,Long>("Volume");
        TableColumn<SP500Record, String> noteCol = new TableColumn<SP500Record, String>("Notes");
            
        // Defines how to fill data for each cell.
        // Get value from property of SP500Record.            
        dateCol.setCellValueFactory(new PropertyValueFactory<SP500Record, String>("date"));         
        openCol.setCellValueFactory(new PropertyValueFactory<SP500Record, Double>("open"));
        highCol.setCellValueFactory(new PropertyValueFactory<SP500Record, Double>("high"));
        lowCol.setCellValueFactory(new PropertyValueFactory<SP500Record, Double>("low"));
        closeCol.setCellValueFactory(new PropertyValueFactory<SP500Record, Double>("close"));
        adjcloseCol.setCellValueFactory(new PropertyValueFactory<SP500Record, Double>("adjclose"));
        volCol.setCellValueFactory(new PropertyValueFactory<SP500Record,Long>("volume")); 
        noteCol.setCellValueFactory(new PropertyValueFactory<SP500Record, String>("note"));

        // Event handling for cell editing
        noteCol.setCellFactory(TextFieldTableCell.forTableColumn());
        noteCol.setOnEditCommit((CellEditEvent<SP500Record, String> event)-> {
            TablePosition<SP500Record, String> pos = event.getTablePosition();
            String newNote = event.getNewValue();
            int row = pos.getRow();
            SP500Record record = event.getTableView().getItems().get(row);
            record.setNote(newNote);  
        });
        
        // TableView row selection event handling
        table.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> obsVal, 
                            Number oldVal, Number newVal) {
                        int selectedRowIndex = newVal.intValue();
                        if ((selectedRowIndex >= 0 && selectedRowIndex < data.size())) {     
                            SP500Record record = (SP500Record) data.get(selectedRowIndex);
                            actionStatus.setText(record.toString()); 
                        }  
                    }
                });
        
        // Create event handler for menu item: open SP500.csv file in a table format 
        EventHandler<ActionEvent> openHandler = new EventHandler<ActionEvent>() {
            @SuppressWarnings("unchecked")
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                // Set extension filter for .csv files
                FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
                fileChooser.getExtensionFilters().add(extFilter);
                
                // Show file dialog
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {    
                    try {
                        data = readSP500Records(file);
                        actionStatus.setText("File read");
                    } catch(IOException e) {
                        actionStatus.setText("Error reading file");
                    }
                }
        
                // Display row data 
                table.getColumns().addAll(dateCol, openCol, highCol, lowCol, 
                        closeCol, adjcloseCol, volCol, noteCol); 
                table.setItems(data);
            }            
        };

        // Create event handler for menu item: clear table 
        EventHandler<ActionEvent> closeHandler = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) {
                table.getItems().clear();
                table.getColumns().clear();
                actionStatus.setText("File closed");
            }
        };
        
        // Add event handlers to menu items 
        openItem.setOnAction(openHandler); 
        closeItem.setOnAction(closeHandler);  
  
        // Create a VBox 
        VBox container = new VBox(bar, table, actionStatus); 
        container.setPadding(new Insets(10, 10, 10, 10));
        container.setSpacing(20);
        Scene scene = new Scene(container, 800, 600);
        
        primaryStage.setTitle("SP500 Daily Data");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static ObservableList<SP500Record> readSP500Records(File file) throws IOException {
        ArrayList<SP500Record> arr = new ArrayList<SP500Record>();
        BufferedReader in = new BufferedReader(new FileReader(file));
    
        String line = in.readLine();  // consume file header row.
        while ((line = in.readLine()) != null) {
            String[] record = line.split(",");
            arr.add(new SP500Record(
                        record[0],
                        Double.parseDouble(record[1]),
                        Double.parseDouble(record[2]),
                        Double.parseDouble(record[3]),
                        Double.parseDouble(record[4]),
                        Double.parseDouble(record[5]),
                        Long.parseLong(record[6])));
        }    
        in.close();
        ObservableList<SP500Record> data = FXCollections.observableList(arr);
        return data;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}