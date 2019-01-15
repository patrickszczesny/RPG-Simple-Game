package pl.sdacademy.homework.rpggame.heroes;

public abstract class Hero {

    private int level=1;
    private int health=10;
    private int currentPlace=0;
    private String heroName;


    public Hero(String heroName){
        this.heroName = heroName;
        }

    public String getHeroName() {
        return heroName;
    }
    public int getLevel() {
        return level;
    }
    public int getCurrentPlace() {
        return currentPlace;
    }
    public void setCurrentPlace(int currentPlace) {
        this.currentPlace = currentPlace;
    }
    public int getHealth() {
        return health;
    }

    private void LevelUp (){
       this.level++;
    }

    private void Travel(int destination){
        this.currentPlace=destination;
    }

    public abstract void Special();
}
