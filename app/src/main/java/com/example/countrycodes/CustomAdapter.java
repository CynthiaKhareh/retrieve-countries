package com.example.countrycodes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{


    private List<Country> dataList;
    private Context context;

    public CustomAdapter(Context context,List<Country> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country results=dataList.get(position);
        holder.name.setText(results.getName());
        holder.alpha.setText(results.getAlpha2Code());
        String url=results.getFlag();
holder.itemView.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Population Size:"+ results.getPopulation(), Toast.LENGTH_SHORT).show();
            }
        }
);
        GlideApp.with(context).load(url).apply(RequestOptions.centerCropTransform()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        public TextView name,alpha;
        public ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            alpha=itemView.findViewById(R.id.alpha);
            image=itemView.findViewById(R.id.image);
        }
    }
}
