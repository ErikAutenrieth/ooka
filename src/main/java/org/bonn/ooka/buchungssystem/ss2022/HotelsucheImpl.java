package org.bonn.ooka.buchungssystem.ss2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelsucheImpl implements Hotelsuche {

    private static DBAccess access;

    @Override
    public List<Hotel> getHotelByName(String name) {
        openSession();
        List<String> searchResult;
        List<Hotel> hotelResult = new ArrayList<>();
        try  {
            searchResult = access.getObjects(DBAccess.HOTEL, name);
            closeSession();
        } catch (Exception ex) {
            return Collections.emptyList(); // Rückgabe einer leeren Liste bei einem Fehler
        }
        if(name == "*") {
            for (int i = 0; i < searchResult.size(); i += 3) {
                int id = Integer.parseInt(searchResult.get(i));
                String hotelName = searchResult.get(i + 1);
                String ort = searchResult.get(i + 2);
                Hotel hotel = new Hotel(id, hotelName, ort);
                hotelResult.add(hotel);
            }
            return hotelResult;

        }else if (searchResult.size() == 3) {
            Hotel hotel = new Hotel(Integer.parseInt(searchResult.get(0)), searchResult.get(1), searchResult.get(2));
            hotelResult.add(hotel);
        }else {
            for (String data : searchResult) {
                String[] parts = data.split(", ");
                System.out.println(parts);
                int id = Integer.parseInt(parts[0]);
                String hotelName = parts[1];
                String ort = parts[2];
                Hotel newHotel = new Hotel(id, hotelName, ort);
                hotelResult.add(newHotel);
            }
        }
        return hotelResult;
    }

    @Override
    public void openSession() {
        access = new DBAccess();
        access.openConnection();
    }

    @Override
    public void closeSession() {
        if (access != null ) {
            access.closeConnection();
        }
    }
}
