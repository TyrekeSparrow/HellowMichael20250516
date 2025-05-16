package com.michael.hellomichael.template.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.michael.hellomichael.tag.Tag;

public class BaseLayout extends TextView {

    public BaseLayout(Context context) {
        super(context);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "=================== getResources().getDisplayMetrics().densityDpi = " + getResources().getDisplayMetrics().densityDpi);
//        setHeight(200 * getResources().getDisplayMetrics().densityDpi);
        setHeight(500);
    }

    public BaseLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Log.d(Tag.REUSE_IMAGE_VIEW, "this = " + this + " visibility = " + visibility);
    }
}
