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

import com.example.manuel.starwars.provider.planet.PlanetColumns;


public class PlanetsActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

    ListView listaPlanetas;
    PlanetAdapter planetAdapter;

    public PlanetsActivityFragment() {
    }

    @Override
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

        View PlanetsFragment = inflater.inflate(R.layout.fragment_planets, container, false);

        //Inicializamos el Loader
        getLoaderManager().initLoader(0, null, this);

        listaPlanetas = (ListView) PlanetsFragment.findViewById(R.id.listPlanets);


        //Enlazamos con el adaptador personalizado los datos con el ListView
        planetAdapter = new PlanetAdapter(getContext(),
                R.layout.planet_row,
                null,
                new String[]{},
                new int[]{},
                0);

        listaPlanetas.setAdapter(planetAdapter);

        return PlanetsFragment;
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                PlanetColumns.CONTENT_URI,
                null,
                null,
                null,
                "name");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        planetAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        planetAdapter.swapCursor(null);
    }
}
