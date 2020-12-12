package com.gameofthrones.App;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static String logtag = "GameOfThronesApp";//for use as the tag when logging

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStark = (Button)findViewById(R.id.buttonStark);
        buttonStark.setOnClickListener(startListener); // Register the onClick listener with the implementation above

        Button buttonLannister = (Button)findViewById(R.id.buttonLannister);
        buttonLannister.setOnClickListener(stopListener); // Register the onClick listener with the implementation above
    }

    //Create an anonymous implementation of OnClickListener
    private OnClickListener startListener = new OnClickListener() {
        public void onClick(View v) {
            Log.d(logtag,"onClick() called - stark button");
            Toast.makeText(MainActivity.this, "House Stark of Winterfell", Toast.LENGTH_LONG).show();
            Log.d(logtag,"onClick() ended - stark button");
            Intent starkClick = new Intent(v.getContext(), StarkActivity.class);
            startActivity(starkClick);
        }
    };

    // Create an anonymous implementation of OnClickListener
    private OnClickListener stopListener = new OnClickListener() {
        public void onClick(View v) {
            Log.d(logtag,"onClick() called - lannister button");
            Toast.makeText(MainActivity.this, "House Lannister of Casterly Rock", Toast.LENGTH_LONG).show();
            Log.d(logtag,"onClick() ended - lannister button");
            Intent lannisterClick = new Intent(v.getContext(), LannisterActivity.class);
            startActivity(lannisterClick);
        }
    };

    @Override
    protected void onDestroy() {//android has killed this activity
        Log.d(logtag,"onDestroy() called");
        super.onDestroy();
    }
}


