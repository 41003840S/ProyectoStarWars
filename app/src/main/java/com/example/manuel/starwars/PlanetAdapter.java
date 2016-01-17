package com.example.manuel.starwars;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.manuel.starwars.provider.planet.PlanetCursor;

import java.util.Random;

public class PlanetAdapter extends SimpleCursorAdapter {

    TextView planetName;
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

        //Metemos los datos de los objetos provinientes de la BD en el layout
        planetName.setText(planetCursor.getName());

        return convertView;

    }

}
