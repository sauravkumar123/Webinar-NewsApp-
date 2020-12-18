package com.example.webinar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder>{



private List<Article> list;
private Context context;

    public adapter(List<Article> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.mylayout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        Article article=list.get(position);

        holder.title.setText(article.getTitle());
        holder.dis.setText(article.getDescription());

        Glide.with(context).load(article.getUrlToImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(context,detail.class);
                    intent.putExtra("url",article.getUrl());
                    context.startActivity(intent);


                }
        });




    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;
        TextView dis;
        public viewholder(@NonNull View itemView) {


            super(itemView);
            imageView=itemView.findViewById(R.id.imagecard);
            title=itemView.findViewById(R.id.posttitle);
            dis=itemView.findViewById(R.id.body);
        }
    }
}
