package com.example.swipecard;


public class Spot {
    private String name;
    private String city;
    private String imageUrl; // 新增：圖片 URL 或資源 ID

    private int swipeStatus; // 0:未滑/中立, 1:右滑, -1:左滑

    // getter和setter
    public int getSwipeStatus() {
        return swipeStatus;
    }

    public void setSwipeStatus(int swipeStatus) {
        this.swipeStatus = swipeStatus;
    }
    public Spot(String name, String city, String imageUrl) {
        this.name = name;
        this.city = city;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public String getImageUrl() { return imageUrl; } // 新增 Getter
}