package com.bw.movie.adapter.cinema;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FindCinemaBean;

/**
 * describe:MyRecViewCinema
 * date:2019/11/18
 * author:任(Lenovo)
 * function:
 */
public class MyCinemaRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindCinemaBean.ResultBean list;
    private Context context;

    public MyCinemaRecViewAdapter(FindCinemaBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_cinema, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).tv_name_cinema.setText(list.getName());
            MyCinemaBQRecViewAdapter myCinemaBQRecViewAdapter = new MyCinemaBQRecViewAdapter(list,context);
            ((MyViewHolder) viewHolder).rec_show_cinema_bq_view.setAdapter(myCinemaBQRecViewAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name_cinema;
        RecyclerView rec_show_cinema_bq_view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name_cinema = itemView.findViewById(R.id.tv_name_cinema);
            rec_show_cinema_bq_view = itemView.findViewById(R.id.rec_show_cinema_bq_view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rec_show_cinema_bq_view.setLayoutManager(linearLayoutManager);
        }
    }
}
