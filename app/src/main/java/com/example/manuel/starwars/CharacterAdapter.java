package com.example.manuel.starwars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.manuel.starwars.charactersJSON.Result;

import java.util.ArrayList;

public class CharacterAdapter extends ArrayAdapter<Result> {

    TextView nombre, altura, masa, pelo, piel, ojos, cumpleanos, genero;

    public CharacterAdapter(Context context, int resource, ArrayList<Result> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtenemos el objeto de la posicion correspondiente
        Result resultItem = getItem(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
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
        nombre.setText(resultItem.getName());
        altura.setText("HEIGHT: " + resultItem.getHeight());
        masa.setText("MASS: " + resultItem.getMass());
        pelo.setText("HAIR: " + resultItem.getHairColor());
        piel.setText("SKIN: " + resultItem.getSkinColor());
        ojos.setText("EYES: " + resultItem.getEyeColor());
        cumpleanos.setText("BIRTHDAY: " + resultItem.getBirthYear());
        genero.setText("GENDER: " + resultItem.getGender());

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