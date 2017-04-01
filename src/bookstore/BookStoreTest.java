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
        try {
            KidsBook b = (KidsBook) bookStore1.getBook("0-000-00000-0");
            Customer angus = new Customer();
            bookStore1.sellBook("0-000-00000-0");
            bookStore1.reserveBook("0-000-00000-0", angus);
            // bookStore1.showBookDetails(b);
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
        
        //bookStore1.addEngineeringBook();
        //bookStore1.addStoryBook();

//        bookStore1.sell("k11"); // not a valid bookID therefore INPUT ERROR
//        bookStore1.sell("k12");
//        bookStore1.sell("s01");
//        bookStore1.sell("k12");// sell two book of the same book that has quantity 2, therefore remove from Inventory
//        bookStore1.sell("e13"); // book is in inventory and more than one of this book, therefore take one from Inventory

        bookStore1.allBooksAvailable();
        bookStore1.trackSalesStatus(); // therefore total books sold is 3

    }
}
