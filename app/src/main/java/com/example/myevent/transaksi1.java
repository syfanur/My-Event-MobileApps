package com.example.myevent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class transaksi1 extends AppCompatActivity {

    private Button btAlert;


    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi1);

        // Initialize the views.
        TextView Judul = findViewById(R.id.ticket);
        TextView Harga = findViewById(R.id.biaya);

        // Set the text from the Intent extra.
        Judul.setText("Archatala");
        Harga.setText("200000");

        btAlert = (Button) findViewById(R.id.konfirmasi);
        btAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        }


    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Lanjutkan Order?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk lanjutkan")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan berpindah ke activity selanjutnya
                        Intent e = new Intent(getApplicationContext(),metodePembayaran.class);
                        startActivity(e);
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

    public void increaseScore(View view) {
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
        }


    public void decreaseScore(View view) {
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
        }

    public void pesan(View view) {
        TextView judul = findViewById(R.id.ticket);
        String name=judul.getText().toString();
        Log.v("MainActivity","Nama:"+name);

        int price=calculateprice();//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name);


        displayMessage(pricemessage);
    }

    private int calculateprice(){//jumlah pesanan * harga
        int harga=200000;

        return quantity * harga;
    }
    private String createOrderSummary(int price, String name) {//hasil pemesanan
        String pricemessage=" ------------------------------------------------------------------ " +
                "\n Nama = "+name;
        pricemessage+="\n Jumlah Pemesanan = " +quantity;
        pricemessage+="\n Total = Rp " +price;
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.info);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.jumlah);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.info);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }




}
