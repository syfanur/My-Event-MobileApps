package com.example.android.rpldanandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private static final String FILE_NAME = "User";
    EditText editEmail, editPassword;
    CheckBox remember;
    ImageButton btsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.text_email);
        editPassword = findViewById(R.id.text_pass);
        remember = findViewById(R.id.rb_remember);
        btsignup = findViewById(R.id.bt_login);
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String email = sharedPreferences.getString("Email Address","");
        String pass = sharedPreferences.getString("Password","");

        editEmail.setText(email);
        editPassword.setText(pass);
        btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String pass = editPassword.getText().toString();

                if (remember.isChecked()) {
                    StoredDataUsingSharedPref(email, pass);
                }

                Intent intent =new Intent(Login.this, Homepage.class);
                startActivity(intent);
        }
        });
    }

    private void StoredDataUsingSharedPref(String emailadd, String pwd){
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
        editor.putString("Email Address",emailadd);
        editor.putString("Password",pwd);
        editor.apply();
    }

    public void RegistHere(View view) {
    }

    public void ForgotPassword(View view) {
    }

}

