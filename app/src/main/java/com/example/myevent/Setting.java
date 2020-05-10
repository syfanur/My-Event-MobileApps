package com.example.myevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import io.paperdb.Paper;


public class Setting extends AppCompatActivity {
    public Activity activity;
    TextView mTextView, mTextView2, mTextView3, mTextView4, mTextView5;
    Spinner mLanguage;
    public static boolean NightMode = false;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));

    }


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


        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.close_settings_btn);
        mTextView5 = (TextView) findViewById(R.id.deskripsi);
//        mTextView5 = (TextView) activity.findViewById(R.id.text_eventforyou);

        Paper.init(this);
        String language = Paper.book().read("language");
        if(language==null){
            Paper.book().write("language", "en");

            updateView((String)Paper.book().read("language"));
        }

    }

    private void updateView(String language) {
        Context context = LocaleHelper.setLocale(this,language);
        Resources resources = context.getResources();
        mTextView.setText(resources.getString(R.string.text_setting));
        mTextView2.setText(resources.getString(R.string.tentang));
        mTextView3.setText(resources.getString(R.string.text_tema));
        mTextView4.setText(resources.getString(R.string.close));
        mTextView5.setText(resources.getString(R.string.desc));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.language_en){
            Paper.book().write("language", "en");
            updateView((String)Paper.book().read("language"));
        } else if(item.getItemId() == R.id.language_id){
            Paper.book().write("language", "in");
            updateView((String)Paper.book().read("language"));
        } else if(item.getItemId() == R.id.language_sa){
            Paper.book().write("language", "ar");
            updateView((String)Paper.book().read("language"));
        } else if(item.getItemId() == R.id.language_kr){
            Paper.book().write("language", "ko");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }

    public void profil(View view) {
        Intent a = new Intent(getApplicationContext(),Editprofile.class);
        startActivity(a);
    }

    public void kembali(View view) {
        Intent uwu = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(uwu);
    }

    public void feedback(View view) {
        Intent uwaw = new Intent(getApplicationContext(),Feedback.class);
        startActivity(uwaw);
    }
}
