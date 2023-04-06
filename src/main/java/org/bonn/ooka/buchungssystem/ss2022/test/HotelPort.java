package org.bonn.ooka.buchungssystem.ss2022.test;

import org.bonn.ooka.buchungssystem.ss2022.Hotel;

import java.util.List;

public interface HotelPort {
    public List<Hotel> searchHotels(String keyword);
}
