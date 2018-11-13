package com.technifutur.mobile.domain.other;


import com.technifutur.mobile.domain.humans.Healer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Un zoo contient des animaux, des cages, du personnel
 */

public class Zoo {

    Random rdm = new Random();

    private int food;
    private String name;
    private LocalDate localDate;
    private ArrayList<Animal> animals;
    private ArrayList<Cage> cages;
    private ArrayList<Healer> healers;

    public Zoo(String name) {
        this.localDate = LocalDate.of(2000, 01, 01);
        this.name = name;
        this.animals = new ArrayList<>();
        this.cages = new ArrayList<>();
        this.healers = new ArrayList<>();
        this.food = 500;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Healer> getHealers() {
        return healers;
    }

    public ArrayList<Cage> getCages() {
        return cages;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public String getDate() {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public int getFood() {
        return food;
    }

    public void removeFood(int removedFood){
        this.food = food - removedFood;
    }


    public void addAnimal(Animal animal) {
        animals.add(animal);

        cages.get(rdm.nextInt(cages.size())).addAnimal(animal);
    }

    public void addHealer(Healer healer) {
        healers.add(healer);
    }


    public void addCage(Cage cage) {
        removeFood(cage.getFood());
        cages.add(cage);
    }

    public void dayChanger() {

        localDate = localDate.plusDays(1);

    }

    @Override
    public String toString() {
        return "Zoo{" +
                "food=" + food +
                ", name='" + name + '\'' +
                ", localDate=" + localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", animals=" + animals +
                ", cages=" + cages +
                ", healers=" + healers +
                '}';
    }
}
