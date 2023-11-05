package group28;

import java.util.Date;

/**
* This is the financial support form class which contains form information.
*
*/

import java.util.Date;

public class FinancialSupportForm{
  private static int idCounter = 0;

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

  // Empty contructor
  public FinancialSupportForm(){ }

  // Contructor to assign all values.
  // Does not automatically assign an ID, made private because we should assign IDs internally. Use next contructor publically.
  private FinancialSupportForm(int ID, String FirstName, String LastName, String SSN, String ApplicantEmail, String RecipientFirstName, String RecipientLastName, Date RecipientDateOfBirth, String RecipientAlienNumber, String RecipientEmail) {
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

  // This constructor automatically assigns a unique incremental ID
  public FinancialSupportForm(String FirstName, String LastName, String SSN, String ApplicantEmail, String RecipientFirstName, String RecipientLastName, Date RecipientDateOfBirth, String RecipientAlienNumber, String RecipientEmail) {
    this(idCounter, FirstName, LastName, SSN, ApplicantEmail, RecipientFirstName, RecipientLastName, RecipientDateOfBirth, RecipientAlienNumber, RecipientEmail);
    idCounter ++;
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
  public static FinancialSupportForm getForm(int ID){
    return null;
  }

  public int getID() {
    return ID;
  }

  public void setID(int iD) {
    ID = iD;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String firstName) {
    FirstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public String getSSN() {
    return SSN;
  }

  public void setSSN(String sSN) {
    SSN = sSN;
  }

  public String getApplicantEmail() {
    return ApplicantEmail;
  }

  public void setApplicantEmail(String applicantEmail) {
    ApplicantEmail = applicantEmail;
  }

  public String getRecipientFirstName() {
    return RecipientFirstName;
  }

  public void setRecipientFirstName(String recipientFirstName) {
    RecipientFirstName = recipientFirstName;
  }

  public String getRecipientLastName() {
    return RecipientLastName;
  }

  public void setRecipientLastName(String recipientLastName) {
    RecipientLastName = recipientLastName;
  }

  public Date getRecipientDateOfBirth() {
    return RecipientDateOfBirth;
  }

  public void setRecipientDateOfBirth(Date recipientDateOfBirth) {
    RecipientDateOfBirth = recipientDateOfBirth;
  }

  public String getRecipientAlienNumber() {
    return RecipientAlienNumber;
  }

  public void setRecipientAlienNumber(String recipientAlienNumber) {
    RecipientAlienNumber = recipientAlienNumber;
  }

  public String getRecipientEmail() {
    return RecipientEmail;
  }

  public void setRecipientEmail(String recipientEmail) {
    RecipientEmail = recipientEmail;
  }
}
