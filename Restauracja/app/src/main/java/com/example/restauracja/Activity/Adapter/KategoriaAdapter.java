package com.example.restauracja.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restauracja.Activity.Domena.Kategoria;
import com.example.restauracja.R;

import java.util.ArrayList;

public class KategoriaAdapter extends RecyclerView.Adapter<KategoriaAdapter.ViewHolder> {
    ArrayList<Kategoria>kategoriaArrayList;

    public KategoriaAdapter(ArrayList<Kategoria> kategoriaArrayList) {
        this.kategoriaArrayList = kategoriaArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nazwaKategori;
        ImageView zdjecieKategori;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nazwaKategori=itemView.findViewById(R.id.categoryName);
            zdjecieKategori = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriaAdapter.ViewHolder holder, int position) {
        holder.nazwaKategori.setText(kategoriaArrayList.get(position).getTitle());
        String picUrl ="";

        switch (position)
        {
            case 0:{
                picUrl="pizza";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background1));
                break;
            }
            case 1:{
                picUrl="burger";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background2));
                break;
            }
            case 2:{
                picUrl="hotdog";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background3));
                break;
            }
            case 3:{
                picUrl="napoj";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background4));
                break;
            }
            case 4:{
                picUrl="paczek";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background5));
                break;
            }
        }
        int drawableResourceId= holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.zdjecieKategori);

    }

    @Override
    public int getItemCount() {
        return kategoriaArrayList.size();
    }


}
