package shop;

import java.util.List;
import java.util.Map;

public class DiscountCalculator {
    public static final int COVERT_INT = 100;

    public static int get(Basket basket, int netPrice) {
        List<Book> books = basket.getBooks();
        Map<String, Integer> booksQty = basket.getBooksQty();

        int price = 0;
        for (int i = 0; i < books.size(); i++) {
            price += books.get(i).getPrice() * COVERT_INT;
        }

        int percentDiscount = Promotion.getDiscount(booksQty.size());

        return netPrice - (price * percentDiscount / COVERT_INT);
    }
}
