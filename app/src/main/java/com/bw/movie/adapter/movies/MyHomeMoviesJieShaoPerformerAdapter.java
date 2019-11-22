package com.bw.movie.adapter.movies;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FindMoviesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * describe:MyHomeMoviesJieShaoPerformerAdapter
 * date:2019/11/18
 * author:任(Lenovo)
 * function:
 */
public class MyHomeMoviesJieShaoPerformerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindMoviesBean.ResultBean.MovieActorBean> list;
    private Context context;

    public MyHomeMoviesJieShaoPerformerAdapter(List<FindMoviesBean.ResultBean.MovieActorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_performer, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).sView_rec_performer.setImageURI(Uri.parse(list.get(i).getPhoto()));
            ((MyViewHolder) viewHolder).tv_name_rec_performer.setText(list.get(i).getName());
            ((MyViewHolder) viewHolder).tv_play_rec_performer.setText(list.get(i).getRole());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_rec_performer;
        TextView tv_name_rec_performer,tv_play_rec_performer;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_performer = itemView.findViewById(R.id.sView_rec_performer);
            tv_name_rec_performer = itemView.findViewById(R.id.tv_name_rec_performer);
            tv_play_rec_performer = itemView.findViewById(R.id.tv_play_rec_performer);
        }
    }
}
