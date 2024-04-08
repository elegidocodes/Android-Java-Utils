package com.elegidocodes.android.java.utils.dimension;

import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenUtil {

    // Minimum diagonal size considered as a tablet (in inches)
    private static final double TABLET_MINIMUM_DIAGONAL = 6.5;

    /**
     * Determines whether the device is a tablet based on its screen size.
     *
     * @param context The context of the application.
     * @return True if the device is a tablet, false otherwise.
     */
    public static boolean isTablet(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float widthInches = metrics.widthPixels / metrics.xdpi;
        float heightInches = metrics.heightPixels / metrics.ydpi;
        double diagonalInches = Math.sqrt(Math.pow(widthInches, 2) + Math.pow(heightInches, 2));

        return diagonalInches >= TABLET_MINIMUM_DIAGONAL;
    }

    /**
     * Retrieves the height of the device's screen in pixels.
     *
     * @param context The context of the application.
     * @return The height of the device's screen in pixels.
     */
    public static float getDeviceHeight(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }

    /**
     * Retrieves the width of the device's screen in pixels.
     *
     * @param context The context of the application.
     * @return The width of the device's screen in pixels.
     */
    public static float getDeviceWidth(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

}
