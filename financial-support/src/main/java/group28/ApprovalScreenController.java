package group28;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ApprovalScreenController {
    @FXML
    private TextField APPLICANT_EMAIL;

    public void changeApplicantEmail(String newString) {
        APPLICANT_EMAIL.setText(newString);
    }

    public void test() {
        System.out.println("Helo");
    }
}
