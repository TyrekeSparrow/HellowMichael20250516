package com.michael.hellomichael.auto;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.michael.hellomichael.ioc.IBeanLayout;

public class AuthorLayout extends LinearLayout implements IBeanLayout {
    public AuthorLayout(Context context) {
        super(context);
    }

    public AuthorLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AuthorLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AuthorLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void setBean(Object bean) {
        // TODO



    }
}
