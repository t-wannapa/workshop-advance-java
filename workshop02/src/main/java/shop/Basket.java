package shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Book> books = new ArrayList<Book>();
    private int netPrice;
    private int discountPrice;

    public void addBook(Book book) {
        books.add(book);
    }
    
    public List<Book> getBooks() {
        return books;
    }

    public int getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}
