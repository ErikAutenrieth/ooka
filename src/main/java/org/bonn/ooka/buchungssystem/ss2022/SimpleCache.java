package org.bonn.ooka.buchungssystem.ss2022;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleCache implements Caching {
    private Map<String, List<Object>> cache;

    public SimpleCache() {
        cache = new HashMap<>();
    }

    @Override
    public void cacheResult(String key, List<Object> value) {
        cache.put(key, value);
    }

    public List<Object> getCachedResult(String key) {
        return cache.get(key);
    }

    public void clearCache() {
        cache.clear();
    }

}