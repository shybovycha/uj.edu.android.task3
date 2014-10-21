package edu.uj.android.task3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends Activity {
    protected ArrayList<Pizza> pizzas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setupPizzaList();


    }

    private void setupPizzaList() {
        createPizzas();

        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        ListView pizzaList = (ListView) findViewById(R.id.pizzaList);
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
