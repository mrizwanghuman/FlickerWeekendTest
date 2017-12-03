package com.example.admin.flickerweekendtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SmallImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_image);
        Intent intent = getIntent();
        String imageSrc =intent.getStringExtra("Image");
        Log.d("TAG", "onCreate: "+imageSrc);
        ImageView smallImageView = findViewById(R.id.small_image);
        Glide.with(this).load(imageSrc).into(smallImageView);
    }
}
