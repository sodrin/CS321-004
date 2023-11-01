package group28;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ApprovalScreen {
    
    public void showScreen(){
        Label label = new Label("I'm a Label the approval screen");

		StackPane layout = new StackPane();
		layout.getChildren().add(label);

		Scene scene = new Scene(layout, 230, 100);

        
        Stage newWindow = new Stage();
		newWindow.setTitle("Approval");
		newWindow.setScene(scene);

		newWindow.show();
    }
}
