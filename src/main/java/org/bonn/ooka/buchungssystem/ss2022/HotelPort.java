package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public interface HotelPort {
    public List<Hotel> searchHotels(String keyword);
}
