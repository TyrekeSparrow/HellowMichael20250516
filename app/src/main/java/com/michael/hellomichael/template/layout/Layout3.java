package com.michael.hellomichael.template.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout3 extends BaseLayout {
    public Layout3(Context context, String content) {
        super(context);
        setBackgroundColor(Color.YELLOW);
        setText("layout3" + content);
    }

    public Layout3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Layout3(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
