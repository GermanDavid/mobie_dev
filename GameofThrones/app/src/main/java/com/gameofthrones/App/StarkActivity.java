package com.gameofthrones.App;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class StarkActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] s1;
    String[] s2;
    int images[] = {R.drawable.rickard_stark, R.drawable.eddard_stark, R.drawable.catelyn_stark,
                    R.drawable.robb_stark, R.drawable.talisa_stark, R.drawable.sansa_stark, R.drawable.arya_stark,
                    R.drawable.bran_stark, R.drawable.rickon_stark, R.drawable.jon_snow};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stark);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.StarkMembers);
        s2 = getResources().getStringArray(R.array.StarkDescription);

        StarkAdapter starkAdapter = new StarkAdapter(this, s1, s2, images);
        recyclerView.setAdapter(starkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}