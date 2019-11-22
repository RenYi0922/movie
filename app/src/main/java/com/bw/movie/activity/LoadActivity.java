package com.bw.movie.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.util.DownloadListener;
import com.bw.movie.util.DownloadUtils;
import com.bw.mvplibrary.base.BaseActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoadActivity extends BaseActivity<Presenter> {

    private Handler handler = new Handler();
    private String downloadUrl = "http://172.17.8.100/media/movie.apk";
    @BindView(R.id.btn_down)
    Button btnDown;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.btn_pause)
    Button btnPause;
    @BindView(R.id.tv_load)
    TextView tvLoad;

    @Override
    protected Presenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_load;
    }

    @Override
    protected void initData() {
        super.initData();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File storageDirectory = Environment.getExternalStorageDirectory();
            String absolutePath = storageDirectory.getAbsolutePath();
            final String path = absolutePath + "/Download/";
            Log.i("zzz", "下载路径 " + path);
            DownloadUtils.getInstance().initDownload(path);
            DownloadUtils.getInstance().setListener(new DownloadListener() {
                @Override
                public void startDownload() {

                }

                @Override
                public void pauseDownload() {

                }

                @Override
                public void finishDownload(String path) {
                    installApk(new File(path));
                }


                @Override
                public void downloadProgress(final long progress) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tvLoad.setText((int)progress + "%");
                            progressBar.setProgress((int) progress);
                        }
                    });
                }
            });
        }
    }

    @OnClick({R.id.btn_down, R.id.btn_pause})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_down:
                DownloadUtils.getInstance().startDownload(downloadUrl);
                break;
            case R.id.btn_pause:
                DownloadUtils.getInstance().pauseDownload();
                break;
        }
    }
    private void installApk(File file) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
