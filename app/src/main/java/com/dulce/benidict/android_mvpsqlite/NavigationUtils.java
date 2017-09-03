package com.dulce.benidict.android_mvpsqlite;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by benidict on 02/09/2017.
 */

@SuppressWarnings("WeakerAccess")
public class NavigationUtils {


    public static void startActivity(Context context, Intent intent){
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Class clazz,
                                     int flags){
        Intent intent = createIntentWithFlags(context, clazz, flags);
        startActivity(context, intent);
    }


    public static void startActivity(Context context, Class clazz,
     int flags, String wrapper){
        Intent intent = createIntentWithFlags(context, clazz, flags);
        intent.putExtra("detailWrapper", wrapper);
        startActivity(context, intent);
    }

    @NonNull
    public static Intent createIntentWithFlags(Context context, Class clazz,
                                               int flags){
        Intent intent = createIntent(context, clazz);
        intent.setFlags(flags);
        return intent;
    }

    @NonNull
    public static Intent createIntent(Context context, Class clazz){
        Intent intent = new Intent(context, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return intent;
    }
}
