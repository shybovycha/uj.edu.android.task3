package edu.uj.android.task3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by shybovycha on 27.10.14.
 */
public class CommentActivity extends Activity {
    protected Order order;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.comment);

        Intent intent = getIntent();

        String title = intent.getStringExtra("order:pizzaTitle");
        String imageUrl = intent.getStringExtra("order:pizzaThumbnailUrl");
        double price = intent.getDoubleExtra("order:pizzaPrice", 0.0);

        boolean extraSize = intent.getBooleanExtra("order:isExtraSize", false);
        boolean extraCheese = intent.getBooleanExtra("order:isExtraCheese", false);
        boolean expressService = intent.getBooleanExtra("order:isExpressService", false);

        order = new Order();

        Pizza pizza = new Pizza(title, price, imageUrl);
        order.setPizza(pizza);

        order.setExtraSize(extraSize);
        order.setExtraCheese(extraCheese);
        order.setExpressService(expressService);
    }

    public void onNextButtonClick(View v) {
        String comment = ((TextView) findViewById(R.id.comment)).getText().toString();

        order.setComment(comment);

        Intent it = new Intent(this, ConfirmationActivity.class);
        it.putExtra("order:pizzaTitle", order.getPizzaTitle());
        it.putExtra("order:pizzaPrice", order.getPizzaPrice());
        it.putExtra("order:pizzaThumbnailUrl", order.getPizzaThumbnailUrl());
        it.putExtra("order:isExtraSize", order.isExtraSize());
        it.putExtra("order:isExtraCheese", order.isExtraCheese());
        it.putExtra("order:isExpressService", order.isExpressService());
        it.putExtra("order:comment", order.getComment());
        startActivity(it);
    }
}