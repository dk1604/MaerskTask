package com.maersk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromotionalOfferCalculator {
    PromotionalInterfaceImpl skuIdSPrice = new PromotionalInterfaceImpl();

    public Integer calculateCartValue(Map<String, Integer> mapOfSkuIdItemCount) {
        Integer finalSum = 0;
        for (Map.Entry<String, Integer> entry : mapOfSkuIdItemCount.entrySet()) {
            String key = entry.getKey().toUpperCase();
            Integer value = entry.getValue();
            List<Integer> bestOfferValueIndex = getClosestOffer(value, skuIdSPrice.getPromotionalOffer(key));
            System.out.println("bestOfferValue for " + key + ":: " + bestOfferValueIndex);
            //finalSum = finalSum + calculation(value, bestOfferValueIndex, skuIdSPrice.getPricePerUnit(key));
            finalSum = finalSum + calculation(value, bestOfferValueIndex, key);
        }
        return finalSum;
    }

    private Integer calculation(Integer aValue, List<Integer> bValue, String key) {
        System.out.println("avalue: "+aValue+ " key "+key+ " bvalue "+bValue);
        //ppu = !(ppu == null) ? ppu : 0;
        Integer ppuValue = skuIdSPrice.getPromotionalOffer(key).get(1);
        Integer bValueQty = !(bValue == null) ? bValue.get(0) : 1;
        Integer bValuePrice = !(bValue == null) ? bValue.get(1) : ppuValue;
        Integer sum = 0;

        if (aValue == bValueQty) {
            sum += bValuePrice;
        } else {
            Integer modValue = !(aValue == null) ? aValue % bValueQty : 0;
            Integer divValue = !(aValue == null) ? aValue / bValueQty : 1;
            sum += (divValue * bValuePrice) + (modValue * ppuValue);
        }

        return sum;
    }

    private List<Integer> getClosestOffer(Integer value, List<Integer> promotionalOffer) {

        List<Integer> finalList = new ArrayList<>();
        Integer index = 0;

        for (int c = 0; c < promotionalOffer.size(); c += 2) {
            if (value >= promotionalOffer.get(c)) {
                index = c;
            }
        }

        finalList.add(promotionalOffer.get(index));
        finalList.add(promotionalOffer.get(index + 1));

        return finalList;
    }
}
