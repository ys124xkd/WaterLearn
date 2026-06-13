package com.example.projectuas.menu;

import android.content.Context;
import android.provider.MediaStore;
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

public class videoAdapter extends RecyclerView.Adapter<videoAdapter.ViewHolder>{
    Context context;
    ArrayList<video> arrayList;
    OnItemClickListener onItemClickListener;
    public videoAdapter(Context context, ArrayList<video> arrayList){
        this.context = context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getUrl()).into(holder.imageView);
        holder.title.setText(arrayList.get(position).getTitle());
        holder.itemView.setOnClickListener(view -> onItemClickListener.onClick(arrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView=itemView.findViewById(R.id.list_item_image);
            title=itemView.findViewById(R.id.list_item_tittle);

        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public interface  OnItemClickListener{
        void onClick(video video);
    }
}




