package com.example.acelerometrograf;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class MainActivity extends AppCompatActivity {
    Viewport viewport;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private double accelerationCurrentValue;
    private double accelerationPreviousValue;
    private int feetStepCount;

    private int pointsPlotted = 5;
    private int graphIntervalCounter = 0;

    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(0, 0),
            new DataPoint(1, 0),
            new DataPoint(2, 0),
            new DataPoint(3, 0),
            new DataPoint(4, 0)
    });

    TextView txt_currentAccel, txt_prevAccel, txt_acceleration, txt_feetStep;
    ProgressBar prog_shakeMeter;

    private SensorEventListener sensorEventListerner = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            accelerationCurrentValue = Math.sqrt((x*x + y*y + z*z));
            double changeInAcceleration = Math.abs(accelerationCurrentValue - accelerationPreviousValue);
            accelerationPreviousValue = accelerationCurrentValue;


            txt_currentAccel.setText("Atual = " + (int) accelerationCurrentValue);
            txt_prevAccel.setText("Anterior = " + (int) accelerationPreviousValue);
            txt_acceleration.setText("Mudança no Equilibrio = " + (int) changeInAcceleration);

            prog_shakeMeter.setProgress((int)changeInAcceleration);

            if(changeInAcceleration > 14){
                txt_acceleration.setBackgroundColor((Color.RED));
            } else if (changeInAcceleration > 5) {
                txt_acceleration.setBackgroundColor((Color.parseColor("#fcad03")));
            } else if (changeInAcceleration > 2) {
                txt_acceleration.setBackgroundColor((Color.YELLOW));
            }
            else {
                txt_acceleration.setBackgroundColor(getResources().getColor(com.google.android.material.R.color.design_default_color_background));
            }

            pointsPlotted++;
            if (pointsPlotted > 2000){
                pointsPlotted = 1;
                series.resetData(new DataPoint[]{new DataPoint(1,0)});
            }

            series.appendData(new DataPoint(pointsPlotted, (int)changeInAcceleration), true, pointsPlotted);
            viewport.setMaxX(pointsPlotted);
            viewport.setMinX(pointsPlotted - 300);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        txt_acceleration = findViewById(R.id.txt_accel);
        txt_currentAccel = findViewById(R.id.txt_currentAccel);
        txt_prevAccel = findViewById(R.id.txt_prevAccel);

        prog_shakeMeter = findViewById(R.id.prog_shakeMeter);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer =  mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        viewport = graph.getViewport();
        viewport.setScrollable(true);
        viewport.setXAxisBoundsManual(true);
        graph.addSeries(series);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListerner, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListerner);
    }

}