package edu.uj.android.task3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import org.w3c.dom.Comment;

/**
 * Created by shybovycha on 26.10.14.
 */
public class ExtrasActivity extends Activity {
    protected Order order;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.extras);

        Intent intent = getIntent();

        String title = intent.getStringExtra("order:pizzaTitle");
        String imageUrl = intent.getStringExtra("order:pizzaThumbnailUrl");
        double price = intent.getDoubleExtra("order:pizzaPrice", 0.0);

        order = new Order();

        Pizza pizza = new Pizza(title, price, imageUrl);
        order.setPizza(pizza);
    }

    public void onNextButtonClick(View v) {
        boolean isExpressService = ((CheckBox) findViewById(R.id.express_service)).isChecked();
        boolean isExtraSize = ((CheckBox) findViewById(R.id.extra_size)).isChecked();
        boolean isExtraCheese = ((CheckBox) findViewById(R.id.extra_cheese)).isChecked();

        order.setExpressService(isExpressService);
        order.setExtraSize(isExtraSize);
        order.setExtraCheese(isExtraCheese);

        Intent it = new Intent(this, CommentActivity.class);
        it.putExtra("order:pizzaTitle", order.getPizzaTitle());
        it.putExtra("order:pizzaPrice", order.getPizzaPrice());
        it.putExtra("order:pizzaThumbnailUrl", order.getPizzaThumbnailUrl());
        it.putExtra("order:isExtraSize", order.isExtraSize());
        it.putExtra("order:isExtraCheese", order.isExtraCheese());
        it.putExtra("order:isExpressService", order.isExpressService());
        startActivity(it);
    }
}