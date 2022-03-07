package com.iut.jeudelavie.Autres;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iut.jeudelavie.Modele.Dieu;
import com.iut.jeudelavie.Modele.Monde;

import java.util.List;
import java.util.Map;

public class AdaptateurRecycleView extends  RecyclerView.Adapter  {

    private Map<String, Dieu> lesConfig;

    public AdaptateurRecycleView(Map<String, Dieu> lesConfig) {
        this.lesConfig = lesConfig;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
