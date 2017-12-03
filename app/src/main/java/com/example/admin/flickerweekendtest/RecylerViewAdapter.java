package com.example.admin.flickerweekendtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.flickerweekendtest.data.ImageData;
import com.example.admin.flickerweekendtest.data.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by  Admin on 12/1/2017.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>{

    List<Item> images;
    private Context context;
    private AlertDialog.Builder alertDialogBuilder;

    public RecylerViewAdapter( Context context) {

        this.context = context;
    }

    public RecylerViewAdapter(List<Item> images) {
        this.images = images;
    }

    @Override
    public RecylerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_view,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecylerViewAdapter.ViewHolder holder, final int position) {
    alertDialogBuilder = new AlertDialog.Builder(context);
//



        final String imageSrc = images.get(position).getMedia().getM();

        Glide.with(context).load(imageSrc).into(holder.imgImage);
        holder.imgImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                alertDialogBuilder.setTitle("Select The Image Size");
               // Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                alertDialogBuilder.setPositiveButton(R.string.large_image, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "Great", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, LargeImageActivity.class);
                        intent.putExtra("Image",imageSrc);
                    context.startActivity(intent);
                    }

                });
                alertDialogBuilder.setNegativeButton(R.string.small_image, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context, SmallImageActivity.class);
                        intent.putExtra("Image", imageSrc);
                        context.startActivity(intent);
                    }
                });

                alertDialogBuilder.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private final ImageView imgImage;

        public ViewHolder(View itemView) {
            super(itemView);

            imgImage = itemView.findViewById(R.id.imImage);
        }
    }
}
