/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author angusmiller
 */
public class Customer extends Person {
    // fields
    private String customerTitle;
    private String ID;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String personTitle;
    // Collection stores all books in the bookstore
    private ArrayList<Book> forSaleInventory = new ArrayList<Book>();
    
    // setters and getters
    private void setDateSold(String customerSurname){
        this.lastname = customerSurname;
    }
    
    private String getID(){
        return ID;
    }
    private void setID(String ID){
        this.ID = ID;
    }
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
    
    
    private String getCustomerID(){
        return ID;
    }
    private void setCustomerID(String customerID){
        this.ID = customerID;
    }
    
    // constructors
    public Customer(String customerID){

        setID(customerID);
        //setPersonTitle("Customer");
        setCustomerDetails();
    }
    
    // public processign methods
    public Book createBookForSale(){
        boolean valid = false;
        String category = "";
        Book book = null;
        Scanner scanner = new Scanner(System.in);
        
         // Ask User for the books category
        while (category != "kids" || category != "story" || category != "engineering" && !valid){ 
            System.out.print("Enter the books category valid option are kids, story, or engineering");
            category = scanner.next();
            if (category == "kids" || category == "story" || category == "engineering"){
                valid = true;
            }
        }
        
        // Add the book to an collection of customers books for sale
        if (category == "kids")
            book = new KidsBook();
        else if (category == "story")
            book = new StoryBook();
        else if (category == "engineering")
            book = new EngineeringBook();
        forSaleInventory.add(book);                    
        
        
        return book;
    }
    
    public Book getBook(String bookISBN){
        for (Book b:forSaleInventory){
            if (b.bookISBN() == bookISBN){
                return b;
            } else {
                return null;
            }
        }
        return null;
    }
    
    public String ID(){
        return ID;
    }
}
    
