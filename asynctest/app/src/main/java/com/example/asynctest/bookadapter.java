package com.example.asynctest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class bookadapter extends RecyclerView.Adapter<bookadapter.MyViewHolder> {
    Context myct;
    List<book> mylist;
    public bookadapter(Context ct, List<book> bookList) {
        myct=ct;
        mylist=bookList;
    }

    @NonNull
    @Override
    public bookadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(myct).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull bookadapter.MyViewHolder holder, int position) {
        book b= mylist.get(position);
        holder.tv_title.setText(b.getTitle());
        holder.tv_author.setText(b.getAuthers());
        Glide.with(myct).load(b.getImagelink()).into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv_title,tv_author;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.bookimage);
            tv_title=itemView.findViewById(R.id.booltitle);
            tv_author= itemView.findViewById(R.id.bookauther);
        }
    }
}
