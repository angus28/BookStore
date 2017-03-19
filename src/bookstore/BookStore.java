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
        book = new KidsBook( author, title , publisher, sellingPriceOfTheBook, quantity, bookID);
        bookInventory.add(book);
    }

    public void addEngineeringBook(String author, String title, String publisher, double sellingPriceOfTheBook, int quantity, String bookID){
        book = new EngineeringBook( author, title , publisher, sellingPriceOfTheBook, quantity, bookID);
        bookInventory.add(book);
    }

    public void addStoryBook(String author, String title, String publisher, double sellingPriceOfTheBook, int quantity, String bookID){
        book = new StoryBook( author, title , publisher, sellingPriceOfTheBook, quantity, bookID);
        bookInventory.add(book);
    }
    
    // Sell a Book from the Store by reducing the a book from booksInventory[]. If the book is > 1 reduce quantity variable by 1, 
    // else if 1 remove the object from the array 
    public void sell(String bookID){
        int arrayListSize = bookInventory.size();
        int loopCount = 0;
        for (Book b:bookInventory){
            loopCount = loopCount + 1;
            if (bookID == b.bookID()){
                int bookQuantity = b.quantity();
                if (bookQuantity == 1){
                    bookInventory.remove(b);
                    totalBooksSold++;
                    break;
                } else {
                    b.assignQuantity(b.quantity() - 1);
                    totalBooksSold++;
                    break;
                }
            // if there is no bookID match after the last book in the inventory then display a error message
            } else if (loopCount == arrayListSize) {
                System.out.println("INPUT ERROR: We could not find that book with bookID " + bookID + ". Please enter a valid bookID and try again. \n");
                break;
            }
        }

    }
    
    // Diplays the total number of books sold
    public void trackSalesStatus(){
        System.out.println("There has been " + totalBooksSold + " books sold.");
    }
    

    // Display all book available in store and there available stock
    public void allBooksAvailable() {
        for(Book b:bookInventory) {
            b.showBookDetails(b);
        }
    }
    
}
