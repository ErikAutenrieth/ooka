package org.bonn.ooka.buchungssystem.ss2022.test;

import org.bonn.ooka.buchungssystem.ss2022.DBAccess;
import org.bonn.ooka.buchungssystem.ss2022.Hotel;

import java.util.ArrayList;
import java.util.List;



public class HotelPortImpl implements HotelPort {
    // Hier wird das Adapter Pattern angewendet, um die Funktionalität des DBAccess-Objekts
    // in der HotelPortImpl-Klasse zu integrieren und eine einheitliche Schnittstelle für die Suche
    // nach Hotels bereitzustellen.
    private DBAccess dbAccess;

    public HotelPortImpl(){
        this.dbAccess = new DBAccess();
    }


    // Implementierung der searchHotels-Methode der HotelPort-Schnittstelle
    @Override
    public List<Hotel> searchHotels(String keyword) {
        dbAccess.openConnection();
        List<String> hotelData = dbAccess.getObjects(DBAccess.HOTEL, keyword);
        dbAccess.closeConnection();


        List<Hotel> hotels = new ArrayList<Hotel>();
        for(int i=0; i<hotelData.size();i+=3){
            int id = Integer.parseInt(hotelData.get(i));
            String name =  hotelData.get(i+1);
            String ort = hotelData.get(i+2);
            Hotel hotel = new Hotel(id, name, ort);
            hotels.add(hotel);
        }
        return hotels;
    }
}
