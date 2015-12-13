package com.example.manuel.starwars;


import android.content.Context;
import android.util.Log;

import com.example.manuel.starwars.charactersJSON.Result;
import com.example.manuel.starwars.provider.characters.CharactersColumns;
import com.example.manuel.starwars.provider.characters.CharactersContentValues;
import com.example.manuel.starwars.provider.planet.PlanetColumns;
import com.example.manuel.starwars.provider.planet.PlanetContentValues;
import com.example.manuel.starwars.provider.starship.StarshipColumns;
import com.example.manuel.starwars.provider.starship.StarshipContentValues;

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
    public void downloadCharacters(final Context context) {

        //Para recorrer las paginas
        for (int i = 9; i > 0 ; i--) {

            //Llamada al servicio SWAPI con el metodo de la interfaz
            Call<com.example.manuel.starwars.charactersJSON.Example> llamadaCharacter = service.characters(i);

            //Cuando recibe la respuesta la pone en cola
            llamadaCharacter.enqueue(new Callback<com.example.manuel.starwars.charactersJSON.Example>() {
                @Override
                public void onResponse(Response<com.example.manuel.starwars.charactersJSON.Example> response, Retrofit retrofit) {

                    com.example.manuel.starwars.charactersJSON.Example character = response.body();

                    for (Result result : character.getResults()) {

                        CharactersContentValues valores = new CharactersContentValues();

                        valores.putName(result.getName());
                        valores.putHeight(result.getHeight());
                        valores.putMass(result.getMass());
                        valores.putHaircolor(result.getHairColor());
                        valores.putSkincolor(result.getSkinColor());
                        valores.putEyecolor(result.getEyeColor());
                        valores.putBirthyear(result.getBirthYear());
                        valores.putGender(result.getGender());
                        context.getContentResolver().insert(CharactersColumns.CONTENT_URI, valores.values());
                    }

                }
                @Override
                public void onFailure(Throwable t) {
                    Log.e("Update characater", Arrays.toString(t.getStackTrace()));
                }
            });
        }
    }

    //Metodo que hace la llamada a la API (Planetas)
    public void downloadPlanetas(final Context context) {


        //Para recorrer las paginas
        for (int i = 7; i > 0 ; i--) {
            //Llamada al servicio SWAPI con el metodo de la interfaz
            Call<com.example.manuel.starwars.planetsJSON.Example> llamadaPlanet = service.planets(i);

            //Cuando recibe la respuesta la pone en cola
            llamadaPlanet.enqueue(new Callback<com.example.manuel.starwars.planetsJSON.Example>() {

                @Override
                public void onResponse(Response<com.example.manuel.starwars.planetsJSON.Example> response, Retrofit retrofit) {

                    com.example.manuel.starwars.planetsJSON.Example planet = response.body();

                    for (com.example.manuel.starwars.planetsJSON.Result result : planet.getResults()) {

                        PlanetContentValues valores = new PlanetContentValues();

                        valores.putName(result.getName());
                        valores.putRotationperiod(result.getRotationPeriod());
                        valores.putOrbitalperiod(result.getOrbitalPeriod());
                        valores.putDiameter(result.getDiameter());
                        valores.putClimate(result.getClimate());
                        valores.putGravity(result.getGravity());
                        valores.putTerrain(result.getTerrain());
                        valores.putSurfacewater(result.getSurfaceWater());
                        valores.putPopulation(result.getPopulation());
                        context.getContentResolver().insert(PlanetColumns.CONTENT_URI, valores.values());
                    }

                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e("Update characater", Arrays.toString(t.getStackTrace()));
                }
            });
        }
    }
    //Metodo que hace la llamada a la API (Planetas)
    public void downloadNaves(final Context context) {

        //Para recorrer las paginas
        for (int i = 1; i < 5 ; i++) {

            //Llamada al servicio SWAPI con el metodo de la interfaz
            Call<com.example.manuel.starwars.starshipsJSON.Example> llamadaStarship = service.starships(i);

            //Cuando recibe la respuesta la pone en cola
            llamadaStarship.enqueue(new Callback<com.example.manuel.starwars.starshipsJSON.Example>() {

                @Override
                public void onResponse(Response<com.example.manuel.starwars.starshipsJSON.Example> response, Retrofit retrofit) {

                    com.example.manuel.starwars.starshipsJSON.Example starship = response.body();

                    for (com.example.manuel.starwars.starshipsJSON.Result result : starship.getResults()) {

                        StarshipContentValues valores = new StarshipContentValues();

                        valores.putName(result.getName());
                        valores.putModel(result.getModel());
                        valores.putManufacturer(result.getManufacturer());
                        valores.putCostincredits(result.getCostInCredits());
                        valores.putLength(result.getLength());
                        valores.putMaxatmospheringspeed(result.getMaxAtmospheringSpeed());
                        valores.putCrew(result.getCrew());
                        valores.putPassengers(result.getPassengers());
                        valores.putCargocapacity(result.getCargoCapacity());
                        valores.putConsumables(result.getConsumables());
                        valores.putHyperdriverating(result.getHyperdriveRating());
                        valores.putMglt(result.getMGLT());
                        valores.putStarshipclass(result.getStarshipClass());
                        context.getContentResolver().insert(StarshipColumns.CONTENT_URI, valores.values());
                    }

                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e("Update starship", Arrays.toString(t.getStackTrace()));
                }
            });
        }
    }

}
