package group28;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;

/**
 * This is the class for the data entry screen.
 */
public class EntryScreen {
    
    private FinancialSupportForm currentForm;

    public void showScreen(){

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);


        final TextField firstName = new TextField();
        firstName.setPromptText("First name");
        GridPane.setConstraints(firstName, 0, 0);
        grid.getChildren().add(firstName);

        final TextField lastName = new TextField();
        lastName.setPromptText("Last name");
        GridPane.setConstraints(lastName, 0, 1);
        grid.getChildren().add(lastName);

        final TextField ssn = new TextField();
        ssn.setPromptText("Social Security Number");
        GridPane.setConstraints(ssn, 0, 2);
        grid.getChildren().add(ssn);

        final TextField email = new TextField();
        email.setPromptText("Email");
        GridPane.setConstraints(email, 0, 3);
        grid.getChildren().add(email);

        final TextField recipientFirstName = new TextField();
        recipientFirstName.setPromptText("Recipient first name");
        GridPane.setConstraints(recipientFirstName, 1, 0);
        grid.getChildren().add(recipientFirstName);

        final TextField recipientLastName = new TextField();
        recipientLastName.setPromptText("Recipient last name");
        GridPane.setConstraints(recipientLastName, 1, 1);
        grid.getChildren().add(recipientLastName);

        final TextField recipientDOB = new TextField();
        recipientDOB.setPromptText("Date of birth dd/MM/yyyy");
        GridPane.setConstraints(recipientDOB, 1, 2);
        grid.getChildren().add(recipientDOB);

        final TextField recipientANum = new TextField();
        recipientANum.setPromptText("Recipient alien number");
        GridPane.setConstraints(recipientANum, 1, 3);
        grid.getChildren().add(recipientANum);

        final TextField recipientEmail = new TextField();
        recipientEmail.setPromptText("Recipient email");
        GridPane.setConstraints(recipientEmail, 1, 4);
        grid.getChildren().add(recipientEmail);


        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 2, 0);
        grid.getChildren().add(submit);

        final Label label = new Label();
        GridPane.setConstraints(label, 0, 5);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        //Setting an action for the Submit button
        submit.setOnAction(new EventHandler<ActionEvent>() {

        @Override
            public void handle(ActionEvent e) {
                if(submitForm(firstName.getText(), lastName.getText(), ssn.getText(), email.getText(), recipientFirstName.getText(), recipientLastName.getText(), recipientDOB.getText(), recipientANum.getText(), recipientEmail.getText())){
                    label.setText("Successfully Submitted");
                }
                else{
                    label.setText("Submission Failed");
                }
            }
        });

		Scene scene = new Scene(grid, 500, 250);

        
        Stage newWindow = new Stage();
		newWindow.setTitle("Data Entry");
		newWindow.setScene(scene);

		newWindow.show();
    }

    public boolean submitForm(String FirstName,  String LastName,  String SSN,  String ApplicantEmail,  String RecipientFirstName,  String RecipientLastName,  String RecipientDateOfBirth,  String RecipientAlienNumber,  String RecipientEmail){

        Date date = new Date();
        try{
            date = new SimpleDateFormat("dd/MM/yyyy").parse(RecipientDateOfBirth);
        }
        catch(Exception e){
            return false;
        }

        Random rand = new Random();
        
        currentForm = new FinancialSupportForm(rand.nextInt(999999), FirstName, LastName, SSN, ApplicantEmail, RecipientFirstName, RecipientLastName, date, RecipientAlienNumber, RecipientEmail);

        currentForm.validate();
        currentForm.saveForm();
        return true;
    }
}
