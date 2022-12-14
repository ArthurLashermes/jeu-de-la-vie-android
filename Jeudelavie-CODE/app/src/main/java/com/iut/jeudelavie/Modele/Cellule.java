package com.iut.jeudelavie.Modele;

import android.widget.CompoundButton;

import androidx.fragment.app.Fragment;

import com.iut.jeudelavie.R;

import java.util.ArrayList;
import java.util.Observer;

public class Cellule implements CompoundButton.OnCheckedChangeListener {
    /**
     * Etat de la cellule au prochain tour de boucle. -1 signifie que la cellule va mourir, 1 signifie qu'elle va naitre, 0 ne change rien
     */
    private int nextTimeStatus;

    /**
     * Etat de la cellule (en vie ou morte).
     */
    private boolean alive;

    /**
     * Coordonnée X de la cellule dans la grille
     */
    private int x;
    /**
     * Coordonnée Y de la cellule dans la grille
     */
    private int y;

    private ArrayList<Observer> listObserver = new ArrayList<>();

    /**
     * Constructeur d'une cellule
     * @param alive
     * @param x Coordonnée X de la cellule dans la grille
     * @param y Coordonnée Y de la cellule dans la grille
     */
    public Cellule(boolean alive, int x, int y) {
        //this.alive = alive; //on initialise toutes les cellules en créant la grille
        nextTimeStatus = 0;
        this.alive=false;
        this.x = x;
        this.y = y;

    }

    /**
     * Guetter de nextTimeStatus
     * @return entier
     */
    public int getNextTimeStatus() {
        return nextTimeStatus;
    }

    /**
     * Setter de nextTimeStatus
     * @param nextTimeStatus
     */
    public void setNextTimeStatus(int nextTimeStatus) {
        this.nextTimeStatus = nextTimeStatus;
    }

    /**
     * Indique si la cellule est en vie ou non.
     * @return True si elle est en vie, false sinon
     */
    public boolean isAlive() {
        return getAlive();
    }


    /**
     * Permet d'actualiser la cellule et de lui donner sont état pour le prochain tour de boucle.
     */
    public void update(){
        if(nextTimeStatus == 1) setAlive(true);
        else if(nextTimeStatus == -1) setAlive(false);
    }

    /**
     * Guetter de Y
     * @return entier
     */
    public int getY() {
        return y;
    }

    /**
     * Setter de Y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Setter
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }


    public void setAlive(boolean alive){
        this.alive =alive;
    }

    public boolean getAlive(){
        return alive;
    }

    public void addListener(Observer observer){
        listObserver.add(observer);
    }


    @Override
    public String toString() {
        return "Cellule{" +
                "nextTimeStatus=" + nextTimeStatus +
                ", alive=" + alive +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        this.alive = b;
    }
}
