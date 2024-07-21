package com.elegido.android.java.utils.network;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class UrlUtil {

    public static boolean isUrl(String data) {
        return data != null && (data.startsWith("http://") || data.startsWith("https://"));
    }

    public static void openUrl(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }

}
