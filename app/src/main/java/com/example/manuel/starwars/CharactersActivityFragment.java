package com.example.manuel.starwars;


import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.manuel.starwars.provider.characters.CharactersColumns;


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
                },
                new int[]{
                        R.id.tvName,
                },
                0);

        //Seteamos el GridView con el adaptador
        listaPersonajes.setAdapter(adapterCharacters);

        //Crea un Listener para que con pulsacion abra otro activity con la informacion de la pelicula
        listaPersonajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Cogemos la id de la pelicula seleccionada y se la pasamos con un intent a ActivityDetail
                Intent i = new Intent(getContext(), CharacterDetail.class);
                i.putExtra("movie_id", id);
                startActivity(i);
            }
        });


        return CharactersFragment;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                CharactersColumns.CONTENT_URI,
                null,
                null,
                null,
                "name");
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