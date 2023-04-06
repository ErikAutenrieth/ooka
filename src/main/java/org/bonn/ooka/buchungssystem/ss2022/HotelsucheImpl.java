package org.bonn.ooka.buchungssystem.ss2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelsucheImpl implements Hotelsuche {

    private static DBAccess access;

    @Override
    public List<Hotel> getHotelByName(String name) {
        openSession();
        List<String> searchResult;
        List<Hotel> hotelResult = new ArrayList<>();
        try  {
            searchResult = access.getObjects(DBAccess.HOTEL, name);
            access.closeConnection();
        } catch (Exception ex) {
            System.out.println(ex);
            return Collections.emptyList(); // Rückgabe einer leeren Liste bei einem Fehler
        }
        if (searchResult.size() == 3) {
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
}
