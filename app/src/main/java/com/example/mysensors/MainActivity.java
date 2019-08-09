package com.example.mysensors;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);

    }

    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (finalI== 0) {
                        Intent intent = new Intent(MainActivity.this, AccelerometerActivity.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        Intent intent = new Intent(MainActivity.this, GyroscopeActivity.class);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    } else if (finalI == 3) {
                        Intent intent = new Intent(MainActivity.this, LightActivity.class);
                        startActivity(intent);
                    } else if (finalI == 4) {
                        Intent intent = new Intent(MainActivity.this, GravityActivity.class);
                        startActivity(intent);
                    } else if (finalI == 5) {
                        Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                        startActivity(intent);
                    } else if (finalI == 6) {
                        Intent intent = new Intent(MainActivity.this, ProximityActivity.class);
                        startActivity(intent);
                    } else if (finalI == 7) {
                        Intent intent = new Intent(MainActivity.this, SupportActivity.class);
                        startActivity(intent);
                    }
                    else
                        {
                            Toast.makeText(MainActivity.this, "please set activity for this card item", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}