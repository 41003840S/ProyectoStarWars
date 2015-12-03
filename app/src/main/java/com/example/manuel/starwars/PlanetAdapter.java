package com.example.manuel.starwars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.manuel.starwars.planetsJSON.Result;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<Result> {

    TextView planetName, planetRotation, planetOrbitation, planetDiameter, planetClimate, planetGravity, planetTerrain, planetWater, planetPopulation;

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
            convertView = inflater.inflate(R.layout.character_row, parent, false);

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

        //Metemos los datos de los objetos provinientes de la BD en el layout
        planetName.setText(resultItem.getName());
        planetRotation.setText("ROTATION: " + resultItem.getName());
        planetOrbitation.setText("ORBITATION: " + resultItem.getRotationPeriod());
        planetDiameter.setText("DIAMETER: " + resultItem.getOrbitalPeriod());
        planetClimate.setText("CLIMATE: " + resultItem.getDiameter());
        planetGravity.setText("GRAVITY: " + resultItem.getGravity());
        planetTerrain.setText("TERRAIN: " + resultItem.getTerrain());
        planetWater.setText("WATER SURFACE: " + resultItem.getSurfaceWater());
        planetPopulation.setText("POPULATION: " + resultItem.getPopulation());


        //Si la posicion es par o impar
       /* if (position % 2 == 1) {
            convertView.setBackgroundResource(R.drawable.layoutsoldado2);
        } else {
            convertView.setBackgroundResource(R.drawable.layoutdarth);
            nombre.setTextAlignment((View.TEXT_ALIGNMENT_VIEW_END));
            altura.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            masa.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            pelo.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            piel.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            ojos.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            cumpleanos.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            genero.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));


        }*/

        return convertView;

    }

}
