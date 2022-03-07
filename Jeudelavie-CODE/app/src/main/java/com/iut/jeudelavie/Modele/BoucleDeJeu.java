package com.iut.jeudelavie.Modele;

<<<<<<< HEAD
//import com.iut.jeudelavie.Modele.Interface.Observer;
=======
>>>>>>> parent of c32b945... Le thread fonctionne, avec un observateur qui fonctionne, la boucle de jeu est donc bonne il suffit juste de régler le probème de l'actualisation et le jeu tourne correctement. Après il faudra s'occuper de la configuration.

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

<<<<<<< HEAD

public class BoucleDeJeu extends Observable implements Runnable{
=======
public class BoucleDeJeu extends Observable implements Runnable{
    /**
     * Instance du dieu
     */
    private final Dieu dieu ;
>>>>>>> parent of c32b945... Le thread fonctionne, avec un observateur qui fonctionne, la boucle de jeu est donc bonne il suffit juste de régler le probème de l'actualisation et le jeu tourne correctement. Après il faudra s'occuper de la configuration.

    /**
     * Indique à la pause si elle est lancée ou non
     */
<<<<<<< HEAD
    //FIXME interdiction de faire passer des variables statiques de proche en proche dans des classes qui ont un cycle de vie Android
    public static int played = 2; //0 pour en pause, 1 pour en cours, 2 pour jamais lancé/réinitialisé
    public static int getPlayed(){ return played; }
    public static void setPlayed(int valeur){ played = valeur;}
=======
    public static boolean played = false;
    public static boolean getPlayed(){ return played; }
    public static void setPlayed(boolean valeur){ played = valeur;}
>>>>>>> parent of c32b945... Le thread fonctionne, avec un observateur qui fonctionne, la boucle de jeu est donc bonne il suffit juste de régler le probème de l'actualisation et le jeu tourne correctement. Après il faudra s'occuper de la configuration.



    /**
     * Période entre chaque répétition de la boucle
     */
    private static int time = 1000;

    public static ArrayList<Observer> listObserver = new ArrayList<>();
    /**
<<<<<<< HEAD
=======
     * Constructeur de la boucle de jeu
     * @param dieu Le dieu qui sera modifié par la boucle de jeu.
     */
    public BoucleDeJeu(Dieu dieu){
        this.dieu = dieu;
        setTime(500);
    }

    /**
>>>>>>> parent of c32b945... Le thread fonctionne, avec un observateur qui fonctionne, la boucle de jeu est donc bonne il suffit juste de régler le probème de l'actualisation et le jeu tourne correctement. Après il faudra s'occuper de la configuration.
     * Algorithme de la boucle de jeu
     */
    @Override
    public void run() {
<<<<<<< HEAD
        while(true){
            while(played == 1){
                try {
                    notifyObservers();
                    Log.d("General", "Running the thread" + getPlayed());
                    Thread.sleep(time);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            while (played == 0){
                try {
                    Log.d("General", "Running the thread" + getPlayed());
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
=======
        while(played){
            if(BoucleDeJeu.getPlayed()){
                notifyObservers();
            }
            try { //ne pas mettre dans la boucle, sinon ça ne tourne pas
                Thread.sleep(getTime());
            } catch(Exception e){
                e.printStackTrace();
>>>>>>> parent of c32b945... Le thread fonctionne, avec un observateur qui fonctionne, la boucle de jeu est donc bonne il suffit juste de régler le probème de l'actualisation et le jeu tourne correctement. Après il faudra s'occuper de la configuration.
            }
        }
    }

    @Override
    public void notifyObservers(){
        for (Observer o : listObserver){
<<<<<<< HEAD
            o.update(this, null);
=======
            o.update(this,);
>>>>>>> parent of c32b945... Le thread fonctionne, avec un observateur qui fonctionne, la boucle de jeu est donc bonne il suffit juste de régler le probème de l'actualisation et le jeu tourne correctement. Après il faudra s'occuper de la configuration.
        }
    }

}
