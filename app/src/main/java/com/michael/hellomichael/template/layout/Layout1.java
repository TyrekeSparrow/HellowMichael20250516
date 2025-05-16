package com.michael.hellomichael.template.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout1 extends BaseLayout {
    public Layout1(Context context) {
        super(context);
        setBackgroundColor(Color.BLUE);
        setText("bean111");
    }

    public Layout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Layout1(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


}
