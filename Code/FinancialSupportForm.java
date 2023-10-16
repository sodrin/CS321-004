/**
* This is the financial support form class which contains form information.
*
*/

public class FinancialSupportForm{
  int ID;
  String FirstName;
  String LastName;
  String SSN;
  String ApplicantEmail;
  String RecipientFirstName;
  String RecipientLastName;
  String RecipientDateOfBirth;
  String RecipientAlienNumber;
  String RecipientEmail;

  // constructor
  public FinancialSupportForm(){

  }

  public FinancialSupportForm(int ID, String FirstName,  String LastName,  String SSN,  String ApplicantEmail,  String RecipientFirstName,  String RecipientLastName,  String RecipientDateOfBirth,  String RecipientAlienNumber,  String RecipientEmail){
    this.ID = ID;
    this.FirstName = FirstName;
    this.LastName = LastName;
    this.SSN = SSN;
    this.ApplicantEmail = ApplicantEmail;
    this.RecipientFirstName = RecipientFirstName;
    this.RecipientLastName = RecipientLastName;
    this.RecipientDateOfBirth = RecipientDateOfBirth;
    this.RecipientAlienNumber = RecipientAlienNumber;
    this.RecipientEmail = RecipientEmail;
  }

  //validation method
  public void validate(){

  }

  //saveform method
  public boolean saveForm(){
    return false;
  }

  //getform method
  public FinancialSupportForm getForm(int ID){
    return null;
  }
}
