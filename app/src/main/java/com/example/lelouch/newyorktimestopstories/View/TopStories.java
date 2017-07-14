package com.example.lelouch.newyorktimestopstories.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lelouch.newyorktimestopstories.Model.TopStoriesModel;
import com.example.lelouch.newyorktimestopstories.R;
import com.example.lelouch.newyorktimestopstories.databinding.ActivityTopStoriesBinding;

import java.util.ArrayList;
import java.util.List;

public class TopStories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityTopStoriesBinding activityTopStoriesBinding = DataBindingUtil.setContentView(this, R.layout.activity_top_stories);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        activityTopStoriesBinding.topstories.setLayoutManager(layoutManager);

        List<TopStoriesModel>resultModelList = new ArrayList<>();

        /* filling the list with Article data objects */
        TopStoriesAdapter topStoriesAdapter = new TopStoriesAdapter(resultModelList);



    }
}
