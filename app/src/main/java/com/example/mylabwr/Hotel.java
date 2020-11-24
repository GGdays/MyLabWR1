package com.example.mylabwr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Hotel {
    private String street;
    private String hotelNumber;
    private String hotelCity;

    public Hotel() {
    }

    public Hotel(String street, String hotelNumber, String hotelCity) {
        this.street = street;
        this.hotelNumber = hotelNumber;
        this.hotelCity = hotelCity;
    }

    public String getStreet() {
        return street;
    }

    public String getHotelNumber() {
        return hotelNumber;
    }

    public String getHotelCity() {
        return hotelCity;
    }
    private final static ArrayList<Hotel> hotels = new ArrayList<Hotel>(
            Arrays.asList(
                    new Hotel("Ozerskaya","№1A","Kyiv"),
                    new Hotel("Vodnaya","№5","Kyiv"),
                    new Hotel("Khristo","№11","Kyiv"),
                    new Hotel("Gagina","№20","Kyiv"),
                    new Hotel("Nalova","№10","Kyiv"),
                    new Hotel("Ternivska","№87","Odesa"),
                    new Hotel("Faleevska","№55","Odesa"),
                    new Hotel("Iakova","№29","Odesa"),
                    new Hotel("Lihova","№2","Odesa"),
                    new Hotel("Kacheeva","№5","Odesa"),
                    new Hotel("Ustavshaya","№32","Lviv"),
                    new Hotel("Ninova","№58","Lviv"),
                    new Hotel("Berkova","№56E","Lviv"),
                    new Hotel("Kulishina","№25C","Lviv"),
                    new Hotel("Centralnaya","№22","Lviv"),
                    new Hotel("Senkevicha","№51","Mykolaiv"),
                    new Hotel("Faleevskaya","№6","Mykolaiv"),
                    new Hotel("Shkolnaya","№99","Mykolaiv"),
                    new Hotel("Ternivska","№1","Mykolaiv"),
                    new Hotel("Holodenko","№4","Kherson"),
                    new Hotel("Stepna","№9A","Kherson"),
                    new Hotel("Belgorodskaya","№2B","Kherson"),
                    new Hotel("Vetrichina","№12","Kherson"),
                    new Hotel("Kolotaeva","№8","Kherson")
            )
    );
    public static ArrayList<Hotel> getHotels(String hotelCities){
        ArrayList<Hotel> htList = new ArrayList<>();
                for(Hotel h: hotels) {
                if (h.getHotelCity().equals(hotelCities)){
                    htList.add(h);
                }
        }
                return htList;
    }
}
