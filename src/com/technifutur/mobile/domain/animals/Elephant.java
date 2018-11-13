package com.technifutur.mobile.domain.animals;

import com.technifutur.mobile.domain.other.Animal;
import com.technifutur.mobile.domain.other.Dirt;

import java.time.LocalDate;

public class Elephant extends Animal {
    public static final int MAX_HP =15;
    public static final Dirt dirt=Dirt.CRASSEUX;
    public static final int hunger = 25;


    public Elephant(String name, LocalDate dateOfBirth, int hp, char gender, String color, int MAX_HP) {
        super(name, hunger, dateOfBirth, hp, gender, color, dirt);

    }

    public int getMaxHp() {
        return MAX_HP;
    }


    public void trunkStuff(){

    }

    public void charge(){

    }
}
