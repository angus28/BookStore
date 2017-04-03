package bookstore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    private Calendar dateSold; 
    private Customer customer;
    private int bookSoldCounter = 0;
    
    private int bookReservedCounter = 0;
    private boolean reservedFlag = false;
    private Date dateReservedExpiry = null;
    private Calendar dateReserved = null;
    private Calendar datePurchased = null;
  
    // setter and getters
    private void setCustomer(Customer customer){
        this.customer = customer;
    }
    private Customer getCustomer(){
        return customer;
    }
    private void setDatePurchased(Calendar purchaseDate){
        this.datePurchased= purchaseDate;
    }
    private Calendar getDatePurchased(){
        return datePurchased;
    }
    private void setDateReserved(Calendar reserved){
        this.dateReserved = reserved;
    }
    private Calendar getDateReserved(){
        return dateReserved;
    }
    private void setDateReservedExpiry(Date dateReservedExpiry){
        this.dateReservedExpiry = dateReservedExpiry;
    }
    private Date getDateReservedExpiry(){
        return dateReservedExpiry;
    }
    
    private boolean getReservedFlag(){
        return reservedFlag;
    }
    private void setReservedFlag(boolean reservedFlag){
        this.reservedFlag = reservedFlag;
    }
    
    private Calendar getDateSold(){
        return dateSold;
    }
    private void setDateSold(Calendar date){
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
    public Calendar datePurchased(){
        return datePurchased;
    } 
    public Customer customer(){
        return customer;
    }
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
    public boolean reservedFlag(){
        return reservedFlag;
    }
    public void changeReservedFlag(boolean reservedFlag){
        this.reservedFlag = reservedFlag;
    }
    public Calendar dateSold(){
        return dateSold;
    }
    public Calendar dateReserved(){
        return dateReserved;
    }
    public Date dateReservedExpiry(){
        return dateReservedExpiry;
    }
    

    public void addSoldBookDetails(Customer customer){
       Calendar date = Calendar.getInstance();
       setDateSold(date); 
       
       // Add customer how reserved the book
        setCustomer(customer);
    }
    

    public void addPurchaseBookDetails(Customer customer){
        Calendar date = Calendar.getInstance();
        setDatePurchased(date); 
       
        // Add customer how reserved the book
        setCustomer(customer);
    }
    
    public void addReservedBookDetails(Customer customer){
        // flag book as reserved as true 
        setReservedFlag(true);
        
        // Add start and expiry date for reservation
        Calendar cal = Calendar.getInstance(); // set start date to time at statement exceution
        setDateReserved(cal); 
        
        // Add customer how reserved the book
        setCustomer(customer);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        cal.add(Calendar.DAY_OF_YEAR, 14); // add two weeks to startDate
        Date expire = cal.getTime();
        dateFormat.format(expire);
        setDateReservedExpiry(expire);     
       
       
 
    }
    
    
                
    public void setBookDetails(){
        String input = "";
        double price;
        int quantity;
        String isbn;
        boolean valid;
        
        Scanner scanner = new Scanner(System.in);
        UserInputValidation validate = new UserInputValidation();
        System.out.println("To add a book to the store please enter the following information.");
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
