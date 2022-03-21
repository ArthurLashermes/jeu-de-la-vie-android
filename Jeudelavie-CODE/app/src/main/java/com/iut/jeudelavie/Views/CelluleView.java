package com.iut.jeudelavie.Views;



import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;


import androidx.annotation.Nullable;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.iut.jeudelavie.Modele.Cellule;
import com.iut.jeudelavie.R.drawable;

public class CelluleView extends MaterialCheckBox {

    private Cellule cellule;

    public CelluleView(Context context,int x ,int y) {
        super(context);
        cellule = new Cellule(false, x, y);
    }

    public Cellule getCellule() {
        return cellule;
    }

    public void setCellule(Cellule cellule) {
        this.cellule = cellule;
    }

    @Override
    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener listener) {
        super.setOnCheckedChangeListener(listener);

    }
}
