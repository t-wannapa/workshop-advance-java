package shop;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiscountCalculator {
    public static int get(Basket basket, int netPrice) {
        List<Book> books = basket.getBooks();

        Map<String, List<Book>> seriesBook = books.stream().collect(Collectors.groupingBy(Book::getName));
        return netPrice - (netPrice*Promotion.getDiscount(seriesBook.size())/100);
    }
}
