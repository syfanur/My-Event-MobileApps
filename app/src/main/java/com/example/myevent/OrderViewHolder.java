package com.example.myevent;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderViewHolder  extends RecyclerView.ViewHolder {
    TextView mpname, mdate, mstatus, mtotal;
    ImageView mposter;
    View v;
    Button btDetail;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);
        mpname = itemView.findViewById(R.id.pemesan);
        mdate = itemView.findViewById(R.id.tanggal);
        mstatus = itemView.findViewById(R.id.status);
        mtotal = itemView.findViewById(R.id.total);
        btDetail = itemView.findViewById(R.id.buttonDetail);


        v = itemView;

    }
}
