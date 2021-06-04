package com.example.biodataapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biodataapp.Model.itemModelFriendList;
import com.example.biodataapp.R;

import java.util.ArrayList;

public class AdapterRecyclerViewHerizontal extends RecyclerView.Adapter<AdapterRecyclerViewHerizontal.ViewHolder> {

    private ArrayList<itemModelFriendList> dataItemku;
    //03/06/2021, 10118055, Reza Pratama, If-2
    AdapterRecyclerViewHerizontal(ArrayList<itemModelFriendList>dataku){
        this.dataItemku = dataku;
    }



    @NonNull
    @Override
    public AdapterRecyclerViewHerizontal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_friendlist,parent,false);
        return new AdapterRecyclerViewHerizontal.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerViewHerizontal.ViewHolder holder, int position) {
        TextView namateman = holder.nametemanku;
        ImageView fototeman = holder.imagestemanku;
        TextView status = holder.status;

        namateman.setText(dataItemku.get(position).getNamateman());
        fototeman.setImageResource(dataItemku.get(position).getFototeman());
        status.setText(dataItemku.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return dataItemku.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nametemanku,status;
        private ImageView imagestemanku;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nametemanku = itemView.findViewById(R.id.nama);
            imagestemanku = itemView.findViewById(R.id.fototeman);
            status = itemView.findViewById(R.id.statusteman);

        }
    }
}
