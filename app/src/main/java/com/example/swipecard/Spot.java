package com.example.swipecard;


public class Spot {
    private String name;
    private String city;
    private String imageUrl; // 新增：圖片 URL 或資源 ID

    public Spot(String name, String city, String imageUrl) {
        this.name = name;
        this.city = city;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public String getImageUrl() { return imageUrl; } // 新增 Getter
}