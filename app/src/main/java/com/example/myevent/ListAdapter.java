package com.example.myevent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>  {

// Member variables.
private ArrayList<Musik> mMusicData;
private Context mContext;

        /**
         * Constructor that passes in the sports data and the context.
         *
         * @param sportsData ArrayList containing the sports data.
         * @param context Context of the application.
         */
        ListAdapter(Context context, ArrayList<Musik> sportsData) {
        this.mMusicData = sportsData;
        this.mContext = context;
        }


/**
 * Required method for creating the viewholder objects.
 *
 * @param parent The ViewGroup into which the new View will be added
 *               after it is bound to an adapter position.
 * @param viewType The view type of the new View.
 * @return The newly created ViewHolder.
 */
@Override
public ListAdapter.ViewHolder onCreateViewHolder(
        ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext)
        .inflate(R.layout.item_list, parent, false));
        }

/**
 * Required method that binds the data to the viewholder.
 *
 * @param holder The viewholder into which the data should be put.
 * @param position The adapter position.
 */
@Override
public void onBindViewHolder(ListAdapter.ViewHolder holder,
        int position) {
        // Get current sport.
        Musik currentMusic = mMusicData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentMusic);
        }


/**
 * Required method for determining the size of the data set.
 *
 * @return Size of the data set.
 */
@Override
public int getItemCount() {
        return mMusicData.size();
        }


/**
 * ViewHolder class that represents each row of data in the RecyclerView.
 */
class ViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener{

    // Member Variables for the TextViews
    private TextView judul;
    private TextView tempat;
    private TextView tanggal;
    private TextView tiket;
    private TextView harga;
    private ImageView poster;

    /**
     * Constructor for the ViewHolder, used in onCreateViewHolder().
     *
     * @param itemView The rootview of the list_item.xml layout file.
     */
    ViewHolder(View itemView) {
        super(itemView);

        // Initialize the views.
        judul = itemView.findViewById(R.id.judul);
        tempat = itemView.findViewById(R.id.alamat);
        poster = itemView.findViewById(R.id.poster);
        tanggal = itemView.findViewById(R.id.tanggal);
        tiket = itemView.findViewById(R.id.tiket);

        // Set the OnClickListener to the entire view.
        itemView.setOnClickListener(this);
    }

    void bindTo(Musik currentMusik){
        // Populate the textviews with data.
        judul.setText(currentMusik.getTitle());
        tempat.setText(currentMusik.getInfo());
        tiket.setText(currentMusik.getTiket());
        tanggal.setText(currentMusik.getTanggal());

        // Load the images into the ImageView using the Glide library.
        Glide.with(mContext).load(
                currentMusik.getImageResource()).into(poster);

    }

    /**
     * Handle click to show DetailActivity.
     *
     * @param view View that is clicked.
     */
    @Override
    public void onClick(View view) {
        Musik currentMusik = mMusicData.get(getAdapterPosition());
        Intent detailIntent = new Intent(mContext, desc_event.class);
        detailIntent.putExtra("title", currentMusik.getTitle());
        detailIntent.putExtra("tempat", currentMusik.getInfo());
        detailIntent.putExtra("penyelenggara", currentMusik.getBy());
        detailIntent.putExtra("tgl", currentMusik.getTgl());
        detailIntent.putExtra("bulan", currentMusik.getBulan());
        detailIntent.putExtra("jam", currentMusik.getJam());
        detailIntent.putExtra("harga", currentMusik.getHarga());
        detailIntent.putExtra("image_resource",
                currentMusik.getImageResource());
        mContext.startActivity(detailIntent);
    }
}
}
