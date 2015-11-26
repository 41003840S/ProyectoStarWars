package com.example.manuel.starwars;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class StarShipsActivityFragment extends Fragment {

    public StarShipsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View StarShipsFragment = inflater.inflate(R.layout.fragment_star_ships, container, false);
        return StarShipsFragment;
    }
}
