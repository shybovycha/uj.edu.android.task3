package edu.uj.android.task3;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shybovycha on 26.10.14.
 */
public class Order {
    protected String pizzaTitle;
    protected String pizzaThumbnailUrl;
    protected String comment;
    protected double pizzaPrice;
    protected boolean isExtraSize;
    protected boolean isExtraCheese;
    protected boolean isExpressService;

    public Order() {}

    public String getPizzaThumbnailUrl() {
        return pizzaThumbnailUrl;
    }

    public double getTotalPrice() {
        double pizzaPrice = getPizzaPrice(),
                xxlPrice = (isExtraSize ? 1 : 0) * 0.4 * pizzaPrice,
                extraCheesePrice = (isExtraCheese ? 1 : 0) * 0.05 * pizzaPrice,
                expressServicePrice = (isExpressService ? 1 : 0) * 0.1 * pizzaPrice;

        return pizzaPrice + xxlPrice + extraCheesePrice + expressServicePrice;
    }

    protected void setPizza(Pizza p) {
        this.pizzaPrice = p.getPrice();
        this.pizzaTitle = p.getTitle();
        this.pizzaThumbnailUrl = p.getThumbnail().toString();
    }

    public String getPizzaTitle() {
        return pizzaTitle;
    }

    public String getExtrasString() {
        String res = "";

        if (isExtraCheese) {
            res += "extra cheese\n";
        }

        if (isExtraSize) {
            res += "extra size\n";
        }

        if (isExpressService) {
            res += "express service\n";
        }

        return res;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public boolean isExtraSize() {
        return isExtraSize;
    }

    public void setExtraSize(boolean isExtraSize) {
        this.isExtraSize = isExtraSize;
    }

    public boolean isExtraCheese() {
        return isExtraCheese;
    }

    public void setExtraCheese(boolean isExtraCheese) {
        this.isExtraCheese = isExtraCheese;
    }

    public boolean isExpressService() {
        return isExpressService;
    }

    public void setExpressService(boolean isExpressService) {
        this.isExpressService = isExpressService;
    }
}
