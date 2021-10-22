package com.maersk;

import java.io.IOException;
import java.util.Map;

public class PromotionMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Promotion Started!!\nEnter your SKU ID using a single space\ni.e.2a 3b");

        Util util = new Util();
        Map<String, Integer> listOfSkuIds = util.reaaConsole();

        PromotionEngine promotionEngine = new PromotionEngine();
        Integer cartTotal = promotionEngine.calculateCartValue(listOfSkuIds);
        System.out.println("final cart value: " + cartTotal);
    }


}
