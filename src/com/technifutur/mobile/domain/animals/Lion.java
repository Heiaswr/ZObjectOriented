package com.technifutur.mobile.domain.animals;

import com.technifutur.mobile.domain.other.Animal;
import com.technifutur.mobile.domain.other.Dirt;

import java.time.LocalDate;

public class Lion extends Animal {
    public static final int MAX_HP=10;
    public static final Dirt dirt=Dirt.SALE;
    public static final int hunger = 20;

    public Lion(String name, LocalDate dateOfBirth, int hp, char gender, String color, int MAX_HP) {
        super(name, hunger, dateOfBirth, hp, gender, color, dirt);

    }

    public int getMAX_HP() {
        return MAX_HP;
    }
}
