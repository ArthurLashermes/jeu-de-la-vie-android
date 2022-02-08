package com.iut.jeudelavie.Modele;

public class Test {
    private String nom;
    private String prenom;

    @Override
    public String toString() {
        return "Test{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Test(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
