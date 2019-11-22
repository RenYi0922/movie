package com.bw.movie.adapter.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.bean.FindMoviesBean;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * describe:MyHomeMoviesYuGaoAdapter
 * date:2019/11/20
 * author:任(Lenovo)
 * function:
 */
public class MyHomeMoviesYuGaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindMoviesBean.ResultBean list;
    private Context context;

    public MyHomeMoviesYuGaoAdapter(FindMoviesBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movies_yg, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).jc_video_yg.setUp(list.getShortFilmList().get(i).getVideoUrl(),((MyViewHolder) viewHolder).jc_video_yg.SCREEN_LAYOUT_NORMAL);
        }
    }

    @Override
    public int getItemCount() {
        return list.getShortFilmList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        JCVideoPlayerStandard jc_video_yg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jc_video_yg = itemView.findViewById(R.id.jc_video_yg);
        }
    }
}
