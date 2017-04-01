package bookstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Angus on 11/03/2017.
 */
public class EngineeringBook extends Book {
    // fields
    private String bookCategory;
    private String author;
    private String title;
    private String publisher;
    private double sellingPriceOfBook;
    private int quantity;
    private String bookID;  

    private Date dateSold; 
    private int bookSoldCounter;
    private int bookReservedCounter;
    
    // setter and getters
    private void setBookCategory(String category){
        this.bookCategory = category;
    }
    
    private String getBookCategory(){
        return bookCategory;
   }
    
    private Date getDateSold(){
        return dateSold;
    }
    private void setDateSold(Date date){
        dateSold = date;
    }
   
    private int getBookSoldCounter(){
        return bookSoldCounter;
    }
    private void setBookSoldCounter(int bookSoldCounter){
        this.bookSoldCounter = bookSoldCounter;
    }
    
    private int getBookReservedCounter(){
        return bookReservedCounter;
    }
    private void setBookReservedCounter(int bookReservedCounter){
        this.bookReservedCounter = bookReservedCounter;
    }
    
    private void setBookID(String bookID){
        this.bookID = bookID;
    }
    private String getBookID(){
        return bookID;
    }

    private int getQuantity(){
        return quantity;
    }
    private void setQuantity(int quantity){
        this.quantity = quantity;
    }

    private void setAuthor(String author){
        this.author = author;
    }
    private String getAuthor(){
        return author;
    }
    
    private void setTitle(String title){
        this.title = title;
    }
    private String getTitle(){
        return title;
    }
    
    private void setPublisher(String publisher){
        this.publisher = publisher;
    }
    private String getPublisher(){
        return publisher;
    }
    
    private void setSellingPriceOfBook(double sellingPriceOfBook){
        this.sellingPriceOfBook = sellingPriceOfBook;
    }
    private double getSellingPriceOfBook(){
        return sellingPriceOfBook;
    }
    private String getCategory(){
        return bookCategory;
    }

    
    // constructors
    public EngineeringBook(){
        Scanner scanner = new Scanner(System.in);
        
        setBookCategory("Engineering");
        setBookDetails();
    }
     
    // public processing methods
   
}

