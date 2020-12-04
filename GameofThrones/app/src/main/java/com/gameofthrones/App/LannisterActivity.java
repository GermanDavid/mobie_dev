package com.gameofthrones.App;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LannisterActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] s1;
    String[] s2;
    int images[] = {R.drawable.tytos_lannister, R.drawable.robert_baratheon, R.drawable.tywin_lannister, R.drawable.cersei_lannister, R.drawable.jaime_lannister, R.drawable.tyrion_lannister,
            R.drawable.joffrey_baratheon, R.drawable.kevan_lannister};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stark);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.LannisterMembers);
        s2 = getResources().getStringArray(R.array.LannisterDescription);

        StarkAdapter starkAdapter = new StarkAdapter(this, s1, s2, images);
        recyclerView.setAdapter(starkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}