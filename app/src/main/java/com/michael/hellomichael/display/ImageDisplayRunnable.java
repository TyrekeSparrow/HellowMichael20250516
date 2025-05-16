package com.michael.hellomichael.display;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.michael.hellomichael.data.PicData;
import com.michael.hellomichael.pool.ReuseBitmapPool;
import com.michael.hellomichael.tag.Tag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageDisplayRunnable implements Runnable{
    public final ImageView imageView;
    public final String imagePath;
    public final Bitmap inBitmap;

    public ImageDisplayRunnable(ImageView imageView, String imagePath, Bitmap inBitmap) {
        this.imageView = imageView;
        this.imagePath = imagePath;
        this.inBitmap = inBitmap;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj != null && obj instanceof ImageDisplayRunnable) {
            ImageDisplayRunnable newRunnable = (ImageDisplayRunnable) obj;
            if (newRunnable.imageView != null && newRunnable.imagePath != null && newRunnable.imageView == imageView && newRunnable.imagePath.equals(imagePath)) {
                return true;
            }
        }
        return false;
    }



    @Override
    public void run() {
        try {
//            int count = 10;
//            int i = 0;


//            while (i++ < count) {
                displayImageImpl();
//            }

        } catch (InterruptedException e) {
            Log.d(Tag.REUSE_IMAGE_VIEW, "displayImageImpl cancel");

//            throw new RuntimeException(e);
        }
    }



    private void displayImageImpl () throws InterruptedException {

//        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ displayImageImpl Thread.interrupted() = " + Thread.interrupted());

        // decode image
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inBitmap = inBitmap;



        Log.d(Tag.REUSE_IMAGE_VIEW, "--------------------- downloading image start ---------------------");
//        try {
//            Thread.sleep(19 * 1000);
//        } catch (InterruptedException e) {
//
//            Log.d(Tag.REUSE_IMAGE_VIEW, "-------------------- sleep InterruptedException e = " + e.getMessage());
//            Log.d(Tag.REUSE_IMAGE_VIEW, "-------------------- sleep Thread.interrupted() = " + Thread.interrupted());
//
//            throw new InterruptedException("downloading image");
//        }



//        boolean isInterrupted = false;
//        do {
//            isInterrupted = Thread.interrupted();
//            Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ displayImageImpl isInterrupted = " + isInterrupted);
//        } while(!isInterrupted);


        // TODO download file

        String networkPath = imagePath;
//        Log.d(Tag.REUSE_IMAGE_VIEW, "Environment.getExternalStorageDirectory() = " + Environment.getExternalStorageDirectory());

        Log.d(Tag.REUSE_IMAGE_VIEW, "imageView.getContext().getExternalCacheDir() = " + imageView.getContext().getExternalCacheDir());

        String diskPath = imageView.getContext().getExternalCacheDir() + PicData.DISK_PATH;
        File diskFile = new File(diskPath);
        if (!diskFile.exists()) {
            try {
                diskFile.createNewFile();
            } catch (IOException e) {
//                throw new RuntimeException(e);
                Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ createNewFile exception = " + e.getMessage());
            }
        }


        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ displayImageImpl networkPath = " + networkPath);
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ displayImageImpl diskPath = " + diskPath);

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(networkPath);
            outputStream = new FileOutputStream(diskPath);

            // read byte to buffer
            // write byte to buffer
            int size = 50 * 1024;
            byte[] buffer = new byte[size];
            int length = -1;
            while ((length = inputStream.read(buffer)) != -123) {
                boolean isTreadInterrupted = Thread.interrupted();
                Log.d(Tag.REUSE_IMAGE_VIEW, "================== isTreadInterrupted = " + isTreadInterrupted);

                if (isTreadInterrupted) {
                    throw new InterruptedException("!!!!!!!!!!!!!!!!! downloading is interrupted!!!!!!!!!!!!!!!");
                }

                // TODO

                outputStream.write(buffer, 0, size);
                Log.d(Tag.REUSE_IMAGE_VIEW, "=============================== displayImageImpl download from network length = " + length);
            }
        } catch (FileNotFoundException e) {
            Log.d(Tag.REUSE_IMAGE_VIEW, "!!!!!!!!!!!!!!!!!!!!!!!! displayImageImpl FileNotFoundException = " + e.getMessage());
//            throw new RuntimeException(e);
        } catch (IOException e) {
            Log.d(Tag.REUSE_IMAGE_VIEW, "!!!!!!!!!!!!!!!!!!!!!!!! displayImageImpl IOException = " + e.getMessage());
//            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            Log.d(Tag.REUSE_IMAGE_VIEW, "!!!!!!!!!!!!!!!!!!!!!!!! displayImageImpl InterruptedException = " + e.getMessage());


        } catch (Exception e) {
            Log.d(Tag.REUSE_IMAGE_VIEW, "!!!!!!!!!!!!!!!!!!!!!!!! displayImageImpl InterruptedException = " + e.getMessage());
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
//                    throw new RuntimeException(e);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        Log.d(Tag.REUSE_IMAGE_VIEW, "--------------------- downloading image complete ---------------------");
//        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ displayImageImpl Thread.interrupted() = " + Thread.interrupted());



























        Bitmap bitmap = BitmapFactory.decodeFile(networkPath, options);





        // display image
        imageView.post(new Runnable() {
            @Override
            public void run() {
                if (imageView != null) {
                    Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ displayImageImpl bitmap = " + bitmap);
                    Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ displayImageImpl inBitmap = " + inBitmap);
                    imageView.setImageBitmap(bitmap);
                    ReuseBitmapPool.updateInBitmapPath(inBitmap, imagePath);
                }
            }
        });



    }

}
