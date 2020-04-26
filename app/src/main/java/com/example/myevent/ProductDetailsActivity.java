package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ProductDetailsActivity extends AppCompatActivity {

    private ImageView productImage;
    private ElegantNumberButton numberButton;
    private TextView nama, deskripsi, harga;
    private String id = "";
    private Button addcart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

    }
}

//        id = getIntent().getStringExtra("pid");
//        addcart = (Button) findViewById(R.id.addcart);
//
//        numberButton = (ElegantNumberButton) findViewById(R.id.number_btn);
//        nama = (TextView) findViewById(R.id.Nama);
//        harga = (TextView) findViewById(R.id.Harga);
//        deskripsi = (TextView) findViewById(R.id.Desc);
//
//        getProductDetails(id);
//        addcart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addingToCartList();
//            }
//        });
//    }
//
//    private void addingToCartList() {
//        String saveCurrentTime, saveCurrentDate;
//        Calendar calForDate = Calendar.getInstance();
//        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
//        saveCurrentDate = currentDate.format(calForDate.getTime());
//
//        SimpleDateFormat currentTime = new SimpleDateFormat("MMM dd, yyyy");
//        saveCurrentTime = currentDate.format(calForDate.getTime());
//
//        DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("CartList");
//        final HashMap<String, Object> cartMap = new HashMap<>();
//        cartMap.put("pid", id);
//        cartMap.put("pname", nama.getText().toString());
//        cartMap.put("price", harga.getText().toString());
//        cartMap.put("date", saveCurrentDate);
//        cartMap.put("time", saveCurrentTime);
//        cartMap.put("quantity", numberButton.getNumber());
//
//        cartListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone()).chil("Products").child(id)
//                .
//
//    }
//
//    private void getProductDetails(String id) {
//    }

