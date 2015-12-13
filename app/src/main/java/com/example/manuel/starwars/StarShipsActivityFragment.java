package com.example.manuel.starwars;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.manuel.starwars.provider.starship.StarshipColumns;
import com.example.manuel.starwars.starshipsJSON.Result;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class StarShipsActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {

    ListView listaNaves;
    StarshipAdapter starshipAdapter;
    ArrayList<Result> items2;

    public StarShipsActivityFragment() {
    }

    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View StarShipsFragment = inflater.inflate(R.layout.fragment_star_ships, container, false);

        //Inicializamos el Loader
        getLoaderManager().initLoader(0, null, this);

        listaNaves = (ListView) StarShipsFragment.findViewById(R.id.listStarships);

        //Enlazamos con el adaptador personalizado los datos con el ListView
        starshipAdapter = new StarshipAdapter(getContext(),
                R.layout.starship_row,
                null,
                new String[]{
                        StarshipColumns.NAME,
                        StarshipColumns.MODEL,
                        StarshipColumns.COSTINCREDITS,
                        StarshipColumns.LENGTH,
                        StarshipColumns.MAXATMOSPHERINGSPEED,
                        StarshipColumns.CREW,
                        StarshipColumns.PASSENGERS,
                        StarshipColumns.CARGOCAPACITY,
                        StarshipColumns.CONSUMABLES,
                        StarshipColumns.HYPERDRIVERATING,
                        StarshipColumns.MGLT,
                        StarshipColumns.STARSHIPCLASS
                },
                new int[]{
                        R.id.tvStarshipName,
                        R.id.tvStarshipModel,
                        R.id.tvStarshipCost,
                        R.id.tvStarshipLenght,
                        R.id.tvStarshipSpeed,
                        R.id.tvStarshipCrew,
                        R.id.tvStarshipPassengers,
                        R.id.tvStarshipCargo,
                        R.id.tvStarshipConsumibles,
                        R.id.tvStarshipHyperdrive,
                        R.id.tvStarshipMglt,
                        R.id.tvStarshipClass

                },
                0);

        listaNaves.setAdapter(starshipAdapter);

        return StarShipsFragment;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                StarshipColumns.CONTENT_URI,
                null,
                null,
                null,
                "_id");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        starshipAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        starshipAdapter.swapCursor(null);
    }
}
