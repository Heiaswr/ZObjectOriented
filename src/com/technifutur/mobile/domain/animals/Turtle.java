package com.technifutur.mobile.domain.animals;

import com.technifutur.mobile.domain.other.Animal;
import com.technifutur.mobile.domain.other.Dirt;

import java.time.LocalDate;

public class Turtle extends Animal {


    private int shellSize;
    public static final int MAX_HP =12;
    public static final Dirt dirt=Dirt.SALE;
    public static final int hunger = 12;

    public Turtle(String name, LocalDate dateOfBirth, int hp, char gender, String color, int shellSize, int MAX_HP) {
        super(name, hunger, dateOfBirth, hp, gender, color, dirt);
        this.shellSize=shellSize;

    }

    public int getShellSize() {
        return shellSize;
    }

    public int getMaxHp() {
        return MAX_HP;
    }

    public void hide() {

    }
}
