package group28;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        //Button to launch data entry screen
        Button entryButton = new Button();
		entryButton.setText("Data Entry");
        entryButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
                EntryScreen screen = new EntryScreen();
                screen.showScreen();
            }
        });

        //Button to launch review screen
        Button reviewButton = new Button();
		reviewButton.setText("Review");
        reviewButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
                ReviewScreen screen = new ReviewScreen();
                screen.showScreen();
            }
        });

        //Button to launch approval screen
        Button approvalButton = new Button();
		approvalButton.setText("Approval");
        approvalButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
                ApprovalScreen screen = new ApprovalScreen();
                screen.showScreen();
            }
        });


        StackPane root = new StackPane(new HBox(entryButton, reviewButton, approvalButton));
        Scene scene = new Scene(root, 450, 250);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}