package com.iut.jeudelavie.Modele;
import android.util.Log;

import com.iut.jeudelavie.Modele.Interface.Observer;

import java.util.ArrayList;


public class BoucleDeJeu implements Runnable{

    /**
     * Indique à la pause si elle est lancé ou non
     */
    public static int played = 2; //0 pour en pause, 1 pour en cours, 2 pour jamais lancé/réinitialisé
    public static int getPlayed(){ return played; }
    public static void setPlayed(int valeur){ played = valeur;}



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

    public static ArrayList<Observer> listObserver = new ArrayList<>();
    /**
     * Constructeur de la boucle de jeu
     */
    public BoucleDeJeu(){
        setTime(1000);
    }

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
                    Thread.sleep(getTime());
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            while (played == 0){
                try {
                    Log.d("General", "Running the thread" + getPlayed());
                    Thread.sleep(getTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
