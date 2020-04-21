package com.example.myevent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText surename, name, email, password;
    Button btn_regist;
    FirebaseDatabase database;
    DatabaseReference reference;
    Regis regis;
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
        regis = new Regis();

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override

                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        getValues();
                        reference.child("").setValue(regis);
                        Toast.makeText(MainActivity.this, "Data Berhasil ", Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


    }
private void getValues()
{
    regis.setSurename(surename.getText().toString());
    regis.setName(name.getText().toString());
    regis.setEmail(email.getText().toString());
    regis.setPass(password.getText().toString());
}
    public void btnInsert(View view) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues();
                reference.child("Regis01").setValue(regis);
                Toast.makeText(MainActivity.this, "Data Berhasil ", Toast.LENGTH_LONG);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

