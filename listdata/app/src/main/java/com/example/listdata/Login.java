//package com.example.listdata;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.ImageButton;
//
//public class Login extends AppCompatActivity {
//
//    private static final String FILE_NAME = "User Login";
//    EditText emailID, password;
//    ImageButton ibLogin;
//    CheckBox remember;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        emailID = findViewById(R.id.text_email);
//        password = findViewById(R.id.text_pass);
//        ibLogin = findViewById(R.id.bt_login);
//        remember = findViewById(R.id.rb_remember);
//        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
//        String email = sharedPreferences.getString("Email Address","");
//        String pass = sharedPreferences.getString("Password","");
//
//        emailID.setText(email);
//        password.setText(pass);
//
//        ibLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = emailID.getText().toString();
//                String pass = password.getText().toString();
//
//                if(remember.isChecked()){
//                    StoredDataUsingSharedPref(email, pass);
//                }
//                Intent intent = new Intent(getApplicationContext(),Homepage.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void StoredDataUsingSharedPref(String emailadd, String pwd){
//        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
//        editor.putString("Email Address",emailadd);
//        editor.putString("Password",pwd);
//        editor.apply();
//    }
//
//    public void RegistHere(View view) {
//    }
//
//    public void ForgotPassword(View view) {
//    }
//    public void IntentHomepage(View view){
//        Intent intent = new Intent(getApplicationContext(),Homepage.class);
//        startActivity(intent);
//    }
//}
