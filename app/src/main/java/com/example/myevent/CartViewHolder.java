package com.example.myevent;

import android.content.ClipData;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtname, txtprice, txtquantity;
    private ItemClickListner itemClickListner;

    public CartViewHolder(View itemView){
        super(itemView);

        txtname = itemView.findViewById(R.id.product_name);
        txtprice = itemView.findViewById(R.id.product_price);
        txtquantity = itemView.findViewById(R.id.product_quantity);


    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view, getAdapterPosition(), false);

    }

    public void setItemClickListner(ItemClickListner itemClickListner){
        this.itemClickListner = itemClickListner;
    }
}
