package com.example.myevent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class metodePembayaran extends AppCompatActivity {
    private Button btMandiri;
    private Button btBni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metode_pembayaran);

        btMandiri = (Button) findViewById(R.id.btMandiri);


        btMandiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        //set title dialog
        alertDialogBuilder.setTitle("Lanjutkan Pembayaran?");

        //set pesan dialog
        alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //jika tombol diklik akan berpindah ke activity selanjutnya
                Intent e = new Intent(getApplicationContext(),uploadBukti.class);
                startActivity(e);
            }
        })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //tombol di klik, tidak terjadi apa2
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();


    }

}
