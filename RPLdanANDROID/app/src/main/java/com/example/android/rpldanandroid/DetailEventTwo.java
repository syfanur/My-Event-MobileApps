package com.example.android.rpldanandroid;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailEventTwo extends AppCompatActivity {

    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event_two);

        mDialog = new Dialog(this);
    }

    public void ButtonCancel(View view) {
        mDialog.setContentView(R.layout.activity_popup_cancel_event);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.show();
    }

    public void ButtonYesCancel(View view) {
        Intent yc = new Intent(DetailEventTwo.this, Exhibiton.class);
        startActivity(yc);
    }

    public void ButtonNoCancel(View view) {
        mDialog.cancel();
    }

    public void ButtonBack(View view) {
        Intent bck = new Intent(DetailEventTwo.this, Exhibiton.class);
        startActivity(bck);
    }
}

