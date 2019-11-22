package com.bw.movie.adapter.cinema;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.ScheduleBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * describe:MyScheduleRecViewAdapter
 * date:2019/11/20
 * author:任(Lenovo)
 * function:
 */
public class MyScheduleRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ScheduleBean.ResultBean> list;
    private Context context;

    public MyScheduleRecViewAdapter(List<ScheduleBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_schedule, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            ScheduleBean.ResultBean resultBean = list.get(i);
            ((MyViewHolder) viewHolder).sView_rec_schedule.setImageURI(Uri.parse(resultBean.getImageUrl()));
            ((MyViewHolder) viewHolder).tv_name_rec_schedule.setText(resultBean.getName());
            ((MyViewHolder) viewHolder).tv_director_rec_schedule.setText("导演:"+resultBean.getDirector());
            ((MyViewHolder) viewHolder).tv_performer_rec_schedule.setText("主演:"+resultBean.getStarring());
            ((MyViewHolder) viewHolder).tv_score_rec_schedule.setText("评分:"+resultBean.getScore()+"");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_rec_schedule;
        TextView tv_name_rec_schedule,tv_director_rec_schedule,tv_performer_rec_schedule,tv_score_rec_schedule;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_schedule = itemView.findViewById(R.id.sView_rec_schedule);
            tv_name_rec_schedule = itemView.findViewById(R.id.tv_name_rec_schedule);
            tv_director_rec_schedule = itemView.findViewById(R.id.tv_director_rec_schedule);
            tv_performer_rec_schedule = itemView.findViewById(R.id.tv_performer_rec_schedule);
            tv_score_rec_schedule = itemView.findViewById(R.id.tv_score_rec_schedule);
        }
    }
}
