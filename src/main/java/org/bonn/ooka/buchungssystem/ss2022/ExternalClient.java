package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.test.HotelPort;
import org.bonn.ooka.buchungssystem.ss2022.test.HotelPortImpl;

import java.util.List;

public class ExternalClient {
    public static void main(String[] args){
        HotelPort hotelPort = new HotelPortImpl();
        Hotelsuche namenSuche = new HotelsucheImpl();

        String keyword = "*";
        List<Hotel> hotels = hotelPort.searchHotels(keyword);

        for(Hotel hotel: hotels){
            System.out.println(hotel.toString());
        }

        String name = "Hilton";
        List<Hotel> hotels2 = namenSuche.getHotelByName(name);

        for(Hotel hotel: hotels2){
            System.out.println(hotel.toString());
        }

    }
}
