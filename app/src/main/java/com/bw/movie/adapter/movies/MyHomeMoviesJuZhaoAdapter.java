package com.bw.movie.adapter.movies;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.bean.FindMoviesBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * describe:MyHomeMoviesYuGaoAdapter
 * date:2019/11/19
 * author:任(Lenovo)
 * function:
 */
public class MyHomeMoviesJuZhaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindMoviesBean.ResultBean list;
    private Context context;

    public MyHomeMoviesJuZhaoAdapter(FindMoviesBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movies_jz, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).sView_rec_jz.setImageURI(Uri.parse(list.getShortFilmList().get(i).getImageUrl()));
        }
    }

    @Override
    public int getItemCount() {
        return list.getShortFilmList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_rec_jz;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_jz = itemView.findViewById(R.id.sView_rec_jz);
        }
    }
}
