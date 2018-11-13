package com.technifutur.mobile.util;

import com.technifutur.mobile.domain.animals.*;
import com.technifutur.mobile.domain.humans.Healer;
import com.technifutur.mobile.domain.other.Animal;
import com.technifutur.mobile.domain.other.Cage;
import com.technifutur.mobile.domain.other.Zoo;

import java.time.LocalDate;
import java.util.Random;

public class Generator {

    Random rdm = new Random();


    public Animal animalGenerator() {

        int type = rdm.nextInt(6);

        switch (type)
        {
            case 0:
                return new Eagle(nameGenerator(), LocalDate.now(), Eagle.MAX_HP, genderGenerator(), colorGenerator(), Eagle.MAX_HP);
            case 1:
                return new Turtle(nameGenerator(), LocalDate.now(), Turtle.MAX_HP, genderGenerator(), colorGenerator(), shellSizeGenerator(), Turtle.MAX_HP);
            case 2:
                return new Elephant(nameGenerator(), LocalDate.now(), Elephant.MAX_HP, genderGenerator(), colorGenerator(), Elephant.MAX_HP);
            case 3:
                return new Gorilla(nameGenerator(), LocalDate.now(), Gorilla.MAX_HP, genderGenerator(), colorGenerator(), Gorilla.MAX_HP);
            case 4:
                return new Lion(nameGenerator(), LocalDate.now(), Lion.MAX_HP, genderGenerator(), colorGenerator(), Lion.MAX_HP);
            case 5:
                return new Tiger(nameGenerator(), LocalDate.now(), Tiger.MAX_HP, genderGenerator(), colorGenerator(), stripesGenerator(), Tiger.MAX_HP);
            default:
                return null;
        }
    }

    public Cage cageGenerator(int maxFood) {
        int food;
        boolean executing=true;
        do
        {
            food = rdm.nextInt(maxFood + 1);

            if(maxFood>=food && food!=0)
            {

                executing=false;
            }
        } while (executing);


        return new Cage(rdm.nextInt(150) + 1, food);
    }

    private int stripesGenerator() {


        return rdm.nextInt(32);

    }

    private int shellSizeGenerator() {

        return rdm.nextInt(31) + 20;
    }

    private String colorGenerator() {
        String[] color = new String[]{"bleu", "blanc", "vert", "rouge", "roux", "brun", "noir", "albinos", "jaune"};

        return color[rdm.nextInt(color.length)];
    }

    private char genderGenerator() {

        char[] gender = new char[]{'M', 'F'};

        return gender[rdm.nextInt(gender.length)];
    }


    public String nameGenerator() {

        String[] cons = new String[]{"z", "r", "t", "p", "q", "s", "d", "f", "g", "h", "j", "k", "l", "m", "w", "x", "c", "v", "b", "n"};
        String[] voy = new String[]{"a", "e", "i", "o", "u", "y"};
        String[] syl = new String[(cons.length) * (voy.length)];
        String name = "";
        int a = 0;

        // Génère des syllabes
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                syl[a] = cons[i] + voy[j];
                a++;
            }
        }
        // Génère un nom de 1 à 12 syllabes
        int nbSyl = rdm.nextInt(11);

        for (int i = 0; i < nbSyl + 1; i++)
        {
            a = rdm.nextInt(120);
            name = name + syl[a];

        }

        return name;


    }

    public Healer healerGenerator() {

        return new Healer(nameGenerator(), 100);


    }
}
