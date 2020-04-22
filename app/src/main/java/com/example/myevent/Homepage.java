package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Homepage extends AppCompatActivity {

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.ic_slide1, R.drawable.ic_slide2, R.drawable.ic_slide3, R.drawable.ic_slide4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);


        }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };



    public void musik(View view) {
        Intent music = new Intent(Homepage.this, ListEvent.class);
        startActivity(music);
    }

    public void education(View view) {
        Intent edu = new Intent(Homepage.this, Education.class);
        startActivity(edu);
    }

    public void exh(View view) {
        Intent exh = new Intent(Homepage.this, ListExhibition.class);
        startActivity(exh);
    }
}
