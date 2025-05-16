package com.michael.hellomichael.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.michael.hellomichael.pool.ReuseBitmapPool;
import com.michael.hellomichael.display.ImageDisplayService;
import com.michael.hellomichael.tag.Tag;

import java.util.concurrent.Future;

public class ReuseImageView extends ImageView {
    private Bitmap mInBitmap;
    private String mImagePath;
    private int mImageWidth;
    private int mImageHeight;

    private Future<Boolean> mImageFuture;

    public void setParams(String path, int width, int height) {
        mImagePath = path;
        mImageWidth = width;
        mImageHeight = height;
    }

    public ReuseImageView(Context context) {
        super(context);
    }

    public ReuseImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ReuseImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ReuseImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);

        Log.d(Tag.REUSE_IMAGE_VIEW, "ReuseImageView onVisibilityChanged visibility = " + visibility);

        if (visibility == VISIBLE) {
            onDisplay();
        } else {
            onHide();
        }
    }

    private void onDisplay() {
        // recovery bitmap
        Log.d(Tag.REUSE_IMAGE_VIEW, "_________________ onDisplay image id = " + getId());

        // if image path not null && inBitmap not null,
        displayImage();
    }

    private void onHide() {
        // release bitmap
        Log.d(Tag.REUSE_IMAGE_VIEW, "_________________onHide image id = " + getId());
        // remove inBitmap from use to idle
        updateInBitmapIdle();
    }

    private boolean hasImageSource() {
        boolean hasImage = mImagePath != null && mImagePath.length() > 0;
        Log.d(Tag.REUSE_IMAGE_VIEW, "hasImageSource = " + hasImage);
        return hasImage;
    }

    public void displayImage() {
//        Log.d(Tag.REUSE_IMAGE_VIEW, "_________________displayImage mBitmapPath = " + mInBitmap);
        if (!hasImageSource()) {
            return;
        }

        if (mInBitmap == null) {
            // generate new inBitmap
            displayImageFirst();
        } else {
            // check inBitmap path
            checkDisplayImage();
        }
    }

    private void checkDisplayImage() {
        if (mInBitmap != null && mImagePath != null) {
            String inBitmapPath = ReuseBitmapPool.getInBitmapPath(mInBitmap);
            if (inBitmapPath != null && inBitmapPath.equals(mImagePath)) {
                // do nothing;
                Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ checkDisplayImage inBitmapPath no changed = " + inBitmapPath);
            } else {
                // if path changed, update path, display image
                displayImageRecovery();
            }
        }
    }

    /*
    private void checkInBitmapPath() {
        if (mInBitmap != null && mImagePath != null) {
            String inBitmapPath = ReuseBitmapPool.getInBitmapPath(mInBitmap);
            if (inBitmapPath != null && inBitmapPath.equals(mImagePath)) {
                // do nothing;
                Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ checkInBitmapPath inBitmapPath no changed = " + inBitmapPath);
            } else {
                // if path changed, update path, display image

            }
        }
    }
    */

    private void displayImageFirst() {
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------displayImageFirst mImagePath = " + mImagePath);
        mInBitmap = ReuseBitmapPool.requestIdleInBitmap(mImagePath, mImageWidth, mImageHeight);
        displayImageFuture();
    }

    private void displayImageRecovery() {
//        ReuseBitmapPool.updateInBitmapPath(mInBitmap, mImagePath);
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------displayImageRecovery mImagePath = " + mImagePath);
        displayImageFuture();
    }

    private void displayImageFuture() {
        mImageFuture = ImageDisplayService.displayImage(this, mImagePath, mInBitmap);
    }

    public void cancelDisplay() {
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ mImageFuture = " + mImageFuture);
        if (mImageFuture != null) {
            Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ cancelDisplay mImagePath = " + mImagePath);
            mImageFuture.cancel(true);
        }
    }

    private void updateInBitmapIdle() {
        if (mInBitmap != null && mImagePath != null) {
            ReuseBitmapPool.updateInBitmapIdle(mInBitmap, mImagePath);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ ReuseImageView onDraw id = " + getId());
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ ReuseImageView onDraw mInBitmap = " + mInBitmap);
        Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ ReuseImageView onDraw mImagePath = " + mImagePath);



        // if inBitmap no changed, draw image
        // else, do not draw
        if (mInBitmap != null && mImagePath != null) {
            String inBitmapPath = ReuseBitmapPool.getInBitmapPath(mInBitmap);
            Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ ReuseImageView onDraw inBitmapPath = " + inBitmapPath);
            if (inBitmapPath != null && inBitmapPath.equals(mImagePath)) {
                Log.d(Tag.REUSE_IMAGE_VIEW, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  ReuseImageView super.onDraw id = " + getId());
                // only draw here
                super.onDraw(canvas);
            } else {
                // if path changed, do nothing
                Log.d(Tag.REUSE_IMAGE_VIEW, "------------------------------------------------------------ ReuseImageView do not draw!!!!!!!!!!!!!! id = " + getId());
                return;
            }
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(Tag.REUSE_IMAGE_VIEW, "--------------------- ReuseImageView onAttachedToWindow");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(Tag.REUSE_IMAGE_VIEW, "--------------------- ReuseImageView onDetachedFromWindow");
        // release inBitmap
        releaseInBitmap();
    }

    private void releaseInBitmap() {
        // remove inBitmap from pool
        if (mInBitmap != null) {
            ReuseBitmapPool.releaseInBitmap(mInBitmap, mImagePath);
        }
        mInBitmap = null;
    }
}
