package com.bw.movie.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.SwitchCinemaActivity;
import com.bw.movie.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * describe:MyHotRecViewAdapter
 * date:2019/11/13
 * author:任(Lenovo)
 * function:
 */
public class MyHotRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HotBean.ResultBean> list;
    private Context context;
    private RecyclerView rec_home_hot_in;

    public MyHotRecViewAdapter(List<HotBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_hot, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final HotBean.ResultBean resultBean = list.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).tv_name_rec_hot.setText(resultBean.getName());
            ((MyViewHolder) viewHolder).tv_score_rec_hot.setText(resultBean.getScore()+"分");
            ((MyViewHolder) viewHolder).sView_rec_hot.setImageURI(resultBean.getImageUrl());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rec_home_hot_in.setLayoutManager(linearLayoutManager);
            MyHotInRecViewAdapter myHotInRecViewAdapter = new MyHotInRecViewAdapter(list, context);
            rec_home_hot_in.setAdapter(myHotInRecViewAdapter);
            myHotInRecViewAdapter.setOnClick(new MyAfterRecViewAdapter.onClick() {
                @Override
                public void moviesId(String moviesId) {
                    onClick.moviesId(moviesId);
                }
            });
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.moviesId(resultBean.getMovieId()+"");
                }
            });
            ((MyViewHolder) viewHolder).btn_buy_rec_hot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SwitchCinemaActivity.class);
                    intent.putExtra("moviesId",list.get(i).getMovieId());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_rec_hot;
        TextView tv_name_rec_hot,tv_score_rec_hot;
        Button btn_buy_rec_hot;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_hot = itemView.findViewById(R.id.sView_rec_hot);
            tv_name_rec_hot = itemView.findViewById(R.id.tv_name_rec_hot);
            tv_score_rec_hot = itemView.findViewById(R.id.tv_score_rec_hot);
            btn_buy_rec_hot = itemView.findViewById(R.id.btn_buy_rec_hot);
            rec_home_hot_in = itemView.findViewById(R.id.rec_home_hot_in);
        }
    }
    private onClick onClick;

    public void setOnClick(onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void moviesId(String moviesId);
    }
}
