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

    //Constructor de la clase con el builder
    public RetroFit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(InterfazStarWarsApi.class);
    }

    //Metodo que hace la llamada a la API (Characters)
    public void downloadCharacters(final CharacterAdapter adapter) {

        adapter.clear();

        //Para recorrer las paginas
        for (int i = 9; i > 0 ; i--) {

            //Llamada al servicio SWAPI con el metodo de la interfaz
            Call<com.example.manuel.starwars.charactersJSON.Example> llamadaCharacter = service.characters(i);

            //Cuando recibe la respuesta la pone en cola
            llamadaCharacter.enqueue(new Callback<com.example.manuel.starwars.charactersJSON.Example>() {
                @Override
                public void onResponse(Response<com.example.manuel.starwars.charactersJSON.Example> response, Retrofit retrofit) {

                    com.example.manuel.starwars.charactersJSON.Example character = response.body();

                    Log.i("Verificar CHARACTERS", character.getResults() + "");
                    adapter.addAll(character.getResults());
                }
                @Override
                public void onFailure(Throwable t) {
                    Log.e("Update characater", Arrays.toString(t.getStackTrace()));
                }
            });
        }
    }

    //Metodo que hace la llamada a la API (Planetas)
    public void downloadPlanetas(final PlanetAdapter adapter1) {

        adapter1.clear();

        //Para recorrer las paginas
        for (int i = 7; i > 0 ; i--) {
            //Llamada al servicio SWAPI con el metodo de la interfaz
            Call<com.example.manuel.starwars.planetsJSON.Example> llamadaPlanet = service.planets(i);

            //Cuando recibe la respuesta la pone en cola
            llamadaPlanet.enqueue(new Callback<com.example.manuel.starwars.planetsJSON.Example>() {

                @Override
                public void onResponse(Response<com.example.manuel.starwars.planetsJSON.Example> response, Retrofit retrofit) {

                    com.example.manuel.starwars.planetsJSON.Example planet = response.body();

                    Log.i("Verificar PLANETS", planet.getResults() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getPopulation() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getClimate() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getCreated() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getDiameter() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getEdited() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getGravity() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getName() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getOrbitalPeriod() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getTerrain() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getRotationPeriod() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getSurfaceWater() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getResidents() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getUrl() + "");
                    Log.i("Verificar PLANET", planet.getResults().get(0).getFilms() + "");


                    adapter1.addAll(planet.getResults());
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e("Update characater", Arrays.toString(t.getStackTrace()));
                }
            });
        }
    }
    //Metodo que hace la llamada a la API (Planetas)
    public void downloadNaves(final StarshipAdapter adapter2) {

        adapter2.clear();

        //Para recorrer las paginas
        for (int i = 1; i < 5 ; i++) {

            //Llamada al servicio SWAPI con el metodo de la interfaz
            Call<com.example.manuel.starwars.starshipsJSON.Example> llamadaStarship = service.starships(i);

            //Cuando recibe la respuesta la pone en cola
            llamadaStarship.enqueue(new Callback<com.example.manuel.starwars.starshipsJSON.Example>() {

                @Override
                public void onResponse(Response<com.example.manuel.starwars.starshipsJSON.Example> response, Retrofit retrofit) {

                    com.example.manuel.starwars.starshipsJSON.Example starship = response.body();

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

}
