package com.example.mysensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GyroscopeActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "GyroscopeActivity";
    private SensorManager sensorManager;
    Sensor mGyro;

    TextView xGyroValue, yGyroValue, zGyroValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        xGyroValue = (TextView) findViewById(R.id.xGyroValue);
        yGyroValue = (TextView) findViewById(R.id.yGyroValue);
        zGyroValue = (TextView) findViewById(R.id.zGyroValue);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(GyroscopeActivity.this, mGyro, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered mGyro listener");
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + "Y" + sensorEvent.values[1] + "Z" + sensorEvent.values[2]);

        xGyroValue.setText("xGyroValue:" + sensorEvent.values[0]);
        yGyroValue.setText("yGyroValue:" + sensorEvent.values[1]);
        zGyroValue.setText("zGyroValue:" + sensorEvent.values[2]);
    }
}