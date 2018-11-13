package com.technifutur.mobile.domain.other;

import java.time.LocalDate;

public abstract class Oviparous extends Animal {
    public static final Dirt dirt=Dirt.PROPRE;
    public Oviparous(String name, int hunger, LocalDate dateOfBirth, int fatigue, int hp, char gender, String color) {
        super(name, hunger, dateOfBirth, hp, gender, color, dirt);
    }
}
