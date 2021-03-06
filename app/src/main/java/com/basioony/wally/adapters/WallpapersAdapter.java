package com.basioony.wally.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.basioony.wally.R;
import com.basioony.wally.models.Category;
import com.basioony.wally.models.Wallpaper;
import com.bumptech.glide.Glide;

import java.util.List;

public class WallpapersAdapter extends RecyclerView.Adapter<WallpapersAdapter.CategoryViewHolder>{

    private Context mCtx;
    private List<Wallpaper> wallpaperList;

    public WallpapersAdapter(Context mCtx, List<Wallpaper> wallpaperList) {
        this.mCtx = mCtx;
        this.wallpaperList = wallpaperList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_wallpapers,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        Wallpaper w = wallpaperList.get(position);
        holder.textView.setText(w.title);
        Glide.with(mCtx).load(w.url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return wallpaperList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        public CategoryViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view_title);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
