package com.example.retrofitwithimage.service;

import com.example.retrofitwithimage.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerService {
    @GET("feeds/flowers.json")
    Call<List<Flower>> getAllFlowers();
}
