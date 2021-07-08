package com.example.storyproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FolktaleAdapter extends RecyclerView.Adapter<FolktaleAdapter.MyViewHolder> {
    Context context;
    ArrayList arrayList,arrayListname;

    public FolktaleAdapter(Context context,ArrayList arrayList,ArrayList arrayListname){
        this.context = context;
        this.arrayList = arrayList;
        this.arrayListname = arrayListname;
    }


    @Override
    public FolktaleAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.storyrow,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  FolktaleAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(Data1.images[position]);
        holder.tv.setText(Data1.names[position]);


    }

    @Override
    public int getItemCount() {return arrayListname.size();}


    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView iv;
        TextView tv;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.itemImage);
            tv=itemView.findViewById(R.id.itemName);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            int a=getAbsoluteAdapterPosition();
            switch (a){
                case 0:
                    Intent intent=new Intent(context,FolkActivity1.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    Intent intent1=new Intent(context,FolkActivity2.class);
                    context.startActivity(intent1);
                    break;
                case 2:
                    Intent intent2=new Intent(context,FolkActivity3.class);
                    context.startActivity(intent2);
                    break;
                case 3:
                    Intent intent3=new Intent(context,FolkActivity4.class);
                    context.startActivity(intent3);
                    break;
                case 4:
                    Intent intent4=new Intent(context,FolkActivity5.class);
                    context.startActivity(intent4);
                    break;

            }

        }
    }
}
