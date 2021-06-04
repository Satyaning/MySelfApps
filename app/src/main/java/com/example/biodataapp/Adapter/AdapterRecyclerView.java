package com.example.biodataapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biodataapp.Model.itemModel;
import com.example.biodataapp.R;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>{

    private ArrayList<itemModel> dataItem;

    //03/06/2021, 10118058, Satyaning, If-2
    AdapterRecyclerView(ArrayList<itemModel>data){
        this.dataItem = data;
    }


    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_galerry, parent,false);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageView image = holder.images;
        TextView name = holder.name;


        TextView nama = holder.nama;

        name.setText(dataItem.get(position).getName());
        nama.setText(dataItem.get(position).getNama());
        image.setImageResource(dataItem.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,nama;
        private ImageView images,images2;
        public ViewHolder(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.name);
            nama = v.findViewById(R.id.nama);
            images = v.findViewById(R.id.foto);
            images2 = v.findViewById(R.id.foto2);


        }
    }


}
