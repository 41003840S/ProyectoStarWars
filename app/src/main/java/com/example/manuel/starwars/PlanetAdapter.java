package com.example.manuel.starwars;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manuel.starwars.planetsJSON.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class PlanetAdapter extends ArrayAdapter<Result> {

    TextView planetName, planetRotation, planetOrbitation, planetDiameter, planetClimate, planetGravity, planetTerrain, planetWater, planetPopulation;
    ImageView planeta;


    public PlanetAdapter(Context context, int resource, ArrayList<Result> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtenemos el objeto de la posicion correspondiente
        Result resultItem = getItem(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
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
        planetName.setText(resultItem.getName()+ "");
        planetRotation.setText("ROTATION: " + resultItem.getRotationPeriod());
        planetOrbitation.setText("ORBITATION: " + resultItem.getOrbitalPeriod());
        planetDiameter.setText("DIAMETER: " + resultItem.getDiameter());
        planetClimate.setText("CLIMATE: " + resultItem.getClimate());
        planetGravity.setText("GRAVITY: " + resultItem.getGravity());
        planetTerrain.setText("TERRAIN: " + resultItem.getTerrain());
        planetWater.setText("WATER SURFACE: " + resultItem.getSurfaceWater());
        planetPopulation.setText("POPULATION: " + resultItem.getPopulation());

        int[] imagenes={R.drawable.p0,R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,
                R.drawable.p5,R.drawable.p6};
        Random r = new Random();
        int n = r.nextInt(7);
        planeta.setImageResource(imagenes[n]);

        return convertView;

    }

}
