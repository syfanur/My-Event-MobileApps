package com.example.android.rpldanandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private static final String FILE_NAME = "Users";
    private EditText editEmail, editPassword;
    private CheckBox remember;
   ImageButton imageButton;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.text_email);
        editPassword = findViewById(R.id.text_pass);
        remember = findViewById(R.id.rb_remember);
        imageButton = findViewById(R.id.bt_login);

        mAuth = FirebaseAuth.getInstance();

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String email = sharedPreferences.getString("Email Address", "");
        String pass = sharedPreferences.getString("Password", "");

        editEmail.setText(email);
        editPassword.setText(pass);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startSignIn();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {

                    startActivity(new Intent(Login.this, Homepage.class));

                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn(){
        String emailField = editEmail.getText().toString();
        String passwordField = editPassword.getText().toString();

        if(emailField.isEmpty()){
            editEmail.setError("Email is required");
            editEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailField).matches()){
            editEmail.setError("Please enter a valid email");
            editEmail.requestFocus();
            return;
        }

        if(passwordField.isEmpty()){
            editPassword.setError("Password is required");
            editPassword.requestFocus();
            return;
        }

        if(passwordField.length() < 6){
            editPassword.setError("Minimum lenght of password should be 6");
            editPassword.requestFocus();
            return;
        }

            mAuth.signInWithEmailAndPassword(emailField, passwordField).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent intent = new Intent(Login.this, Homepage.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        if (remember.isChecked()) {
            StoredDataUsingSharedPref(emailField, passwordField);
        }
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

