package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public interface HotelRetrievalIf extends Caching{
    List<Hotel> getHotelByName(String name);

    List<Object> getCachedResult(String key);

    void setHotelSeach(String type);

    @Override
    void cacheResult(String key, List<Object> value);

    @Override
    void clearCache();

}
