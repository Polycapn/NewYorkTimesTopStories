package com.example.lelouch.newyorktimestopstories.util;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.webkit.WebView;

/**
 * Created by lelouch on 7/15/2017.
 */

public class WebviewBinder {

    @BindingAdapter("app:webUrl")
    public static void setWebView(WebView webView, String webUrl) {
        if (TextUtils.isEmpty(webUrl)) return;
        webView.loadUrl(webUrl);
    }


}
