package com.iut.jeudelavie.Autres;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.Modele.Monde;
import com.iut.jeudelavie.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdaptateurRecycleView extends  RecyclerView.Adapter  {

    private HashMap<String, Dieu> lesConfig;

    public AdaptateurRecycleView(HashMap<String, Dieu> lesConfig) {
        this.lesConfig = lesConfig;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout ln= (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_demo, parent, false);
        return new ViewHolderConfig(ln);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //recuperer mon model item grave a la position
        //binder mon model item sur mon view holder
        ArrayList<String> laList=new ArrayList<>();
        laList.addAll(lesConfig.keySet());
        String elementCourant =laList.get(position);
        ((ViewHolderConfig)holder).getTextView().setText(elementCourant);

    }

    @Override
    public int getItemCount() {
        return lesConfig.size();
    }
}
