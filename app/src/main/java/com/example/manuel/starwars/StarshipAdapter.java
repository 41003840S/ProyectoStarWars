package com.example.manuel.starwars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.manuel.starwars.starshipsJSON.Result;

import java.util.ArrayList;


public class StarshipAdapter extends ArrayAdapter<Result> {

    TextView starshipNombre, starshipModelo, starshipCoste, starshipLongitud, starshipVelocidad, starshipTripulacion, starshipPasajeros, starshipCarga, starshipConsumible, starshipHyper, starshipMglt, starshipClase;

    public StarshipAdapter(Context context, int resource, ArrayList<Result> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtenemos el objeto de la posicion correspondiente
        Result resultItem = getItem(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.starship_row, parent, false);
        }

        //Enlazamos las variables con las ids
        starshipNombre = (TextView) convertView.findViewById(R.id.tvStarshipName);
        starshipModelo = (TextView) convertView.findViewById(R.id.tvStarshipModel);
        starshipCoste = (TextView) convertView.findViewById(R.id.tvStarshipCost);
        starshipLongitud = (TextView) convertView.findViewById(R.id.tvStarshipLenght);
        starshipVelocidad = (TextView) convertView.findViewById(R.id.tvStarshipSpeed);
        starshipTripulacion = (TextView) convertView.findViewById(R.id.tvStarshipCrew);
        starshipPasajeros = (TextView) convertView.findViewById(R.id.tvStarshipPassengers);
        starshipCarga = (TextView) convertView.findViewById(R.id.tvStarshipCargo);
        starshipConsumible = (TextView) convertView.findViewById(R.id.tvStarshipConsumibles);
        starshipHyper = (TextView) convertView.findViewById(R.id.tvStarshipHyperdrive);
        starshipMglt = (TextView) convertView.findViewById(R.id.tvStarshipMglt);
        starshipClase = (TextView) convertView.findViewById(R.id.tvStarshipClass);

        //Metemos los datos de los objetos provinientes de la BD en el layout
        starshipNombre.setText(resultItem.getName());
        starshipModelo.setText("MODEL: " + resultItem.getModel());
        starshipCoste.setText("COST: " + resultItem.getCostInCredits() + " Credits");
        starshipLongitud.setText("LENGHT: " + resultItem.getLength());
        starshipVelocidad.setText("SPEED: " + resultItem.getMaxAtmospheringSpeed());
        starshipTripulacion.setText("CREW: " + resultItem.getCrew());
        starshipPasajeros.setText("PASSENGERS: " + resultItem.getPassengers());
        starshipCarga.setText("CARGO: " + resultItem.getCargoCapacity());
        starshipConsumible.setText("CONSUMABLES: " + resultItem.getConsumables());
        starshipHyper.setText("HYPER DRIVE: " + resultItem.getHyperdriveRating());
        starshipMglt.setText("MEGA LIGHT: " + resultItem.getMGLT());
        starshipClase.setText("CLASS: " + resultItem.getStarshipClass());

        return convertView;

    }
}

