package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public class Proxy implements HotelRetrievalIf{

        private HotelRetrieval retrieval;
        private String searchType;


        public Proxy(String searchType){
                this.searchType = searchType;
                setSearch();
        }

        public void setSearch(){
                if (this.retrieval == null) {
                        this.retrieval = new HotelRetrieval();
                        setHotelSeach(this.searchType);
                }
        }

        @Override
        public List<Hotel> getHotelByName(String name) {
                return this.retrieval.getHotelByName(name);
        }

        @Override
        public List<Object> getCachedResult(String key) {
                return this.retrieval.getCachedResult(key);
        }

        @Override
        public void setHotelSeach(String type) {
                this.retrieval.setHotelSeach(type);
        }

        @Override
        public void cacheResult(String key, List<Object> value) {
                this.retrieval.cacheResult(key, value);
        }

        @Override
        public void clearCache() {
                this.retrieval.clearCache();
        }
}
