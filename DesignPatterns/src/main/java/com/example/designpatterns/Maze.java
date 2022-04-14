package com.example.designpatterns;

import java.util.ArrayList;

public class Maze {

    private static int NUMBER_OF_ROWS = 10;
    private static int NUMBER_OF_COLUMNS = 10;

    private ArrayList<ArrayList<Room>> rooms;

    public Maze(RoomFactory roomFactory) {
        rooms = new ArrayList<>();

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            rooms.add(new ArrayList<>());
            for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
                rooms.get(row).add(roomFactory.createRoom());
            }
        }
    }

}
