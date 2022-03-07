package com.iut.jeudelavie.Modele;
import android.util.Log;

//import com.iut.jeudelavie.Modele.Interface.Observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class BoucleDeJeu extends Observable implements Runnable{

    /**
     * Indique à la pause si elle est lancée ou non
     */
    //FIXME interdiction de faire passer des variables statiques de proche en proche dans des classes qui ont un cycle de vie Android
    public static int played = 2; //0 pour en pause, 1 pour en cours, 2 pour jamais lancé/réinitialisé
    public static int getPlayed(){ return played; }
    public static void setPlayed(int valeur){ played = valeur;}



    /**
     * Période entre chaque répétition de la boucle
     */
    private static int time = 1000;

    public static ArrayList<Observer> listObserver = new ArrayList<>();
    /**
     * Algorithme de la boucle de jeu
     */
    @Override
    public void run() {
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
            }
        }

    }

    public void notifyObservers(){
        for (Observer o : listObserver){
            o.update(this, null);
        }
    }

    public void addListener(Observer observer){
        listObserver.add(observer);
    }

}
