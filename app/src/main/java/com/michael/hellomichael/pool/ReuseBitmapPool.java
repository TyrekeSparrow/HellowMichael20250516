package com.michael.hellomichael.pool;

import android.graphics.Bitmap;
import android.util.Log;

import com.michael.hellomichael.tag.Tag;
import com.michael.hellomichael.util.BitmapUtil;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Cache BitmapPath
 */
public class ReuseBitmapPool {
    private static final HashSet<Bitmap> IDLE_BITMAPS = new HashSet<Bitmap>();
    private static final HashMap<Bitmap, String> USE_BITMAPS = new HashMap<Bitmap, String>();

    public static Bitmap requestIdleInBitmap(String path, int width, int height) {
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------ requestIdleInBitmap");
        Bitmap inBitmap = null;
        // get from idle bitmaps
        inBitmap = getIdleBitmap(width, height);

        if (inBitmap == null) {
            // generate new inBitmap
            inBitmap = BitmapUtil.generateBitmap(width, height);
        }

        // cache inBitmap path
        if (inBitmap != null) {
            // update use bitmap with new path
            updateInBitmapPath(inBitmap, path);
        }

        return inBitmap;
    }

    private static Bitmap getIdleBitmap(int width, int height) {
        Bitmap inBitmap = null;
        if (IDLE_BITMAPS.size() > 0) {
            Bitmap idleBitmap = null;
            for (Bitmap bitmap : IDLE_BITMAPS) {
                if (BitmapUtil.isSizeOK(bitmap, width, height)) {
                    idleBitmap = bitmap;
                }
            }
            if (idleBitmap != null) {
                // remove idle bitmap
                IDLE_BITMAPS.remove(idleBitmap);
                inBitmap = idleBitmap;
            }
        }
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------ getIdleBitmap inBitmap = " + inBitmap);
        return inBitmap;
    }

    public static String getInBitmapPath(Bitmap inBitmap) {
        if (inBitmap != null) {
            return USE_BITMAPS.get(inBitmap);
        } else {
            return null;
        }
    }

    public static void updateInBitmapPath(Bitmap inBitmap, String imagePath) {
        if (inBitmap != null && imagePath != null) {
            USE_BITMAPS.put(inBitmap, imagePath);
        }
    }


    // add inBitmap idle state
    public static void updateInBitmapIdle(Bitmap inBitmap, String path) {
        if (inBitmap != null && path != null) {
            if (USE_BITMAPS.get(inBitmap) != null && USE_BITMAPS.get(inBitmap).equals(path)) {
                if (!IDLE_BITMAPS.contains(inBitmap)) {
                    Log.d(Tag.REUSE_IMAGE_VIEW, "--------------------- updateInBitmapIdle inBitmap = " + inBitmap);
                    IDLE_BITMAPS.add(inBitmap);
                }
            }
        }
    }

    public static void releaseInBitmap(Bitmap inBitmap, String imagePath) {
        if (inBitmap != null) {
            // remove from use bitmaps
            if (USE_BITMAPS.get(inBitmap) != null && imagePath != null && USE_BITMAPS.get(inBitmap).equals(imagePath)) {
                Log.d(Tag.REUSE_IMAGE_VIEW, "--------------------- real releaseInBitmap inBitmap = " + inBitmap);
                USE_BITMAPS.remove(inBitmap);
                // remove from idle bitmaps
                if (IDLE_BITMAPS.contains(inBitmap)) {
                    IDLE_BITMAPS.remove(inBitmap);
                }
            }
        }
    }



}
