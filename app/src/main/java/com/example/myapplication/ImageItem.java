package com.example.myapplication;

public class ImageItem {
    private String imageUrl;
    private long timestamp; // 시간 알려주는 정수형 값
    public ImageItem(String imageUrl, long timestamp) {
        this.imageUrl = imageUrl;
        this.timestamp=timestamp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
