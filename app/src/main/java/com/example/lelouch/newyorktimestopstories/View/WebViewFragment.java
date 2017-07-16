package com.example.lelouch.newyorktimestopstories.View;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lelouch.newyorktimestopstories.R;
import com.example.lelouch.newyorktimestopstories.databinding.WebviewBinding;

/**
 * Created by leloud' ch on 7/15/2017.
 */

public class WebViewFragment extends Fragment {

    public static final String WEB_URL = "web_url";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        WebviewBinding binding = DataBindingUtil.inflate(inflater, R.layout.webview, container, false);
        ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Loading article", "Please wait", true);
        progressDialog.setCancelable(true);
        progressDialog.show();


        Bundle arguments = getArguments();
        String webUrl = arguments.getString(WEB_URL);
        WebView webView = binding.webView;
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
        return binding.getRoot();
    }
}
