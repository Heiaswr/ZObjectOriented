package com.technifutur.mobile.domain.other;

import java.time.LocalDate;

public abstract class Bird extends Animal{


    //Envergure de l'oiseau
    private int span;
    public static final Dirt dirt=Dirt.PROPRE;

    public Bird(String name, int hunger, LocalDate dateOfBirth, int fatigue, int hp, char gender, String color, int span) {
        super(name, hunger, dateOfBirth, hp, gender, color, dirt);
        this.span=span;
    }


    public void fly() {

    }
}
