package com.example.lelouch.newyorktimestopstories.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.lelouch.newyorktimestopstories.Model.TopStoriesModel;

import java.util.List;

/**
 * Created by lelouch on 7/13/2017.
 */

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.BindingHolder> {
    private List<TopStoriesModel>topStoriesModelList;
    private Context aContext;

    public TopStoriesAdapter(List<TopStoriesModel>topStoriesModelList){
        this.topStoriesModelList = topStoriesModelList;
    }

    @Override
    public TopStoriesAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // TopstoriesItemBinding aBinding = DataBindingUtil.inflate(
              //  LayoutInflater.from(parent.getContext()),
              //  R.layout.cardview, parent, false);

        //return new BindingHolder(aBinding);
        return null;
    }

    @Override
    public void onBindViewHolder(TopStoriesAdapter.BindingHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        public BindingHolder(View itemView) {
            super(itemView);
        }
        // private TopstoriesItemBinding aBinding;

       // public BindingHolder(TopstoriesItemBinding binding) {
//            super(binding.articleCard);
           // this.aBinding = binding;
       // }

    }
}
