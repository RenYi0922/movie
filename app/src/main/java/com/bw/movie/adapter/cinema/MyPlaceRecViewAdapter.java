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
import com.bw.movie.bean.PlaceBean;

import java.util.List;

/**
 * describe:MyPlaceRecViewAdapter
 * date:2019/11/13
 * author:任(Lenovo)
 * function:
 */
public class MyPlaceRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PlaceBean.ResultBean> list;
    private Context context;

    public MyPlaceRecViewAdapter(List<PlaceBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_show_place, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final PlaceBean.ResultBean resultBean = list.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).tv_place.setText(resultBean.getName());
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
        TextView tv_place;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_place = itemView.findViewById(R.id.tv_place);
        }
    }
    /*private onIntent onIntent;

    public void setOnIntent(MyPlaceRecViewAdapter.onIntent onIntent) {
        this.onIntent = onIntent;
    }

    public interface onIntent{
        void onIntent(String id);
    }*/
}
