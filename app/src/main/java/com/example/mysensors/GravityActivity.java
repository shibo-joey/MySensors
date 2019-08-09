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

public class GravityActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "GravityActivity";
    private SensorManager sensorManager;
    Sensor mGra;

    TextView xGraValue, yGraValue, zGraValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);

        xGraValue = (TextView) findViewById(R.id.xGraValue);
        yGraValue = (TextView) findViewById(R.id.yGraValue);
        zGraValue = (TextView) findViewById(R.id.zGraValue);


        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mGra = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensorManager.registerListener(GravityActivity.this, mGra, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered mGra listener");
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + "Y" + sensorEvent.values[1] + "Z" + sensorEvent.values[2]);

        xGraValue.setText("xGraValue:" + sensorEvent.values[0]);
        yGraValue.setText("yGraValue:" + sensorEvent.values[1]);
        zGraValue.setText("zGraValue:" + sensorEvent.values[2]);

        if(sensorEvent.values[0]<-3 ){

            getWindow().getDecorView().setBackgroundColor(Color.DKGRAY);
        }

        else  if (sensorEvent.values[0] < -1.8 && sensorEvent.values[0] >= -3) {
            getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
        }

        else  if (sensorEvent.values[0] < 3 && sensorEvent.values[0] >= 1.8) {
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        }

        else  if (sensorEvent.values[0] >=3) {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }

        else {
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }

    }



}