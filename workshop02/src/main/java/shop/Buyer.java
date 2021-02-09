package shop;

public class Buyer {
    private String firstName;
    private String lastName;
    
    public void requestToBuy() {
        Basket basket = new Basket();
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        Book book3 = new Book("Potter 1", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        
        
        Checkout checkout = new Checkout();
        checkout.process(basket);
    }
}
