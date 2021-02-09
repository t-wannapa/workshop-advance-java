package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private List<Book> books = new ArrayList<>();
    private Map<String, Integer> bookQty = new HashMap<>();
    private int netPrice;
    private int discountPrice;

    public void addBook(Book book) {
        int qty = 0;
        String name = book.getName();
        if (bookQty.containsKey(name)) 
            qty = bookQty.get(name);
        else 
            books.add(book);
        
        qty++;
        bookQty.put(name, qty);
    }
    
    public List<Book> getBooks() {
        return books;
    }
    
    public int getBooksQty(int index) {
        String name = books.get(index).getName();
        return bookQty.get(name);
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
