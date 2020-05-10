package com.example.retrofitwithimage.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.retrofitwithimage.R;
import com.example.retrofitwithimage.activity.FlowerDetails;
import com.example.retrofitwithimage.model.Flower;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<Flower> {

    LinearLayout linearLayout;
    private final Activity context;
    private final List<Flower> flowers;

    public FlowerAdapter(Activity context,List<Flower> flowers) {
        super(context,R.layout.listviewlayout,flowers);
        this.context = context;
        this.flowers = flowers;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.listviewlayout, parent, false);

        linearLayout = row.findViewById(R.id.linearLayoutId);
        TextView flowerCategory = row.findViewById(R.id.flowercategoryId);
        TextView flowerName = row.findViewById(R.id.flowernameId);
        TextView flowerPrice = row.findViewById(R.id.flowerpriceId);

        flowerCategory.setText(flowers.get(position).getCategory());
        flowerName.setText(flowers.get(position).getName());
        flowerPrice.setText(flowers.get(position).getPrice().toString());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlowerDetails.class);
                intent.putExtra("flowername",flowers.get(position).getName());
                intent.putExtra("flowerimage",flowers.get(position).getPhoto());
                context.startActivity(intent);
                //context.startActivity(new Intent(context, PresidentDetails.class));
            }
        });

        return row;
    }
}
