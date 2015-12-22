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

        //Metemos los datos de los objetos provinientes de la BD en el layout
        starshipNombre.setText(starshipCursor.getName());

        //Si la posicion es par o impar
        /*if (position % 2 == 1) {

        } else {

        }*/

        return convertView;

    }
}

