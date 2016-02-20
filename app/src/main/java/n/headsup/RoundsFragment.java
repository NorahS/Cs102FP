package n.headsup;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Norah on 2/2/16 AD.
 */
public class RoundsFragment extends Fragment implements SensorEventListener {

    private SensorManager senSensorManager;
    private Sensor senAccelerometer, senMagnetometer;
    private MediaPlayer pass, right;
    private View rootView = null;
    private TextView rot;

    private float mGravity[], mGeomagnetic[];
    private int rollDegs[] = new int[12];
    private long lastUpdate = 0;
    private int degIndex = 0;
    private int lowThreshold = 25;
    private int highThreshold = 90;
    private int transitionDelay = 230;

    //constructor
    public RoundsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.content_round, container, false);

        Intent intent = getActivity().getIntent();
        rot = (TextView) rootView.findViewById(R.id.rot);
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String catogry = intent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.catogry)).setText(catogry);
        }

        senSensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senMagnetometer = senSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_UI);
        senSensorManager.registerListener(this, senMagnetometer, SensorManager.SENSOR_DELAY_UI);




        return rootView;

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;

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


            float roll = orientation[2];
            int rollDeg = (int) Math.round(Math.toDegrees(roll));
            rollDegs[degIndex] = rollDeg;
            degIndex++;
            if (degIndex == rollDegs.length) {

                int devRot = this.state();
                long curTime = System.currentTimeMillis();
                if ((devRot < lowThreshold) && (curTime - lastUpdate) > transitionDelay) {
                    rot.setText("pass");
                    pass = MediaPlayer.create(getContext(), R.raw.sss);
                    pass.start();
                    lastUpdate = System.currentTimeMillis();

                } else if (devRot > highThreshold && (curTime - lastUpdate) > transitionDelay) {
                    rot.setText("succse");
                    right = MediaPlayer.create(getContext(), R.raw.ss);
                    right.start();
                    lastUpdate = System.currentTimeMillis();

                } else
                    rot.setText("next");
            }


        }
    }

    private int state() {
        int sum = 0;
        for (int i = 0; i != rollDegs.length; i++)
            sum += rollDegs[i];
        degIndex = 0;
        int aver = sum / rollDegs.length;
        int n =getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if(n== Surface.ROTATION_90)
            aver*=-1;
        return aver;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }



}
