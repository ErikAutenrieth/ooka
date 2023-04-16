package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProxyClientTest {

    @org.junit.jupiter.api.Test
    void hotelsToString() {
        
        String type = "einfach";
        Proxy hotelsuche = new Proxy(type);

        String alleHotels = "*";

        List<Hotel> h1 = hotelsuche.getHotelByName(alleHotels);

        List<Hotel> h2 = hotelsuche.getHotelByName("Maritim");


        // assert does throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            List<Hotel> h3 = hotelsuche.getHotelByName("Falscher Name");
        });


    }
}