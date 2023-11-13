package group28;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ReviewScreen {
	private FinancialSupportForm currentForm;

    public void showScreen(){
        Label label = new Label("This is the review screen!");

		StackPane layout = new StackPane();
		layout.getChildren().add(label);

		Scene scene = new Scene(layout, 230, 100);


        Stage newWindow = new Stage();
		newWindow.setTitle("Review");
		newWindow.setScene(scene);

		newWindow.show();
    }

	public boolean sendFormToApproval(){
		return true;
	}
	public boolean denyForm(){
		return true;
	}

	public boolean validateForm(){
		return true;
	}

	public boolean getNextForm(){
		return true;
	}
}
