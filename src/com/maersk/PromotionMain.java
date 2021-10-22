package com.maersk;

import java.io.IOException;
import java.util.Map;

public class PromotionMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Promotion Started!!\nEnter your SKU ID using a single space\ni.e.2a 3b");

        ConsoleReader reader = new ConsoleReader();
        Map<String, Integer> listOfSkuIds = reader.reaaConsole();

        PromotionalOfferCalculator promotionEngine = new PromotionalOfferCalculator();
        Integer cartTotal = promotionEngine.calculateCartValue(listOfSkuIds);
        System.out.println("Final cart value: " + cartTotal);
    }


}
