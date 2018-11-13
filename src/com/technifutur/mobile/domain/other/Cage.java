package com.technifutur.mobile.domain.other;

import java.util.ArrayList;

/**
 * Une cage peut accueillir un ou plusieurs animaux
 */

public class Cage {
    private final int maxFood;
    private int space;
    private int food;
    private int dirt;
    private ArrayList<Animal> animals;
    //TODO gérer l'affectation des animaux à une cage

    public Cage(int space, int food) {
        this.dirt = 0;
        this.space = space;
        this.food = food;
        this.animals = new ArrayList<>();
        this.maxFood = food;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getFood() {
        return food;
    }

    public int getDirt() {

        if (dirt > 100)
        {
            dirt = 100;
        }
        return dirt;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void removeFood(int food) {
        this.food -= food;
    }

    public void removeDirt(int dirt) {
        this.dirt += dirt;
    }

    public void restoreDirt(){
        this.dirt=0;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void restoreFood(int food)
    {
        this.food=food;
    }


    public int getMaxFood() {
        return maxFood;
    }
}
