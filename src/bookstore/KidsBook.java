package BookStore;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.UUID;

/**
 *
 * @author angusmiller
 */
public class KidsBook extends Book {
    // fields
    private String bookCategory;
    private String author;
    private String title;
    private String publisher;
    private double sellingPriceOfBook;
    private int quantity;
    private String bookID;  

    
    
  
    // getters and setters
    private String getBookID(){
        return bookID;
    }
    
    private int getQuantity(){
        return quantity;
   }
    private void setQuantity(int quantity){
        this.quantity = quantity;
   }

    private String getAuthor(){
        return author;
    }
    private String getTitle(){
        return title;
    }
    private String getPublisher(){
        return publisher;
    }
    private double getSellingPriceOfBook(){
        return sellingPriceOfBook;
    }
    private String getCategory(){
        return bookCategory;
    }
    
    
     
    // constructors
   public KidsBook( String author, String title, String publisher, double sellingPriceOfBook, int quantity, String bookID){
        this.bookCategory = "Kids";
        this.bookID =  bookID;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.sellingPriceOfBook = sellingPriceOfBook;
        this.quantity = quantity;
    }
   
   
   // public processing methods

     
    public void assignQuantity(int quantity){
        setQuantity(quantity);
    }
    
    public int quantity(){
        return getQuantity();
    }
    
     
     public String bookID(){
        return getBookID();
    }
     
     public void showBookDetails(Book b){
        
    }
}
