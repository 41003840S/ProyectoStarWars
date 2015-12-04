package com.example.manuel.starwars;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.manuel.starwars.charactersJSON.Result;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersActivityFragment extends Fragment {

    ListView listaPersonajes;
    CharacterAdapter adapterCharacters;
    ArrayList<Result> items;


    public CharactersActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        refreshCharacters();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View CharactersFragment = inflater.inflate(R.layout.fragment_characters, container, false);

        listaPersonajes = (ListView) CharactersFragment.findViewById(R.id.listCharacters);

        items = new ArrayList<>();

        //Enlazamos con el adaptador personalizado los datos con el ListView
        adapterCharacters = new CharacterAdapter(getContext(),R.layout.character_row,items);

        listaPersonajes.setAdapter(adapterCharacters);


        return CharactersFragment;
    }

    public void refreshCharacters(){
        RetroFit character1 = new RetroFit();
        character1.downloadCharacters(adapterCharacters);

    }
}