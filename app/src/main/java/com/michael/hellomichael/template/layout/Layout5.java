package com.michael.hellomichael.template.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class Layout5 extends BaseLayout {
    public Layout5(Context context, String content) {
        super(context);
        setBackgroundColor(Color.RED);
        setText("layout5" + content);
    }

    public Layout5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout5(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Layout5(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


}
