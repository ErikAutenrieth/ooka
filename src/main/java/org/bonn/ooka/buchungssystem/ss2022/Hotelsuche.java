package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public interface Hotelsuche {

    public Hotel[] getHotelsByName(String name);
    public void openSession();
    public void closeSession();
    
}
