package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.SwitchPlaceActivity;
import com.bw.movie.bean.ByCinemaBean;
import com.bw.movie.bean.FindCinemasInfoByRegion;
import com.bw.movie.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * describe:MyHomeMoviesSwitchByRecAdapter
 * date:2019/11/21
 * author:任(Lenovo)
 * function:
 */
public class MyHomeMoviesSwitchByRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindCinemasInfoByRegion.ResultBean> list;
    private Context context;

    public MyHomeMoviesSwitchByRecAdapter(List<FindCinemasInfoByRegion.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_by, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).sView_switch_by.setImageURI(Uri.parse(list.get(i).getLogo()));
            ((MyViewHolder) viewHolder).tv_name_by.setText(list.get(i).getName());
            ((MyViewHolder) viewHolder).tv_address_by.setText(list.get(i).getAddress());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SwitchPlaceActivity.class);
                    intent.putExtra("cinemaId",list.get(i).getCinemaId()+"");
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
        SimpleDraweeView sView_switch_by;
        TextView tv_name_by,tv_address_by;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_switch_by = itemView.findViewById(R.id.sView_switch_by);
            tv_name_by = itemView.findViewById(R.id.tv_name_by);
            tv_address_by = itemView.findViewById(R.id.tv_address_by);
        }
    }
}
