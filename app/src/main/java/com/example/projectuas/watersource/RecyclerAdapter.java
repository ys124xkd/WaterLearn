package com.example.projectuas.watersource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projectuas.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String tag="RecyclerView";

    private Context mContext;
    private ArrayList<messages> messagelist;

    public RecyclerAdapter (Context mContext,ArrayList<messages>messagelist){
        this.mContext=mContext;
        this.messagelist=messagelist;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.water_item, parent, false);

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //textview
        holder.nama.setText(messagelist.get(position).getName());
        holder.description.setText(messagelist.get(position).getDescription());

        //imageView:glide Library
        //
        Glide.with(mContext)
                .load(messagelist.get(position).getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return messagelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //widget
        ImageView imageView;
        TextView nama,description;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            nama=itemView.findViewById(R.id.nama);
            description=itemView.findViewById(R.id.description);
        }
    }
}
