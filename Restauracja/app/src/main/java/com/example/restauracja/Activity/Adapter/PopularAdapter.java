package com.example.restauracja.Activity.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import com.example.restauracja.Activity.Domena.PopularDomain;
import com.example.restauracja.Activity.ShowDetailActivity;
import com.example.restauracja.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<PopularDomain> pupularFood;

    public PopularAdapter(ArrayList<PopularDomain> pupularFood) {
        this.pupularFood = pupularFood;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        TextView addBtn;
        ConstraintLayout popularLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.picfood);
            addBtn = itemView.findViewById(R.id.addBtn);
            popularLayout = itemView.findViewById(R.id.popularLayout);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(pupularFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(pupularFood.get(position).getFee()));
        String picUrl ="";

        switch (position) {
            case 0: {
                picUrl = "pizza1";
                holder.popularLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background1));
                break;
            }
            case 1: {
                picUrl = "burger2";
                holder.popularLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background2));
                break;
            }
            case 2: {
                picUrl = "pizza2";
                holder.popularLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background3));
                break;
            }
        }

        int drawableResourceId= holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", pupularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pupularFood.size();
    }


}
