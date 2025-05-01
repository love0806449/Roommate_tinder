package com.example.swipecard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.yuyakaido.android.cardstackview.CardStackView;
import java.util.List;

public class CardStackAdapter extends CardStackView.Adapter<CardStackAdapter.ViewHolder> {

    private List<Spot> spots; // 新增：數據列表

    // 新增：構造方法，傳入數據
    public CardStackAdapter(List<Spot> spots) {
        this.spots = spots;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Spot spot = spots.get(position);
        holder.name.setText(spot.getName());
        holder.city.setText(spot.getCity());

        // 使用 Glide 載入圖片
        Glide.with(holder.itemView.getContext())
                .load(spot.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(holder.image);
    }

    // 新增：必須實現的方法，返回數據數量
    @Override
    public int getItemCount() {
        return spots.size();
    }

    public static class ViewHolder extends CardStackView.ViewHolder {
        TextView name, city;
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.item_name);
            city = view.findViewById(R.id.item_city);
            image = view.findViewById(R.id.item_image);
        }
    }
}