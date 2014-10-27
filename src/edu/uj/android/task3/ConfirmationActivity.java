package edu.uj.android.task3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shybovycha on 27.10.14.
 */
public class ConfirmationActivity extends Activity {
    protected Order order;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.confirmation);

        Intent intent = getIntent();

        String title = intent.getStringExtra("order:pizzaTitle");
        String imageUrl = intent.getStringExtra("order:pizzaThumbnailUrl");
        double price = intent.getDoubleExtra("order:pizzaPrice", 0.0);

        boolean extraSize = intent.getBooleanExtra("order:isExtraSize", false);
        boolean extraCheese = intent.getBooleanExtra("order:isExtraCheese", false);
        boolean expressService = intent.getBooleanExtra("order:isExpressService", false);

        String comment = intent.getStringExtra("order:comment");

        order = new Order();

        Pizza pizza = new Pizza(title, price, imageUrl);
        order.setPizza(pizza);

        order.setExtraSize(extraSize);
        order.setExtraCheese(extraCheese);
        order.setExpressService(expressService);
        order.setComment(comment);

        ((TextView) findViewById(R.id.extras)).setText(order.getExtrasString());
        ((TextView) findViewById(R.id.pizza_title)).setText(order.getPizzaTitle());
        ((TextView) findViewById(R.id.pizza_price)).setText(String.format("%.02f", order.getPizzaPrice()));
        ((TextView) findViewById(R.id.comment)).setText(order.getComment());
        ((TextView) findViewById(R.id.total)).setText(String.format("%.02f", order.getTotalPrice()));
    }

    public void onResetButtonClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onSubmitButtonClick(View v) {
        Toast.makeText(this, "Submitted", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}