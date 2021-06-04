package com.example.biodataapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biodataapp.R;
import com.example.biodataapp.Model.WalkthroughItem;

import java.util.List;

public class WalkthroughAdapter extends RecyclerView.Adapter<WalkthroughAdapter.WalkthroughViewHolder>{

    private List<WalkthroughItem>walkthroughItems;

    public WalkthroughAdapter(List<WalkthroughItem> walkthroughItems) {
        this.walkthroughItems = walkthroughItems;
    }

    @NonNull
    @Override
    public WalkthroughViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WalkthroughViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_walkthrough, parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull WalkthroughViewHolder holder, int position) {
        holder.setWalkthroughData(walkthroughItems.get(position));
    }

    @Override
    public int getItemCount() {
        return walkthroughItems.size();
    }

    class WalkthroughViewHolder extends RecyclerView.ViewHolder{

        private TextView textTitle;
        private TextView textDescription;
        private ImageView imageWalkthrough;


         WalkthroughViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageWalkthrough = itemView.findViewById(R.id.imageWalkthrough);
        }
        void setWalkthroughData(WalkthroughItem walkthroughItem){
           textTitle.setText(walkthroughItem.getTitle());
           textDescription.setText(walkthroughItem.getDescription());
           imageWalkthrough.setImageResource(walkthroughItem.getImage());
        }
    }
}
