package com.bw.movie.adapter.cinema;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FindCinemaBean;

/**
 * describe:MyCinemaBQRecViewAdapter
 * date:2019/11/20
 * author:任(Lenovo)
 * function:
 */
public class MyCinemaBQRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindCinemaBean.ResultBean list;
    private Context context;

    public MyCinemaBQRecViewAdapter(FindCinemaBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_label, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            String[] split = list.getLabel().split(",");
            for (int j = 0; j < split.length; j++) {
                String s = split[j];
                ((MyViewHolder) viewHolder).tv_label_cinema.setText(s);
            }
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_label_cinema;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_label_cinema = itemView.findViewById(R.id.tv_label_cinema);
        }
    }
}
