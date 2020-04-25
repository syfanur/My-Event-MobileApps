package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText surename, name, email, password;
    Button btn_regist;
    FirebaseDatabase database;
    DatabaseReference reference;
    class_regis regis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        surename = (EditText) findViewById(R.id.surename);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.Pass);
        btn_regist = (Button) findViewById(R.id.btn_insert);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Register");
        regis = new class_regis();

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        getValues();
                        reference.child(String.valueOf(""+1)).setValue(regis);
                        Toast.makeText(Register.this, "Data Berhasil ", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    private void getValues()
    {
        regis.setSurename(surename.getText().toString());
        regis.setName(name.getText().toString());
        regis.setEmail(email.getText().toString());
        regis.setPass(password.getText().toString());
    }

    public void btn_insert(View view) {
    }
//    public void btn_insert(View view) {
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                getValues();
//                reference.child("Register").setValue(regis);
//                Toast.makeText(Register.this, "Data Berhasil ", Toast.LENGTH_LONG);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }

