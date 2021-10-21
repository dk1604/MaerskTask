package com.maersk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PromotionMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Promotion Started!!\nEnter your SKU ID using a single space\ni.e.2a 3b");
        PromotionMain promotionMain = new PromotionMain();
        promotionMain.reaaConsole();
    }

    private List<String> reaaConsole() throws IOException {
        List<String> skuIds = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String[] temp = name.split(" ");
        for (String token : temp) {
            String skuId = !token.isEmpty() ? String.valueOf(token.charAt(1)) : "default";
            switch (skuId.toUpperCase()) {
                case SKUIDS.A:
                    skuIds.add(token);
                    break;
                case SKUIDS.B:
                    skuIds.add(token);
                    break;
                case SKUIDS.C:
                    skuIds.add(token);
                    break;
                case SKUIDS.D:
                    skuIds.add(token);
                    break;
                default:
                    System.out.println("Please enter valid SKU ID!!");
                    break;
            }
        }
        System.out.println(skuIds);
        return skuIds;
    }
}
