package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FindMoviesBean;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * describe:MyHomeMoviesSwitchRecAdapter
 * date:2019/11/21
 * author:任(Lenovo)
 * function:
 */
public class MyHomeMoviesSwitchRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindMoviesBean.ResultBean list;
    private Context context;

    public MyHomeMoviesSwitchRecAdapter(FindMoviesBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_switch, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).jc_video_switch.setUp(list.getShortFilmList().get(i).getVideoUrl(),((MyViewHolder) viewHolder).jc_video_switch.SCREEN_LAYOUT_NORMAL);
            ((MyViewHolder) viewHolder).tv_name_switch.setText(list.getName());
            ((MyViewHolder) viewHolder).tv_time_switch.setText(list.getDuration()+"分钟");
            ((MyViewHolder) viewHolder).tv_score_switch.setText(list.getScore()+"分");
            ((MyViewHolder) viewHolder).tv_director_switch.setText(list.getMovieDirector().get(i).getName());
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        JCVideoPlayerStandard jc_video_switch;
        TextView tv_name_switch,tv_time_switch,tv_score_switch,tv_director_switch;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            jc_video_switch = itemView.findViewById(R.id.jc_video_switch);
            tv_name_switch = itemView.findViewById(R.id.tv_name_switch);
            tv_time_switch = itemView.findViewById(R.id.tv_time_switch);
            tv_score_switch = itemView.findViewById(R.id.tv_score_switch);
            tv_director_switch = itemView.findViewById(R.id.tv_director_switch);
        }
    }
}
