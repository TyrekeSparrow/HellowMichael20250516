package com.michael.hellomichael.display;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.michael.hellomichael.pool.ReuseBitmapPool;
import com.michael.hellomichael.view.ReuseImageView;
import com.michael.hellomichael.tag.Tag;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


// TODO display future
public class ImageDisplayService {

    private static final ExecutorService mDecodeService = Executors.newSingleThreadExecutor();

    public static Future<Boolean> displayImage(ReuseImageView imageView, String imagePath, Bitmap inBitmap) {
        ImageDisplayRunnable runnable = new ImageDisplayRunnable(imageView, imagePath, inBitmap);



        Future<Boolean> future = mDecodeService.submit(runnable, true);
//        future.cancel(true);
        return future;



        /*
        mDecodeService.execute(new Runnable() {
            @Override
            public void run() {
                displayImageImpl(imageView, imagePath, inBitmap);
            }
        });
        */


    }




}
