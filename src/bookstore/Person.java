package bookstore;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author angusmiller
 */
public abstract class Person {
    // fields
    private String firstname;
    private String ID;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String personTitle;
    
    // setters and getters
    private void setFirstname(String firstname){
        this.firstname = firstname;
    }
    private String getFirstname(){
        return firstname;
    }
    private void setSurname(String surname){
        lastname = surname;
    }
    private String getSurname(){
        return lastname;
    }
    private String getID(){
        return ID;
    }
    private void setID(String ID){
        this.ID = ID;
    }
    
    // public processing methods
    public String surname(){
        return getSurname();
    }
    public String firstname(){
        return getFirstname();
    }
    public String ID(){
        return getID();
    }
    
    // Set Customers details
    public void setCustomerDetails(){
        String firstname = "";
        String lastname = "";
        String phoneNumber = "";
        String email = "";
        
        Scanner scanner = new Scanner(System.in);
        UserInputValidation validate = new UserInputValidation();
        
        // firtname
        firstname = validate.name(firstname, "first");
        setFirstname(firstname);
        
        // lastname
        lastname = validate.name(lastname, "last");
        setSurname(lastname);
        
    }
}

    
    