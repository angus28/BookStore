package BookStore;
/**
 * Created by Angus on 11/03/2017.
 */
public class StoryBook extends Book {
    // fields
    private String bookCategory;
    private String author;
    private String title;
    private String publisher;
    private double sellingPriceOfBook;
    private int quantity;
    private String bookID;  
    
    
    // setter and getters
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
    public StoryBook( String author, String title, String publisher, double sellingPriceOfBook, int quantity, String bookID){
        this.bookCategory = "Story";
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
        StoryBook story = (StoryBook) b;
        
        String details = "Author: " + story.getAuthor() + "\n" +
                                   "Title: " + story.getTitle() + "\n" +
                                   "Publisher: " + story.getPublisher() + "\n" +
                                   "Selling Price of the Book: $ " + story.getSellingPriceOfBook() + " AUD \n" +
                                   "BookID: " + story.bookID() + "\n" +
                                   "Book Stock: " + story.getQuantity() + "\n" +
                                   "Book Category: " + story.getCategory() + "\n \n";
        System.out.println(details);
    }
}

