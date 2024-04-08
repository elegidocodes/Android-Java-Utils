package com.elegidocodes.android.java.utils.layout;

import android.content.Context;
import android.content.res.Configuration;

import com.elegidocodes.android.java.utils.dimension.ScreenUtil;

public class GridLayoutUtil {

    /**
     * Retrieves the span count based on the device's current orientation.
     *
     * @param context   The context of the application.
     * @param landscape The span count to use when the device is in landscape orientation.
     * @param portrait  The span count to use when the device is in portrait orientation.
     * @return The appropriate span count based on the device's orientation.
     */
    public static int getSpanCount(Context context,
                                   int landscape,
                                   int portrait) {
        int orientation = context.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return landscape;
        } else {
            return portrait;
        }
    }

    /**
     * Retrieves the span count based on the device's current orientation and type.
     *
     * @param context    The context of the application.
     * @param responsive Determines if the span count should be responsive to device type (tablet or phone).
     * @param landscape  The span count to use when the device is in landscape orientation.
     * @param portrait   The span count to use when the device is in portrait orientation.
     * @return The appropriate span count based on the device's orientation and type.
     */
    public static int getSpanCountWithResponsiveBehavior(Context context,
                                                         boolean responsive,
                                                         int landscape,
                                                         int portrait) {
        if (responsive) {
            if (ScreenUtil.isTablet(context)) {
                // The device is a tablet
                return getSpanCount(context, landscape * 2, portrait * 2);
            } else {
                // The device is a phone
                return getSpanCount(context, landscape, portrait);
            }
        } else {
            return getSpanCount(context, landscape, portrait);
        }
    }

}
