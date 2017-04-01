/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author angusmiller
 */
public class Customer {
    // fields
    private String customerTitle;
    private String customerID;
    private String lastname;
    
    // setters and getters
    private String getCustomerSurname(){
        return lastname;
    }
    private void setDateSold(String customerSurname){
        this.lastname = customerSurname;
    }
    
    private String getCustomerID(){
        return customerID;
    }
    private void setCustomerID(String customerID){
        this.customerID = customerID;
    }
    
    // public processing methods
    public String customerSurname(){
        return getCustomerSurname();
    }
}
