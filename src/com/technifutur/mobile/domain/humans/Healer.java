package com.technifutur.mobile.domain.humans;

import com.technifutur.mobile.domain.other.Cage;

import java.util.ArrayList;

/**
 * Un soigneur peut nourrir un ou plusieurs animaux, peut nettoyer la cage, peut soigner les animaux, peut retirer
 * les corps des animaux morts (RIP).
 * <p>
 * Il a une barre de points de vie.
 */

public class Healer {

    private String name;
    private int hp;

    public Healer(String name, int hp) {

        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void feed(Cage cage) {
        cage.restoreFood(cage.getMaxFood());

    }

    public void cleanCage(Cage cage) {

        cage.restoreDirt();

    }

    private void cleanDeadAnimals(Cage cage) {
        for (int j = 0; j < cage.getAnimals().size(); j++)
        {
            if (cage.getAnimals().get(j).getHp() == 0)
            {
                System.out.println("Animal enlevé: " + cage.getAnimals().get(j).getName() + " " + cage.getAnimals().get(j).getSpecies());
                cage.getAnimals().remove(j);
            }
        }
    }

    public void healerJob(ArrayList<Cage> cages) {

        ArrayList<Cage> selectCage = new ArrayList<>();
        int indexCage = 0;
        int temp, max = 0;
        int food, dirt;

        //Sélection de la cage

        /*
        Critères de sélection de la cage:
                -Nombre d'animaux morts
                -Saleté au maximum
                -Bouffe au minimum
         */
        for (int i = 0; i < cages.size(); i++)
        {
            temp = 0;
            food = 0;
            dirt = 0;
            for (int j = 0; j < cages.get(i).getAnimals().size(); j++)
            {
                if (cages.get(i).getAnimals().get(j).getHp() == 0)
                {
                    temp = temp + 10;
                }
                temp = temp + (cages.get(i).getAnimals().get(j).getMaxHp() - cages.get(i).getAnimals().get(j).getHp());
                food = food + cages.get(i).getAnimals().get(j).getHunger();
                dirt = dirt + cages.get(i).getAnimals().get(j).getDirt().getValeur();
            }
            if (cages.get(i).getFood() <= food)
            {
                temp = temp + (food - cages.get(i).getFood());
            }
            if (cages.get(i).getDirt() <= dirt)
            {
                temp = temp + (food - cages.get(i).getDirt());
            }
            if (temp > max)
            {
                max = temp;
                indexCage = i;
            }
        }

        System.out.println("Index = " + indexCage);


        //Nettoyage de la cage
        cleanCage(cages.get(indexCage));
        System.out.println("Clean cage");


        //Remise de nourriture
        feed(cages.get(indexCage));
        System.out.println("Feed");

        //Enlèvement de l'animal mort.

        cleanDeadAnimals(cages.get(indexCage));
        System.out.println("Clean bodies");
    }


}
