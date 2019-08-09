package com.example.mysensors;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LightActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "LightActivity";
    private SensorManager sensorManager;
    Sensor mLight;

    TextView light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        light = (TextView) findViewById(R.id.Light);


        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(LightActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered mLight listener");
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0]);

        light.setText("light:" + sensorEvent.values[0]);

        if (sensorEvent.values[0] < 15) {
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        }


        else if (sensorEvent.values[0] < 35 && sensorEvent.values[0] >= 15) {
            getWindow().getDecorView().setBackgroundColor(Color.CYAN);
        }


        else if (sensorEvent.values[0] < 60 && sensorEvent.values[0] >= 35) {
            getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
        }

       else  if (sensorEvent.values[0] < 90 && sensorEvent.values[0] >= 60) {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }

        else  if (sensorEvent.values[0] < 125 && sensorEvent.values[0] >= 90) {
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        }

        else  if (sensorEvent.values[0] < 160 && sensorEvent.values[0] >= 125) {
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }

        else  if (sensorEvent.values[0] < 190 && sensorEvent.values[0] >= 160) {
            getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
        }
        else  if (sensorEvent.values[0] < 300 && sensorEvent.values[0] >= 190) {
            getWindow().getDecorView().setBackgroundColor(Color.DKGRAY);
        }
        else {
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }

    }
    }

