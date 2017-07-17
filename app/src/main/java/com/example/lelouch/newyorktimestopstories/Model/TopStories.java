package com.example.lelouch.newyorktimestopstories.Model;


import com.example.lelouch.newyorktimestopstories.Service.MainService;

import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by lelouch on 7/12/2017.
 *
 * Model that contains an Array List of Top Stories
 */

public class TopStories {

    private List<Result> results = null;

    public static Observable<TopStories> requestArticlesData() {
        return new MainService().getTopStories()
                .subscribeOn(Schedulers.io());
    }

    public List<Result> getResults() {
        return results;
    }
}

