package com.example.lelouch.newyorktimestopstories.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lelouch.newyorktimestopstories.BR;
import com.example.lelouch.newyorktimestopstories.Model.MultimediumModel;
import com.example.lelouch.newyorktimestopstories.Model.ResultModel;
import com.example.lelouch.newyorktimestopstories.Model.TopStoriesModel;

/**
 * Created by lelouch on 7/13/2017.
 */

public class ArticlesViewModel extends BaseObservable {
    TopStoriesModel topStoriesModel;
    ResultModel resultModel;
    MultimediumModel multimediumModel;
    Context context;


    public ArticlesViewModel(TopStoriesModel topStoriesModel, ResultModel resultModel, MultimediumModel multimediumModel, Context context) {
        this.context = context;
        this.multimediumModel = multimediumModel;
        this.resultModel = resultModel;
        this.topStoriesModel = topStoriesModel;
    }

    @Bindable
    public String getTitle() {
        return resultModel.getTitle();
    }

    public void setTitle (String title){
        resultModel.setTitle(title);
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getImageUrl (){
        return multimediumModel.getUrl();
    }
    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url){
        Glide.with(view.getContext()).load(url).centerCrop().into(view);
    }

    



}
