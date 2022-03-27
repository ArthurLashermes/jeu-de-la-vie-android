package com.iut.jeudelavie.Views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import com.iut.jeudelavie.BaseApplication;
import com.iut.jeudelavie.Modele.BoucleDeJeu;

import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.Modele.Interface.Observer;
import com.iut.jeudelavie.Modele.Monde;
import com.iut.jeudelavie.Autres.AdaptateurRecycleView;
import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.R;
import com.iut.jeudelavie.Stub.Stub;


import java.util.HashMap;


public class Principale extends AppCompatActivity implements Observer {
    private Button boutonLancement;
    private Button boutonConfig;
    private Button avancer;
    private ImageFilterButton info;
    private GridLayout table;
    private BoucleDeJeu boucleDeJeu;
    private Thread thread;
    private CheckBox Tab[][]= new CheckBox[10][10];


    public Dieu dieu = BaseApplication.getInstance().getDieu();


    /**
     * Cette fonction servira pour permmettre de faire la transposition d'une array list vers un
     * tableau double.
     *
     * @param position
     * @return
     */
    public Pair<Integer, Integer> mapPosition(int position) {
        int x=position/10;
        int y=position%10;
        return new Pair(x, y);
    }

    public Principale() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.principale);
        boutonLancement=findViewById(R.id.lancement);
        boutonConfig=findViewById(R.id.config);
        info=findViewById(R.id.info);
        table=findViewById(R.id.Table);
        avancer=findViewById(R.id.Avancer);
        Stub stub = new Stub();
        HashMap<String,Dieu> lesConfig = stub.Loader(getBaseContext());

        dieu=BaseApplication.getInstance().getDieu();


        for (int j = 0; j< 10; j++) {
            for (int i = 0; i < 10; i++) {
                View view=getLayoutInflater().inflate(R.layout.cell, table, false);
                GridLayout.LayoutParams params =(GridLayout.LayoutParams)view.getLayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                view.setLayoutParams(params);
                CheckBox box=(CheckBox)view;
                box.setChecked(dieu.getMonde().getGrille()[i][j].getAlive());
                int finalI1 = i;
                int finalJ = j;
                box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            dieu.getMonde().getGrille()[finalI1][finalJ].setAlive(true);
                        }
                    }
                });
                Tab[j][i]=box;

                table.addView(box);
            }
        }
        boutonLancement.setText("play");
                /*
        TabCells tabCells = new TabCells(this, dieu);

         */

        /*
        AdaptateurRecycleView adp=new AdaptateurRecycleView(new Stub().LoadMonde(), new AdaptateurRecycleView.OnItemClick() {
            @Override
            public void onMondeClicked(Monde monde) {
            }
        });*/

        boucleDeJeu = new BoucleDeJeu(dieu);
        boucleDeJeu.addListener(this);
        boucleDeJeu.setTime(200);
        thread = new Thread(boucleDeJeu);
        thread.start();



        avancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicSurBoutonInfo();
            }
        });
        boutonLancement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clicSurBoutonPlay();
            }
        });
        boutonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicSurBoutonConfig();
            }
        });



    }

    public void clicSurBoutonConfig(){
        Intent monIntent = new Intent(this, ConfigActivity.class);
        startActivity(monIntent);
    }

    public void clicSurBoutonInfo(){
        Intent monIntent = new Intent(this, Info.class);
        startActivity(monIntent);
    }


    public void clicSurBoutonPlay(){

        if(boutonLancement.getText() == "play"){
            boutonLancement.setText("stop");
            boucleDeJeu.setPlayed(true);
        }else{
            boutonLancement.setText("play");
            boucleDeJeu.setPlayed(false);
        }
    }

    public void start(){update();}
//        BoucleDeJeu boucleDeJeu = new BoucleDeJeu();

    //il faut modifier actualiser, ça prend beaucoup de ressources et ça marche pas (une erreur que je comprend pas vraiment)
    // il faut que l'on actualise seulement l'état du checkbox

    public void update() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dieu.evolution();
                dieu.updateCells();
                actualiser();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        actualiser();
    }

    public void actualiser(){
        View view;
        CheckBox box;
        table.removeAllViews();
        for (int j = 0; j< 10; j++) {
            for (int i = 0; i < 10; i++) {
                view = Tab[j][i];
                GridLayout.LayoutParams params =(GridLayout.LayoutParams) view.getLayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                view.setLayoutParams(params);
                box=(CheckBox)view;
                box.setChecked(dieu.getMonde().getGrille()[i][j].getAlive());
                table.addView(box);
            }
        }
    }
}
