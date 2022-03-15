package com.iut.jeudelavie.Modele;


import com.iut.jeudelavie.BaseApplication;

public class BoucleDeJeu implements Runnable{
    /**
     * Instance du dieu
     */
    private Dieu dieu;

    /**
     * Indique à la pause si elle est lancé ou non
     */
    public static boolean played = false;
    public static boolean getPlayed(){ return played; }
    public static void setPlayed(boolean valeur){ played = valeur;}



    /**
     * Période entre chaque répétition de la boucle
     */
    private static int time;

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        BoucleDeJeu.time = time;
    }
    /**
     * Constructeur de la boucle de jeu
     * @param dieu Le dieu qui sera modifié par la boucle de jeu.
     */
    public BoucleDeJeu(Dieu dieu){
        this.dieu = dieu;
        setTime(500);
    }

    /**
     * Algorithme de la boucle de jeu
     */
    @Override
    public void run() {
        while(true){
            if(BoucleDeJeu.played){
                dieu.evolution();
                dieu.updateCells();
            }
            try { //ne pas mettre dans la boucle, sinon ça ne tourne pas
                Thread.sleep(time);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
