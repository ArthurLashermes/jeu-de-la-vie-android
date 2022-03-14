package com.iut.jeudelavie.Views;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iut.jeudelavie.Autres.AdaptateurRecycleView;
import com.iut.jeudelavie.R;
import com.iut.jeudelavie.Stub.Stub;

public class ConfigActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        RecyclerView laListView = findViewById(R.id.lalistview);
        AdaptateurRecycleView ARV = new AdaptateurRecycleView(new Stub().Loader());
        laListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        laListView.setAdapter(ARV);


    }

}
