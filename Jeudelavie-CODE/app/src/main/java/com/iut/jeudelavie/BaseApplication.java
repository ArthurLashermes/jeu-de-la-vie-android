package com.iut.jeudelavie;

import android.app.Application;

import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.Stub.Stub;

public class BaseApplication extends Application {

    private static BaseApplication instance;

    private Dieu dieu;

    public static BaseApplication getInstance() {
        return instance;
    }

    public Dieu getDieu() {
        if(dieu == null){
            dieu=new Stub().Loader().get("recursif");
        }
        return dieu;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
