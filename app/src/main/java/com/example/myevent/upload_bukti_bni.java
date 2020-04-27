package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class upload_bukti_bni extends AppCompatActivity {
    private Button btnUpload;
    private static final int SELECT_PHOTO = 100;
    Uri selectedImage;
    FirebaseStorage storage;
    StorageReference storageRef, imageRef;
    ProgressDialog progressDialog;
    UploadTask uploadTask;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_bukti_bni);

        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        textView = (TextView) findViewById(R.id.textViewTimer);
        //BUAT ALERT
        Timer();
    }

    public void bni(View view) {
        imageRef = storageRef.child("imagesBNI/" + selectedImage.getLastPathSegment());

        //creating and showing progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Uploading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        progressDialog.setCancelable(false);

        //start upload
        uploadTask = imageRef.putFile(selectedImage);

        uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0 * taskSnapshot.getBytesTransferred()) /
                        taskSnapshot.getTotalByteCount();


                progressDialog.incrementProgressBy((int) progress);
                Intent e = new Intent(getApplicationContext(), riwayatPembayaran.class);
                startActivity(e);
            }

        });
    }
    public void Timer() {
        new CountDownTimer(59000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("" + millisUntilFinished / 1000 + "Batas Pembayaran Selesai");
            }

            @Override
            public void onFinish() {
                textView.setText("");

            }
        }.start();
    }
    public void bt_select(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultcode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultcode, imageReturnedIntent);

        switch (requestCode) {
            case SELECT_PHOTO:
                if (resultcode == RESULT_OK) {
                    Toast.makeText(upload_bukti_bni.this, "Image Selected", Toast.LENGTH_SHORT).show();
                    selectedImage = imageReturnedIntent.getData();
                }
        }
    }}

