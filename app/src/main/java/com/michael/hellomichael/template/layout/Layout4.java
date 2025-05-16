package com.michael.hellomichael.template.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout4 extends BaseLayout {
    public Layout4(Context context) {
        super(context);
        setBackgroundColor(Color.GRAY);
        setText("bean444");
    }

    public Layout4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Layout4(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
