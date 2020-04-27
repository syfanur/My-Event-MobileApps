package com.example.android.rpldanandroid;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailEvent extends AppCompatActivity {

    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);
        mDialog = new Dialog(this);
    }

    public void ButtonHome(View view) {
        startActivity(new Intent(DetailEvent.this, Exhibiton.class));
    }

    public void ButtonHadir(View view) {
        mDialog.setContentView(R.layout.activity_popup_going_event);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }

    public void ButtonYes(View view) {
        Intent y = new Intent(DetailEvent.this, DetailEventTwo.class);
        startActivity(y);
    }

    public void ButtonNo(View view) {
        Intent n = new Intent(DetailEvent.this, Exhibiton.class);
        startActivity(n);
    }
}

