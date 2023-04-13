package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public class ProxyClient {

    public static void hotelsToString(List<Hotel> list){
        for (Hotel hotel: list){
            System.out.println(hotel.toString());
        }
    }



    public static void main(String[] args) {

        String type = "einfach";
        Proxy hotelsuche = new Proxy(type);

        String alleHotels = "*";

        List<Hotel> h1 = hotelsuche.getHotelByName(alleHotels);

        List<Hotel> h2 = hotelsuche.getHotelByName("Maritim");

        hotelsToString(h2);


        List<Hotel> h3 = hotelsuche.getHotelByName("Falscher Name");

    }


}



