package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Filter extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    private static final String TAG = Filter.class.getSimpleName();
    private String mSpinnerLabel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Spinner spinner_popularity = findViewById(R.id.spinner_popularity);
        if (spinner_popularity != null) {
            spinner_popularity.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter_popularity =
                ArrayAdapter.createFromResource(
                        this, R.array.popularity_array,
                        android.R.layout.simple_spinner_item);
        adapter_popularity.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner_popularity != null) {
            spinner_popularity.setAdapter(adapter_popularity);
        }
        Spinner spinner_kuota = findViewById(R.id.spinner_kuota);
        if (spinner_kuota != null) {
            spinner_kuota.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter_kuota =
                ArrayAdapter.createFromResource(
                        this, R.array.kuota_array,
                        android.R.layout.simple_spinner_item);
        adapter_kuota.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner_kuota != null) {
            spinner_kuota.setAdapter(adapter_kuota);
        }
        Spinner spinner_price = findViewById(R.id.spinner_price);
        if (spinner_price != null) {
            spinner_price.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter_price =
                ArrayAdapter.createFromResource(
                        this, R.array.price_array,
                        android.R.layout.simple_spinner_item);
        adapter_price.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner_price != null) {
            spinner_price.setAdapter(adapter_price);
        }
        Spinner spinner_type = findViewById(R.id.spinner_type);
        if (spinner_type != null) {
            spinner_type.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter_type =
                ArrayAdapter.createFromResource(
                        this, R.array.type_array,
                        android.R.layout.simple_spinner_item);
        adapter_type.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner_type != null) {
            spinner_type.setAdapter(adapter_type);
        }
        Spinner spinner_rating = findViewById(R.id.spinner_rating);
        if (spinner_rating != null) {
            spinner_rating.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter_rating =
                ArrayAdapter.createFromResource(
                        this, R.array.rating_array,
                        android.R.layout.simple_spinner_item);
        adapter_rating.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner_rating != null) {
            spinner_rating.setAdapter(adapter_rating);
        }
        Spinner spinner_choice = findViewById(R.id.spinner_choice);
        if (spinner_choice != null) {
            spinner_choice.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter_choice =
                ArrayAdapter.createFromResource(
                        this, R.array.choice_array,
                        android.R.layout.simple_spinner_item);
        adapter_choice.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner_choice != null) {
            spinner_choice.setAdapter(adapter_choice);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView,
                               View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, "onNothingSelected: ");
    }
}
