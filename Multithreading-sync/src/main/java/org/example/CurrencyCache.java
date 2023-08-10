package org.example;

import java.util.concurrent.ConcurrentHashMap;

public class CurrencyCache {
    private volatile ConcurrentHashMap<String, Integer> currencyCache;

    // double-checked locking
    // мы не хотим вызывать initCache больше одного раза
    public int getSomething(String code) {
        if (currencyCache == null) {
            synchronized (this) {
                if (currencyCache == null) {
                    currencyCache = initCache(); // когда мы записали значение, оно перестало быть null
                }
            }
        }
        return currencyCache.get(code);
    }

    private ConcurrentHashMap<String, Integer> initCache() {
        return new ConcurrentHashMap<>(); // получили данные извне и преобразовали
    }
}
