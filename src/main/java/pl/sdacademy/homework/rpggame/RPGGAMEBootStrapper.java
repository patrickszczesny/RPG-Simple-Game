package pl.sdacademy.homework.rpggame;

import pl.sdacademy.homework.rpggame.map.Board;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RPGGAMEBootStrapper {

    public static void start() {
        System.out.println("\nLet the game begin.");
        System.out.println("Magic Warriors\n");

        File Music = new File("Tristram.wav");
        Play(Music);


        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name hero?");
        String heroName = scanner.nextLine();
        System.out.println("Welcome " + heroName + " to 'Magic Warriors' the epic world full of Monsters and Treasures.\n" +
                "A world, where you have to defeat challenging epic adventure!!!\n");

        System.out.println(heroName + " could you choose which class are you? (Choose one number)\n");
        System.out.println("1.Warrior - A powerfull and skilled melee fighter!!!");
        System.out.println("2.Wizard - A master of spells and magic weapons!!!");
        System.out.println("3.Thief - A master of disguise and range weapons!!!\n");
        System.out.println("Choose wisely...\n");
        System.out.print("Class number :");

        int heroClassChoice = scanner.nextInt();
        String heroClass;
        int health;
        int baseHealth;
        List<String> WeaponList = new ArrayList<>();
        List<Integer> WeaponDMGList = new ArrayList<>();
       // Hero PlayerOne = null;

        switch (heroClassChoice) {
            case 1:
               // PlayerOne = new Warrior(heroName);
                heroClass = "Warrior";
                health = 30;
                baseHealth=health;
                WeaponList.add("Sword");
                WeaponDMGList.add(20);
                WeaponList.add("ThrowingAxe");
                WeaponDMGList.add(10);
                break;
            case 2:
                //   PlayerOne = new Wizard(heroName);
                heroClass = "Wizard";
                health = 10;
                baseHealth=health;
                WeaponList.add("MagicalStaff");
                WeaponDMGList.add(30);
                WeaponList.add("MagicalStaff");
                WeaponDMGList.add(30);
                break;
            case 3:
                //    PlayerOne = new Thief(heroName);
                heroClass = "Thief";
                health = 20;
                baseHealth=health;
                WeaponList.add("Dagger");
                WeaponDMGList.add(10);
                WeaponList.add("Bow");
                WeaponDMGList.add(20);
                break;
            default:
                System.out.println("Wrong choice. Your are now a nobody ;(");
                heroClass = "Nobody";
                health = 10;
                baseHealth=health;
                WeaponList.add("Stick");
                WeaponDMGList.add(0);
                WeaponList.add("Stone");
                WeaponDMGList.add(0);
                break;
        }
        System.out.println(heroName + " the " + heroClass + ". Great choice!");
        System.out.println("Enter the 'WORLD' size:");
        System.out.print("Rows:");
        int rows = scanner.nextInt();
        System.out.print("Columns:");
        int columns = scanner.nextInt();
        Board board1 = Board.build(rows, columns);
        System.out.println("\nYour map looks like this:");
        System.out.println(board1);
        System.out.println("Now " + heroName + " the " + heroClass + " enter your new World and fight for victory!!!");
        System.out.println("You will start at Number 0: " + board1.getBoard()[0][0] + " at upper left");
        System.out.println("Let the adventure begin...");
        int currentLocationNumber = 0;
        board1.setTempPlaceName(board1.getBoard()[0][0]);
        board1.travelTo(0, currentLocationNumber);

        int level = 1;
        String monsterName = "";
        String monsterType = "";
        int monsterHealth = 0;
        List<Integer> monsterResistance = new ArrayList<>();
        monsterResistance.add(0,0);
        monsterResistance.add(1,0);
        monsterResistance.add(2,0);
        int monsterCounterDmg =0;

        while (level < 10) {
            if(health>0){
            System.out.println("Where do you like to go ?");
            System.out.println(board1);
            System.out.println("Choose you travel destination: ");
            int destination = scanner.nextInt();
            if (destination >= 0) {
                if (destination < rows * columns) {
                    board1.travelTo(destination, currentLocationNumber);
                    currentLocationNumber = board1.getTempPlaceNumber();
                    System.out.println("You travel safely to " + currentLocationNumber+" "+ board1.getTempPlaceName());
                    System.out.println(board1);

                    switch (board1.getTempPlaceName()) {
                        case "CASTLE":
                            monsterName = "GHOST";
                            monsterType = "MAGIC";
                            monsterHealth = 20;
                            monsterResistance.set(0, 20);
                            monsterResistance.set(1, 5);
                            monsterResistance.set(2, 0);
                            monsterCounterDmg=10;
                            break;
                        case "WOODS":
                            monsterName = "WEREWOLF";
                            monsterType = "MELLE";
                            monsterHealth = 60;
                            monsterResistance.set(0, 10);
                            monsterResistance.set(1, 10);
                            monsterResistance.set(2, 0);
                            monsterCounterDmg=20;
                            break;
                        case "FIELD":
                            monsterName = "GOBLIN";
                            monsterType = "MELLE";
                            monsterHealth = 20;
                            monsterResistance.set(0, 0);
                            monsterResistance.set(1, 0);
                            monsterResistance.set(2, 0);
                            monsterCounterDmg=10;
                            break;
                        case "GARDEN":
                            monsterName = "GARDEN TERROR";
                            monsterType = "MELLE";
                            monsterHealth = 100;
                            monsterResistance.set(0, 0);
                            monsterResistance.set(1, 5);
                            monsterResistance.set(2, 15);
                            monsterCounterDmg=25;
                            break;
                        case "DUNGEON":
                            monsterName = "DRAGON";
                            monsterType = "FLYIENG";
                            monsterHealth = 200;
                            monsterResistance.set(0, 10);
                            monsterResistance.set(1, 0);
                            monsterResistance.set(2, 10);
                            monsterCounterDmg=30;
                            break;
                        case "DESERT":
                            monsterName = "GIN";
                            monsterType = "FLYIENG";
                            monsterHealth = 50;
                            monsterResistance.set(0, 10);
                            monsterResistance.set(1, 5);
                            monsterResistance.set(2, 0);
                            monsterCounterDmg=20;
                            break;
                        case "ROAD":
                            monsterName = "ORCS";
                            monsterType = "MELLE";
                            monsterHealth = 80;
                            monsterResistance.set(0, 0);
                            monsterResistance.set(1, 10);
                            monsterResistance.set(2, 10);
                            monsterCounterDmg=10;
                            break;
                        case "TOWN":
                            monsterName = "VAMPIRE";
                            monsterType = "MAGIC";
                            monsterHealth = 100;
                            monsterResistance.set(0, 10);
                            monsterResistance.set(1, 10);
                            monsterResistance.set(2, 10);
                            monsterCounterDmg=10;
                            break;
                    }
                    System.out.println("You encounter a " + monsterName + "!!!!\nIt's a powerfull " + monsterType + " monster.");
                    System.out.println("You need to fight it");
                    System.out.println("Choose your weapon to attack :");
                    System.out.println("0. "+WeaponList.get(0)+". It's your melee weapon.");
                    System.out.println("1. "+WeaponList.get(1)+". It's your range weapon.");
                    System.out.println("Default you will fight at melee range.");
                    System.out.print("With which weapon you want to battle: ");
                    int weaponOfChoice =scanner.nextInt();
                    switch (weaponOfChoice){
                          case 1:
                            while (monsterHealth>0) {
                                if (health > 0) {
                                    System.out.println("\nYou have "+health+" hp left.");
                                    System.out.println("You attack with " + WeaponList.get(weaponOfChoice));
                                    int currentDMG=WeaponDMGList.get(weaponOfChoice) -monsterResistance.get(weaponOfChoice);
                                    monsterHealth -=currentDMG;
                                    System.out.println("\nYou have done to"+ monsterName +" a "+ currentDMG+" dmg.");
                                    if (monsterHealth > 0) {
                                        System.out.println("The "+ monsterName +" have only "+ monsterHealth+" hp left.");
                                        System.out.println("\nThe "+monsterName+" counterattack!!!");
                                        health -= monsterCounterDmg;
                                        System.out.println("It's done "+monsterCounterDmg+" dmg.");
                                    }
                                }else{break;}
                            }
                            break;
                            default:
                                while (monsterHealth>0) {
                                    if (health > 0) {
                                        System.out.println("\nYou have "+health+" hp left.");
                                        System.out.println("You attack with " + WeaponList.get(0));
                                        int currentDMG=WeaponDMGList.get(0) - monsterResistance.get(0);
                                        monsterHealth -=currentDMG;
                                        System.out.println("\nYou have done to"+ monsterName +" a "+ currentDMG+" dmg.");
                                        if (monsterHealth > 0) {
                                            System.out.println("The "+ monsterName +" have only "+ monsterHealth+" hp left.");
                                            System.out.println("\nThe "+monsterName+" counterattack!!!");
                                            health -= monsterCounterDmg;
                                            System.out.println("It's done "+monsterCounterDmg+" dmg.");
                                        }
                                    }else{break;}
                                }
                                break;
                    }
                    if (monsterHealth<=0) {
                        System.out.println("Congratulation - you defeat " +monsterName);
                        System.out.println("You gain a level !!!!");
                        level++;
                        health= baseHealth+level*10;
                        System.out.println("You are at "+ level +" level");
                        System.out.println("You restore your health.");
                        System.out.println("You have " + health+ " hp.");
                        if (level<10) {
                            int neededlevel = 10 - level;
                            System.out.println("Only " + neededlevel + " levels to win.");
                        }
                    }
                } else {
                    System.out.println("You flee from the map...\n");
                    if (level >= 1) {
                        System.out.println("You loose one level...");
                        level--;
                    } else {
                        System.out.println("You drop to your starting level... shame...");
                    }
                }
            } else {
                System.out.println("You flee from the map...\n");
                if (level >= 1) {
                    System.out.println("You loose one level...");
                    level--;
                } else {
                    System.out.println("You drop to your starting level... shame...");
                }


                board1.travelTo(destination, currentLocationNumber);
                currentLocationNumber = board1.getTempPlaceNumber();
                System.out.println("You travel safely to void");
                System.out.println(board1);
            }
        }else {level=10;}
        }
        if (health>0) {
            System.out.println("Congatulation your WON - WOW !!!!!!\n");
            System.out.println("Nice!\n");
            System.out.println("Good Job!\n");
            System.out.println("Write anything to end the game:");
        } else {
            System.out.println("You died.\n");
            System.out.println("Try again.\n");
            System.out.println("Write anything to end the game:");
        }
        String end1 = scanner.next();

    }

    static void Play(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
        } catch (Exception e) {
        }
    }
}
