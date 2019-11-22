package com.bw.movie.adapter.cinema;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.AddressBean;

import java.util.List;

/**
 * describe:MyAddressRecViewAdapter
 * date:2019/11/13
 * author:任(Lenovo)
 * function:
 */
public class MyAddressRecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AddressBean.ResultBean> list;
    private Context context;

    public MyAddressRecViewAdapter(List<AddressBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_show_address, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final AddressBean.ResultBean resultBean = list.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).tv_address.setText(resultBean.getRegionName());
            ((MyViewHolder) viewHolder).tv_address.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onClick(resultBean.getRegionId()+"");
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_address = itemView.findViewById(R.id.tv_address);
        }
    }

    private onClick onClick;

    public void setOnClick(MyAddressRecViewAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void onClick(String regionId);
    }
}
