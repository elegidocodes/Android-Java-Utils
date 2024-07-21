package com.elegido.android.java.utils.animation;

import android.text.TextUtils;
import android.widget.TextView;

public class AnimationUtil {

    /**
     * Sets scroll animation for a single-line TextView. Set to -1 to repeat indefinitely.
     *
     * @param text   The TextView to apply the scroll animation to.
     * @param repeat The number of times the scroll animation should repeat.
     */
    public static void setScrollAnimationInSingleLine(TextView text, int repeat) {
        // Enable the scroll animation for the text
        text.setSelected(true);

        // Restrict the text to a single line
        text.setSingleLine(true);

        // Set ellipsize mode to trigger the scroll animation
        text.setEllipsize(TextUtils.TruncateAt.MARQUEE);

        // Set the number of times the scroll animation should repeat
        text.setMarqueeRepeatLimit(repeat);
    }

}
