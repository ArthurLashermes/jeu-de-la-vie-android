package com.iut.jeudelavie.Modele;


public class Rules {
    /**
     * Règle de naissance des cellules.
     */
    private boolean[] BornRules;
    public boolean getBornRules(int i){ return BornRules[i]; }
    public void setBornRules(int i,boolean value){BornRules[i]=value;}


    /**
     * Règle de survie des cellules.
     */
    private boolean[] SurviveRules;

    public boolean getSurviveRules(int i){ return SurviveRules[i]; }
    public void setSurviveRules(int i,boolean value){SurviveRules[i]=value;}

    /**
     * Constructeur de Rules
     * @param bornRules Règles de naissances
     * @param surviveRules  Règles de survie
     */
    public Rules(boolean[] bornRules, boolean[] surviveRules){
        this.BornRules = bornRules;
        this.SurviveRules = surviveRules;
    }

    /**
     * Permet de changer les règles du jeu, sans regénérer une nouvelle instance et devoir refaire le binding de la vue.
     * @param newRules Nouvelles règles à appliquer
     */
    public void switchRulesTo(Rules newRules){
        for(int i=0;i<9;i++){
            setBornRules(i, newRules.getBornRules(i));
            setSurviveRules(i, newRules.getSurviveRules(i));
        }
    }
}
