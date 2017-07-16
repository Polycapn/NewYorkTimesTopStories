package com.example.lelouch.newyorktimestopstories.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by lelouch on 7/15/2017.
 */

public class WebviewBinder {

    @BindingAdapter("app:webUrl")
    public static void setWebView(WebView webView, String webUrl) {
        if (TextUtils.isEmpty(webUrl)) return;
        ProgressDialog progressDialog = setUpProgressDialog(webView.getContext());

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        webView.loadUrl(webUrl);
    }

    private static ProgressDialog setUpProgressDialog(Context context) {
        ProgressDialog progressDialog = ProgressDialog.show(context, "Loading article", "Please wait", true);
        progressDialog.setCancelable(true);
        progressDialog.show();
        return progressDialog;
    }


}
