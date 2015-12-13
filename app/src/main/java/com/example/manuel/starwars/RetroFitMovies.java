package com.example.manuel.starwars;


import android.content.Context;
import android.util.Log;

import com.example.manuel.starwars.provider.movies.MoviesColumns;
import com.example.manuel.starwars.provider.movies.MoviesContentValues;
import com.example.manuel.starwars.sagamoviesJSON.Example;
import com.example.manuel.starwars.sagamoviesJSON.Item;

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
    public void downloadMovies(final Context context) {

        //Llamada al servicio SWAPI con el metodo de la interfaz
        Call<Example> llamadaMovie = service.listaSaga(APPID);

        //Cuando recibe la respuesta la pone en cola
        llamadaMovie.enqueue(new Callback<Example>() {

            @Override
            public void onResponse(Response<Example> response, Retrofit retrofit) {

                Example movie = response.body();

                for (Item item : movie.getItems()) {

                    MoviesContentValues valores = new MoviesContentValues();

                    valores.putTitle(item.getTitle());
                    valores.putPopularity(String.valueOf(item.getPopularity())); //Era Double
                    valores.putOverview(item.getOverview());
                    valores.putPosterpath(item.getPosterPath());
                    context.getContentResolver().insert(MoviesColumns.CONTENT_URI, valores.values());
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update movies", Arrays.toString(t.getStackTrace()));
            }
        });
    }

}
