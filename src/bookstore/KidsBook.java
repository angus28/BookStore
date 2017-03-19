package bookstore;


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
        KidsBook kids = (KidsBook) b;
        
        String details = "Author: " + kids.getAuthor() + "\n" +
                                   "Title: " + kids.getTitle() + "\n" +
                                   "Publisher: " + kids.getPublisher() + "\n" +
                                   "Selling Price of the Book: $ " + kids.getSellingPriceOfBook() + " AUD \n" +
                                   "BookID: " + kids.bookID() + "\n" +
                                   "Book Stock: " + kids.getQuantity() + "\n" +
                                   "Book Category: " + kids.getCategory() + "\n \n";
        System.out.println(details);
    }
}
