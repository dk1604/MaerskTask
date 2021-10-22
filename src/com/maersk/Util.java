package com.maersk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Util {
    public Map<String, Integer> reaaConsole() throws IOException {
        Map<String, Integer> skuIds = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine().toUpperCase();
        String[] temp = name.split(" ");
        for (String token : temp) {
            int itemCount = (token.length() == 1) ? 1 : Integer.parseInt(String.valueOf(token.charAt(0)));
            System.out.println("itemcount " + itemCount + " token " + token);
            String skuId = (token.length() == 1) ? String.valueOf(token.charAt(0)) :
                    !token.isEmpty() ? String.valueOf(token.charAt(1)) : "default";

            switch (skuId.toUpperCase()) {
                case SKUIDS.A:
                    skuIds.put(skuId, itemCount);
                    break;
                case SKUIDS.B:
                    skuIds.put(skuId, itemCount);
                    break;
                case SKUIDS.C:
                    skuIds.put(skuId, itemCount);
                    break;
                case SKUIDS.D:
                    if (!skuIds.containsKey(SKUIDS.C)) {
                        skuIds.put(skuId, itemCount);
                    } else {
                        idCombinator(itemCount, skuIds, skuId, SKUIDS.C, "CD");
                    }
                    break;
                default:
                    System.out.println("Please enter valid SKU ID!!");
                    break;
            }
        }
        return skuIds;
    }

    private void idCombinator(Integer itemCount, Map<String, Integer> skuIds, String skuId, String key, String combinedString) {
        if (itemCount > skuIds.get(key)) {
            skuIds.put(combinedString, skuIds.get(key));
            itemCount = itemCount - skuIds.get(key);
            skuIds.remove(key);
            skuIds.put(skuId, itemCount);
        } else if (itemCount < skuIds.get(key)) {
            skuIds.put(combinedString, itemCount);
            itemCount = skuIds.get(key) - itemCount;
            skuIds.remove(key);
            skuIds.put(key, itemCount);
        } else {
            skuIds.remove(key);
            skuIds.put(combinedString, skuIds.get(key));
        }
    }
}
