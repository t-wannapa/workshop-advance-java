package shop;

import java.util.HashMap;
import java.util.Map;

public class Promotion {

    private static Map<Integer, Integer> promotionDiscount;
    static {
        promotionDiscount = new HashMap<>();
        promotionDiscount.put(1, 0);
        promotionDiscount.put(2, 5);
        promotionDiscount.put(3, 10);
        promotionDiscount.put(4, 20);
        promotionDiscount.put(5, 25);
    }

    
    public static int getDiscount(int seriesBook) {

        return promotionDiscount.get(seriesBook);
    }
}
