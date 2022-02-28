package com.iut.jeudelavie.Modele;

//import com.iut.jeudelavie.Views.CelluleView;

/**
 * Gère la création de tableau de cellules.
 */
public class GrilleCellFactory {

    /**
     * Créer un tableau de cellule
     * @param sizeX Taille x du tableau
     * @param sizeY Taille y du tableau
     * @return Tableau de cellule
     */
    public static Cellule[][] createCellGrid(int sizeX,int sizeY){
        Cellule[][] grille = new Cellule[sizeX][sizeY];
        for(int x=0;x<sizeX;x++){
            for(int y=0;y<sizeY;y++){
                grille[x][y] = new Cellule(false,x,y);
            }
        }

        return grille;
    }
}
