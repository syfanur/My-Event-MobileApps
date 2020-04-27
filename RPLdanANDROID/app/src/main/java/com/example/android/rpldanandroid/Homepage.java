package com.example.android.rpldanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class Homepage extends AppCompatActivity {

    SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(1);
        setSliderViews();

        ImageButton button = findViewById(R.id.bt_art);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, Exhibiton.class);
                startActivity(intent);
            }
        });
    }

    private void setSliderViews() {
        for (int i = 0; i<=3; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.ic_slide1);
                    sliderView.setDescription("Best Event 1");
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.ic_slide2);
                    sliderView.setDescription("Best Event 2");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.ic_slide3);
                    sliderView.setDescription("");
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.ic_slide4);
                    sliderView.setDescription("");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(Homepage.this, "This is best event " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);
        }
    }

    public void ButtonSignOut(View view) {

        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();
    }

}