package com.dukeg.settingsvaluechecker.brightness;

import android.content.Context;
import android.provider.Settings;

/**
 * Created by johnyu on 21/10/2017.
 * This is a brightness checker
 */

public class brightnessChecker {

    public int getSystemBrightness(Context context) {
        int systemBrightness = 0;
        try {
            systemBrightness = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        }
        catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return systemBrightness;
    }
}
