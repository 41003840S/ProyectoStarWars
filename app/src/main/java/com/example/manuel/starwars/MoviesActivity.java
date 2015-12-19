package com.example.manuel.starwars;

import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manuel.starwars.provider.movies.MoviesColumns;
import com.example.manuel.starwars.provider.movies.MoviesCursor;
import com.squareup.picasso.Picasso;


public class MoviesActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);

        }

        @Override
        public int getCount() {
            // Show 6 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "THE PHANTOM MENACE";
                case 1:
                    return "ATTACK OF THE CLONES";
                case 2:
                    return "REVENGE OF THE SITH";
                case 3:
                    return "A NEW HOPE";
                case 4:
                    return "THE EMPIRE STRIKES BACK";
                case 5:
                    return "RETURN OF THE JEDI";
                case 6:
                    return "THE FORCE AWAKENS";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        TextView tvTitulo, tvPopularidad, tvDescripcion;
        ImageView ivPosterImage;
        final private String POSTERURL = "http://image.tmdb.org/t/p/";
        final private String POSTERSIZE = "w185";
        int posicion;

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_movies, container, false);

            //Inicializamos el Loader
            getLoaderManager().initLoader(0, null, this);

            posicion = getArguments().getInt(ARG_SECTION_NUMBER);

            //Enlazamos las variables con las ids
            tvTitulo = (TextView) rootView.findViewById(R.id.tvTitle);
            tvPopularidad = (TextView) rootView.findViewById(R.id.tvCriticsScore);
            tvDescripcion = (TextView) rootView.findViewById(R.id.tvSynopsis);
            ivPosterImage = (ImageView) rootView.findViewById(R.id.ivPoster);

            return rootView;
        }

        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            return new CursorLoader(getContext(),
                    MoviesColumns.CONTENT_URI,
                    null,
                    null,
                    null,
                    "_id");
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

            //le resto uno a posicion porque empezaba desde 1
            posicion = posicion -1;
            
            MoviesCursor moviesCursor = new MoviesCursor(data);
            moviesCursor.moveToPosition(posicion);

            tvTitulo.setText(moviesCursor.getTitle());
            tvPopularidad.setText(moviesCursor.getPopularity().substring(0,4) + "%");
            tvDescripcion.setText(moviesCursor.getOverview());
            Picasso.with(getContext()).load(POSTERURL + POSTERSIZE + moviesCursor.getPosterpath()).fit().into(ivPosterImage);

        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    }
}
