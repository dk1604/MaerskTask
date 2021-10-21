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

}
