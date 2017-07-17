package com.example.lelouch.newyorktimestopstories.View;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lelouch.newyorktimestopstories.BR;
import com.example.lelouch.newyorktimestopstories.Model.Multimedia;
import com.example.lelouch.newyorktimestopstories.Model.Result;
import com.example.lelouch.newyorktimestopstories.Model.TopStories;
import com.example.lelouch.newyorktimestopstories.R;
import com.example.lelouch.newyorktimestopstories.util.RefreshCompleteListener;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by lelouch on 7/13/2017.
 *
 * Binds array list of Top Stories to Cards
 */

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.BindingHolder> {
    public static final String TAG = TopStoriesAdapter.class.getSimpleName();
    private Result.ItemClickListener clickListener;
    private List<Result> topStories;

    TopStoriesAdapter(Result.ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }


    @Override
    public TopStoriesAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.cardview, parent, false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(TopStoriesAdapter.BindingHolder holder, int position) {
        ViewDataBinding binding = holder.getDataBinding();
        Result result = topStories.get(position);
        binding.setVariable(BR.result, result);
        Multimedia multimedia = result.getMultimedia();
        if (multimedia != null) binding.setVariable(BR.multimedia, multimedia);
        binding.getRoot().setOnClickListener(clickListener.onItemClick(result));
    }

    @Override
    public int getItemCount() {

        if (topStories != null)
            return topStories.size();
        else
            return 0;
    }

    public void refreshArticles(RefreshCompleteListener refreshCompleteListener) {
        TopStories.requestArticlesData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(topStories -> {
                    setTopStories(topStories.getResults());
                    notifyDataSetChanged();
                    refreshCompleteListener.onRefreshComplete();
                }, throwable -> {
                    refreshCompleteListener.onError(throwable);
                    Log.e(TAG, throwable.getMessage());
                });
    }

    public void setTopStories(List<Result> topStories) {
        this.topStories = topStories;
    }

    class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding dataBinding;

        BindingHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            dataBinding = binding;
            dataBinding.executePendingBindings();
        }

        ViewDataBinding getDataBinding() {
            return dataBinding;
        }


    }
}
