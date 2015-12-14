package com.example.manuel.starwars;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.manuel.starwars.provider.movies.MoviesColumns;
import com.example.manuel.starwars.provider.movies.MoviesCursor;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;


public class MoviesAdapter extends SimpleCursorAdapter {

    final private String POSTERURL = "http://image.tmdb.org/t/p/";
    final private String POSTERSIZE = "w185";
    DecimalFormat decimal = new DecimalFormat("#.#");
    Context context;

    public MoviesAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cursor myCursor = getCursor();
        MoviesCursor moviesCursor = new MoviesCursor(myCursor);
        moviesCursor.moveToPosition(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.allmovies_layout, parent, false);
        }

        //Enlazamos las variables con las ids
        TextView tvTitulo = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvPopularidad = (TextView) convertView.findViewById(R.id.tvCriticsScore);
        TextView tvDescripcion = (TextView) convertView.findViewById(R.id.tvSynopsis);
        ImageView ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPoster);

        //Metemos los datos de los objetos provinientes del JSON en el layout
        tvTitulo.setText(moviesCursor.getTitle());
        tvPopularidad.setText(moviesCursor.getPopularity() + "%");
        tvDescripcion.setText(moviesCursor.getOverview());
        Picasso.with(context).load(POSTERURL + POSTERSIZE + moviesCursor.getPosterpath()).fit().into(ivPosterImage);

        return convertView;
    }

}
