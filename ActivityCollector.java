package com.example.god.broadcastbestpratice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by god on 2016/3/1.
 */
public class ActivityCollector {
    public static List<Activity> mActivities=new ArrayList<>();
    public static void addActivity(Activity activity)
    {
        mActivities.add(activity);
    }
    public static void removeActivity(Activity activity)
    {
        mActivities.remove(activity);
    }

    public static void finishAll()
    {
        for (Activity activity:mActivities) {
            if(!activity.isFinishing())
            activity.finish();
        }
    }
}
