package com.example.lelouch.newyorktimestopstories.Model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.lelouch.newyorktimestopstories.BR;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lelouch on 7/12/2017.
 */

public class Result extends BaseObservable {

    private static final String SIZE = "superJumbo";
    private String title;
    @SerializedName("url")
    private String webUrl;
    private List<Multimedia> multimedia;
    @SerializedName("short_url")
    private String shortUrl;
    @SerializedName("abstract")
    private String caption;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String url) {
        this.webUrl = url;
        notifyPropertyChanged(BR.webUrl);
    }

    public Multimedia getMultimedia() {
        for (Multimedia media : multimedia) {
            if (media.getFormat().equals(SIZE)) return media;
        }
        return null;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Bindable
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
        notifyPropertyChanged(BR.caption);
    }

    public interface ItemClickListener {
        View.OnClickListener onItemClick(Result result);
    }
}

