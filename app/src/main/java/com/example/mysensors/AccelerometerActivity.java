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

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "AccelerometerActivity";
    private SensorManager sensorManager;
    Sensor accelerometer;


    TextView xValue, yValue, zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(AccelerometerActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered accelerometer listener");
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + "Y" + sensorEvent.values[1] + "Z" + sensorEvent.values[2]);

        xValue.setText("xValue:" + sensorEvent.values[0]);
        yValue.setText("yValue:" + sensorEvent.values[1]);
        zValue.setText("zValue:" + sensorEvent.values[2]);

        if(sensorEvent.values[0]<-3 ){

            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }

        else  if (sensorEvent.values[0] < -1.8 && sensorEvent.values[0] >= -3) {
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
        }

        else  if (sensorEvent.values[0] < 3 && sensorEvent.values[0] >= 1.8) {
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }

        else  if (sensorEvent.values[0] >=3) {
            getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
        }

        else {
            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        }

    }
}