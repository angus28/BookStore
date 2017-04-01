package bookstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author angusmiller
 */
public abstract class Book {
    // fields
    private String bookCategory;
    private String author;
    private String title;
    private String publisher;
    private double sellingPriceOfBook;
    private int quantity;
    private String bookISBN;

    private Date dateSold; 
    private String customerSurname;
    private String customerID;
    private int bookSoldCounter;
    private int bookReservedCounter;
    
  
    // setter and getters
  
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
    
    private void setBookCategory(String category){
        this.bookCategory = category;
    }
    
    private String getBookCategory(){
        return bookCategory;
    }
    
    private void setBookISBN(String bookISBN){
        this.bookISBN = bookISBN;
    }
    private String getBookISBN(){
        return bookISBN;
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
    
  
   // public processing methods
    public String bookCategory(){
        return bookCategory;
    }
    
    public String bookISBN(){
        return bookISBN;
    }

    public int quantity(){
        return quantity;
    }

    public String author(){
        return author;
    }
    
    public String title(){
        return title;
    }
   
    public String publisher(){
        return publisher;
    }
 
    public double sellingPriceOfBook(){
        return sellingPriceOfBook;
    }
    
   

    public ArrayList<Object> addSoldBookDetails(){
        ArrayList<Object> soldBookDetails = new ArrayList <Object>();
        Date date = new Date();
        soldBookDetails.add(date);     
        soldBookDetails.add("123-123"); // dummy text need to implement global random generator
        soldBookDetails.add(getTitle());
        soldBookDetails.add(getSellingPriceOfBook());
       
       return soldBookDetails;
    }
    
    public ArrayList<Object> addReservedBookDetails(){
        ArrayList<Object> reservedBookDetails = new ArrayList <Object>();
        
        // Add start and expiry date for reservation
        int noOfDays = 14; // two weeks
        Calendar startDate = Calendar.getInstance(); // set start date to time at statement exceution
        reservedBookDetails.add(startDate); // add start date to collection details
        
                 
        startDate.add(Calendar.DAY_OF_YEAR, noOfDays); // add two weeks to startDate
        Date expireDate = startDate.getTime(); // store expiry date to Date object
        reservedBookDetails.add(expireDate);     
        
        // Add book id and title
        reservedBookDetails.add("123-123"); // dummy text need to implement global random generator
        reservedBookDetails.add(getTitle());
       
       return reservedBookDetails;
    }
    
    
                
    public void setBookDetails(){
        String input = "";
        double price;
        int quantity;
        String isbn;
        boolean valid;
        
        Scanner scanner = new Scanner(System.in);
        UserInputValidation validate = new UserInputValidation();
        
        // Author
        input = validate.name(input, "author's");
        setAuthor(input);
        
        // Publisher
        input = validate.name(input, "publisher's");
        setPublisher(input);

        // Title
        input = validate.name(input, "tile");
        setTitle(input);
        
        // Price
        valid = false;
        while (!valid){
            try {
                System.out.print("Enter the book's selling price:");
                price = scanner.nextDouble();
                setSellingPriceOfBook(price);
                valid = true;
            } catch (InputMismatchException ex){
                scanner.next();
                System.out.println("Looks like you have enter a invalid input. Make sure it is a numeric value. ");
            }
        }
        
        // Quantity
        valid = false;
        while (!valid){
            try {
                System.out.print("Enter the book's quantity:");
                quantity = scanner.nextInt();
                setQuantity(quantity);
                valid = true;
            } catch (InputMismatchException ex){
                scanner.next();
                System.out.println("Looks like you have enter a invalid input. Make sure it is a numeric value without a decimal value. ");
            }
        }
        //quantity = validate.quantity(quantity);
        
        
        // Book ISBN
        isbn = "";
        isbn = validate.isbn(isbn);
        setBookISBN(isbn);
    }
    
       
    
    public void assignQuantity(int qty){
        setQuantity(qty);
    }
       
        
     
}
