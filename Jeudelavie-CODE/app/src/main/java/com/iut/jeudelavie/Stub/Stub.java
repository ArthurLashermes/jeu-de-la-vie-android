package com.iut.jeudelavie.Stub;

import com.iut.jeudelavie.Modele.Test;

import java.util.ArrayList;

public class Stub {
    static public ArrayList<Test> load (){
        ArrayList<Test> list= new ArrayList<Test>();
        list.add(new Test("LALLALAL","LKofjehijifji"));
        list.add(new Test("jhiijij","dsffwfwf"));
        list.add(new Test("uiduiuidu", "fkfofok"));
        list.add(new Test("PPPPP", "AAAAAA"));
        return list;
    }

}
