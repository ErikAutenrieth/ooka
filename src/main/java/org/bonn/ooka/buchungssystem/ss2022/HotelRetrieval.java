package org.bonn.ooka.buchungssystem.ss2022;

import java.util.*;

public class HotelRetrieval implements Caching, HotelRetrievalIf{

    private Hotelsuche hotelsuche;
    private Map<String, List<Object>> cache;
    private Logging logging;


    public HotelRetrieval() {
        this.cache = new HashMap<>();
        this.logging = new Logging();
    }


    public List<Hotel> getHotelByName(String name){

        List<Object> cachedResultArray = getCachedResult(name);

        if(!cachedResultArray.isEmpty() && this.cache.containsKey(name) ){
            List<Hotel> hotelResult = new ArrayList<>();
            for(Object obj : cachedResultArray ){
                if (obj instanceof Hotel){
                    hotelResult.add((Hotel) obj);
                }
            }
            System.out.println("Das Hotel %s wird aus dem Cache geladen!".formatted(name));
            logging.logData(name);
            return hotelResult;
        }
        // Falls nicht im cache, stellt HotelsucheImpl die Daten bereit
        List<Hotel> hotelResult = hotelsuche.getHotelByName(name);
        if (hotelResult.size() != 0){
            if (name =="*"){
                for (Hotel h: hotelResult) {
                    List<Object> n = new ArrayList<>();
                    n.add(h);
                    cacheResult(h.getName(), n);
                }
            }

            System.out.println("Das Hotel %s wird über die Hotelsuche geladen".formatted(name));
            // Schreibe die Daten in den cache
            cacheResult(name, new ArrayList<>(hotelResult));
            logging.logData(name);
        }else {
            throw new IllegalArgumentException("Das gesuchte Hotel ist nicht in der Datenbank!");
        }
        return hotelResult;
    }


    public List<Object> getCachedResult(String key) {
        if (this.cache == null) {
            this.cache = new HashMap<>();
        }
        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }
        return Collections.emptyList();
    }

    public void setHotelSeach(String type) {
        if (type.matches("(?i)erweitert")) {
            this.hotelsuche = new HotelsucheErweitert();
        } else if (type.matches("(?i)einfach")) {
            this.hotelsuche = new HotelsucheEinfach();
        } else {
            throw new IllegalArgumentException("Ungültiger Wert für Suche: " + type);
        }
    }

    @Override
    public void cacheResult(String key, List<Object> value) {
        if (this.cache == null) {this.cache = new HashMap<>();}
        this.cache.put(key, value);
    }

    @Override
    public void clearCache() {
        if (cache != null) {
            cache.clear();
        }
    }





}
