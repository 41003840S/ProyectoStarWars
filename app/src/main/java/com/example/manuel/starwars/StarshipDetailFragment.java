package com.example.manuel.starwars;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manuel.starwars.provider.starship.StarshipColumns;
import com.example.manuel.starwars.provider.starship.StarshipCursor;

/**
 * A placeholder fragment containing a simple view.
 */
public class StarshipDetailFragment extends Fragment {

    TextView starshipNombre, starshipModelo, starshipCoste, starshipLongitud, starshipVelocidad, starshipTripulacion, starshipPasajeros, starshipCarga, starshipConsumible, starshipHyper, starshipMglt, starshipClase;

    public StarshipDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View StarshipDetailFragment = inflater.inflate(R.layout.fragment_starship_detail, container, false);


        Long movie_id = getActivity().getIntent().getLongExtra("starship_id", -1);

        Cursor cursor = getContext().getContentResolver().query(
                StarshipColumns.CONTENT_URI,
                null,
                StarshipColumns._ID + " = ?",
                new String[]{String.valueOf(movie_id)},
                null);

        StarshipCursor starshipCursor = new StarshipCursor(cursor);
        cursor.moveToNext();

        //Enlazamos las variables con las ids
        starshipNombre = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipName);
        starshipModelo = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipModel);
        starshipCoste = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipCost);
        starshipLongitud = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipLenght);
        starshipVelocidad = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipSpeed);
        starshipTripulacion = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipCrew);
        starshipPasajeros = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipPassengers);
        starshipCarga = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipCargo);
        starshipConsumible = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipConsumibles);
        starshipHyper = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipHyperdrive);
        starshipMglt = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipMglt);
        starshipClase = (TextView) StarshipDetailFragment.findViewById(R.id.tvStarshipClass);

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


        return StarshipDetailFragment;
    }
}
