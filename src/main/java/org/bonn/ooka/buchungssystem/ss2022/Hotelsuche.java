package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public interface Hotelsuche {

    public List<Hotel> getHotelByName(String name);
    public void openSession();

}
