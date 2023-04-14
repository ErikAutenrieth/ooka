package org.bonn.ooka.buchungssystem.ss2022;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ProxyTest {
    private Proxy hotelsuche;

    @BeforeEach
    public void setUp() {
        String type = "einfach";
        hotelsuche = new Proxy(type);
    }

    @Test
    public void testGetHotelByNameWithWildcard() {
        String alleHotels = "*";
        List<Hotel> hotels = hotelsuche.getHotelByName(alleHotels);

        assertNotNull(hotels);
        assertTrue(hotels.size() > 0);
    }

    @Test
    public void testGetHotelByNameWithValidName() {
        String name = "Maritim";
        List<Hotel> hotels = hotelsuche.getHotelByName(name);

        assertNotNull(hotels);
        assertTrue(hotels.size() > 0);
    }

    @Test
    public void testGetHotelByNameWithInvalidName() {
        String name = "Falscher Name";
        List<Hotel> hotels = hotelsuche.getHotelByName(name);

        assertNotNull(hotels);
        assertTrue(hotels.isEmpty());
    }

    @Test
    public void testCacheResult() {
        String key = "testKey";
        List<Object> value = new ArrayList<>();
        value.add("Test Value");

        hotelsuche.cacheResult(key, value);

        List<Object> cachedResult = hotelsuche.getCachedResult(key);

        assertNotNull(cachedResult);
        assertEquals(value, cachedResult);
    }

    @Test
    public void testClearCache() {
        String key = "testKey";
        List<Object> value = new ArrayList<>();
        value.add("Test Value");

        hotelsuche.cacheResult(key, value);
        hotelsuche.clearCache();

        List<Object> cachedResult = hotelsuche.getCachedResult(key);

        assertNull(cachedResult);
    }
}
