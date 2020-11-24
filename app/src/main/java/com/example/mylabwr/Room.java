package com.example.mylabwr;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private String type;
    private String kind;
    private String price;

    public Room() {
    }

    public Room(String type, String kind, String price) {
        this.type = type;
        this.kind = kind;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getKind() {
        return kind;
    }

    public String getPrice() {
        return price;
    }
    private final static ArrayList<Room> rooms = new ArrayList<Room>(
            Arrays.asList(
                    new Room("Persons","Single","10"),
                    new Room("Persons","Double","20"),
                    new Room("Persons","Triple","30"),
                    new Room("Persons","Extra Bed","35"),
                    new Room("Persons","Child (Infant)","23"),
                    new Room("Persons","Junior Suite","40"),
                    new Room("Comfort","Suite","50"),
                    new Room("Comfort","De Luxe","60"),
                    new Room("Comfort","Duplex","66"),
                    new Room("Comfort","Family Room","60"),
                    new Room("Comfort","Studio","60"),
                    new Room("Comfort","Standart","29"),
                    new Room("Comfort","Village","1000"),
                    new Room("Comfort","Apartament","1000"),
                    new Room("Comfort","Honeymoon Room","777"),
                    new Room("Comfort","President Villa","4000"),
                    new Room("Comfort","Villa Deluxe","2000"),
                    new Room("View","Pool","100"),
                    new Room("View","Park","30"),
                    new Room("View","Sea","150"),
                    new Room("View","City","50"),
                    new Room("View","Mountain","150"),
                    new Room("View","Ocean","200")
            )
    );
    public static ArrayList<Room> getRooms(String type){
        ArrayList<Room> rmList = new ArrayList<>();
        for(Room r: rooms) {
            if (r.getType().equals(type)){
                rmList.add(r);
            }
        }
        return rmList;
    }
}
