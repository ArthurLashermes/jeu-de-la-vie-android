package com.iut.jeudelavie.Autres;

//import static com.iut.jeudelavie.Views.Principale.dieu;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iut.jeudelavie.R;
import com.iut.jeudelavie.Stub.Stub;
import com.iut.jeudelavie.Modele.Monde;

public class ViewHolderConfig extends RecyclerView.ViewHolder {
    private final TextView textView;
    private AdaptateurRecycleView.OnItemClick listener;

    public ViewHolderConfig(@NonNull View itemView, AdaptateurRecycleView.OnItemClick listener) {
        super(itemView);
        this.listener = listener;
        textView = itemView.findViewById(R.id.cellconfig);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Monde md=new Stub().LoadMonde(view.getContext()).get(textView.getText());
                listener.onMondeClicked(md);
            }
        });
    }
    public TextView getTextView(){
        return textView;
    }

}
