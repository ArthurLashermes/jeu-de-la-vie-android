package com.iut.jeudelavie.Stub;

import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.Modele.Monde;
import com.iut.jeudelavie.Modele.Rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Stub {

    public HashMap<String, Dieu> Loader() {
        HashMap<String, Dieu> lesConfig = new HashMap<>();
        Monde monde2 = new Monde(10, 10);
        boolean born2[] = new boolean[10];
        boolean survive2[] = new boolean[10];
        Arrays.fill(born2, false);
        Arrays.fill(survive2, false);
        born2[3] = true;
        survive2[2] = true;
        survive2[3] = true;

        Rules rules2 = new Rules(born2, survive2);

        Dieu dieu2 = new Dieu(monde2, rules2);
        dieu2.getMonde().getGrille()[2][1].setAlive(true);
        dieu2.getMonde().getGrille()[2][2].setAlive(true);
        dieu2.getMonde().getGrille()[2][3].setAlive(true);

        lesConfig.put("recursif", dieu2);
        return lesConfig;

    }

    public HashMap<String, Monde> LoadMonde() {
        HashMap<String, Monde> DicoMonde = new HashMap<>();
        Monde monde = new Monde(10, 10);

        monde.getGrille()[1][0].setAlive(true);
        monde.getGrille()[2][1].setAlive(true);
        monde.getGrille()[0][2].setAlive(true);
        monde.getGrille()[1][2].setAlive(true);
        monde.getGrille()[2][2].setAlive(true);
        DicoMonde.put("glider", monde);


        Monde monde2 = new Monde(10, 10);

        monde2.getGrille()[2][1].setAlive(true);
        monde2.getGrille()[2][2].setAlive(true);
        monde2.getGrille()[2][3].setAlive(true);
        DicoMonde.put("recursif", monde2);
        return DicoMonde;
    }
}