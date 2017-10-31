package com.dukeg.settingsvaluechecker.volume;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by johnyu on 21/10/2017.
 * This is volume checker
 */


public class volumeChecker {

//    public enum VolumeType {
//        alarm, media, notification, ringtone, system, call
//    }

    public int getMaxVolume(int volumeType, Context context) {
        AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return mAudioManager.getStreamMaxVolume(volumeType);

//        switch (volumeType) {
//            case alarm:
//                int alarm = 4;
//                int alarmMaxVolume = mAudioManager.getStreamMaxVolume(alarm);
//                break;
//            case media:
//                int media = 3;
//                int mediaMaxVolume = mAudioManager.getStreamMaxVolume(media);
//                break;
//            case notification:
//                int notification = 5;
//                int notificationMaxVolume = mAudioManager.getStreamMaxVolume(notification);
//                break;
//            case ringtone:
//                int ringtone = 2;
//                int ringtoneMaxVolume = mAudioManager.getStreamMaxVolume(ringtone);
//                break;
//            case system:
//                int system = 1;
//                int systemMaxVolume = mAudioManager.getStreamMaxVolume(system);
//                break;
//            case call:
//                int call = 0;
//                int callMaxVolume = mAudioManager.getStreamMaxVolume(call);
//                break;
//            default:
//                break;
//        }
    }

    public int getVolume(int volumeType, Context context) {
        AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return mAudioManager.getStreamVolume(volumeType);
//        switch (volumeType) {
//            case alarm:
//                int alarm = 4;
//                int alarmVolume = mAudioManager.getStreamVolume(alarm);
//                break;
//            case media:
//                int media = 3;
//                int mediaVolume = mAudioManager.getStreamVolume(media);
//                break;
//            case notification:
//                int notification = 5;
//                int notificationVolume = mAudioManager.getStreamVolume(notification);
//                break;
//            case ringtone:
//                int ringtone = 2;
//                int ringtoneVolume = mAudioManager.getStreamVolume(ringtone);
//                break;
//            case system:
//                int system = 1;
//                int systemVolume = mAudioManager.getStreamVolume(system);
//                break;
//            case call:
//                int call = 0;
//                int callVolume = mAudioManager.getStreamVolume(call);
//                break;
//            default:
//                break;
//        }
    }
}
