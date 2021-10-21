package com.maersk;

import java.util.HashMap;

public class SkuIdSPrice {
    public void pricePerUnit() {
        HashMap<String, Integer> ppu = new HashMap<>();
        ppu.put(SKUIDS.A, 50);
        ppu.put(SKUIDS.B, 30);
        ppu.put(SKUIDS.C, 20);
        ppu.put(SKUIDS.D, 15);
    }

    public void promotionalOffers() {
        HashMap<String, Integer> promoOffer = new HashMap<>();
        promoOffer.put("3"+SKUIDS.A, 130);
        promoOffer.put("2"+SKUIDS.B, 45);
        promoOffer.put(SKUIDS.C+SKUIDS.D, 30);
    }

}
