package com.michael.hellomichael.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.michael.hellomichael.R;
import com.michael.hellomichael.server.ServerData;
import com.michael.hellomichael.view.ReuseImageView;

public class BitmapDisplayActivity extends Activity {
//    public static final String TAG = "BitmapReuse";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bitmap_recovery);
//        Log.d(TAG, "requestPermissions read");








//        ServerData.initData();
        initViews();

    }



    private ReuseImageView imageView1;

    private void initViews() {
        // init imageView
        // init wallpaperView1
        imageView1 = (ReuseImageView) findViewById(R.id.wallpaperview1);

//        Log.d(Tag.REUSE_IMAGE_VIEW, "================ getExternalCacheDir().getPath() = " + getExternalCacheDir().getPath());
//        String networkPath = Environment.getExternalStorageDirectory().getPath() + NetworkData.PATH;


        // init display button
        View displayButton = findViewById(R.id.display_image_button);
        displayButton. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display wallpaper1



//                String networkPath = Environment.getExternalStorageDirectory().getPath() + NetworkData.PATH;
                String networkPath = ServerData.PATH;
                imageView1.setParams(networkPath, ServerData.WIDTH, ServerData.HEIGHT);
                imageView1.displayImage();
            }
        });


        // init cancel button
        View cancelButton = findViewById(R.id.cancel_display_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO cancel display

                imageView1.cancelDisplay();










            }
        });






        // init reuse button
        View reuseButton = findViewById(R.id.start_reuse_activity_button);
        reuseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BitmapDisplayActivity.this.getApplicationContext(), BitmapReuseActivity.class));
            }
        });

    }






}
