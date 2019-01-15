package pl.sdacademy.homework.rpggame.weapons;

import java.util.Random;

public enum WeaponList {
    SWORD,
    MAGICALSTAFF,
    DAGGER,
    BOW,
    AXE;

    public static WeaponList getRandomWeapon() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];

    }
}
