package bookstore;


/**
 *
 *
 * @author angusmiller
 * @version 1.0 March 11, 2017
 */
public class BookStoreTest {
    public static void main(String[] args){
        KidsBook t;
        BookStore bookStore1 = new BookStore("Planet friendly - Second Hand Books");
        bookStore1.addKidsBook();
        bookStore1.addCustomer();
        try {
            bookStore1.sellBook();
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
    
        bookStore1.allBooksAvailable();
        bookStore1.allReservedBooks();
        bookStore1.trackSalesStatus(); // therefore total books sold is 3

    }
}
