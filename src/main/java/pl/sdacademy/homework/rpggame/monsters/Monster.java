package pl.sdacademy.homework.rpggame.monsters;

public abstract class Monster {

    private int currentHealth;
    private String monsterType;

    public Monster(){
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getMonsterType() {
        return monsterType;
    }


    public abstract void ContrAttack();
}
