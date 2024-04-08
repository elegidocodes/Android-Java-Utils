package com.elegidocodes.android.java.utils.theme;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Log;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class ThemeUtil {

    /**
     * Checks if dark mode is enabled in the current theme.
     *
     * @param context The context of the application.
     * @return True if dark mode is enabled, false otherwise.
     */
    public static boolean isDarkModeEnabled(Context context) {
        int nightMode = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return nightMode == Configuration.UI_MODE_NIGHT_YES;
    }

    /**
     * Retrieves the background color for dark mode.
     *
     * @param context The context of the application.
     * @return The background color for dark mode.
     */
    public static int getDarkModeBackgroundColor(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            try (TypedArray a = context.obtainStyledAttributes(new int[]{android.R.attr.windowBackground})) {
                int backgroundColor = a.getColor(0, 0);
                Log.d("Output message", String.valueOf(backgroundColor));
                //a.recycle();
                return backgroundColor;
            }
        } else {
            return -14935265; // Default background color for devices with lower SDK versions
        }
    }

    /**
     * Sets colors for the SwipeRefreshLayout based on the current theme.
     *
     * @param swipeRefreshLayout The SwipeRefreshLayout to set colors for.
     * @param dayColor           The color to use when dark mode is not enabled.
     * @param nightColor         The color to use when dark mode is enabled.
     * @param dayBackground      The background color to use when dark mode is not enabled.
     * @param nightBackground    The background color to use when dark mode is enabled.
     */
    public static void setSwipeRefreshLayoutDarkMode(SwipeRefreshLayout swipeRefreshLayout,
                                                     int dayColor,
                                                     int nightColor,
                                                     int dayBackground,
                                                     int nightBackground) {
        Context context = swipeRefreshLayout.getContext();
        if (isDarkModeEnabled(context)) {
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(context.getColor(nightBackground));
            swipeRefreshLayout.setColorSchemeColors(context.getColor(nightColor));
        } else {
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(context.getColor(dayBackground));
            swipeRefreshLayout.setColorSchemeColors(context.getColor(dayColor));
        }
    }

}
