package bookstore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;


/**
 *
 * @author Angus
 */
public class BookStore {

    // Fields
    private String storeID;
    // Collection stores all books in the bookstore
    private ArrayList<Book> bookInventory = new ArrayList<Book>();
    // Collection stores all customers in the bookstore
    private ArrayList<Customer> customerCollection = new ArrayList<Customer>();
    // Collection stores all sold books
    private ArrayList<Book> booksSoldBookCollection = new ArrayList<Book>();
    // Collection stores all sold books customers
    private ArrayList<Customer> booksSoldCustomerCollection = new ArrayList<Customer>();
    // Collection stores all sold books
    private ArrayList<Customer> booksPurchaseCustomerCollection = new ArrayList<Customer>();
    // Collection stores all reserved books 
    private ArrayList<Book> booksReservedBookCollection = new ArrayList<Book>();
    // Collection stores all reserved customers
    private ArrayList<Customer> booksReservedCustomerCollection = new ArrayList<Customer>();
    private static int totalBooksSold;
    private static int totalBooksPurchased;
    Book book;
    Customer customer; 
    
    // setters and getters
    private void setStoreID(String storeID){
        this.storeID = storeID; 
    }
    private String getStoreID(){
        return storeID;
    }
    private void setTotalBooksSold(int qty){
        this.totalBooksSold += qty;
    }
    private int getTotalBooksSold(){
        return totalBooksSold;
    }
    private void setTotalBooksPurchased(int qty){
        this.totalBooksPurchased += qty;
    }
    private int getTotalBooksPurchased(){
        return totalBooksPurchased;
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
    
   
    
    public void addCustomer(){
       // Generate random string for customer id
        String customerID = UUID.randomUUID().toString();

       System.out.println("To become a member first please enter the following information. ");
       Customer customer = new Customer(customerID);
       System.out.println("We have added you as a member. Your customer ID is " + customerID);
       customerCollection.add(customer);
 
    }
    
    // Get Book 
    // For Customer
    public Book getBook(Customer customer, String customerID, String bookISBN){
        boolean found = false;
        String continueSearch = null;
        Scanner scanner = new Scanner(System.in);
        UserInputValidation validate = new UserInputValidation();
        while (!found){
            // if their is a customer as a member then we can get a book for them
            for (Book book: bookInventory){
              if (bookISBN.equals(book.bookISBN())){
                    System.out.print("We found your book with ISBN " + bookISBN + "!");
                    found = true;
                    return book;
                } 
            }


            //allBooksAvailable();

            System.out.println("We could not find the book you entered! \nDo you want to continue searching? Type y to keep searching or s to stop searching or r to reserve and be notified when the book is available .");
            continueSearch = scanner.next();
            if ("y".equals(continueSearch)){
                // ask user for isbn
                System.out.print("Please select an available book:");
                bookISBN = scanner.next();
                bookISBN = validate.isbn(bookISBN);
            } else if ("s".equals(continueSearch)){
                System.out.println("Ok. We will stop asking you to search");
                found = true;
                return null;
            } else {
                String category = "";
                boolean valid = false;
                // Notify customer when book is available
                System.out.println("Ok. We will notify you when the book becomes available, but first.");

                // Ask User for the books category
                while (!valid){ 
                    System.out.print("Enter the books category valid options are kids, story, or engineering: ");
                    category = scanner.next();
                    if ("kids".equals(category) || "story".equals(category) || "engineering".equals(category)){
                        if(customer == null){
                            System.out.print("We cannot reserve and notify you as you did become a member! Become a member to reserve books.");
                            found = true;
                            return null;
                        } else {
                            
                            try {
                                reserveBook(customer, bookISBN, category);;
                            } catch (NullPointerException ex){
                                ex.printStackTrace();
                            }
                            
                            System.out.print("We have reserved the book you requested! Look out for a notification when the book is available.");
                            found = true;
                            return null;
                            
                        }
                        
                    }
                }    
            } 
        }          
        return null;
    }
    
   
   
    
    // Get Customer
    public Customer getCustomer(String customerID){
        String option = null;
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        while (!found){
            for (Customer customer: customerCollection){
                 System.out.println("You entered" + customerID + "The customerID is" + customer.ID());

                if (customerID.equals(customer.ID())){
                    return customer;
                } 
            }

            System.out.println("We could not find you in the the system! Do you want to become a member?\n");
            
                System.out.print("Type y to become a member and n to not become a member or if you mistyped the customerID then type s  or any character to retype the customerID: ");
                option = scanner.next();
                switch (option) {
                    case "y":
                        addCustomer();
                        return customer;
                    case "n":
                        System.out.println("Ok. We will not add you to the system.");
                        return null;
                    case "s":
                        System.out.print("Enter the customerID:");
                        customerID = scanner.next();
                        break;
                    default:
                        System.out.println("Looks like you have entered an invalid option.");
                        System.out.print("Enter the customerID:");
                        customerID = scanner.next();
                        break;
                    }
        }
        return null;
    }
    
    // Sell a Book from the Store by reducing the book from booksInventory[]. If the book is > 1 reduce quantity variable by 1, 
    // else if 1 remove the object from the array 
    public int sellBook(){
        Book book;
        Customer customer;
        String customerID = ""; 
        String bookID = ""; 
        Scanner scanner = new Scanner(System.in);
        UserInputValidation validate = new UserInputValidation();
        
        System.out.println("To buy a book please enter the following information.");
        
        // Ask User for their customerID
        System.out.print("Enter your customer ID:");
        customerID = scanner.next();
        
        
        // Get the customers id and check he is a member, if not ask to add to system, else exit the selling of the book
        customer = getCustomer(customerID);
        if (customer == null) {
            System.out.print("Looks like you are not member and don't want to be. Therefore you cannot buy a book. If you still want to buy the book then you need to register.");
            return -1;
        }
        
        // Ask User the book they want
        System.out.println("What is the ISBN of the book you want to buy?");
        bookID = validate.isbn(bookID);
        
        
        // Get the customers id and check he is a member, if not ask to add to system, else exit the selling of the book
        try {
            book = getBook(customer, customerID, bookID);
            if (book == null) {
                System.out.print("Looks like you didn't enter a corrent bookID and don't want to be notified! If you still want to buy a book then re-enter the bookID or ask to be notified when its available.");
                return -1;
            }
            book.addSoldBookDetails(customer); // add sold details to book
            int bookQuantity = book.quantity();
            if (bookQuantity >= 1){
                bookInventory.remove(book);
                book.assignQuantity(book.quantity() - 1);
                setTotalBooksSold(1);
            } 
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    // Purchase a book form customer or other source
    public int purchaseBook(){
        Book book;
        Customer customer;
        String customerID = ""; 
        String bookID = ""; 
        Scanner scanner = new Scanner(System.in);
        UserInputValidation validate = new UserInputValidation();
        
        // Ask for customerID
        customerID = scanner.next();
        customerID = validate.id(customerID);
        
        
        // Get the customers id and check he is a member, if not ask to add to system, else exit the selling of the book
        customer = getCustomer(customerID);
        if (customer == null) {
            System.out.print("Looks like their is no customer with that ID. You cannot purchase a book from this ID as it doesn't exist!");
            return -1;
        }
        
        // Ask what book they want from the customer
        bookID = scanner.next();
        bookID = validate.isbn(bookID);
        
     
        // Get the book id and check it is available
        book = customer.getBook(bookID);
        if (book == null) {
            System.out.print("Looks like you didn't enter a corrent bookID.");
            return -1;
        }
       
        book.addPurchaseBookDetails(customer); // add purchased details such as date purchased and customer purchased from to the book
        bookInventory.add(book);
        setTotalBooksPurchased(1);
        book.assignQuantity(book.quantity() + 1);
            
        return 0;
    }
            
       
    
    
    // Book Reserving
    private int reserveBook(Customer customer, String bookID, String category){
        System.out.println("THe customer value is" + customer);
        Book book = null;
        if (category == "kids")
            book = new KidsBook();
        else if (category == "story")
            book = new StoryBook();
        else if (category == "engineering")
            book = new EngineeringBook();
 
 
        
        // Add book details and customer for the book
        try {
            book.addReservedBookDetails(customer);
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
       
        return 0;
    }
    
    
    ////////////////////////////////////////
    ///////         NOTIFY         ///////  
    //////////////////////////////////////
    public void notifyCustomerWhenBookAvailable(Book b, String customerID){
        if(bookInventory.contains(b)){
            System.out.print("The book " + b.title() +" you reserved is available!");
            // check reserved book is with the 2 week period if not remove customer from queue, 
                // then another customer can reserve or buy the book. 
                    //If the book is sold tell the user the reserved period has ended and another customer has brought or reserved the book
            // if book is within the reserved period, add the customer to the queue and tell the user can by the book
            System.out.println("Here is the details:");
            showBookDetails(b);
            
        }
    }
    ////////////////////////////////////////
    ///////         DISPLAY         ///////  
    //////////////////////////////////////
    // Diplays the total number of books sold overall and by book id
    public void trackSalesStatus(){
        System.out.println("There has been " + totalBooksSold + " books sold.");
        
    }
    
    
    // Display all books reserved details
    public int allReservedBooks() {
        System.out.println("Here are all the books reserved:");
        for (Book b:bookInventory){
            if (b.reservedFlag()){
                showBookDetails(b);
                Customer customer = b.customer();
                System.out.println("This book is reserved by " + customer.firstname() + " " + customer.surname() +"\nCustomers details:\n" + customer.ID());
            }
        }       
     return 0;  
    }
    
    // Display all book available in store and there available stock
    public int allBooksAvailable() {
        int bookInventorySize = bookInventory.size();
        if (bookInventorySize == 0){ 
            System.out.println("THERE ARE NO BOOKS IN " + getStoreID() + " INVENTORY!" );
            return -1;
        } else {
            System.out.println("A list of all books at " + getStoreID());
            for(Book b:bookInventory) {
                showBookDetails(b);
            }
        }
        return 0;
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
        if (c == null){
            System.out.print("Looks like you did not give a valid customer. First create a customer and get the customer if you haven't already.");
        } else {
            String details = "Name: " + c.firstname() + " " + c.surname() + "\n \n";
            System.out.println(details);
        }
    }
    
}
