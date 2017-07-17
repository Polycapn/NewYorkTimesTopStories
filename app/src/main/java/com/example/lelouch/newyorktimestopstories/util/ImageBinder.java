package com.example.lelouch.newyorktimestopstories.util;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by lelouch on 7/15/2017.
 *
 * Used to bind results from Picasso's network request to the Imageview in Recyclerview
 */

public class ImageBinder {
    @BindingAdapter("app:imgUrl")
    public static void setImage(ImageView view, String uri) {
        //using Picasso to request Images for the Topstories eliminating need for boiler plate code

        if (TextUtils.isEmpty(uri)) return;
        Picasso picassoSession = Picasso.with(view.getContext());
        picassoSession.setLoggingEnabled(true);
        picassoSession.load(uri).into(view);
    }

}
