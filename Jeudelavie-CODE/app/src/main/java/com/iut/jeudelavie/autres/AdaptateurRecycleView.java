package com.iut.jeudelavie.autres;

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

public class AdaptateurRecycleView extends  RecyclerView.Adapter  {

    private HashMap<String, Monde> lesConfig;
    private OnItemClick onItemClick;

    public AdaptateurRecycleView(HashMap<String, Monde> lesConfig,AdaptateurRecycleView.OnItemClick adp) {
        this.lesConfig = lesConfig;
        this.onItemClick=adp;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout ln= (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_demo, parent, false);
        return new ViewHolderConfig(ln, onItemClick);
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

    public interface OnItemClick {
        void onMondeClicked(Monde monde);
    }
}
