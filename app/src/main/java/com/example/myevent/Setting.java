package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;

public class Setting extends AppCompatActivity {

    public static boolean NightMode = false;

    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);



        SwitchCompat switchCompat = findViewById(R.id.switch_dark_mode);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                NightMode = isChecked;
                int delaytime = 200;
                buttonView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(NightMode){
                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        } else {
                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        }
                    }
                }, delaytime);
            }
        });
    }

    public void profil(View view) {
        Intent a = new Intent(getApplicationContext(),Profil.class);
        startActivity(a);
    }

    public void fb(View view) {
        Intent feedback = new Intent(getApplicationContext(),Feedback.class);
        startActivity(feedback);
    }
}
