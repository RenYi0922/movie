package com.bw.movie.adapter.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FindMoviesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * describe:MyMoviesRecViewAdapter
 * date:2019/11/15
 * author:任(Lenovo)
 * function:
 */
public class MyHomeMoviesRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindMoviesBean list;
    private Context context;

    public MyHomeMoviesRecViewAdapter(FindMoviesBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movies, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof MyViewHolder) {
            final FindMoviesBean.ResultBean resultBean = list.getResult();
            ((MyViewHolder) viewHolder).sView_rec_movies.setImageURI(resultBean.getImageUrl());
            ((MyViewHolder) viewHolder).tv_name_rec_movies.setText(resultBean.getName());
            ((MyViewHolder) viewHolder).tv_type_rec_movies.setText(resultBean.getMovieType());
            ((MyViewHolder) viewHolder).tv_duration_rec_movies.setText(resultBean.getDuration());
            ((MyViewHolder) viewHolder).tv_place_rec_movies.setText(resultBean.getPlaceOrigin()+"上映");
            ((MyViewHolder) viewHolder).tv_commentNum_rec_movies.setText(resultBean.getCommentNum()+"万条");
            ((MyViewHolder) viewHolder).tv_score_rec_movies.setText(resultBean.getScore()+"分");
            Date date = new Date(resultBean.getReleaseTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) viewHolder).tv_releaseTime_rec_movies.setText(day);
            ((MyViewHolder) viewHolder).img_gz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num = 1;
                    int cs = num++;
                    if (cs%2==1) {
                        ((MyViewHolder) viewHolder).img_gz.setImageResource(R.drawable.gz);
                        ((MyViewHolder) viewHolder).tv_gz.setText("已关注");
                    }else if (cs%2==0){
                        ((MyViewHolder) viewHolder).img_gz.setImageResource(R.drawable.qgz);
                        ((MyViewHolder) viewHolder).tv_gz.setText("未关注");
                    }
                    onGz.onGz(cs);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_rec_movies;
        ImageView img_gz;
        TextView tv_gz,tv_name_rec_movies,tv_type_rec_movies,tv_duration_rec_movies,tv_place_rec_movies,tv_commentNum_rec_movies,tv_score_rec_movies,tv_releaseTime_rec_movies;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_movies = itemView.findViewById(R.id.sView_rec_movies);
            img_gz = itemView.findViewById(R.id.img_gz);
            tv_gz = itemView.findViewById(R.id.tv_gz);
            tv_name_rec_movies = itemView.findViewById(R.id.tv_name_rec_movies);
            tv_type_rec_movies = itemView.findViewById(R.id.tv_type_rec_movies);
            tv_duration_rec_movies = itemView.findViewById(R.id.tv_duration_rec_movies);
            tv_place_rec_movies = itemView.findViewById(R.id.tv_place_rec_movies);
            tv_score_rec_movies = itemView.findViewById(R.id.tv_score_rec_movies);
            tv_commentNum_rec_movies = itemView.findViewById(R.id.tv_commentNum_rec_movies);
            tv_releaseTime_rec_movies = itemView.findViewById(R.id.tv_releaseTime_rec_movies);
        }
    }
    private onGz onGz;

    public void setOnGz(MyHomeMoviesRecViewAdapter.onGz onGz) {
        this.onGz = onGz;
    }

    public interface onGz{
        void onGz(int num);
    }
}
