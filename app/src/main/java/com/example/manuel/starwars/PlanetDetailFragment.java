package com.example.manuel.starwars;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manuel.starwars.provider.planet.PlanetColumns;
import com.example.manuel.starwars.provider.planet.PlanetCursor;

import java.util.Random;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlanetDetailFragment extends Fragment {

    TextView planetName, planetRotation, planetOrbitation, planetDiameter, planetClimate, planetGravity, planetTerrain, planetWater, planetPopulation;
    ImageView planeta;

    public PlanetDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View planetFragment = inflater.inflate(R.layout.fragment_planet_detail, container, false);

        Long movie_id = getActivity().getIntent().getLongExtra("planet_id", -1);


        Cursor cursor = getContext().getContentResolver().query(
                PlanetColumns.CONTENT_URI,
                null,
                PlanetColumns._ID + " = ?",
                new String[]{String.valueOf(movie_id)},
                null);


        PlanetCursor planetCursor = new PlanetCursor(cursor);
        cursor.moveToNext();

        planetName = (TextView) planetFragment.findViewById(R.id.tvPlanetName);
        planetRotation = (TextView) planetFragment.findViewById(R.id.tvPlanetRotation);
        planetOrbitation = (TextView) planetFragment.findViewById(R.id.tvPlanetOrbital);
        planetDiameter = (TextView) planetFragment.findViewById(R.id.tvPlanetDiameter);
        planetClimate = (TextView) planetFragment.findViewById(R.id.tvPlanetClimate);
        planetGravity = (TextView) planetFragment.findViewById(R.id.tvPlanetGravity);
        planetTerrain = (TextView) planetFragment.findViewById(R.id.tvPlanetTerrain);
        planetWater = (TextView) planetFragment.findViewById(R.id.tvPlanetWater);
        planetPopulation = (TextView) planetFragment.findViewById(R.id.tvPlanetPopulation);
        planeta = (ImageView) planetFragment.findViewById(R.id.imagePlanet);

        //Metemos los datos de los objetos provinientes de la BD en el layout

        planetName.setText(planetCursor.getName());
        planetRotation.setText("ROTATION: " + planetCursor.getRotationperiod());
        planetOrbitation.setText("ORBITATION: " + planetCursor.getOrbitalperiod());
        planetDiameter.setText("DIAMETER: " + planetCursor.getDiameter());
        planetClimate.setText("CLIMATE: " + planetCursor.getClimate());
        planetGravity.setText("GRAVITY: " + planetCursor.getGravity());
        planetTerrain.setText("TERRAIN: " + planetCursor.getTerrain());
        planetWater.setText("WATER SURFACE: " + planetCursor.getSurfacewater());
        planetPopulation.setText("POPULATION: " + planetCursor.getPopulation());

        int[] imagenes={R.drawable.p0,R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,
                R.drawable.p5,R.drawable.p6};

        Random r = new Random();
        int n = r.nextInt((6 - 0) + 1) + 0;
        planeta.setImageResource(imagenes[n]);


        return planetFragment;
    }
}
