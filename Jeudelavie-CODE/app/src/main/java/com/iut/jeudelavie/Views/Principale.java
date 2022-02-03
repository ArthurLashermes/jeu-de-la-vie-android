package com.iut.jeudelavie.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import com.iut.jeudelavie.R;

public class Principale extends AppCompatActivity {
    private Button boutonLancement;
    private Button boutonConfig;
    private ImageFilterButton info;
    private GridLayout table;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principale);
        boutonLancement=findViewById(R.id.lancement);
        boutonConfig=findViewById(R.id.config);
        info=findViewById(R.id.info);
        table=findViewById(R.id.Table);
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

        CheckBox box;
        //layout param à modif
        for (int j = 0; j< 10; j++) {
            for (int i = 0; i < 10; i++) {
                CheckBox cb = (CheckBox) getLayoutInflater().inflate(R.layout.cell, table, false);
                ViewGroup.LayoutParams lt = cb.getLayoutParams();
                cb.setLayoutParams();
                /*
                a finir
                FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
                params.gravity = Gravity.TOP;
                view.setLayoutParams(params);
                 */
            }
        }




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
        }
    }
}
