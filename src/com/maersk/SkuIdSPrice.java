package com.maersk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkuIdSPrice {
    private Map<String, Integer> pricePerUnit() {
        HashMap<String, Integer> ppu = new HashMap<>();
        ppu.put(SKUIDS.A, 50);
        ppu.put(SKUIDS.B, 30);
        ppu.put(SKUIDS.C, 20);
        ppu.put(SKUIDS.D, 15);

        return ppu;
    }
    public Integer getPricePerUnit(String key){
        SkuIdSPrice skuIdSPrice = new SkuIdSPrice();
        return skuIdSPrice.pricePerUnit().get(key);
    }

    public Map<String, List<Integer>> promotionalOffers() {
        List<Integer> valSetOne = new ArrayList<Integer>();
        valSetOne.add(3);
        valSetOne.add(130);

        List<Integer> valSetTwo = new ArrayList<Integer>();
        valSetTwo.add(2);
        valSetTwo.add(45);

        List<Integer> valSetThree = new ArrayList<Integer>();
        valSetThree.add(1);
        valSetThree.add(30);

        Map<String, List<Integer>> promoOffer = new HashMap<>();
        promoOffer.put(SKUIDS.A, valSetOne);
        promoOffer.put(SKUIDS.B, valSetTwo);
        promoOffer.put(SKUIDS.C + SKUIDS.D, valSetThree);

        return promoOffer;
    }

}
