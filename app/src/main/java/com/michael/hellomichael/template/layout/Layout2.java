package com.michael.hellomichael.template.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout2 extends BaseLayout {
    public Layout2(Context context) {
        super(context);
        setBackgroundColor(Color.MAGENTA);
        setText("bean222");
    }

    public Layout2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Layout2(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
