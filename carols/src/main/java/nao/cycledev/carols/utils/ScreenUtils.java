package nao.cycledev.carols.utils;

import android.content.Context;
import android.content.res.Configuration;

public class ScreenUtils {

    // For test
    public static boolean isScreenSizeLarge(){
        return true;
    }

    public static boolean isScreenSizeLarge(Context context){
        return ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
    }
}
