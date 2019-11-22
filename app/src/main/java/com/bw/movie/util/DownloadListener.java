package com.bw.movie.util;

/**
 * describe:DownloadListener
 * date:2019/11/7
 * author:任(Lenovo)
 * function:
 */
public interface DownloadListener {
    void startDownload();

    void pauseDownload();

    void finishDownload(String path);

    void downloadProgress(long progress);
}
