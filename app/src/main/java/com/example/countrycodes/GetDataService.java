package com.example.countrycodes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

        @GET("all")
        Call<List<Country>> getCountrys();
    }

