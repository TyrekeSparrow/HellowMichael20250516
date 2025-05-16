package com.michael.hellomichael.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.michael.hellomichael.data.PicData;
import com.michael.hellomichael.R;
import com.michael.hellomichael.view.ReuseImageView;

public class BitmapReuseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bitmap_reuse);

        initViews();


    }

    private void initViews() {
        View view = findViewById(R.id.reuse_image_button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayImage11();
            }
        });
    }

    private void displayImage11() {
        ReuseImageView reuseImageView = (ReuseImageView) findViewById(R.id.reuse_image_view1);
//        reuseImageView.setParams(PicData.ULR11, PicData.IMAGE11_WIDTH, PicData.IMAGE11_HEIGHT);
//        reuseImageView.displayImage();
    }




}
