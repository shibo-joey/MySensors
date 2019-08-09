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

public class ProximityActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "ProximityActivity";
    private SensorManager sensorManager;
    Sensor mProximity;

    TextView Proximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        Proximity = (TextView) findViewById(R.id.Proximity);


        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(ProximityActivity.this, mProximity,2*1000*1000,SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered mProximity listener");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0]);

        Proximity.setText("proximity:" + sensorEvent.values[0]);
    if(sensorEvent.values[0]<mProximity.getMaximumRange()){

     getWindow().getDecorView().setBackgroundColor(Color.GREEN);

}
else{
      getWindow().getDecorView().setBackgroundColor(Color.WHITE);
  }

    }


    }
