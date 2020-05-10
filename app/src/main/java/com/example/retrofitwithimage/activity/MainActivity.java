package com.example.retrofitwithimage.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.retrofitwithimage.R;
import com.example.retrofitwithimage.adapter.FlowerAdapter;
import com.example.retrofitwithimage.model.Flower;
import com.example.retrofitwithimage.service.FlowerService;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://services.hanselandpetal.com/";
    private FlowerService flowerService;
    private List<Flower> flowerList;
    private FlowerAdapter flowerAdapter;
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listviewId);
        flowerList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlowerService service = retrofit.create(FlowerService.class);

        Call<List<Flower>> flowers = service.getAllFlowers();

        flowers.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, final Response<List<Flower>> response) {
                if(response.code() == 200) {
                    flowerList = response.body();
                    //Log.e("Response",""+flowerList.size());
                    flowerAdapter = new FlowerAdapter(MainActivity.this,flowerList);
                    listView.setAdapter(flowerAdapter);
//                    listView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Gson gson = new Gson();
//                            Intent intent = new Intent(MainActivity.this,FlowerDetails.class);
//                            intent.putExtra("obj", gson.toJson(flowerList));
//                            startActivity(intent);
//                        }
//                    });
//                    for(Flower flower : flowerList) {
//                        textView.append(flower.getName()+"\n");
//                    }
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });
    }
}
