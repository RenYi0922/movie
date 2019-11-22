package com.bw.movie.adapter.movies;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MovieCommentBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * describe:MyHomeMoviesYingPingAdapter
 * date:2019/11/19
 * author:任(Lenovo)
 * function:
 */
public class MyHomeMoviesYingPingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieCommentBean.ResultBean> list;
    private Context context;

    public MyHomeMoviesYingPingAdapter(List<MovieCommentBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movies_yp, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final MovieCommentBean.ResultBean resultBean = list.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder) viewHolder).sView_rec_head.setImageURI(Uri.parse(resultBean.getCommentHeadPic()));
            ((MyViewHolder) viewHolder).tv_name_yp.setText(resultBean.getCommentUserName());
            Date date = new Date(resultBean.getCommentTime());
            String day = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  HH:mm");
                day = simpleDateFormat.format(date);
            }catch (Exception e){
                e.printStackTrace();
            }
            ((MyViewHolder) viewHolder).tv_time_yp.setText(day);
            ((MyViewHolder) viewHolder).tv_pl_yp.setText(resultBean.getCommentContent());
            ((MyViewHolder) viewHolder).tv_dz_yp.setText(resultBean.getGreatNum()+"");
            ((MyViewHolder) viewHolder).tv_replyNum_yp.setText("等"+resultBean.getReplyNum()+"人进行了回复");
            ((MyViewHolder) viewHolder).img_dz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.onClick(resultBean.getCommentId()+"");
                    ((MyViewHolder) viewHolder).tv_dz_yp.setText(resultBean.getGreatNum()+1+"");
                    ((MyViewHolder) viewHolder).img_dz.setImageResource(R.drawable.dianzan_1);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sView_rec_head;
        TextView tv_name_yp,tv_time_yp,tv_pl_yp,tv_dz_yp,tv_replyNum_yp;
        ImageView img_dz;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sView_rec_head = itemView.findViewById(R.id.sView_rec_head);
            tv_name_yp = itemView.findViewById(R.id.tv_name_yp);
            tv_time_yp = itemView.findViewById(R.id.tv_time_yp);
            tv_pl_yp = itemView.findViewById(R.id.tv_pl_yp);
            tv_dz_yp = itemView.findViewById(R.id.tv_dz_yp);
            tv_replyNum_yp = itemView.findViewById(R.id.tv_replyNum_yp);
            img_dz = itemView.findViewById(R.id.img_dz);
        }
    }
    private onClick onClick;

    public void setOnClick(MyHomeMoviesYingPingAdapter.onClick onClick) {
        this.onClick = onClick;
    }

    public interface onClick{
        void onClick(String commentId);
    }
}
