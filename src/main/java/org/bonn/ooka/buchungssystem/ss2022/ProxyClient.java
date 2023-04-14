package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public class ProxyClient {

    public static void main(String[] args) {

        String type = "einfach";
        Proxy hotelsuche = new Proxy(type);
        String alleHotels = "*";
        List<Hotel> h1 = hotelsuche.getHotelByName(alleHotels);
        List<Hotel> h2 = hotelsuche.getHotelByName("Maritim");
        Proxy.hotelsToString(h2);

        List<Hotel> h3 = hotelsuche.getHotelByName("Falscher Name");

    }

    // start the application with start() method
    public static void start() {
        
        main(null);
    }

    // stop the application with stop() method
    public static void stop() {
        System.exit(0);
    }




}



