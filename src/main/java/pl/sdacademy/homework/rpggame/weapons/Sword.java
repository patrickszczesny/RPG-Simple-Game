package pl.sdacademy.homework.rpggame.weapons;

import pl.sdacademy.homework.rpggame.monsters.Monster;

public class Sword implements Weapons {

    int attack =20;

    @Override
    public void attack(Monster monster) {
        switch(monster.getMonsterType()){

            case "MAGICAL":
                monster.setCurrentHealth(monster.getCurrentHealth()-(attack/2));
                break;
            case "MELLE":
                monster.setCurrentHealth(monster.getCurrentHealth()-(attack));
                break;
            case "FLYING":
                monster.setCurrentHealth(monster.getCurrentHealth()-(attack/4));
                break;

        }
    }
}
