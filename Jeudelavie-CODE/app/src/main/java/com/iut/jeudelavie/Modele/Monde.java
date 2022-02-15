package com.iut.jeudelavie.Modele;


import com.iut.jeudelavie.Views.CelluleView;

public class Monde{

    /**
     * Taille X de la grille de cellule. Bind sur un spinner dans la vue.
     */
    private static int tailleX;

    public static int getTailleX() {
        return tailleX;
    }

    public static void setTailleX(int tailleX) {
        Monde.tailleX = tailleX;
    }

    /**
     * Taille Y de la grille de cellule. Bind sur un spinner dans la vue.
     * Taille Y de la grille de cellule. Bind sur un spinner dans la vue.
     */
    public static int tailleY;

    public static int getTailleY() {
        return tailleY;
    }

    public static void setTailleY(int tailleY) {
        Monde.tailleY = tailleY;
    }

    /**
     * Grille de cellule.
     */
    private CelluleView[][] grille;


    /**
     * Constructeur du monde
     * @param tailleX Taille X du monde
     * @param tailleY Taille Y du monde
     */
    public Monde(int tailleX, int tailleY) {
        setTailleX(tailleX);
        setTailleY(tailleY);
        grille = GrilleCellFactory.createCellGrid(tailleX,tailleY);
    }

    /**
     * Getter
     * @return
     */
    public CelluleView[][] getGrille() {
        return grille;
    }

    /**
     * Setter
     * @param grille
     */
    public void setGrille(Cellule[][] grille) {
        this.grille = grille;
    }
}
