package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmFinalOrderActivity extends AppCompatActivity {

    private EditText name, phone, address;
    private Button confirm;

    private String totalAmount = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_final_order);

        totalAmount = getIntent().getStringExtra("Total Price");
        Toast.makeText(this, "Total Price = "+totalAmount, Toast.LENGTH_SHORT).show();

        confirm = (Button) findViewById(R.id.confirm_final_btn);
        name = (EditText) findViewById(R.id.shippment_name);
        phone = (EditText) findViewById(R.id.shippment_phone_number);
        address = (EditText) findViewById(R.id.shippment_address);
    }
}
