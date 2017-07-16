package com.example.lelouch.newyorktimestopstories.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.lelouch.newyorktimestopstories.Model.Result;
import com.example.lelouch.newyorktimestopstories.R;
import com.example.lelouch.newyorktimestopstories.databinding.ActivityTopStoriesBinding;
import com.example.lelouch.newyorktimestopstories.util.AppConfig;
import com.example.lelouch.newyorktimestopstories.util.RefreshCompleteListener;


public class TopStoriesActivity extends AppCompatActivity implements Result.ItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = TopStoriesActivity.class.getSimpleName();
    TopStoriesAdapter topStoriesAdapter;
    ActivityTopStoriesBinding activityTopStoriesBinding;
    private String currentArticle = AppConfig.DEFAULT_SECTION;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTopStoriesBinding = DataBindingUtil.setContentView(this, R.layout.activity_top_stories);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        activityTopStoriesBinding.recyclerView.setLayoutManager(layoutManager);
        /* filling the list with Article data objects */
        topStoriesAdapter = new TopStoriesAdapter(this);
        activityTopStoriesBinding.recyclerView.setAdapter(topStoriesAdapter);
        activityTopStoriesBinding.refreshLayout.setOnRefreshListener(this);
        onRefresh();

    }

    @Override
    public View.OnClickListener onItemClick(Result result) {
        return view -> {
            WebViewFragment webViewFragment = new WebViewFragment();
            Bundle args = new Bundle();
            args.putString(WebViewFragment.WEB_URL, result.getWebUrl());
            webViewFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.webViewFragment, webViewFragment)
                    .addToBackStack(null)
                    .commit();
        };
    }

    @Override
    public void onRefresh() {
        if (topStoriesAdapter != null) {
            activityTopStoriesBinding.refreshLayout.setRefreshing(true);
            topStoriesAdapter.refreshArticles(new RefreshCompleteListener() {
                @Override
                public void onRefreshComplete() {
                    activityTopStoriesBinding.refreshLayout.setRefreshing(false);
                }

                @Override
                public void onError(Throwable throwable) {
                    Log.e(TAG,throwable.getMessage());

                }
            });
        }
    }
}
