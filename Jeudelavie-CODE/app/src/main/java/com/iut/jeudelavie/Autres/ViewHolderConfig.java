package com.iut.jeudelavie.Autres;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iut.jeudelavie.R;

class ViewHolderConfig extends RecyclerView.ViewHolder {
    private final TextView textView;

    public ViewHolderConfig(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.cellconfig);
    }
    public TextView getTextView(){
        return textView;
    }

}
