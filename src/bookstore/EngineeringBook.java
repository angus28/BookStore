package bookstore;

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
     public EngineeringBook( String author, String title, String publisher, double sellingPriceOfBook, int quantity, String bookID){
        this.bookCategory = "Engineering";
        this.bookID =  bookID;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.sellingPriceOfBook = sellingPriceOfBook;
        this.quantity = quantity;
    }
     
     
     //public processigning methods
   
     
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
        EngineeringBook engineer = (EngineeringBook) b;
        
        String details = "Author: " + engineer.getAuthor() + "\n" +
                                   "Title: " + engineer.getTitle() + "\n" +
                                   "Publisher: " + engineer.getPublisher() + "\n" +
                                   "Selling Price of the Book: $ " + engineer.getSellingPriceOfBook() + " AUD \n" +
                                   "BookID: " + engineer.bookID() + "\n" +
                                   "Book Stock: " + engineer.getQuantity() + "\n" +
                                   "Book Category: " + engineer.getCategory() + "\n \n";
        System.out.println(details);
    }
}
