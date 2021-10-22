package com.maersk;

import java.util.*;

public class SkuIdSPrice implements PromotionalInterface {
    private Map<String, Integer> pricePerUnit() {
        HashMap<String, Integer> ppu = new HashMap<>();
        ppu.put(SKUIDS.A, 50);
        ppu.put(SKUIDS.B, 30);
        ppu.put(SKUIDS.C, 20);
        ppu.put(SKUIDS.D, 15);

        return ppu;
    }
    @Override
    public Integer getPricePerUnit(String key){
        SkuIdSPrice skuIdSPrice = new SkuIdSPrice();
        return skuIdSPrice.pricePerUnit().get(key);
    }

    public List<Integer> getPromotionalOffer(String key) {
        System.out.println("getPromotional offer key:: "+key);
        List<Integer> value;
        SkuIdSPrice skuIdSPrice = new SkuIdSPrice();
        switch (key){
            case SKUIDS.A:
                value = skuIdSPrice.promotionalOfferA().get(key);
                break;
            case SKUIDS.B:
                value = skuIdSPrice.promotionalOfferB().get(key);
                break;
            case SKUIDS.C:
                value = skuIdSPrice.promotionalOfferC().get(key);
                break;
            case SKUIDS.D:
                value = skuIdSPrice.promotionalOfferD().get(key);
                break;
            case SKUIDS.C+SKUIDS.D:
                value = skuIdSPrice.promotionalOfferCD().get(key);
                break;
            default:
                throw new IllegalStateException("No offer for this key: " + key);
        }
        return value;
    }

    @Override
    public Map<String, List<Integer>> promotionalOfferA() {
        List<Integer> valSetOne = new ArrayList<Integer>();
        //offer 1 for A
        valSetOne.add(1);
        valSetOne.add(50);
        //
        valSetOne.add(3);
        valSetOne.add(130);
        //offer 2 for A
        valSetOne.add(6);
        valSetOne.add(100);

        Map<String, List<Integer>> promoOffer = new HashMap<>();
        promoOffer.put(SKUIDS.A, valSetOne);

        return promoOffer;
    }

    @Override
    public Map<String, List<Integer>> promotionalOfferB() {
        List<Integer> valSetOne = new ArrayList<Integer>();
        valSetOne.add(1);
        valSetOne.add(30);

        valSetOne.add(2);
        valSetOne.add(45);

        Map<String, List<Integer>> promoOffer = new HashMap<>();
        promoOffer.put(SKUIDS.B, valSetOne);

        return promoOffer;
    }

    @Override
    public Map<String, List<Integer>> promotionalOfferC() {

        List<Integer> valSetOne = new ArrayList<Integer>();
        valSetOne.add(1);
        valSetOne.add(20);

        Map<String, List<Integer>> promoOffer = new HashMap<>();
        promoOffer.put(SKUIDS.C, valSetOne);

        return promoOffer;
    }

    @Override
    public Map<String, List<Integer>> promotionalOfferD() {

        List<Integer> valSetOne = new ArrayList<Integer>();
        valSetOne.add(1);
        valSetOne.add(15);

        Map<String, List<Integer>> promoOffer = new HashMap<>();
        promoOffer.put(SKUIDS.D, valSetOne);

        return promoOffer;
    }

    @Override
    public Map<String, List<Integer>> promotionalOfferCD() {

        List<Integer> valSetThree = new ArrayList<Integer>();
        valSetThree.add(1);
        valSetThree.add(30);

        Map<String, List<Integer>> promoOffer = new HashMap<>();
        promoOffer.put(SKUIDS.C + SKUIDS.D, valSetThree);

        return promoOffer;
    }

}
