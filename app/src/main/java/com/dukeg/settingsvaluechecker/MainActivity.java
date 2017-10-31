package com.dukeg.settingsvaluechecker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.dukeg.settingsvaluechecker.brightness.brightnessChecker;
import com.dukeg.settingsvaluechecker.volume.volumeChecker;

public class MainActivity extends AppCompatActivity {

    int call = 0;
    int system = 1;
    int ringtone = 2;
    int media = 3;
    int alarm = 4;
    int notification = 5;
    Context context;
    volumeChecker mVolumeChecker;
    brightnessChecker mBrightnessChecker;

    TextView current_brightness_level;
    TextView current_volume_level;
    TextView max_volume_level;

    Spinner volume_type_selector;

    Button refresh_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        current_brightness_level = (TextView)findViewById(R.id.current_brightness_level);
        current_volume_level = (TextView)findViewById(R.id.current_volume_level);
        max_volume_level = (TextView)findViewById(R.id.max_volume_level);

        volume_type_selector = (Spinner)findViewById(R.id.volume_type_selector);
        volume_type_selector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String[] volume_type = getResources().getStringArray(R.array.volume_type);
                switch (volume_type[pos]) {
                    case "call": {
                        String maxVolume = String.valueOf(mVolumeChecker.getMaxVolume(call, context));
                        String currentVolume = String.valueOf(mVolumeChecker.getVolume(call, context));
                        break;
                    }
                    case "system": {
                        String maxVolume = String.valueOf(mVolumeChecker.getMaxVolume(system, context));
                        String currentVolume = String.valueOf(mVolumeChecker.getVolume(system, context));
                        break;
                    }
                    case "ringtone": {
                        String maxVolume = String.valueOf(mVolumeChecker.getMaxVolume(ringtone, context));
                        String currentVolume = String.valueOf(mVolumeChecker.getVolume(ringtone, context));
                        break;
                    }
                    case "media": {
                        String maxVolume = String.valueOf(mVolumeChecker.getMaxVolume(media, context));
                        String currentVolume = String.valueOf(mVolumeChecker.getVolume(media, context));
                        break;
                    }
                    case "alarm": {
                        String maxVolume = String.valueOf(mVolumeChecker.getMaxVolume(alarm, context));
                        String currentVolume = String.valueOf(mVolumeChecker.getVolume(alarm, context));
                        break;
                    }
                    case "notification": {
                        String maxVolume = String.valueOf(mVolumeChecker.getMaxVolume(notification, context));
                        String currentVolume = String.valueOf(mVolumeChecker.getVolume(notification, context));
                        break;
                    }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        refresh_button = (Button)findViewById(R.id.refresh_button);
        refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentBrightness = String.valueOf(mBrightnessChecker.getSystemBrightness(MainActivity.this));
                current_brightness_level.append(currentBrightness);
                max_volume_level.append(maxVolume);
                current_volume_level.append(currentVolume);
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }
}
