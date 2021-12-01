package com.arif.carikos.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface service {

    @GET("list.php")
    Call<Responserver> getlistkos();


    @GET("view.php")
    Call<Responserver> getlistkos(
            @Query("key") String key
    );
}
