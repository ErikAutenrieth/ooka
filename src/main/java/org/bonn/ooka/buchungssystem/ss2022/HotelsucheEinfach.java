package org.bonn.ooka.buchungssystem.ss2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HotelsucheEinfach implements Hotelsuche{

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

        try {

            Iterator<String> iterator = searchResult.stream().iterator();

            while (iterator.hasNext()) {
                try {
                    int id = Integer.parseInt(iterator.next());
                    String hotelName = iterator.next();
                    String ort = iterator.next();

                    Hotel hotel = new Hotel(id, hotelName, ort);
                    hotelResult.add(hotel);
                }catch (NumberFormatException ex){
                    System.out.println(ex);
                }
            }
        } finally {
            searchResult.stream().close();
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
