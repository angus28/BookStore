package BookStore;


/**
 *
 * @author angusmiller
 */
public abstract class Book {
    private String bookCategory;
    private String author;
    private String title;
    private String publisher;
    private double sellingPriceOfBook;
    private int quantity;
    private String bookID;
    
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
    
  
     
    public abstract void assignQuantity(int quantity);
    
    public abstract int quantity();
   
    public abstract String bookID();
    
    public abstract void showBookDetails(Book b);
    
    



}
