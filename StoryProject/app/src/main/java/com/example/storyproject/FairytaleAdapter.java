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

public class FairytaleAdapter extends RecyclerView.Adapter<FairytaleAdapter.MyViewHolder> {
    Context context ;
    ArrayList arrayList,arrayListname;
    public FairytaleAdapter(Context context,ArrayList arrayList,ArrayList arrayListname){
        this.context = context;
        this.arrayList = arrayList;
        this.arrayListname = arrayListname;
    }


    @Override
    public FairytaleAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.storyrow,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FairytaleAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(Data2.images[position]);
        holder.tv.setText(Data2.names[position]);

    }



    @Override
    public int getItemCount() {
        return arrayListname.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            int b=getAbsoluteAdapterPosition();
            switch (b){
                case 0:
                    Intent intent=new Intent(context,FairActivity1.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    Intent intent1=new Intent(context,FairActivity2.class);
                    context.startActivity(intent1);
                    break;
                case 2:
                    Intent intent2=new Intent(context,FairActivity3.class);
                    context.startActivity(intent2);
                    break;
                case 3:
                    Intent intent3=new Intent(context,FairActivity4.class);
                    context.startActivity(intent3);
                    break;
                case 4:
                    Intent intent4=new Intent(context,FairActivity5.class);
                    context.startActivity(intent4);
                    break;

            }

        }
    }
}
