package bookstore;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Angus
 */
public class BookStore {

    // Fields
    private String storeID;
    // Collection stores all books in the bookstore
    private ArrayList<Book> bookInventory = new ArrayList<Book>();
    // Collection stores all sold books with customer details
    private ArrayList<Object> booksSoldCollection = new ArrayList<Object>();
    // Collection stores all sold books with customer details
    private ArrayList<Object> booksReservedCollection = new ArrayList<Object>();
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
    public void addKidsBook(){
        book = new KidsBook();
        bookInventory.add(book);
    }

    public void addEngineeringBook(){
        book = new EngineeringBook();
        bookInventory.add(book);
    }

    public void addStoryBook(){
        book = new StoryBook();
        bookInventory.add(book);
    }
    
    // Get Book
    public Book getBook(String bookISBN){
        ///String option = "y";
        
        int arrayListSize = bookInventory.size();
        //while (option == "y"){
            //Scanner scanner = new Scanner(System.in);
            int loopCount = 0;
            for (Book b:bookInventory){
                loopCount = loopCount + 1;
                String ISBN = "0-000-00000-0";
                if (bookISBN == ISBN){
                    return b;
                } else if (loopCount == arrayListSize) {
                    System.out.println(" We could not find that book with book ISBN " + bookISBN + ". Please try again and enter a valid book ISBN . \n");
                    //System.out.println("Do you want to search again? Type y to search again and n to not search again");
                    //option = scanner.next();
                }
            //}
        }
        return null;
    }
    
    // Sell a Book from the Store by reducing the book from booksInventory[]. If the book is > 1 reduce quantity variable by 1, 
    // else if 1 remove the object from the array 
    public void sellBook(String bookISBN){
        Book book;
        
        book = getBook(bookISBN);
        
        if (book != null){
            book.addSoldBookDetails(); // add sold details to book
            booksSoldCollection.add(book); // add sold book object to collection
            //bookSoldDetailsCollection.add(c.customerSurname()); // add customer details
            int bookQuantity = book.quantity();
            if (bookQuantity == 1){
                bookInventory.remove(book);
                totalBooksSold++;
            } else {
                book.assignQuantity(book.quantity() - 1);
                totalBooksSold++;
            }
        }
    }
       
    
    
    // Book Reserving
    public void reserveBook(String bookISBN, Customer c){
        Book book;
        book = getBook(bookISBN);
        if (book != null){
            book.addReservedBookDetails();
            booksReservedCollection.add(book);
            
        }   
    }
    
    // Diplays the total number of books sold overall and by book id
    public void trackSalesStatus(){
        System.out.println("There has been " + totalBooksSold + " books sold.");
        
    }
    
    // Display all books reserved details
    public void allBooksReserved() {
        int bookInventorySize = booksReservedCollection.size();
        if (bookInventorySize == 0) 
            System.out.println("THERE ARE NO BOOKS RESERVED!" );
        else
            System.out.println("A list of all books reserved");
        
        for(Object o: booksReservedCollection) {
            Book b = (Book) o;
            Customer c = (Customer) o;
            
            showBookDetails(b);
            showCustomerDetails(c);
        }
    }
    
    // Display all book available in store and there available stock
    public void allBooksAvailable() {
        int bookInventorySize = bookInventory.size();
        if (bookInventorySize == 0) 
            System.out.println("THERE ARE NO BOOKS IN " + getStoreID() + " INVENTORY!" );
        else
            System.out.println("A list of all books at " + getStoreID());
        
        for(Book b:bookInventory) {
            showBookDetails(b);
        }
    }
    
    public void showBookDetails(Book b){
        String details = "Author: " + b.author() + "\n" +
                                   "Title: " + b.title() + "\n" +
                                   "Publisher: " + b.publisher() + "\n" +
                                   "Selling Price of the Book: $ " + b.sellingPriceOfBook() + " AUD \n" +
                                   "BookID: " + b.bookISBN() + "\n" +
                                   "Book Stock: " + b.quantity() + "\n" +
                                   "Book Category: " + b.bookCategory() + "\n \n";
        System.out.println(details);
    }
    
    public void showCustomerDetails(Customer c){
        String details = "Name: " + c.customerSurname() + "\n \n";
        System.out.println(details);
    }
    
}
