package com.example.manuel.starwars;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersActivityFragment extends Fragment {

    public CharactersActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View CharactersFragment = inflater.inflate(R.layout.fragment_characters, container, false);

        return CharactersFragment;
    }
}
