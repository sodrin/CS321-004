/**
* This is the financial support form class which contains form information.
*
*/

import java.util.Date;

public class FinancialSupportForm{
  int ID;
  String FirstName;
  String LastName;
  String SSN;
  String ApplicantEmail;
  String RecipientFirstName;
  String RecipientLastName;
  Date RecipientDateOfBirth;
  String RecipientAlienNumber;
  String RecipientEmail;

  // constructor
  public FinancialSupportForm(){

  }

  public FinancialSupportForm(int ID, String FirstName,  String LastName,  String SSN,  String ApplicantEmail,  String RecipientFirstName,  String RecipientLastName,  Date RecipientDateOfBirth,  String RecipientAlienNumber,  String RecipientEmail){
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
  public boolean validate(){
    //date representing 18 years ago
    Date requirement = new Date(2005, 10, 18);
    Date comparison = this.RecipientDateOfBirth;
    boolean result = comparison.after(requirement);
    return result;
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
