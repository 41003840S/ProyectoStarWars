package com.example.manuel.starwars;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.manuel.starwars.planetsJSON.Result;
import com.example.manuel.starwars.provider.planet.PlanetCursor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class PlanetAdapter extends SimpleCursorAdapter {

    TextView planetName, planetRotation, planetOrbitation, planetDiameter, planetClimate, planetGravity, planetTerrain, planetWater, planetPopulation;
    ImageView planeta;
    Context context;

    public PlanetAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cursor myCursor = getCursor();
        //myCursor.moveToPosition(position);
        PlanetCursor planetCursor = new PlanetCursor(myCursor);
        planetCursor.moveToPosition(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.planet_row, parent, false);

        }

        //Enlazamos las variables con las ids
        planetName = (TextView) convertView.findViewById(R.id.tvPlanetName);
        planetRotation = (TextView) convertView.findViewById(R.id.tvPlanetRotation);
        planetOrbitation = (TextView) convertView.findViewById(R.id.tvPlanetOrbital);
        planetDiameter = (TextView) convertView.findViewById(R.id.tvPlanetDiameter);
        planetClimate = (TextView) convertView.findViewById(R.id.tvPlanetClimate);
        planetGravity = (TextView) convertView.findViewById(R.id.tvPlanetGravity);
        planetTerrain = (TextView) convertView.findViewById(R.id.tvPlanetTerrain);
        planetWater = (TextView) convertView.findViewById(R.id.tvPlanetWater);
        planetPopulation = (TextView) convertView.findViewById(R.id.tvPlanetPopulation);
        planeta = (ImageView) convertView.findViewById(R.id.imagePlanet);

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
        int n = r.nextInt(7);
        planeta.setImageResource(imagenes[n]);

        return convertView;

    }

}
