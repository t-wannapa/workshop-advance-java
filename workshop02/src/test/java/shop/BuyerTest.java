package shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {
    @Test
    public void buy_1_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        basket.addBook(book1);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 8, discountPrice 0%
        assertEquals(800, basket.getNetPrice()); // 8.00
        assertEquals(800, basket.getDiscountPrice()); // 8.00
    }

    @Test
    public void buy_2_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 16, discountPrice 5%
        assertEquals(1600, basket.getNetPrice()); // 16.00
        assertEquals(1520, basket.getDiscountPrice()); // 15.20
    }

    @Test
    public void buy_3_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        Book book3 = new BookBuilder().chooseBook("Potter 3").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 24, discountPrice 24 - 10%
        assertEquals(2400, basket.getNetPrice()); // 24.00
        assertEquals(2160, basket.getDiscountPrice()); // 21.60
    }

    @Test
    public void buy_2_books_same_book_of_book_is_1() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        assertEquals(1, basket.getBooks().size()); 
        assertEquals(2, basket.getBooksQty(0));
    }

    @Test
    @DisplayName("ซื้อหนังสือ Potter 1 จำนวน 2 เล่ม จะไม่ได้รับส่วนลด")
    public void buy_2_books_same_book() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 16, discountPrice 0%
        assertEquals(1600, basket.getNetPrice()); // 16.00
        assertEquals(1600, basket.getDiscountPrice()); // 0
    }

    @Test
    @DisplayName("ซื้อหนังสือ Potter 1 จำนวน 2 เล่ม และ Potter 2 จำนวน 1 เล่ม จะได้ส่วนลด 5%")
    public void buy_2_books_same_book_and_other_book() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        Book book3 = new Book("Potter 2", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 16, discountPrice 0%
        assertEquals(2400, basket.getNetPrice()); // 16.00
        assertEquals(2320, basket.getDiscountPrice()); // 0
    }
}