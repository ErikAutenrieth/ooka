package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.test.HotelPort;
import org.bonn.ooka.buchungssystem.ss2022.test.HotelPortImpl;

import java.util.List;

public class ExternalClient {
    public static void main(String[] args){
        Hotelsuche hotelSearch = new HotelsucheImpl();

        // Call the getHotelByName method with a sample name
        String name = "*";
        List<Hotel> hotels = hotelSearch.getHotelByName(name);

        System.out.println("Hotels found:");
        for (Hotel hotel : hotels) {System.out.println(hotel.toString());}


        HotelRetrieval hotelRetrieval = new HotelRetrieval((HotelsucheImpl) hotelSearch);

        hotelRetrieval.getHotelByName("Hilton");
        hotelRetrieval.getHotelByName("Maritim");
        hotelRetrieval.getHotelByName("Hilton");

        hotelRetrieval.getHotelByName("*");



    }
}
