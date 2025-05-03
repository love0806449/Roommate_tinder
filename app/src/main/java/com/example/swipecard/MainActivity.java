package com.example.swipecard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements CardStackListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardStackView cardStackView = findViewById(R.id.card_stack_view);


        List<Spot> spots = new ArrayList<>();
        spots.add(new Spot("東京鐵塔", "東京", "https://kmweb.moa.gov.tw/files/IMITA_Gallery/13/b1a898ccbb_m.jpg"));
        spots.add(new Spot("晴空塔", "東京", "https://c.files.bbci.co.uk/03F9/production/_93871010_96d3c9bd-2068-4643-bc4f-81c1ad795343.jpg"));
        spots.add(new Spot("淺草寺", "東京", "https://en.pimg.jp/115/846/989/1/115846989.jpg"));
// 或用本地資源（R.drawable.xxx）
        spots.add(new Spot("曹哲維", "大猛男", "android.resource://" + getPackageName() + "/" + R.drawable.nigga));

        CardStackAdapter adapter = new CardStackAdapter(spots);
        cardStackView.setAdapter(adapter);

        // 設定 CardStackView 的 LayoutManager
        CardStackLayoutManager manager = new CardStackLayoutManager(this, this); // 第二個參數是 Listener
        cardStackView.setLayoutManager(manager);

// 設定卡片堆疊行為
        manager.setStackFrom(StackFrom.Top);
        manager.setVisibleCount(3);
        manager.setDirections(Direction.HORIZONTAL); // 只允許左右滑動



    }
    @Override
    public void onCardDragging(@NonNull Direction direction, float ratio) {
        // 卡片正在拖动时调用
    }

    @Override
    public void onCardSwiped(@NonNull Direction direction) {
        // 卡片滑动完成时调用
        if (direction == Direction.Left) {
            Toast.makeText(this, "向左滑动了", Toast.LENGTH_SHORT).show();
            Log.d("SwipeDirection", "Left");
            // 在这里处理左滑逻辑
        } else if (direction == Direction.Right) {
            Toast.makeText(this, "向右滑动了", Toast.LENGTH_SHORT).show();
            Log.d("SwipeDirection", "Right");
            // 在这里处理右滑逻辑
        }
    }

    @Override
    public void onCardRewound() {
        // 卡片回弹时调用
    }

    @Override
    public void onCardCanceled() {
        // 滑动取消时调用
    }

    @Override
    public void onCardAppeared(View view, int position) {
        // 卡片出现时调用
    }

    @Override
    public void onCardDisappeared(View view, int position) {
        // 卡片消失时调用
    }
}