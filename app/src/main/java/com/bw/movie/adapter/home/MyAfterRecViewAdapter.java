package com.bw.movie.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.SwitchCinemaActivity;
import com.bw.movie.bean.AfterBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * describe:MyHotRecViewAdapter
 * date:2019/11/13
 * author:任(Lenovo)
 * function:
 */
public class MyAfterRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AfterBean.ResultBean> list;
    private Context context;

    public MyAfterRecViewAdapter(List<AfterBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_after, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final AfterBean.ResultBean resultBean = list.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).tv_name_rec_after.setText(resultBean.getName());
            ((MyViewHolder) viewHolder).tv_score_rec_after.setText(resultBean.getScore()+"分");
            ((MyViewHolder) viewHolder).sView_rec_after.setImageURI(resultBean.getImageUrl());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.moviesId(resultBean.getMovieId()+"");
                }
            });
            ((MyViewHolder) viewHolder).btn_buy_rec_after.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SwitchCinemaActivity.class);
                    intent.putExtra("moviesId",list.get(i).getMovieId()+"");
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
        SimpleDraweeView sView_rec_after;
        TextView tv_name_rec_after,tv_score_rec_after;
        Button btn_buy_rec_after;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_after = itemView.findViewById(R.id.sView_rec_after);
            tv_name_rec_after = itemView.findViewById(R.id.tv_name_rec_after);
            tv_score_rec_after = itemView.findViewById(R.id.tv_score_rec_after);
            btn_buy_rec_after = itemView.findViewById(R.id.btn_buy_rec_after);
        }
    }

    private onClick onClick;

    public void setOnClick(MyAfterRecViewAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void moviesId(String moviesId);
    }
}
