package com.bw.movie.adapter.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FindMoviesBean;

/**
 * describe:MyHomeMoviesJieShaoAdapter
 * date:2019/11/18
 * author:任(Lenovo)
 * function:
 */
public class MyHomeMoviesJieShaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private FindMoviesBean.ResultBean list;
    private Context context;

    public MyHomeMoviesJieShaoAdapter(FindMoviesBean.ResultBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_movies_js_summary, viewGroup, false);
            return new MySummaryViewHolder(inflate);
        } else if (i == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_movies_js_director, viewGroup, false);
            return new MyDirectorViewHolder(inflate);
        } else if (i == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_movies_js_performer, viewGroup, false);
            return new MyPerformerViewHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        switch (itemViewType){
            case 0:
                if (viewHolder instanceof MySummaryViewHolder) {
                    ((MySummaryViewHolder) viewHolder).tv_summary.setText(list.getSummary());
                }
                break;
            case 1:
                if (viewHolder instanceof MyDirectorViewHolder) {
                    MyHomeMoviesJieShaoDirectorAdapter myHomeMoviesJieShaoDirectorAdapter = new MyHomeMoviesJieShaoDirectorAdapter(list.getMovieDirector(),context);
                    ((MyDirectorViewHolder) viewHolder).rec_home_movies_js_director.setAdapter(myHomeMoviesJieShaoDirectorAdapter);
                }
                break;
            case 2:
                if (viewHolder instanceof MyPerformerViewHolder) {
                    MyHomeMoviesJieShaoPerformerAdapter myHomeMoviesJieShaoPerformerAdapter = new MyHomeMoviesJieShaoPerformerAdapter(list.getMovieActor(),context);
                    ((MyPerformerViewHolder) viewHolder).rec_home_movies_js_performer.setAdapter(myHomeMoviesJieShaoPerformerAdapter);
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0) {
            return 0;
        }else if (position == 1){
            return 1;
        }else if (position == 2) {
            return 2;
        }
        return 0;
    }

    public class MySummaryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_summary;
        public MySummaryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_summary = itemView.findViewById(R.id.tv_summary);
        }
    }
    public class MyDirectorViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rec_home_movies_js_director;
        public MyDirectorViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_home_movies_js_director = itemView.findViewById(R.id.rec_home_movies_js_director);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            rec_home_movies_js_director.setLayoutManager(linearLayoutManager);
        }
    }
    public class MyPerformerViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rec_home_movies_js_performer;
        public MyPerformerViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_home_movies_js_performer = itemView.findViewById(R.id.rec_home_movies_js_performer);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
            rec_home_movies_js_performer.setLayoutManager(gridLayoutManager);
        }
    }
}
