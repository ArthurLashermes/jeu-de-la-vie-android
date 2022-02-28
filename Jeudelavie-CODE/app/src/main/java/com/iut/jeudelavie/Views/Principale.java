package com.iut.jeudelavie.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import com.iut.jeudelavie.Modele.BoucleDeJeu;
import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.Modele.Monde;
import com.iut.jeudelavie.Modele.Rules;
import com.iut.jeudelavie.R;

import java.util.Arrays;

public class Principale extends AppCompatActivity {
    private Button boutonLancement;
    private Button boutonConfig;
    private ImageFilterButton info;
    private GridLayout table;


    private BoucleDeJeu boucleDeJeu;
    private Dieu dieu;
    private Monde monde;
    private Rules rules;


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

//        monde = new Monde(10,10);
//        boucleDeJeu =new BoucleDeJeu(monde, /*j'ai pas capté l'utilisation des règles*/);
//        dieu = new Dieu(boucleDeJeu);

        //layout param à modif
        Monde monde = new Monde(10,10);
        boolean born[] = new boolean[10];
        boolean survive[] = new boolean[10];
        Arrays.fill(born, false);
        Arrays.fill(survive, false);
        born[3]=true;
        survive[2]=true;
        survive[3]=true;

        Rules rules = new Rules(born,survive);
        dieu = new Dieu(monde, rules);


        //glider
        dieu.getMonde().getGrille()[1][0].setAlive(true);
        dieu.getMonde().getGrille()[2][1].setAlive(true);
        dieu.getMonde().getGrille()[0][2].setAlive(true);
        dieu.getMonde().getGrille()[1][2].setAlive(true);
        dieu.getMonde().getGrille()[2][2].setAlive(true);




        actualiser();




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
        Intent monIntent = new Intent(this, Config.class);
        startActivity(monIntent);
    }

    public void clicSurBoutonInfo(){
        Intent monIntent = new Intent(this, Info.class);
        startActivity(monIntent);
    }


    public void clicSurBoutonPlay(){
        if(boutonLancement.getText() == "Pause"){
            boutonLancement.setText("Play");
        }else{
            boutonLancement.setText("Pause");
            start();
        }
    }

    public void start(){
//        BoucleDeJeu boucleDeJeu = new BoucleDeJeu();

        //boucleDeJeu.run();
        dieu.evolution();
        dieu.updateCells();
        actualiser();
    }

    public void actualiser(){

        table.removeAllViews();
        for (int j = 0; j< 10; j++) {
            for (int i = 0; i < 10; i++) {
                View view=getLayoutInflater().inflate(R.layout.cell, table, false);
                GridLayout.LayoutParams params =(GridLayout.LayoutParams) view.getLayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                view.setLayoutParams(params);
                CheckBox box=(CheckBox)view;
                box.setChecked(dieu.getMonde().getGrille()[i][j].getAlive());
                table.addView(box);
            }
        }
    }
}
