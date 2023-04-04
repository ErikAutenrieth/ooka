package org.bonn.ooka.buchungssystem.ss2022;

import java.util.ArrayList;
import java.util.List;

public class ExternalClient {
    public static void main(String[] args){
        HotelPort hotelPort = new HotelPortImpl();

        String keyword = "*";
        List<Hotel> hotels = hotelPort.searchHotels(keyword);

        for(Hotel hotel: hotels){
            System.out.println(hotel.toString());
        }


    }
}
