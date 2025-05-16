package com.michael.hellomichael.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.michael.hellomichael.R;

public class HelloMainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hellomain);

        final View button = findViewById(R.id.startbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelloMainActivity.this, BitmapDisplayActivity.class));
            }
        });


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 666);



















    }

    public void startImageListActivity(View view) {
        startActivity(new Intent(this, ImageListActivity.class));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "requestCode = " + requestCode);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "permissions length = " + permissions.length);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "grantResults 0 = " + grantResults[0]);
//        Log.d(Tag.REUSE_IMAGE_VIEW, "grantResults 1 = " + grantResults[1]);
//
//
//
//        Log.d(Tag.REUSE_IMAGE_VIEW, "getExternalStorageState = " + Environment.getExternalStorageState());
//        Log.d(Tag.REUSE_IMAGE_VIEW, "getExternalStorageDirectory = " + Environment.getExternalStorageDirectory().getPath());
//        Log.d(Tag.REUSE_IMAGE_VIEW, "getExternalStorageDirectory NetworkData.PATH = " + Environment.getExternalStorageState(new File(NetworkData.PATH)));


//        Log.d(Tag.REUSE_IMAGE_VIEW, "getExternalStorageDirectory DIRECTORY_DCIM = " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
//        Log.d(Tag.REUSE_IMAGE_VIEW, "getExternalStorageDirectory DIRECTORY_DOWNLOADS = " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath());
//        Log.d(Tag.REUSE_IMAGE_VIEW, "getExternalStorageDirectory DIRECTORY_PICTURES = " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath());


    }


}
