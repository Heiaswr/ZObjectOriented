package com.technifutur.mobile.domain.animals;

import com.technifutur.mobile.domain.other.Animal;
import com.technifutur.mobile.domain.other.Dirt;

import java.time.LocalDate;

public class Eagle extends Animal {
    public static final int MAX_HP = 8;
    public static final Dirt dirt=Dirt.PROPRE;
    public static final int hunger = 10;



    public Eagle(String name, LocalDate dateOfBirth, int hp, char gender, String color, int MAX_HP) {
        super(name, hunger, dateOfBirth, hp, gender, color, dirt);

    }

    public int getMaxHp() {
        return MAX_HP;
    }






}
