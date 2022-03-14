package com.iut.jeudelavie.Autres;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iut.jeudelavie.R;

class ViewHolderConfig extends RecyclerView.ViewHolder {
    private final TextView textView;

    public ViewHolderConfig(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.cellconfig);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),  "viewholder = " + textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public TextView getTextView(){
        return textView;
    }

}
