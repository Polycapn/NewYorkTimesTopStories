package com.example.lelouch.newyorktimestopstories.Service;

import com.example.lelouch.newyorktimestopstories.Model.TopStories;
import com.example.lelouch.newyorktimestopstories.util.AppConfig;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by lelouch on 7/14/2017.
 */

public class MainService {

    private NetworkService networkService;

    private OkHttpClient getAuthClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Interceptor authInterceptor = chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        };
        httpClient.addInterceptor(logging);
        httpClient.addInterceptor(authInterceptor);
        return httpClient.build();
    }

    public MainService() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getAuthClient())
                .build();

        networkService = retrofit.create(NetworkService.class);
    }



    private interface NetworkService{
        @GET("technology.json")
        Observable<TopStories>getTopStories(
                @Query("api_key") String key);

    }
    public Observable<TopStories> getTopStories() {
        return networkService.getTopStories("cf901d91db9346949358310315561890");
    }
}

