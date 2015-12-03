package com.example.manuel.starwars;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.manuel.starwars.planetsJSON.Result;

import java.util.ArrayList;


public class PlanetsActivityFragment extends Fragment {

    ListView listaPlanetas;
    PlanetAdapter planetAdapter;
    ArrayList<Result> items1;

    public PlanetsActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        refreshPlanets();
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

        listaPlanetas = (ListView) PlanetsFragment.findViewById(R.id.listPlanets);

        items1 = new ArrayList<>();

        //Enlazamos con el adaptador personalizado los datos con el ListView
        planetAdapter = new PlanetAdapter(getContext(),R.layout.planet_row, items1);

        listaPlanetas.setAdapter(planetAdapter);

        return PlanetsFragment;
    }


    public void refreshPlanets(){
        RetroFit planet1 = new RetroFit();
        planet1.mostrarPlanetas(planetAdapter);
    }

}
