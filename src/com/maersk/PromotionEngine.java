package com.maersk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromotionEngine {
    SkuIdSPrice skuIdSPrice = new SkuIdSPrice();

    public Integer calculateCartValue(Map<String, Integer> mapOfSkuIdItemCount) {
        Integer finalSum = 0;
        for (Map.Entry<String, Integer> entry : mapOfSkuIdItemCount.entrySet()) {
            String key = entry.getKey().toUpperCase();
            Integer value = entry.getValue();
            System.out.println("key:: " + key + "  -- value:: " + value);
            List<Integer> bestOfferValueIndex = getClosestOffer(value, skuIdSPrice.getPromotionalOffer(key));
            System.out.println("bestOfferValue for " + key + ":: " + bestOfferValueIndex);
            finalSum = finalSum + calculation(value, bestOfferValueIndex, skuIdSPrice.getPricePerUnit(key));
        }
        return finalSum;
    }

    private Integer calculation(Integer aValue, List<Integer> bValue, Integer ppu) {
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

    public List<Integer> getClosestOffer(Integer value, List<Integer> promotionalOffer) {
        System.out.println("promotionalOffer: " + promotionalOffer);
        Integer idx = 0;
        for (int c = 0; c < promotionalOffer.size(); c += 2) {
            if (value >= promotionalOffer.get(c)) {
                System.out.println("c 1 is:: " + promotionalOffer.get(c));
                idx = c;
                System.out.println("idx:: " + idx);
            }
        }
        Integer theInedx = idx;
        System.out.println("promotionalOffer.get: " + promotionalOffer.get(theInedx));
        List<Integer> finalList = new ArrayList<>();
        finalList.add(promotionalOffer.get(theInedx));
        finalList.add(promotionalOffer.get(theInedx + 1));
        return finalList;
    }
}
