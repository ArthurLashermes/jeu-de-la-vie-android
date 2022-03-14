package com.iut.jeudelavie.autres;

import static com.iut.jeudelavie.Views.Principale.dieu;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iut.jeudelavie.R;
import com.iut.jeudelavie.Stub.Stub;

class ViewHolderConfig extends RecyclerView.ViewHolder {
    private final TextView textView;
    private AdaptateurRecycleView.OnItemClick listener;

    public ViewHolderConfig(@NonNull View itemView, AdaptateurRecycleView.OnItemClick listener) {
        super(itemView);
        this.listener = listener;
        textView = itemView.findViewById(R.id.cellconfig);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), " position = " + textView.getText(), Toast.LENGTH_SHORT).show();
                listener.onMondeClicked(monde);
                dieu.setMonde(new Stub().Loader().get(textView.getText()).getMonde());
            }
        });
    }
    public TextView getTextView(){
        return textView;
    }

}
