package com.technifutur.mobile.ui;

import com.technifutur.mobile.domain.humans.Healer;
import com.technifutur.mobile.domain.other.Animal;
import com.technifutur.mobile.domain.other.Cage;
import com.technifutur.mobile.domain.other.Zoo;
import com.technifutur.mobile.util.Generator;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Scanner sc = new Scanner(System.in);
    Zoo zoo;

    boolean executing = true;

    public Zoo generateZoo() {

        String tempName;

        System.out.print("Veuillez nommer votre zoo: ");
        tempName = sc.nextLine();
        zoo = new Zoo(tempName);


        return zoo;
    }

    public void start() {


        do
        {

            showStatus();

            addElement();

            makeHunger();

            makeDirt();


            // TODO C'est le soigneur qui enlève les cadavres
            // TODO Nettoyer les cages
            // TODO Remettre de la bouffe


            endOfDay();

        } while (executing);


    }


    private void makeHunger() {

        ArrayList<Cage> cages = zoo.getCages();


        for (int i = 0; i < cages.size(); i++)
        {
            for (int j = 0; j < cages.get(i).getAnimals().size(); j++)
            {
                if (cages.get(i).getAnimals().get(j).getHp() == 0)
                {
                    System.out.println(cages.get(i).getAnimals().get(j).getName() + " est mort... Pauvre " + cages.get(i).getAnimals().get(j).getSpecies());
                }
                else if (cages.get(i).getFood() >= cages.get(i).getAnimals().get(j).getHunger())
                {
                    cages.get(i).removeFood(cages.get(i).getAnimals().get(j).getHunger());
                }
                else
                {
                    cages.get(i).removeFood(cages.get(i).getFood());
                    cages.get(i).getAnimals().get(j).loseHp(1);
                }
            }
        }

    }

    private void makeDirt() {

        ArrayList<Cage> cages = zoo.getCages();


        for (int i = 0; i < cages.size(); i++)
        {
            for (int j = 0; j < cages.get(i).getAnimals().size(); j++)
            {
                if (cages.get(i).getDirt() <= 100 - cages.get(i).getAnimals().get(j).getDirt().getValeur())
                {
                    cages.get(i).removeDirt(cages.get(i).getAnimals().get(j).getDirt().getValeur());
                }
                else
                {
                    cages.get(i).removeDirt(cages.get(i).getDirt());
                    cages.get(i).getAnimals().get(j).loseHp(1);
                }
            }
        }


    }

    private void endOfDay() {

        zoo.dayChanger();

    }

    private void addElement() {

        int choice;
        boolean isOk = false;
        Generator generator = new Generator();

        do
        {
            addMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice)
            {
                case 1:
                    System.out.println("Ajout animal");
                    if (zoo.getCages().isEmpty())
                    {
                        System.out.println("Il n'y a pas de cage. Ce serait dommage de faire bouffer tous les visiteurs...");
                    }
                    else
                    {

                        zoo.addAnimal(generator.animalGenerator());
                        System.out.println("Animal ajouté");
                        isOk = true;
                    }


                    break;
                case 2:
                    System.out.println("Ajout cage");
                    if (zoo.getFood() > 0)
                    {
                        zoo.addCage(generator.cageGenerator(zoo.getFood()));
                        System.out.println("Cage ajoutée !");
                        isOk = true;

                    }
                    else
                    {
                        System.out.println("Il n'y a plus de nourriture disponible. Impossible d'ajouter une cage !");
                    }

                    break;
                case 3:
                    System.out.println("Ajout soigneur");
                    zoo.addHealer(generator.healerGenerator());
                    isOk = true;
                    break;
                case 4:
                    if (!zoo.getHealers().isEmpty())
                    {
                        for (Healer healer : zoo.getHealers())
                        {
                            healer.healerJob(zoo.getCages());
                        }
                        isOk = true;
                    }

                    else
                    {
                        System.out.println("Pas de soigneurs");
                    }
                    break;
                case 0:
                    executing = false;
                    isOk = true;
                    break;
                default:
                    System.out.println("Ne fait rien");
                    isOk = true;
                    break;

            }
        } while (!isOk);

    }


    private void addMenu() {
        System.out.println("1.\tAjouter un animal.");
        System.out.println("2.\tAjouter une cage.");
        System.out.println("3.\tAjouter un soigneur.");
        System.out.println("4.\tFaire travailler les soigneurs.");
        System.out.println("0.\tQuitter la simulation.");
        System.out.println("\nAppuyez sur une autre touche pour ne rien faire");
    }

    private void showStatus() {

        System.out.println("Date du jour: " + zoo.getDate());
        ArrayList<Cage> cages = zoo.getCages();
        ArrayList<Animal> animals = zoo.getAnimals();
        ArrayList<Healer> healers = zoo.getHealers();
        for (int i = 0; i < cages.size(); i++)
        {
            Cage cage = cages.get(i);
            System.out.println("Cage " + (i + 1) + "\nSpace: " + cage.getSpace() + "\nFood: " + cage.getFood() + "\nDirt: " + cage.getDirt());
            for (int j = 0; j < cages.get(i).getAnimals().size(); j++)
            {
                System.out.println(cages.get(i).getAnimals().get(j).getName() + " / " + cages.get(i).getAnimals().get(j).getSpecies() + cages.get(i).getAnimals().get(j).getHp() + "/" + cages.get(i).getAnimals().get(j).getMaxHp());
            }
            System.out.println();
        }
        System.out.println("Soigneurs:");
        for (int i = 0; i < healers.size(); i++)
        {
            System.out.println("\t\t\t" + healers.get(i).getName());
        }
        System.out.println("Food = " + zoo.getFood());

    }
}
