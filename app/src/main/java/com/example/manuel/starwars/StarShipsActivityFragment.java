package com.example.manuel.starwars;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.manuel.starwars.starshipsJSON.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class StarShipsActivityFragment extends Fragment {

    ListView listaNaves;
    StarshipAdapter starshipAdapter;
    ArrayList<Result> items2;

    public StarShipsActivityFragment() {
    }

    public void onStart() {
        super.onStart();
        refreshStarships();
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

        listaNaves = (ListView) StarShipsFragment.findViewById(R.id.listStarships);

        items2 = new ArrayList<>();

        //Enlazamos con el adaptador personalizado los datos con el ListView
        starshipAdapter = new StarshipAdapter(getContext(),R.layout.starship_row,items2);

        listaNaves.setAdapter(starshipAdapter);

        return StarShipsFragment;
    }

    public void refreshStarships(){
        RetroFit starship1 = new RetroFit();
        starship1.mostrarNaves(starshipAdapter);
    }
}
