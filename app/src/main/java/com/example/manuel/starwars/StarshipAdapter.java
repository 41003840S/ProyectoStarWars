package com.example.manuel.starwars;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.manuel.starwars.provider.starship.StarshipColumns;
import com.example.manuel.starwars.provider.starship.StarshipCursor;
import com.example.manuel.starwars.starshipsJSON.Result;

import java.util.ArrayList;


public class StarshipAdapter extends SimpleCursorAdapter {

    TextView starshipNombre, starshipModelo, starshipCoste, starshipLongitud, starshipVelocidad, starshipTripulacion, starshipPasajeros, starshipCarga, starshipConsumible, starshipHyper, starshipMglt, starshipClase;
    Context context;

    public StarshipAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cursor myCursor = getCursor();

        StarshipCursor starshipCursor = new StarshipCursor(myCursor);
        starshipCursor.moveToPosition(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
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
        starshipNombre.setText(starshipCursor.getName());
        starshipModelo.setText(starshipCursor.getModel());
        starshipCoste.setText("COST: " + starshipCursor.getCostincredits() + " Credits");
        starshipLongitud.setText("LENGHT: " + starshipCursor.getLength());
        starshipVelocidad.setText("SPEED: " + starshipCursor.getMaxatmospheringspeed());
        starshipTripulacion.setText("CREW: " + starshipCursor.getCrew());
        starshipPasajeros.setText("PASSENGERS: " + starshipCursor.getPassengers() + " passengers");
        starshipCarga.setText("CARGO: " + starshipCursor.getCargocapacity() + " Kg");
        starshipConsumible.setText("CONSUMABLES: " + starshipCursor.getConsumables());
        starshipHyper.setText("HYPER DRIVE: " + starshipCursor.getHyperdriverating());
        starshipMglt.setText("MEGA LIGHT: " + starshipCursor.getMglt());
        starshipClase.setText("CLASS: " + starshipCursor.getStarshipclass());

        //Si la posicion es par o impar
        if (position % 2 == 1) {
            convertView.setBackgroundResource(R.drawable.space2);
        } else {
            convertView.setBackgroundResource(R.drawable.space1);
            starshipNombre.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipModelo.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipCoste.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipLongitud.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipVelocidad.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipTripulacion.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipPasajeros.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipCarga.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipConsumible.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipHyper.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipPasajeros.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipMglt.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            starshipClase.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
        }

        return convertView;

    }
}

