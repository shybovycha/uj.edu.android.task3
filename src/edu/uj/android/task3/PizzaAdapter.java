package edu.uj.android.task3;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shybovycha on 20.10.14.
 */
public class PizzaAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Pizza> data;
    private static LayoutInflater inflater = null;
    // public ImageLoader imageLoader;

    public PizzaAdapter(Activity a, ArrayList<Pizza> d) {
        activity = a;
        data = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if (convertView == null)
            vi = inflater.inflate(R.layout.pizza_list_item, null);

        TextView title = (TextView) vi.findViewById(R.id.title);
        TextView price = (TextView) vi.findViewById(R.id.price);
        ImageView thumb_image = (ImageView) vi.findViewById(R.id.thumbnail);

        Pizza pizza = data.get(position);

        title.setText(pizza.getTitle());
        price.setText(pizza.getPriceStr());
        thumb_image.setImageURI(pizza.getThumbnail());
        // imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);

        return vi;
    }
}
