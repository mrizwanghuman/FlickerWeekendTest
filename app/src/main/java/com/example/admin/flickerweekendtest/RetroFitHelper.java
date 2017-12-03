package com.example.admin.flickerweekendtest;

import com.example.admin.flickerweekendtest.data.ImageData;
import com.example.admin.flickerweekendtest.data.Item;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by  Admin on 12/1/2017.
 */

public class RetroFitHelper {
    public static final String BASE_URL = "http://api.flickr.com/services/feeds/";

    public static Retrofit retrofitConfig(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public static Call<ImageData> getImagesHelper(){
        Retrofit retrofit = retrofitConfig();
        ImageService imageService = retrofit.create(ImageService.class);
        return imageService.getFlickerImage();
    }

}
