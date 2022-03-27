package com.iut.jeudelavie.Modele;


import com.iut.jeudelavie.BaseApplication;
import com.iut.jeudelavie.Modele.Interface.Observer;
import java.util.ArrayList;


public class BoucleDeJeu implements Runnable{

    /**
     * Indique à la pause si elle est lancé ou non
     */
    public static boolean played = false;
    public boolean getPlayed(){ return played; }
    public void setPlayed(boolean valeur){ played = valeur;}
    public static ArrayList<Observer> listObserver = new ArrayList<>();



    private Dieu dieu;
    /**
     * Période entre chaque répétition de la boucle
     */
    private static int time;

    public static int getTime() {
        return time;
    }

    public void setTime(int time) {
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
                notifyObservers();
            }
            try { //ne pas mettre dans la boucle, sinon ça ne tourne pas
                Thread.sleep(time);
            } catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public void notifyObservers(){
        for (Observer o : listObserver){
            o.update();
        }
    }

    public void addListener(Observer observer){
        listObserver.add(observer);
    }
}
