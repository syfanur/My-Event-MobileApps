package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;


public class Setting extends AppCompatActivity {
    TextView mTextView, mTextView2, mTextView3;
    Spinner mLanguage;
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

        mLanguage = (Spinner) findViewById(R.id.spLanguage);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);

        mAdapter = new ArrayAdapter<String>(Setting.this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.bahasa_arrays));
        mLanguage.setAdapter(mAdapter);

        if (LocaleHelper.getLanguage(Setting.this).equalsIgnoreCase("en")) {
            mLanguage.setSelection(mAdapter.getPosition("English"));
        } else if (LocaleHelper.getLanguage(Setting.this).equalsIgnoreCase("in")) {
            mLanguage.setSelection(mAdapter.getPosition("Indonesian"));
        } else {
            mLanguage.setSelection(mAdapter.getPosition("Korean"));
        }

        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(Setting.this, "en");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text_setting));
                        mTextView2.setText(resources.getString(R.string.text_bahasa));
                        mTextView3.setText(resources.getString(R.string.text_tema));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(Setting.this, "in");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text_setting));
                        mTextView2.setText(resources.getString(R.string.text_bahasa));
                        mTextView3.setText(resources.getString(R.string.text_tema));
                        break;
                    case 2:
                        context = LocaleHelper.setLocale(Setting.this, "ko");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text_setting));
                        mTextView2.setText(resources.getString(R.string.text_bahasa));
                        mTextView3.setText(resources.getString(R.string.text_tema));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }





    public void profil(View view) {
        Intent a = new Intent(getApplicationContext(),Profil.class);
        startActivity(a);
    }
}
