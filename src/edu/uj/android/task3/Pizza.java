package edu.uj.android.task3;

import android.net.Uri;

/**
 * Created by shybovycha on 20.10.14.
 */
public class Pizza {
    protected String title;
    protected double price;
    protected Uri thumbnail;

    public Pizza(String title, double price, String thumbnailUri) {
        this.title = title;
        this.price = price;
        this.thumbnail = Uri.parse(thumbnailUri);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceStr() {
        return String.format("%.2f", this.price);
    }

    public Uri getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Uri thumbnail) {
        this.thumbnail = thumbnail;
    }
}
