package org.bonn.ooka.buchungssystem.ss2022;

import java.util.*;

public class HotelRetrieval implements Caching{

    private HotelsucheImpl hotelsuche;
    private Map<String, List<Object>> cache;
    private Logging logging;


    public HotelRetrieval(HotelsucheImpl hotelsuche) {
        this.hotelsuche = hotelsuche;
        this.cache = new HashMap<>();
        this.logging = new Logging();
    }


    public List<Hotel> getHotelByName(String name){

        List<Object> cachedResult = getCachedResult(name);

        if(!cachedResult.isEmpty()){
            List<Hotel> hotelResult = new ArrayList<>();
            for(Object obj : cachedResult ){
                if (obj instanceof Hotel){
                    hotelResult.add((Hotel) obj);
                }
            }
            //System.out.println("Hoteldaten aus dem Cache: " + hotelResult.toString());
            logging.logData(name);
            return hotelResult;
        }

        // Falls nicht im cache, stellt HotelsucheImpl die daten bereit
        List<Hotel> hotelResult = hotelsuche.getHotelByName(name);

        // Schreibe die Daten in den cache
        cacheResult(name, new ArrayList<>(hotelResult));
        //System.out.println("Hoteldaten aus der Suche: " + hotelResult.toString());
        logging.logData(name);
        return hotelResult;

    }

    public List<Object> getCachedResult(String key) {
        if (cache == null) {
            cache = new HashMap<>();
        }
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return Collections.emptyList();
    }

    @Override
    public void cacheResult(String key, List<Object> value) {
        if (cache == null) {
            cache = new HashMap<>();
        }
        cache.put(key, value);
    }

    @Override
    public void clearCache() {
        if (cache != null) {
            cache.clear();
        }
    }
}
