package com.company;

import  java.util.Random;

public class Main {public static int bossHealth = 700;
    public static int[] heroesHealth = {250,250,250,250};

    public static int bossAttack = 50;
    public static int[] heroesAttack = {20,20,20,10};
    public static String bossDefenceType= "";
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Healer"};
    public static int healingHero = 20;


    public static void main(String[] args) {
        int roundNumber = 1;
        printStatistics(0);
        while (!isFinished()) {
            changeBossDefence();
            round(roundNumber);
            roundNumber++;

        }

    }
    public static void changeBossDefence(){
        Random r = new Random();
        int randomIndex= r.nextInt (3);
        bossDefenceType = heroesAttackType[randomIndex];
        System.out.println("Boss defence:" + bossDefenceType);
    }
    public static  void round (int number){
        heroesHit();
        bossHit();
        healingHero();
        printStatistics(number);
    }
    public static  boolean isFinished(){
        if(bossHealth <= 0 ) {
            System.out.println("Heroes won!!!");
            return true;

        }
        if (heroesHealth[0] <=0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("Boss won!!");
            return true;
        }
        return false;

    }
    public static void bossHit(){
        for (int i = 0; i <heroesHealth.length; i++) {
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                heroesHealth[i] = heroesHealth[i] = bossAttack;


            }
        }
    }
    public static void healingHero () {

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && heroesHealth[3] > 0) {
                heroesHealth[i] = heroesHealth[i] + healingHero;
                System.out.println("Healer healed the players "+" "+healingHero );
            }
        }
    }
    public static void heroesHit() {
        for (int i = 0; i < heroesAttack.length; i++) {
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossDefenceType.equals(heroesAttackType[i])) {
                    Random r = new Random();
                    int randomNumber = r.nextInt(9) + 2;
                    bossHealth = bossHealth - heroesAttack[i] * randomNumber;
                    System.out.println("Critical Damage!" + (heroesAttack[i] * randomNumber));

                } else {
                    bossHealth = bossHealth - heroesAttack[i];
                }
            }
        }
    }


    public static void printStatistics(int round) {
        System.out.println("       " );
        System.out.println("Round" + round);
        System.out.println("boss health"+bossHealth);
        System.out.println("Physical health"+heroesHealth[0]);
        System.out.println("Magical health"+heroesHealth[1]);
        System.out.println("Kinetic health"+ heroesHealth[2]);
        System.out.println("        ");
    }
}




