package com.example.manuel.starwars;


import android.util.Log;

import com.example.manuel.starwars.sagamoviesJSON.Example;
import com.example.manuel.starwars.sagamoviesJSON.Item;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

interface InterfazTheMovieDB {

    //ID de la lista
    @GET("509fb10819c29510bb000675")
    Call<Example> listaSaga(
            @Query("api_key") String api_key);

}
public class RetroFitMovies {

    private final InterfazTheMovieDB service;
    private final String BASE_URL = "https://api.themoviedb.org/3/list/";
    private final String APPID = "13bc649b4be786a5459437a47ac059a5";

    //Constructor de la clase con el builder
    public RetroFitMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(InterfazTheMovieDB.class);
    }

    //Metodo que hace la llamada a la API (Characters)
    public void downloadMovies() {

        //Llamada al servicio SWAPI con el metodo de la interfaz
        Call<Example> llamadaMovie = service.listaSaga(APPID);

        //Cuando recibe la respuesta la pone en cola
        llamadaMovie.enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Response<Example> response, Retrofit retrofit) {

                Example movie = response.body();



                for (Item item : movie.getItems()) {
                    //pelis.add(item);
                }

                Log.i("Verificar MOVIES", movie.getItems() + "");
                //Comprobar que se han guardado las pelis
               /* for (Item peli : pelis) {
                    Log.i("Verificar MOVIES", peli.getTitle() + "");
                }*/


            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update movies", Arrays.toString(t.getStackTrace()));
            }
        });
    }

}
