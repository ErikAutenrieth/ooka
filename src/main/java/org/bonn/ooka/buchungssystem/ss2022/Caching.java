package org.bonn.ooka.buchungssystem.ss2022;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface Caching {

    public void cacheResult(String key, List<Object> value);
}
