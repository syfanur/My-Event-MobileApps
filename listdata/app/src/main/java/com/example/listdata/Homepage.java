//package com.example.listdata;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.smarteist.autoimageslider.DefaultSliderView;
//import com.smarteist.autoimageslider.IndicatorAnimations;
//import com.smarteist.autoimageslider.SliderLayout;
//import com.smarteist.autoimageslider.SliderView;
//
//public class Homepage extends AppCompatActivity {
//
//    SliderLayout sliderLayout;
//
//    BottomNavigationView bottomNavigationView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_homepage);
//        sliderLayout = findViewById(R.id.slider_hmpg);
//        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
//        sliderLayout.setScrollTimeInSec(1);
//        setSliderViews();
//
//        bottomNavigationView = findViewById(R.id.BottomNav);
//
//        if(savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
//        }
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment = null;
//
//                switch (item.getItemId()) {
//                    case R.id.bt_home:
//                        fragment = new HomeFragment();
//                        break;
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
//                return true;
//            }
//        });
//    }
//
//    private void setSliderViews(){
//        for (int i = 0; i <= 3; i++){
//            DefaultSliderView sliderView = new DefaultSliderView(this);
//
//            switch (i){
//                case 0:
//                    sliderView.setImageDrawable(R.drawable.ic_slide1);
//                    sliderView.setDescription("Seminar Leadership");
//                    break;
//                case 1:
//                    sliderView.setImageDrawable(R.drawable.ic_slide2);
//                    sliderView.setDescription("Dalawampu Varnamaya");
//                    break;
//                case 2:
//                    sliderView.setImageDrawable(R.drawable.ic_slide3);
//                    sliderView.setDescription("Seminar Bisnis");
//                    break;
//                case 3:
//                    sliderView.setImageDrawable(R.drawable.ic_slide4);
//                    sliderView.setDescription("Archatala");
//                    break;
//            }
//
//            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
//            final int finalI = i;
//            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
//                @Override
//                public void onSliderClick(SliderView sliderView) {
//                    Toast.makeText(Homepage.this, "This is Best Event" + (finalI + 1), Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            sliderLayout.addSliderView(sliderView);
//        }
//    }
//
//    public void ButtonArt(View view) {
//        Intent art = new Intent(Homepage.this, Exhibiton.class);
//        startActivity(art);
//    }
//
//
//    public void ButtonSignOut(View view) {
//        Intent intent = new Intent(getApplicationContext(),Login.class);
//        startActivity(intent);
//    }
//}
