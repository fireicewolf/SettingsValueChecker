package com.dukeg.settingsvaluechecker;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int call = AudioManager.STREAM_VOICE_CALL;
    int system = AudioManager.STREAM_SYSTEM;
    int ringtone = AudioManager.STREAM_RING;
    int media = AudioManager.STREAM_MUSIC;
    int alarm = AudioManager.STREAM_ALARM;
    int notification = AudioManager.STREAM_NOTIFICATION;

    int volumeType;

    int getSystemBrightness(Activity activity) {
        int systemBrightness = 0;
        ContentResolver contentResolver = activity.getContentResolver();
        try {
            systemBrightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
        }
        catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return systemBrightness;
    }

    int getVolume(int volumeType, Context context) {
        AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        assert mAudioManager != null;
        return mAudioManager.getStreamVolume(volumeType);
    }
    int getMaxVolume(int volumeType, Context context) {
        AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        assert mAudioManager != null;
        return mAudioManager.getStreamMaxVolume(volumeType);
    }

    TextView current_brightness_level;
    TextView current_volume_level;
    TextView max_volume_level;
    Spinner volume_type_selector;
    Button refresh_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        current_brightness_level = findViewById(R.id.current_brightness_level);
        current_volume_level = findViewById(R.id.current_volume_level);
        max_volume_level = findViewById(R.id.max_volume_level);

        volume_type_selector = findViewById(R.id.volume_type_selector);


        final CharSequence current_brightness_level_text = current_brightness_level.getText();
        final CharSequence max_volume_level_text = max_volume_level.getText();
        final CharSequence current_volume_level_text = current_volume_level.getText();

        refresh_button = findViewById(R.id.refresh_button);
        refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volume_type_selector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        String[] volume_type = getResources().getStringArray(R.array.volume_type);

                        if (volume_type[pos].equals(getString(R.string.call))){
                            volumeType = call;
                        }
                        else if (volume_type[pos].equals(getString(R.string.call))){
                            volumeType = system;
                        }
                        else if (volume_type[pos].equals(getString(R.string.ringtone))){
                            volumeType = ringtone;
                        }
                        else if (volume_type[pos].equals(getString(R.string.media))){
                            volumeType = media;
                        }
                        else if (volume_type[pos].equals(getString(R.string.alarm))){
                            volumeType = alarm;
                        }
                        else if (volume_type[pos].equals(getString(R.string.notification))){
                            volumeType = notification;
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Another interface callback
                    }
                });

                String currentBrightness = String.valueOf(getSystemBrightness(MainActivity.this));
                String maxVolume = String.valueOf(getMaxVolume(volumeType, MainActivity.this));
                String currentVolume = String.valueOf(getVolume(volumeType, MainActivity.this));

                current_brightness_level.setText(new StringBuffer(current_brightness_level_text).append(currentBrightness));
                max_volume_level.setText(new StringBuffer(max_volume_level_text).append(maxVolume));
                current_volume_level.setText(new StringBuffer(current_volume_level_text).append(currentVolume));
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }
}
