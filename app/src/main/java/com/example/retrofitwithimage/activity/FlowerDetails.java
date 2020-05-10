package com.example.retrofitwithimage.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitwithimage.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class FlowerDetails extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_details);

        imageView = findViewById(R.id.flowerimageId);
        textView = findViewById(R.id.flowernameId);

//        Gson gson = new Gson();
//        String strObj = getIntent().getStringExtra("obj");
//        MainActivity obj = gson.fromJson(strObj, MainActivity.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String flowerName = extras.getString("flowername");
            String flowerImage = extras.getString("flowerimage");
            //Toast.makeText(getApplicationContext(),floweImage, Toast.LENGTH_LONG).show();
            Picasso.get().load("http://services.hanselandpetal.com/photos/"+flowerImage).into(imageView);
            textView.setText(flowerName);
        }
    }
}
