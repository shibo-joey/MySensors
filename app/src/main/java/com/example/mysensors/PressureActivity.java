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

public class PressureActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "PressureActivity";
    private SensorManager sensorManager;
    Sensor mPressure;

    TextView pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        pressure = (TextView) findViewById(R.id.Pressure);


        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        sensorManager.registerListener(PressureActivity.this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered mPressure listener");
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0]);

        pressure.setText("pressure:" + sensorEvent.values[0]);

        if(sensorEvent.values[0]<1011 ){

            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }


        else{
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }

    }


}