package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class uploadBukti extends AppCompatActivity {
    private Button btnUpload;
    private static final int SELECT_PHOTO = 100;
    Uri selectedImage;
    FirebaseStorage storage;
    StorageReference storageRef, imageRef;
    ProgressDialog progressDialog;
    UploadTask uploadTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_bukti);
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        //BUAT ALERT


    }

    public void bt_upload(View view) {
        imageRef = storageRef.child("images/" + selectedImage.getLastPathSegment());

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
                //Intent e = new Intent(getApplicationContext(),riwayatPembayaran.class);
                //startActivity(e);
            }

        });

    //btnUpload = (Button) findViewById(R.id.bt_upload);
        //btnUpload.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
            //showDialog();
        //}
    //});
    //}
        //private void showDialog () {
            //AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    //this);

            //set title
            //alertDialogBuilder.setTitle("Berhasil Menggunggah Gambar");


            //setpesan
            //alertDialogBuilder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                //@Override
                //public void onClick(DialogInterface dialog, int i) {
                    //Intent e = new Intent(getApplicationContext(), riwayatPembayaran.class);
                    //startActivity(e);

                //}

            //});
            //membuat alert
            //AlertDialog alertDialog = alertDialogBuilder.create();

            //menampilkan dialog
            //alertDialog.show();

        }

        //Intent e = new Intent(getApplicationContext(),riwayatPembayaran.class);
        //startActivity(e);




    //INI BUAT ALERT
//private void showDialog() {
    //AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
            //this);

    //set title
    //alertDialogBuilder.setTitle("Berhasil Menggunggah Gambar");


    //setpesan
    //alertDialogBuilder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
        //@Override
        //public void onClick(DialogInterface dialog, int i) {
            //Intent e = new Intent(getApplicationContext(), riwayatPembayaran.class);
            //startActivity(e);

        //}

    //});
    //membuat alert
    //AlertDialog alertDialog = alertDialogBuilder.create();

    //menampilkan dialog
    //alertDialog.show();

//}




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
                    Toast.makeText(uploadBukti.this, "Image Selected",Toast.LENGTH_SHORT).show();
                    selectedImage = imageReturnedIntent.getData();
                }
                }

    }

    }
