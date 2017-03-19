package bookstore;

import java.util.ArrayList;

/**
 *
 * @author Angus
 */
public class BookStore {

    // Fields
    private String storeID;
    private ArrayList<Book> bookInventory = new ArrayList<Book>();
    private static int totalBooksSold;
    Book book;
    
    // setters and getters
    private void setStoreID(String storeID){
        this.storeID = storeID; 
    }
    private String getStoreID(){
        return storeID;
    }
    
    // Constructor
    public BookStore(String storeID) {
        
        setStoreID(storeID);
        System.out.println("Welcome to " + getStoreID() + "!\n");
         
        
    }
    
    // public processing methods
    // Add Books to the BookStore's booksInventory[] array
    public void addKidsBook(String author, String title, String publisher, double sellingPriceOfTheBook, int quantity, String bookID){
       
    }

    public void addEngineeringBook(String author, String title, String publisher, double sellingPriceOfTheBook, int quantity, String bookID){
       
    }

    public void addStoryBook(String author, String title, String publisher, double sellingPriceOfTheBook, int quantity, String bookID){
       
    }
    
    // Sell a Book from the Store by reducing the a book from booksInventory[]. If the book is > 1 reduce quantity variable by 1, 
    // else if 1 remove the object from the array 
    public void sell(String bookID){
        

    }
    
    // Diplays the total number of books sold
    public void trackSalesStatus(){
        
    }
    

    // Display all book available in store and there available stock
    public void allBooksAvailable() {
       
    }
    
}
