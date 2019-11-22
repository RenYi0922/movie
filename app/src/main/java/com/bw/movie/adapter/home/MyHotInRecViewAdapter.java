package com.bw.movie.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.adapter.home.MyAfterRecViewAdapter;
import com.bw.movie.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * describe:MyHotRecViewAdapter
 * date:2019/11/13
 * author:任(Lenovo)
 * function:
 */
public class MyHotInRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HotBean.ResultBean> list;
    private Context context;

    public MyHotInRecViewAdapter(List<HotBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_hot_in, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final HotBean.ResultBean resultBean = list.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).tv_name_rec_hot_in.setText(resultBean.getName());
            ((MyViewHolder) viewHolder).tv_score_rec_hot_in.setText(resultBean.getScore()+"分");
            ((MyViewHolder) viewHolder).sView_rec_hot_in.setImageURI(resultBean.getImageUrl());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.moviesId(resultBean.getMovieId()+"");
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_rec_hot_in;
        TextView tv_name_rec_hot_in,tv_score_rec_hot_in;
        Button btn_buy_rec_hot_in;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_hot_in = itemView.findViewById(R.id.sView_rec_hot_in);
            tv_name_rec_hot_in = itemView.findViewById(R.id.tv_name_rec_hot_in);
            tv_score_rec_hot_in = itemView.findViewById(R.id.tv_score_rec_hot_in);
            btn_buy_rec_hot_in = itemView.findViewById(R.id.btn_buy_rec_hot_in);
        }
    }
    private MyAfterRecViewAdapter.onClick onClick;

    public void setOnClick(MyAfterRecViewAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void moviesId(String moviesId);
    }
}
