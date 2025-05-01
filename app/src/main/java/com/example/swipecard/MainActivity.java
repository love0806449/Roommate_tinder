package com.example.swipecard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

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
        spots.add(new Spot("台場", "東京", "android.resource://" + getPackageName() + "/" + R.drawable.nigga));

        CardStackAdapter adapter = new CardStackAdapter(spots);
        cardStackView.setAdapter(adapter);

        // 設定 CardStackView 的 LayoutManager
        CardStackLayoutManager manager = new CardStackLayoutManager(this);
        cardStackView.setLayoutManager(manager);
// 設定卡片堆疊行為
        manager.setStackFrom(StackFrom.Top);         // 堆疊方向（Top/Bottom/Left/Right）
        manager.setVisibleCount(3);                 // 可見卡片數量
        manager.setTranslationInterval(12.0f);      // 卡片間距
        manager.setScaleInterval(0.95f);            // 卡片縮放比例
        manager.setSwipeThreshold(0.3f);            // 滑動閾值（0.1~1.0）
        manager.setMaxDegree(20.0f);                // 卡片最大旋轉角度
        manager.setDirections(Direction.HORIZONTAL); // 允許滑動方向（水平/垂直）
        manager.setCanScrollHorizontal(true);       // 允許水平滑動
        manager.setCanScrollVertical(true);         // 允許垂直滑動
    }

}
