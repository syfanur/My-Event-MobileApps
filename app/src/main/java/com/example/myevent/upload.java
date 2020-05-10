package com.example.myevent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class upload extends AppCompatActivity {

    private static final int REQUEST_CODE_IMAGE = 101;
    private ImageView imageView;
    private EditText inputJudul;
    private EditText inputAlamat;
    private EditText inputTanggal;
    private EditText inputHarga;
    private EditText inputDesc;
    private EditText inputJam;
    private EditText inputPenyelenggara;
    private TextView textViewProgress;
    private ProgressBar progressBar;
    private Button btnUpload;
    private ProgressDialog loadingBar;

    Uri imageUri;
    boolean isImageAdded = false;

    DatabaseReference DataRef;
    StorageReference StorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);

        btnUpload = (Button) findViewById(R.id.btnUpload);
        imageView = findViewById(R.id.ImageView);
        inputJudul = findViewById(R.id.inputJudul);
        inputAlamat = findViewById(R.id.inputAlamat);
        inputTanggal = findViewById(R.id.inputTanggal);
        inputHarga = findViewById(R.id.inputHarga);
        inputDesc = findViewById(R.id.inputDesc);
        inputJam = findViewById(R.id.inputJam);
        inputPenyelenggara = findViewById(R.id.inputPenyelenggara);
        textViewProgress = findViewById(R.id.textViewProgress);
        progressBar = findViewById(R.id.progressBar);
        btnUpload = findViewById(R.id.btnUpload);
        loadingBar = new ProgressDialog(this);

        textViewProgress.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

//        DataRef = FirebaseDatabase.getInstance().getReference().child("Exhibition");
        StorageRef = FirebaseStorage.getInstance().getReference().child("Request");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
            }
        });
    }


    private void CreateAccount() {
        final String judulImage = inputJudul.getText().toString();
        final String alamatImage = inputAlamat.getText().toString();
        final String tanggalImage = inputTanggal.getText().toString();
        final String hargaImage = inputHarga.getText().toString();
        final String descImage = inputDesc.getText().toString();
        final String jamImage = inputJam.getText().toString();
        final String penyelenggaraImage = inputPenyelenggara.getText().toString();

        if (TextUtils.isEmpty(judulImage)) {
            Toast.makeText(this, "Please write your title...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(alamatImage)) {
            Toast.makeText(this, "Please write your url...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(tanggalImage)) {
            Toast.makeText(this, "Please write your date...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(hargaImage)) {
            Toast.makeText(this, "Please confirm your price...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(descImage)) {
            Toast.makeText(this, "Please write your full desc...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(jamImage)) {
            Toast.makeText(this, "Please write your full time...", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(penyelenggaraImage)) {
            Toast.makeText(this, "Please write your full owner...", Toast.LENGTH_SHORT).show();
        } else {
            loadingBar.setTitle("Upload New Event");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidatePhone(judulImage, alamatImage, tanggalImage, hargaImage, descImage, jamImage, penyelenggaraImage);
        }
    }


    private void ValidatePhone(final String judulImage, final String alamatImage, final String tanggalImage, final String hargaImage, final String descImage, final String jamImage, final String penyelenggaraImage) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Request").child(judulImage).exists())) {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("Judul", judulImage);
                    userdataMap.put("Alamat", alamatImage);
                    userdataMap.put("Tanggal", tanggalImage);
                    userdataMap.put("Harga", hargaImage);
                    userdataMap.put("Deskripsi", descImage);
                    userdataMap.put("Jam", jamImage);
                    userdataMap.put("Penyelenggara", penyelenggaraImage);
                    userdataMap.put("Poster",imageUri.toString());

                    RootRef.child("Request").child(judulImage).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(upload.this, "Congratulations, upload success.", Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();

                                        Intent intent = new Intent(upload.this, HomeActivity.class);
                                        startActivity(intent);
                                    } else {
                                        loadingBar.dismiss();
                                        Toast.makeText(upload.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(upload.this, "This " + judulImage + " already exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(upload.this, "Please try again using another phone number.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMAGE && data != null) {
            imageUri = data.getData();
            isImageAdded = true;
            imageView.setImageURI(imageUri);
        }
    }
}
