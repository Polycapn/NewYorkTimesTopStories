package com.example.lelouch.newyorktimestopstories.util;

/**
 * Created by lelouch on 7/16/2017.
 */

public interface RefreshCompleteListener {
    void onRefreshComplete();
    void onError(Throwable throwable);
}
