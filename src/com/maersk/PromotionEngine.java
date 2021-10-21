package com.maersk;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PromotionEngine {
    SkuIdSPrice skuIdSPrice = new SkuIdSPrice();

    private List<Integer> getActivePromotions(String token) {
        Map<String, List<Integer>> offers = skuIdSPrice.promotionalOffers();
        List<Integer> valueList = offers.get(token);
        return valueList;
    }

    public Integer calculateCartValue(Map<String, Integer> mapOfSkuIdItemCount) {
        Integer finalSum = 0;
        List<Integer> listOfValue;
        for (Map.Entry<String, Integer> entry : mapOfSkuIdItemCount.entrySet()) {
            String key = entry.getKey().toUpperCase();
            Integer value = entry.getValue();

            listOfValue = getActivePromotions(key);
            finalSum = finalSum + calculation(value, listOfValue, skuIdSPrice.getPricePerUnit(key));
        }
        return finalSum;
    }

    public Integer calculation(Integer aValue, List<Integer> bValue, Integer ppu) {
        ppu = !(ppu == null) ? ppu : 0;
        Integer bValueQty = !(bValue == null) ? bValue.get(0) : 1;
        Integer bValuePrice = !(bValue == null) ? bValue.get(1) : ppu;
        Integer sum = 0;
        if (aValue == bValueQty) {
            //use new offer price
            sum += bValuePrice;
        } else {
            //use new offer price and ppu price
            Integer modValue = !(aValue == null) ? aValue % bValueQty : 0;
            Integer divValue = !(aValue == null) ? aValue / bValueQty : 1;
            sum += (divValue * bValuePrice) + (modValue * ppu);
        }
        return sum;
    }
}
