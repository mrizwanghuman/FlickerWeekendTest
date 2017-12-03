package com.example.admin.flickerweekendtest.imageList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.flickerweekendtest.R;
import com.example.admin.flickerweekendtest.RecylerViewAdapter;
import com.example.admin.flickerweekendtest.RetroFitHelper;
import com.example.admin.flickerweekendtest.data.ImageData;
import com.example.admin.flickerweekendtest.data.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageList extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final List<Item> itemList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.mainActivityRec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetroFitHelper.getImagesHelper().enqueue(new Callback<ImageData>() {
            @Override
            public void onResponse(Call<ImageData> call, Response<ImageData> response) {
itemList.addAll(response.body().getItems());

                RecylerViewAdapter adapter = new RecylerViewAdapter(itemList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ImageData> call, Throwable t) {

            }
        });

    }


}
