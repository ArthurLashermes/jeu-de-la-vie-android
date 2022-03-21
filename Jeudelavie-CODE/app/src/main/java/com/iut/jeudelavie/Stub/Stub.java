package com.iut.jeudelavie.Stub;

import android.content.Context;

import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.Modele.Monde;
import com.iut.jeudelavie.Modele.Rules;

import java.util.ArrayList;
import java.util.Arrays;

public class Stub {

    public static Dieu Loader(Context context){

        Monde monde = new Monde(context, 10,10);
        boolean born[] = new boolean[10];
        boolean survive[] = new boolean[10];
        Arrays.fill(born, false);
        Arrays.fill(survive, false);
        born[3]=true;
        survive[2]=true;
        survive[3]=true;

        Rules rules = new Rules(born,survive);
        Dieu dieu = new Dieu(rules);
        dieu.setMonde(monde);


        //glider
//        dieu.getMonde().getGrille()[1][0].getCellule().setAlive(true);
//        dieu.getMonde().getGrille()[2][1].getCellule().setAlive(true);
//        dieu.getMonde().getGrille()[0][2].getCellule().setAlive(true);
//        dieu.getMonde().getGrille()[1][2].getCellule().setAlive(true);
//        dieu.getMonde().getGrille()[2][2].getCellule().setAlive(true);
        return dieu;

    }

}
