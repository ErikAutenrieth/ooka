package org.bonn.ooka.buchungssystem.ss2022;

public class Hotel {
    int id;
    String name;
    String ort;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ort='" + ort + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getOrt() {
        return ort;
    }

    public Hotel(int id, String name, String ort){
        this.id = id;
        this.name=name;
        this.ort=ort;
    }

}
