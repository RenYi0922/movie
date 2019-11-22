package com.bw.movie.adapter.cinema;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.CinemaActivity;
import com.bw.movie.activity.ScheduleActivity;
import com.bw.movie.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * describe:MyRecommendRecViewAdapter
 * date:2019/11/14
 * author:任(Lenovo)
 * function:
 */
public class MyRecommendRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RecommendBean.ResultBean> list;
    private Context context;

    public MyRecommendRecViewAdapter(List<RecommendBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_recommend, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final RecommendBean.ResultBean resultBean = list.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).sView_rec_show_rec.setImageURI(resultBean.getLogo());
            ((MyViewHolder) viewHolder).tv_name_rec_show_recommend.setText(resultBean.getName());
            ((MyViewHolder) viewHolder).tv_address_show_recommend.setText(resultBean.getAddress());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CinemaActivity.class);
                    intent.putExtra("Id",resultBean.getId()+"");
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_rec_show_rec;
        TextView tv_name_rec_show_recommend,tv_address_show_recommend;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_show_rec = itemView.findViewById(R.id.sView_rec_show_rec);
            tv_name_rec_show_recommend = itemView.findViewById(R.id.tv_name_rec_show_recommend);
            tv_address_show_recommend = itemView.findViewById(R.id.tv_address_show_recommend);
        }
    }
}
