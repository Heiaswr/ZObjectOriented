package com.technifutur.mobile.domain.animals;


import com.technifutur.mobile.domain.other.Animal;
import com.technifutur.mobile.domain.other.Dirt;

import java.time.LocalDate;

/**
 * Qu'est-ce qu'un gorille peut bien avoir de plus par rapport aux autres animaux qui serait utile dans la
 * gestion de notre ZOO?
 */
public class Gorilla extends Animal {
    public static final int MAX_HP =14;
    public static final Dirt dirt=Dirt.CRASSEUX;
    public static final int hunger = 15;


    public Gorilla(String name, LocalDate dateOfBirth, int hp, char gender, String color, int MAX_HP) {
        super(name, hunger, dateOfBirth, hp, gender, color, dirt);

    }

    public int getMaxHp() {
        return MAX_HP;
    }

    public void swagger() {

    }

    public void banging(){

    }

}
