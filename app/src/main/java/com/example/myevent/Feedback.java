package com.example.myevent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Feedback extends AppCompatActivity {
    private Button BtFeedback;
    private TextInputEditText textFeedback;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_feedback);

        BtFeedback = (Button) findViewById(R.id.bt_feedback);
        textFeedback = (TextInputEditText) findViewById(R.id.txtFeedback);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Feedback");
        BtFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        getValues();
                        reference.child("Surat Feedback").setValue(textFeedback.getText().toString());
                        Toast.makeText(Feedback.this, "Data Berhasil ", Toast.LENGTH_LONG).show();
                    }

                    private void getValues() {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }


    public void btn_insert(View view) {
    }
}