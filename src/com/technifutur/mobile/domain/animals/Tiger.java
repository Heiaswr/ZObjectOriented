package com.technifutur.mobile.domain.animals;

import com.technifutur.mobile.domain.other.Animal;
import com.technifutur.mobile.domain.other.Dirt;

import java.time.LocalDate;

public class Tiger extends Animal {

    private int stripes;
    public static final int MAX_HP =10;
    public static final Dirt dirt=Dirt.SALE;
    public static final int hunger = 20;


    public Tiger(String name, LocalDate dateOfBirth, int hp, char gender, String color, int stripes, int MAX_HP) {
        super(name, hunger, dateOfBirth, hp, gender, color, dirt);
        this.stripes=stripes;

    }

    public int getStripes() {
        return stripes;
    }

    public int getMaxHp() {
        return MAX_HP;
    }
}
