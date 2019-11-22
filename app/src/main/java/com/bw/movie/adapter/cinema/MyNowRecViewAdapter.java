package com.bw.movie.adapter.cinema;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.NowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * describe:MyHotRecViewAdapter
 * date:2019/11/13
 * author:任(Lenovo)
 * function:
 */
public class MyNowRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NowBean.ResultBean> list;
    private Context context;

    public MyNowRecViewAdapter(List<NowBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_now, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final NowBean.ResultBean resultBean = list.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).tv_name_rec_now.setText(resultBean.getName());
            ((MyViewHolder) viewHolder).sView_rec_now.setImageURI(resultBean.getImageUrl());
            Date date = new Date(resultBean.getReleaseTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) viewHolder).tv_get_rec_now.setText(day+"上映");
            ((MyViewHolder) viewHolder).tv_want_rec_now.setText(resultBean.getWantSeeNum()+"人想看");
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
        SimpleDraweeView sView_rec_now;
        TextView tv_name_rec_now,tv_get_rec_now,tv_want_rec_now;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_now = itemView.findViewById(R.id.sView_rec_now);
            tv_name_rec_now = itemView.findViewById(R.id.tv_name_rec_now);
            tv_get_rec_now = itemView.findViewById(R.id.tv_get_rec_now);
            tv_want_rec_now = itemView.findViewById(R.id.tv_want_rec_now);
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
