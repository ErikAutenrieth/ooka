package org.bonn.ooka.buchungssystem.ss2022.test;

import org.bonn.ooka.buchungssystem.ss2022.Hotel;
import org.bonn.ooka.buchungssystem.ss2022.HotelRetrieval;
import org.bonn.ooka.buchungssystem.ss2022.Hotelsuche;
import org.bonn.ooka.buchungssystem.ss2022.test.HotelsucheImpl;

import java.util.List;

public class ExternalClient {
    public static void main(String[] args){
        Hotelsuche hotelSearch = new HotelsucheImpl();

        // Call the getHotelByName method with a sample name
        String name = "*";
        List<Hotel> hotels = hotelSearch.getHotelByName(name);

        System.out.println("Hotels found:");
        for (Hotel hotel : hotels) {System.out.println(hotel.toString());}


        HotelRetrieval hotelRetrieval = new HotelRetrieval();

        hotelRetrieval.getHotelByName("Hilton");
        hotelRetrieval.getHotelByName("Maritim");
        hotelRetrieval.getHotelByName("Hilton");

        List<Hotel> hotels2 =  hotelRetrieval.getHotelByName("*");
        for (Hotel hotel : hotels2) {System.out.println(hotel.toString());}


    }
}
