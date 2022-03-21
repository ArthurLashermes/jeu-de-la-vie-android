package com.iut.jeudelavie.Views;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;


import com.google.android.material.checkbox.MaterialCheckBox;
import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.R;

public class TabCells {

    private Dieu dieu;
    private CheckBox Tab[][] = new CheckBox[10][10];
    private ViewGroup table;

    public TabCells(Activity activity, Dieu dieu) {
        this.dieu = dieu;
        table = new GridLayout(activity);
        table = activity.findViewById(R.id.Table);
        for (int j = 0; j< 10; j++) {
            for (int i = 0; i < 10; i++) {
                View view=activity.getLayoutInflater().inflate(R.layout.cell,table, false);
                GridLayout.LayoutParams params =(GridLayout.LayoutParams)view.getLayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                view.setLayoutParams(params);
                CelluleView celluleView = new CelluleView(activity, j, i);
                celluleView.setChecked(dieu.getMonde().getGrille()[i][j].getCellule().getAlive());
                celluleView.setOnCheckedChangeListener(celluleView.getCellule());
                Tab[j][i]=celluleView;
                table.addView((View)celluleView);

            }
        }
    }

    public ViewGroup getTable() {
        return table;
    }
}
