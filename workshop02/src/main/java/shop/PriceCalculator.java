package shop;

import java.util.List;

public class PriceCalculator {


    public static final int CONVERT_INT = 100;

    public static int get(Basket basket) {
        List<Book> books = basket.getBooks();
        return books.stream().mapToInt(Book::getPrice).sum() * CONVERT_INT;
    }
}
