package org.bonn.ooka.buchungssystem.ss2022;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheImpl implements Caching {

    private Map<String, List<Object>> cache;

    public CacheImpl() {
        cache = new HashMap<>();
    }

    @Override
    public void cacheResult(String key, List<Object> value) {
        cache.put(key, value);
    }

    @Override
    public void clearCache() {
        cache.clear();
    }
}