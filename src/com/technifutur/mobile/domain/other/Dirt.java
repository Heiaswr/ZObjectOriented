package com.technifutur.mobile.domain.other;

public enum Dirt {

    PROPRE(5),
    SALE(15),
    CRASSEUX(25);

    private int valeur;

    Dirt(int valeur) {
        this.valeur=valeur;
    }

    public int getValeur() {
        return valeur;
    }
}
