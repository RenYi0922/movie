package com.bw.movie.adapter.home;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.adapter.cinema.MyNowRecViewAdapter;
import com.bw.movie.bean.AfterBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.NowBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * describe:MyHomeAdapter
 * date:2019/11/14
 * author:任(Lenovo)
 * function:
 */
public class MyHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BannerBean.ResultBean> list_banner;
    private List<AfterBean.ResultBean> list_after;
    private List<NowBean.ResultBean> list_now;
    private List<HotBean.ResultBean> list_hot;
    private Context context;

    public MyHomeAdapter(List<BannerBean.ResultBean> list_banner, List<AfterBean.ResultBean> list_after, List<NowBean.ResultBean> list_now, List<HotBean.ResultBean> list_hot, Context context) {
        this.list_banner = list_banner;
        this.list_after = list_after;
        this.list_now = list_now;
        this.list_hot = list_hot;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_banner, viewGroup, false);
            return new MyBannerViewHolder(inflate);
        } else if (i == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_after, viewGroup, false);
            return new MyAfterViewHolder(inflate);
        } else if (i == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_now, viewGroup, false);
            return new MyNowViewHolder(inflate);
        } else if (i == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_hot, viewGroup, false);
            return new MyHotViewHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        switch (itemViewType){
            case 0:
                if (viewHolder instanceof MyBannerViewHolder) {
                    ((MyBannerViewHolder) viewHolder).ban_ner.setImages(list_banner);
                    ((MyBannerViewHolder) viewHolder).ban_ner.setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            BannerBean.ResultBean resultBean = (BannerBean.ResultBean) path;
                            imageView.setImageURI(Uri.parse(resultBean.getImageUrl()));
                        }
                        @Override
                        public ImageView createImageView(Context context) {
                            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
                            return simpleDraweeView;
                        }
                    });
                    ((MyBannerViewHolder) viewHolder).ban_ner.isAutoPlay(true);
                    ((MyBannerViewHolder) viewHolder).ban_ner.setDelayTime(2000);
                    ((MyBannerViewHolder) viewHolder).ban_ner.start();
                }
                break;
            case 1:
                if (viewHolder instanceof MyAfterViewHolder) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    ((MyAfterViewHolder) viewHolder).rec_home_after.setLayoutManager(linearLayoutManager);
                    MyAfterRecViewAdapter myAfterRecViewAdapter = new MyAfterRecViewAdapter(list_after, context);
                    ((MyAfterViewHolder) viewHolder).rec_home_after.setAdapter(myAfterRecViewAdapter);
                    myAfterRecViewAdapter.setOnClick(new MyAfterRecViewAdapter.onClick() {
                        @Override
                        public void moviesId(String moviesId) {
                            onClick.moviesId(moviesId);
                        }
                    });
                }
                break;
            case 2:
                if (viewHolder instanceof MyNowViewHolder) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    ((MyNowViewHolder) viewHolder).rec_home_now.setLayoutManager(linearLayoutManager);
                    MyNowRecViewAdapter myNowRecViewAdapter = new MyNowRecViewAdapter(list_now,context);
                    ((MyNowViewHolder) viewHolder).rec_home_now.setAdapter(myNowRecViewAdapter);
                    myNowRecViewAdapter.setOnClick(new MyNowRecViewAdapter.onClick() {
                        @Override
                        public void moviesId(String moviesId) {
                            onClick.moviesId(moviesId);
                        }
                    });
                }
                break;
            case 3:
                if (viewHolder instanceof MyHotViewHolder) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    ((MyHotViewHolder) viewHolder).rec_home_hot.setLayoutManager(linearLayoutManager);
                    MyHotRecViewAdapter myHotRecViewAdapter = new MyHotRecViewAdapter(list_hot, context);
                    ((MyHotViewHolder) viewHolder).rec_home_hot.setAdapter(myHotRecViewAdapter);
                    myHotRecViewAdapter.setOnClick(new MyHotRecViewAdapter.onClick() {
                        @Override
                        public void moviesId(String moviesId) {
                            onClick.moviesId(moviesId);
                        }
                    });
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0) {
            return 0;
        }else if (position == 1){
            return 1;
        }else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        }
        return 0;
    }

    public class MyAfterViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rec_home_after;
        public MyAfterViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_home_after = itemView.findViewById(R.id.rec_home_after);
        }
    }
    public class MyNowViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rec_home_now;
        public MyNowViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_home_now = itemView.findViewById(R.id.rec_home_now);
        }
    }
    public class MyHotViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rec_home_hot;
        public MyHotViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_home_hot = itemView.findViewById(R.id.rec_home_hot);
        }
    }
    public class MyBannerViewHolder extends RecyclerView.ViewHolder {
        Banner ban_ner;
        public MyBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ban_ner = itemView.findViewById(R.id.ban_ner);
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
