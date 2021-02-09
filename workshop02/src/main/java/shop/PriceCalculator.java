package shop;

import java.util.List;

public class PriceCalculator {


    public static final int CONVERT_INT = 100;

    public static int get(Basket basket) {
        int totalPrice = 0;
        List<Book> books = basket.getBooks();
        for (int i = 0; i < books.size(); i++) {
            totalPrice += basket.getBooksQty(i) * books.get(i).getPrice();
        }
        return totalPrice * CONVERT_INT;
    }
}
