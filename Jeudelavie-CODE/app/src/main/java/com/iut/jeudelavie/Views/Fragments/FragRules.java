package com.iut.jeudelavie.Views.Fragments;

import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.iut.jeudelavie.R;

public class FragRules extends Fragment {

    private CheckBox box1;
    private CheckBox box2;
    private CheckBox box3;
    private CheckBox box4;
    private CheckBox box5;
    private CheckBox box6;
    private CheckBox box7;
    private CheckBox box8;

    private TextView text;


    public FragRules(String text){
        super(R.layout.fragment_rules);
        box1.findViewById(R.id.checkBoxSurvive1);
        box2.findViewById(R.id.checkBoxSurvive2);
        box3.findViewById(R.id.checkBoxSurvive3);
        box4.findViewById(R.id.checkBoxSurvive4);
        box5.findViewById(R.id.checkBoxSurvive5);
        box6.findViewById(R.id.checkBoxSurvive6);
        box7.findViewById(R.id.checkBoxSurvive7);
        box8.findViewById(R.id.checkBoxSurvive8);


    }

}
