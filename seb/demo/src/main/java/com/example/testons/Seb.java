package com.example.testons;

/**
 * La belle classe de Seb.
 */
public class Seb {
    /**
     * Constructeur par défault.
     */
    public Seb() {
        super();
    }

    /**
     * @param a première chaine
     * @param b seconde chaine
     * @return la concatenation
     */
    public String concat(String a, String b) {
        return a + " " + b;
    }

    /**
     * @param prixHorsTVA
     * @param tauxTVA
     * @return prixTVAC
     */
    public double calculTVA(double prixHorsTVA, double tauxTVA) {
        if (tauxTVA < 0 || prixHorsTVA < 0) {
            throw new IllegalArgumentException("Ne pas etre negatif");
        }
        return prixHorsTVA * tauxTVA / 100;
    }
}
