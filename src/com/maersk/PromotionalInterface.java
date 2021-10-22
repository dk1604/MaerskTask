package com.maersk;

import java.util.List;
import java.util.Map;

public interface PromotionalInterface {

    Integer getPricePerUnit(String key);

    Map<String, List<Integer>> promotionalOfferA();

    Map<String, List<Integer>> promotionalOfferB();

    Map<String, List<Integer>> promotionalOfferC();

    Map<String, List<Integer>> promotionalOfferD();

    Map<String, List<Integer>> promotionalOfferCD();
}
