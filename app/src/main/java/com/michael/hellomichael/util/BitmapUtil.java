package com.michael.hellomichael.util;

import android.graphics.Bitmap;
import android.util.Log;

import com.michael.hellomichael.tag.Tag;

public class BitmapUtil {
    public static Bitmap generateBitmap(int width, int height) {
        Log.d(Tag.REUSE_IMAGE_VIEW, "@@@@@@@@@@@@@@ generateBitmap width = " + width);
        Log.d(Tag.REUSE_IMAGE_VIEW, "@@@@@@@@@@@@@@ generateBitmap height = " + height);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        return bitmap;
    }

    public static boolean isSizeOK(Bitmap idleBitmap, int width, int height) {
        if (idleBitmap != null && idleBitmap.getWidth() * idleBitmap.getHeight() >= width * height) {
            return true;
        }
        return false;
    }


}
