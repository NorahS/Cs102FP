package n.headsup;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Norah on 3/10/16 AD.
 */
public class Sensors extends Setup implements SensorEventListener {

    private SensorManager senSensorManager;
    private Sensor senAccelerometer, senMagnetometer;


    private float mGravity[], mGeomagnetic[];
    private int rotDegs[] = new int[12];
    private long lastUpdate = 0;
    private int degIndex = 0;
    private int lowThreshold = 25;
    private int highThreshold = 90;
    private int transitionDelay = 230;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = super.onCreateView( inflater,container, savedInstanceState);

        senSensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senMagnetometer = senSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_UI);
        senSensorManager.registerListener(this, senMagnetometer, SensorManager.SENSOR_DELAY_UI);


        return rootView;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    public  void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_UI);
        senSensorManager.registerListener(this, senMagnetometer, SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    public void onPause() {

        super.onPause();
        senSensorManager.unregisterListener(this);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;
        int ranIndex;
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mGravity = event.values;

        } else if (mySensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            mGeomagnetic = event.values;
        }
        if (mGeomagnetic != null && mGravity != null) {
            float rotation[] = new float[9];
            senSensorManager.getRotationMatrix(rotation, null, mGravity, mGeomagnetic);

            float orientation[] = new float[9];
            senSensorManager.getOrientation(rotation, orientation);


            float rot = orientation[2];
            int rotDeg = (int) Math.round(Math.toDegrees(rot));
            rotDegs[degIndex] = rotDeg;
            degIndex++;
            if (degIndex == rotDegs.length) {

                int devRot = this.state();
                long curTime = System.currentTimeMillis();
                if ((devRot < lowThreshold) && (curTime - lastUpdate) > transitionDelay) {

                    HelperFunctions.next();
//                    pass = MediaPlayer.create(getContext(), R.raw.sss);
//                    pass.start();
                    lastUpdate = System.currentTimeMillis();

                } else if (devRot > highThreshold && (curTime - lastUpdate) > transitionDelay) {


//                    right = MediaPlayer.create(getContext(), R.raw.ss);
//                    right.start();
                    HelperFunctions.next();
                    lastUpdate = System.currentTimeMillis();

                } else {}

            }


        }
    }

    private int state() {
        int sum = 0;
        for (int i = 0; i != rotDegs.length; i++)
            sum += rotDegs[i];
        degIndex = 0;
        int aver = sum / rotDegs.length;
        int n = getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (n == Surface.ROTATION_90)
            aver *= -1;
        return aver;
    }

    public void stopSensors(){
        this.onPause();
    }

}
