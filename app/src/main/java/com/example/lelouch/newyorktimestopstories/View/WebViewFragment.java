package com.example.lelouch.newyorktimestopstories.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lelouch.newyorktimestopstories.R;
import com.example.lelouch.newyorktimestopstories.databinding.WebviewBinding;

/**
 * Created by leloud' ch on 7/15/2017.
 *
 * View used to anchor Webview
 */

public class WebViewFragment extends Fragment {

    public static final String WEB_URL = "web_url";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        WebviewBinding binding = DataBindingUtil.inflate(inflater, R.layout.webview, container, false);
        Bundle arguments = getArguments();
        String webUrl = arguments.getString(WEB_URL);
        binding.setWebUrl(webUrl);
        return binding.getRoot();
    }
}
