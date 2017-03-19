package bookstore;


/**
 *
 *
 * @author angusmiller
 * @version 1.0 March 11, 2017
 */
public class BookStoreTest {
    public static void main(String[] args){
        BookStore bookStore1 = new BookStore("Wonder Books");
        bookStore1.addKidsBook("Angus Miller","Programming in JAVA","Press",20.00, 2, "k12");
        bookStore1.addEngineeringBook("Bill Miller","Civil Engineering Basics","Press",10.00, 5, "e13");
        bookStore1.addStoryBook("Gary Miller","The fairy","Press",5.00, 2, "s01");

        bookStore1.sell("k11"); // not a valid bookID therefore INPUT ERROR
        bookStore1.sell("k12");
        bookStore1.sell("s01");
        bookStore1.sell("k12");// sell two book of the same book that has quantity 2, therefore remove from Inventory
        bookStore1.sell("e13"); // book is in inventory and more than one of this book, therefore take one from Inventory

        bookStore1.allBooksAvailable();
        bookStore1.trackSalesStatus(); // therefore total books sold is 3

    }
}
