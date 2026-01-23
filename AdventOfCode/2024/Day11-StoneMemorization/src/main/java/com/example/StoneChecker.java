package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StoneChecker {

    private static final Logger logger = LogManager.getLogger(StoneChecker.class);

    public Map<String,Long> cache;

    public StoneChecker (Map<String,Long> hashMap){
        this.cache = hashMap;
    }

    public static void main(String[] args) {
        StoneChecker stoneChecker = new StoneChecker(new HashMap<>());

        long result = stoneChecker.blinker(List.of(6L, 11L, 33023L, 4134L ,564L, 0L, 8922422L, 688775L), 500L);

        System.out.println(result);
    }

    public long blinker(List<Long> inputList, long blinksLeft){

        long result = 0;

        STONELIST: for (Long stoneNumber : inputList) {
            long stoneResult = 0L;

            for( ; blinksLeft > 0;){

                String key = stoneNumber + "::" + blinksLeft;

                // Cache
                if (cache.containsKey(key)) {
                    result += cache.get(key);
                    continue STONELIST;
                }
                
                // Base case
                if (blinksLeft == 1L){
                    List<Long> blinkResultList = ListChecker.checkList(List.of(stoneNumber));
                    int baseCaseResult = blinkResultList.size();
                    cache.put(key, (long) baseCaseResult);
                    result += baseCaseResult;
                    continue STONELIST;
                }

                // Blink for this stone number
                List<Long> resultListAfterBlink =  ListChecker.checkList(List.of(stoneNumber));
                long blinkResult = blinker(resultListAfterBlink, blinksLeft - 1);
                cache.put(key, blinkResult);
                result += blinkResult;
                continue STONELIST;
            }
            result += stoneResult;
        }

        return result;
    }

    public Map<String,Long> getCache(){
        return cache;
    }
}
