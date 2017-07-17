package com.example.lelouch.newyorktimestopstories.util;

/**
 * Created by lelouch on 7/16/2017.
 *
 * Used to handle refreshing animation and any possible errors from refreshing Top Stories Activity
 */

public interface RefreshCompleteListener {
    void onRefreshComplete();
    void onError(Throwable throwable);
}
