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

import com.example.manuel.starwars.charactersJSON.Result;
import com.example.manuel.starwars.provider.characters.CharactersColumns;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharactersActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

    ListView listaPersonajes;
    CharacterAdapter adapterCharacters;

    public CharactersActivityFragment() {
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

        View CharactersFragment = inflater.inflate(R.layout.fragment_characters, container, false);


        //Inicializamos el Loader
        getLoaderManager().initLoader(0, null, this);

        listaPersonajes = (ListView) CharactersFragment.findViewById(R.id.listCharacters);

        //Enlazamos con el adaptador personalizado los datos con el ListView
        adapterCharacters = new CharacterAdapter(getContext(),
                R.layout.character_row,
                null,
                new String[]{
                        CharactersColumns.NAME,
                        CharactersColumns.HEIGHT,
                        CharactersColumns.MASS,
                        CharactersColumns.HAIRCOLOR,
                        CharactersColumns.SKINCOLOR,
                        CharactersColumns.EYECOLOR,
                        CharactersColumns.BIRTHYEAR,
                        CharactersColumns.GENDER
                },
                new int[]{
                        R.id.tvName,
                        R.id.tvHeight,
                        R.id.tvMass,
                        R.id.tvHair,
                        R.id.tvSkin,
                        R.id.tvEye,
                        R.id.tvBirth,
                        R.id.tvGender
                },
                0);

        //Seteamos el GridView con el adaptador
        listaPersonajes.setAdapter(adapterCharacters);


        return CharactersFragment;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                CharactersColumns.CONTENT_URI,
                null,
                null,
                null,
                "_id");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapterCharacters.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapterCharacters.swapCursor(null);
    }
}