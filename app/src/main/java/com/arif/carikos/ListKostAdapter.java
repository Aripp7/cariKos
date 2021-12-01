package com.arif.carikos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListKostAdapter extends RecyclerView.Adapter<ListKostAdapter.ListViewHolder> {


    private Context context;
    private List<Kost> listKost;
    public ListKostAdapter(Context context, List<Kost> listKost){
        this.context = context;
        this.listKost = listKost;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kos, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Kost kos = listKost.get(position);
        Glide.with(context).load("http://carikos.mwebs.id/gambar/"+kos.getFoto()).into(holder.imgFoto);
        // holder.image.setImageResource(staffList.get(position).getFoto());
        holder.nama_kos.setText(listKost.get(position).getName());
        holder.tvPrice.setText(listKost.get(position).getHarga());

        holder.tvAlamat.setText((listKost.get(position).getAlamat()));

        holder.itemkost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("nama_kos", listKost.get(holder.getAdapterPosition()).getName());
                intent.putExtra("id", listKost.get(holder.getAdapterPosition()).getId());
                intent.putExtra("harga",listKost.get(holder.getAdapterPosition()).getHarga());
                intent.putExtra("ukuran",listKost.get(holder.getAdapterPosition()).getUkuran());
                intent.putExtra("alamat",listKost.get(holder.getAdapterPosition()).getAlamat());

                intent.putExtra("wifi",listKost.get(holder.getAdapterPosition()).getWifi());

                intent.putExtra("ac",listKost.get(holder.getAdapterPosition()).getAc());

               intent.putExtra("foto", listKost.get(holder.getAdapterPosition()).getFoto());
               intent.putExtra("latitude", listKost.get(holder.getAdapterPosition()).getLatitude());
               intent.putExtra("langitude", listKost.get(holder.getAdapterPosition()).getLongitude());

                context.startActivity(intent);
               // Toast.makeText(context,"Test",Toast.LENGTH_LONG).show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return listKost.size();
    }

     class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFoto;
//       RecyclerView rc_view;
         RelativeLayout itemkost;

        TextView nama_kos, tvAlamat,tvPrice;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            itemkost = itemView.findViewById(R.id.itemkost);
//            rc_view = itemView.findViewById(R.id.rc_kos);
            imgFoto = itemView.findViewById(R.id.item_image);
            nama_kos = itemView.findViewById(R.id.item_name);
            tvAlamat = itemView.findViewById(R.id.item_lokasi);
            tvPrice = itemView.findViewById(R.id.item_harga);




        }
    }




}
