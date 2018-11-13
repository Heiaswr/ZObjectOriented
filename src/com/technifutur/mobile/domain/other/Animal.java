package com.technifutur.mobile.domain.other;


import java.time.LocalDate;

/**
 * La classe Animal va gérer tout ce qui a trait à un animal en général
 * Son nom, sa jauge de faim, sa date de naissance, son niveau de fatigue, son genre (mâle ou femelle. Nique sa mère
 * les non-binaires et autres), sa couleur.
 * <p>
 * L'animal en général aura plusieurs méthodes: crier, manger, dormir, boire et se reposer.
 */
public abstract class Animal {

    private final Dirt dirt;
    private final int maxHp;
    private String name;
    private int hunger;
    private LocalDate dateOfBirth;
    private int fatigue;
    private int hp;
    private char gender;
    private String color;

    public Animal(String name, int hunger, LocalDate dateOfBirth, int hp, char gender, String color, Dirt dirt) {
        this.name = name;
        this.hunger = hunger;
        this.dirt = dirt;
        this.dateOfBirth = dateOfBirth;
        this.fatigue = 0;
        this.hp = hp;
        this.gender = gender;
        this.color = color;
        this.maxHp = hp;
    }

    public Dirt getDirt() {
        return dirt;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getFatigue() {
        return fatigue;
    }

    public int getHp() {
        return hp;
    }

    public char getGender() {
        return gender;
    }

    public String getColor() {
        return color;
    }

    public String getSpecies() {
        return getClass().getSimpleName();
    }

    public void loseHp(int hp) {
        if (this.hp - hp < 0)
        {
            this.hp = 0;
        }

        else
        {
            this.hp -= hp;
        }
    }

    public int getMaxHp() {
        return maxHp;
    }
}
