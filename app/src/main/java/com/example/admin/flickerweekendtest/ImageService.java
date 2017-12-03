package com.example.admin.flickerweekendtest;

import com.example.admin.flickerweekendtest.data.ImageData;
import com.example.admin.flickerweekendtest.data.Item;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by  Admin on 12/1/2017.
 */

public interface ImageService {
    @GET("photos_public.gne?tag=kitten&format=json&nojsoncallback=1")
   Call<ImageData> getFlickerImage();

}
