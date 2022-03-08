package com.iut.jeudelavie.Stub;

import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.Modele.Monde;
import com.iut.jeudelavie.Modele.Rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Stub {

    public HashMap<String, Dieu> Loader(){
        HashMap<String, Dieu> lesConfig = new HashMap<>();
        Monde monde = new Monde(10,10);
        boolean born[] = new boolean[10];
        boolean survive[] = new boolean[10];
        Arrays.fill(born, false);
        Arrays.fill(survive, false);
        born[3]=true;
        survive[2]=true;
        survive[3]=true;

        Rules rules = new Rules(born,survive);
        Dieu dieu = new Dieu(monde, rules);


        //glider
        dieu.getMonde().getGrille()[1][0].setAlive(true);
        dieu.getMonde().getGrille()[2][1].setAlive(true);
        dieu.getMonde().getGrille()[0][2].setAlive(true);
        dieu.getMonde().getGrille()[1][2].setAlive(true);
        dieu.getMonde().getGrille()[2][2].setAlive(true);
        lesConfig.put("glider",dieu);
        Dieu dieu2 = new Dieu(monde,rules);
        dieu.getMonde().getGrille()[2][1].setAlive(true);
        dieu.getMonde().getGrille()[2][2].setAlive(true);
        dieu.getMonde().getGrille()[2][3].setAlive(true);
        lesConfig.put("Récursif",dieu2);
        return lesConfig;

    }



}
