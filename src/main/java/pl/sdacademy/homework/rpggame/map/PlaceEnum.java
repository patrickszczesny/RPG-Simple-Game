package pl.sdacademy.homework.rpggame.map;

import java.util.Random;

public enum PlaceEnum {
    CASTLE,
    WOODS,
    FIELD,
    GARDEN,
    DUNGEON,
    DESERT,
    ROAD,
    TOWN;

    public static PlaceEnum getRandomPlace() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];

    }
}
