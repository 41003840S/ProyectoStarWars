package com.example.manuel.starwars;


import android.util.Log;

import java.util.Arrays;


import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;


//Interfaz
interface InterfazStarWarsApi {

    @GET("people")
    Call<com.example.manuel.starwars.charactersJSON.Example> characters(@Query("page") Integer page);

    @GET("planets")
    Call<com.example.manuel.starwars.planetsJSON.Example> planets(@Query("page") Integer page);

    @GET("starships")
    Call<com.example.manuel.starwars.starshipsJSON.Example> starships(@Query("page") Integer page);
}


public class RetroFit {

    private final InterfazStarWarsApi service;
    private final String BASE_URL = "http://swapi.co/api/";
    private int PAGECHARACTERS = 1;
    private int PAGEPLANETS = 1;
    private int PAGESTARSHIPS = 1;


    //Constructor de la clase con el builder
    public RetroFit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(InterfazStarWarsApi.class);
    }

    //Metodo que hace la llamada a la API (Characters)
    public void mostrarCharacters(final CharacterAdapter adapter) {
        //Llamada al servicio SWAPI con el metodo de la interfaz
        Call<com.example.manuel.starwars.charactersJSON.Example> llamadaCharacter = service.characters(PAGECHARACTERS);

        //Cuando recibe la respuesta la pone en cola
        llamadaCharacter.enqueue(new Callback<com.example.manuel.starwars.charactersJSON.Example>() {

            @Override
            public void onResponse(Response<com.example.manuel.starwars.charactersJSON.Example> response, Retrofit retrofit) {

                com.example.manuel.starwars.charactersJSON.Example character = response.body();

                adapter.clear();
                Log.i("Verificar CHARACTERS", character.getResults() + "");
                adapter.addAll(character.getResults());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update characater", Arrays.toString(t.getStackTrace()));
            }
        });
    }

    //Metodo que hace la llamada a la API (Planetas)
    public void mostrarPlanetas(final PlanetAdapter adapter1) {

        //Llamada al servicio SWAPI con el metodo de la interfaz
        Call<com.example.manuel.starwars.planetsJSON.Example> llamadaPlanet = service.planets(PAGEPLANETS);

        //Cuando recibe la respuesta la pone en cola
        llamadaPlanet.enqueue(new Callback<com.example.manuel.starwars.planetsJSON.Example>() {

            @Override
            public void onResponse(Response<com.example.manuel.starwars.planetsJSON.Example> response, Retrofit retrofit) {

                com.example.manuel.starwars.planetsJSON.Example planet = response.body();

                adapter1.clear();
                Log.i("Verificar PLANETS", planet.getResults() + "");
                adapter1.addAll(planet.getResults());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update characater", Arrays.toString(t.getStackTrace()));
            }
        });

    }
    //Metodo que hace la llamada a la API (Planetas)
    public void mostrarNaves(final StarshipAdapter adapter2) {

        //Llamada al servicio SWAPI con el metodo de la interfaz
        Call<com.example.manuel.starwars.starshipsJSON.Example> llamadaStarship = service.starships(PAGESTARSHIPS);

        //Cuando recibe la respuesta la pone en cola
        llamadaStarship.enqueue(new Callback<com.example.manuel.starwars.starshipsJSON.Example>() {

            @Override
            public void onResponse(Response<com.example.manuel.starwars.starshipsJSON.Example> response, Retrofit retrofit) {

                com.example.manuel.starwars.starshipsJSON.Example starship = response.body();

                adapter2.clear();
                Log.i("Verificar STARSHIP", starship.getResults() + "");
                adapter2.addAll(starship.getResults());
            }
            @Override
            public void onFailure(Throwable t) {
                Log.e("Update starship", Arrays.toString(t.getStackTrace()));
            }
        });
        }

    }
