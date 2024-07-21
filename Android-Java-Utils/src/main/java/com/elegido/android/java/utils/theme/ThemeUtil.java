package com.elegido.android.java.utils.theme;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class ThemeUtil {

    public static final String LOG_TAG = "THEME_UTIL";

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
                Log.d(LOG_TAG, String.valueOf(backgroundColor));
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
     * @param lightColor         The color to use when dark mode is not enabled.
     * @param lightBackground    The background color to use when dark mode is not enabled.
     * @param darkColor          The color to use when dark mode is enabled.
     * @param darkBackground     The background color to use when dark mode is enabled.
     */
    public static void setSwipeRefreshLayoutTheme(SwipeRefreshLayout swipeRefreshLayout,
                                                  int lightColor, int lightBackground,
                                                  int darkColor, int darkBackground) {
        Context context = swipeRefreshLayout.getContext();

        if (isDarkModeEnabled(context)) {
            swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context, darkColor));
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(context, darkBackground));
        } else {
            swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context, lightColor));
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(context, lightBackground));
        }
    }

}
