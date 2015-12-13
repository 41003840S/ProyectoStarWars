package com.example.manuel.starwars;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.manuel.starwars.provider.characters.CharactersCursor;


public class CharacterAdapter extends SimpleCursorAdapter {

    TextView nombre, altura, masa, pelo, piel, ojos, cumpleanos, genero;
    Context context;

    public CharacterAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cursor myCursor = getCursor();
        //myCursor.moveToPosition(position);

        CharactersCursor cursorCharacter = new CharactersCursor(myCursor);
        cursorCharacter.moveToPosition(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.character_row, parent, false);
        }

        //Enlazamos las variables con las ids
        nombre = (TextView) convertView.findViewById(R.id.tvName);
        altura = (TextView) convertView.findViewById(R.id.tvHeight);
        masa = (TextView) convertView.findViewById(R.id.tvMass);
        pelo = (TextView) convertView.findViewById(R.id.tvHair);
        piel = (TextView) convertView.findViewById(R.id.tvSkin);
        ojos = (TextView) convertView.findViewById(R.id.tvEye);
        cumpleanos = (TextView) convertView.findViewById(R.id.tvBirth);
        genero = (TextView) convertView.findViewById(R.id.tvGender);

        //Metemos los datos de los objetos provinientes de la BD en el layout
        //nombre.setText(myCursor.getString(myCursor.getColumnIndex(CharactersColumns.NAME)));
        nombre.setText(cursorCharacter.getName());
        altura.setText("HEIGHT: " + cursorCharacter.getHeight());
        masa.setText("MASS: " + cursorCharacter.getMass());
        pelo.setText("HAIR: " + cursorCharacter.getHaircolor());
        piel.setText("SKIN: " + cursorCharacter.getSkincolor());
        ojos.setText("EYES: " + cursorCharacter.getEyecolor());
        cumpleanos.setText("BIRTHDAY: " + cursorCharacter.getBirthyear());
        genero.setText("GENDER: " + cursorCharacter.getGender());

        //Si la posicion es par o impar
        if (position % 2 == 1) {
            convertView.setBackgroundResource(R.drawable.layoutsoldado2);
        } else {
            convertView.setBackgroundResource(R.drawable.layoutdarth);
            nombre.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            altura.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            masa.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            pelo.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            piel.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            ojos.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            cumpleanos.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
            genero.setTextAlignment((View.TEXT_ALIGNMENT_TEXT_END));
        }

        return convertView;
    }
}