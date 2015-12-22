package com.example.manuel.starwars;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manuel.starwars.provider.characters.CharactersColumns;
import com.example.manuel.starwars.provider.characters.CharactersCursor;

/**
 * A placeholder fragment containing a simple view.
 */
public class CharacterDetailFragment extends Fragment {

    TextView nombre, altura, masa, pelo, piel, ojos, cumpleanos, genero;

    public CharacterDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmetDetail = inflater.inflate(R.layout.fragment_character_detail, container, false);



        Long movie_id = getActivity().getIntent().getLongExtra("movie_id", -1);

        Cursor cursor = getContext().getContentResolver().query(
                CharactersColumns.CONTENT_URI,
                null,
                CharactersColumns._ID + " = ?",
                new String[]{String.valueOf(movie_id)},
                null);

        CharactersCursor charactersCursor = new CharactersCursor(cursor);
        cursor.moveToNext();

        //Enlazamos las variables con las ids
        nombre = (TextView) fragmetDetail.findViewById(R.id.tvName);
        altura = (TextView) fragmetDetail.findViewById(R.id.tvHeight);
        masa = (TextView) fragmetDetail.findViewById(R.id.tvMass);
        pelo = (TextView) fragmetDetail.findViewById(R.id.tvHair);
        piel = (TextView) fragmetDetail.findViewById(R.id.tvSkin);
        ojos = (TextView) fragmetDetail.findViewById(R.id.tvEye);
        cumpleanos = (TextView) fragmetDetail.findViewById(R.id.tvBirth);
        genero = (TextView) fragmetDetail.findViewById(R.id.tvGender);

        //Metemos los datos de los objetos provinientes de la BD en el layout
        //nombre.setText(myCursor.getString(myCursor.getColumnIndex(CharactersColumns.NAME)));
        nombre.setText(charactersCursor.getName());
        altura.setText(Html.fromHtml("HEIGHT: ") + charactersCursor.getHeight());
        masa.setText(Html.fromHtml("MASS: ") + charactersCursor.getMass());
        pelo.setText(Html.fromHtml("HAIR: ") + charactersCursor.getHaircolor());
        piel.setText(Html.fromHtml("SKIN: ") + charactersCursor.getSkincolor());
        ojos.setText(Html.fromHtml("EYES: ") + charactersCursor.getEyecolor());
        cumpleanos.setText(Html.fromHtml("BIRTHDAY: ") + charactersCursor.getBirthyear());
        genero.setText(Html.fromHtml("GENDER: ") + charactersCursor.getGender());

        return fragmetDetail;

    }
}
