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

public class MainActivity extends AppCompatActivity implements CardStackListener {

    private List<Spot> spots;
    private CardStackAdapter adapter;
    private CardStackView cardStackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStackView = findViewById(R.id.card_stack_view);

        // 初始化數據
        spots = new ArrayList<>();
        spots.add(new Spot("東京鐵塔", "東京", "https://kmweb.moa.gov.tw/files/IMITA_Gallery/13/b1a898ccbb_m.jpg"));
        spots.add(new Spot("晴空塔", "東京", "https://c.files.bbci.co.uk/03F9/production/_93871010_96d3c9bd-2068-4643-bc4f-81c1ad795343.jpg"));
        spots.add(new Spot("淺草寺", "東京", "https://en.pimg.jp/115/846/989/1/115846989.jpg"));
        spots.add(new Spot("曹哲維", "大猛男", "android.resource://" + getPackageName() + "/" + R.drawable.nigga));

        adapter = new CardStackAdapter(spots);
        cardStackView.setAdapter(adapter);

        // 設定 CardStackView 的 LayoutManager
        CardStackLayoutManager manager = new CardStackLayoutManager(this, this); // 第二個參數是 Listener
        cardStackView.setLayoutManager(manager);

        // 設定卡片堆疊行為
        manager.setStackFrom(StackFrom.Top);
        manager.setVisibleCount(3);
        manager.setDirections(Direction.HORIZONTAL); // 只允許左右滑動
    }

    // 以下是 CardStackListener 的實現方法
    @Override
    public void onCardDragging(@NonNull Direction direction, float ratio) {
        Log.d("CardStack", "正在拖拽: " + direction + ", 比例: " + ratio);
    }

    @Override
    public void onCardSwiped(@NonNull Direction direction) {
        int position = ((CardStackLayoutManager)cardStackView.getLayoutManager()).getTopPosition() - 1;
        if (position >= 0 && position < spots.size()) {
            Spot swipedSpot = spots.get(position);

            if (direction == Direction.Right) {
                swipedSpot.setSwipeStatus(1); // 右滑
                Toast.makeText(this, "喜歡: " + swipedSpot.getName(), Toast.LENGTH_SHORT).show();
            } else if (direction == Direction.Left) {
                swipedSpot.setSwipeStatus(-1); // 左滑
                Toast.makeText(this, "不喜歡: " + swipedSpot.getName(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onCardRewound() {
        Log.d("CardStack", "卡片回退");
    }

    @Override
    public void onCardCanceled() {
        Log.d("CardStack", "取消滑動");
    }

    @Override
    public void onCardAppeared(@NonNull View view, int position) {
        Spot spot = spots.get(position);
        Log.d("CardStack", "顯示卡片: " + spot.getName());
    }

    @Override
    public void onCardDisappeared(@NonNull View view, int position) {
        Spot spot = spots.get(position);
        Log.d("CardStack", "消失卡片: " + spot.getName());
    }
}