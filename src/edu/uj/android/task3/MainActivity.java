package edu.uj.android.task3;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends ListActivity {
    protected ArrayList<Pizza> pizzas;
    protected Order order;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupPizzaList();
        setupOrder();
    }

    @Override
    public void onListItemClick(ListView listView, View item, int position, long id) {
        Pizza pizza = pizzas.get(position);
        order.setPizza(pizza);

        Intent it = new Intent(this, ExtrasActivity.class);
        it.putExtra("order:pizzaTitle", order.getPizzaTitle());
        it.putExtra("order:pizzaPrice", order.getPizzaPrice());
        it.putExtra("order:pizzaThumbnailUrl", order.getPizzaThumbnailUrl());
        startActivity(it);
    }

    private void setupOrder() {
        this.order = new Order();
    }

    private void setupPizzaList() {
        createPizzas();

        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        ListView pizzaList = (ListView) findViewById(android.R.id.list);
        pizzaList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void createPizzas() {
        this.pizzas = new ArrayList<Pizza>();

        Random rnd = new Random();

        for (int i = 0; i < 5; i++) {
            Pizza pizza = new Pizza(String.format("pizza #%d", i), (rnd.nextInt() * 3.14), "http://google.com/");
            pizzas.add(pizza);
        }
    }
}
