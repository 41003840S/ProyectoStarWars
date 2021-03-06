package com.example.manuel.starwars;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.manuel.starwars.provider.characters.CharactersColumns;
import com.example.manuel.starwars.provider.movies.MoviesColumns;
import com.example.manuel.starwars.provider.planet.PlanetColumns;
import com.example.manuel.starwars.provider.starship.StarshipColumns;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent i;
    SharedPreferences preferences;
    ListView searchListView;
    CharacterAdapter characterAdapter;
    PlanetAdapter planetAdapter;
    StarshipAdapter starshipAdapter;
    Spinner spinner;
    EditText searchText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Si es la primera vez que arranca hace la llamada y lo guarda en la BD
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean primer_arranque = preferences.getBoolean(getString(R.string.primer_arranque), true);

        if (primer_arranque) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("", false);
            editor.apply();

            RefreshBackground downloadMoviesTask = new RefreshBackground();
            downloadMoviesTask.execute();

        }
        //.......................................

        searchListView = (ListView) findViewById(R.id.listViewSearch);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        spinner = (Spinner) findViewById(R.id.spinner);
        searchText = (EditText) findViewById(R.id.editTextSearch);

        spinner.setVisibility(View.INVISIBLE);
        searchText.setVisibility(View.INVISIBLE);

        spinner.setPrompt("Select Category");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (position == 0) {
                        searchText.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                               Cursor autocompleteCursor = getBaseContext().getContentResolver().query(
                                        CharactersColumns.CONTENT_URI,
                                        null,
                                        CharactersColumns.NAME + " LIKE ?",
                                        new String[]{searchText.getText().toString() + "%"},
                                        "name");

                                characterAdapter = new CharacterAdapter(getBaseContext(),
                                        R.layout.character_row,
                                        autocompleteCursor,
                                        new String[]{
                                                CharactersColumns.NAME,
                                        },
                                        new int[]{
                                                R.id.tvName,
                                        },
                                        0);

                                searchListView.setAdapter(characterAdapter);
                                searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        Intent i = new Intent(getBaseContext(), CharacterDetail.class);
                                        i.putExtra("movie_id", id);
                                        startActivity(i);
                                    }
                                });


                            }
                        });

                    } else if (position == 1) {

                        searchText.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                                Cursor autocompleteCursor = getBaseContext().getContentResolver().query(
                                        PlanetColumns.CONTENT_URI,
                                        null,
                                        PlanetColumns.NAME + " LIKE ?",
                                        new String[]{searchText.getText().toString() + "%"},
                                        "name");

                                planetAdapter = new PlanetAdapter(getBaseContext(),
                                        R.layout.planet_row,
                                        autocompleteCursor,
                                        new String[]{},
                                        new int[]{},
                                        0);

                                searchListView.setAdapter(planetAdapter);

                                searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        Intent i = new Intent(getBaseContext(), PlanetDetail.class);
                                        i.putExtra("planet_id", id);
                                        startActivity(i);
                                    }
                                });
                            }
                        });


                    } else if (position == 2) {

                        searchText.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                                Cursor autocompleteCursor = getBaseContext().getContentResolver().query(
                                        StarshipColumns.CONTENT_URI,
                                        null,
                                        StarshipColumns.NAME + " LIKE ?",
                                        new String[]{searchText.getText().toString() + "%"},
                                        "name");

                                starshipAdapter = new StarshipAdapter(getBaseContext(),
                                        R.layout.starship_row,
                                        autocompleteCursor,
                                        new String[]{},
                                        new int[]{},
                                        0);

                                searchListView.setAdapter(starshipAdapter);

                                searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        Intent i = new Intent(getBaseContext(), StarshipDetail.class);
                                        i.putExtra("starship_id", id);
                                        startActivity(i);
                                    }
                                });
                            }
                        });

                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setTitle("INTERNET CONNECTION");
            alertDialogBuilder.setMessage("You are going to download some data. Make sure you have your WIFI connection enabled otherwise" +
                    " this could result in costs with your operator.\nDownload data?");

            // set positive button: Yes message
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    //Borramos todas las tablas
                    getBaseContext().getContentResolver().delete(
                            CharactersColumns.CONTENT_URI,
                            null,
                            null);
                    getBaseContext().getContentResolver().delete(
                            PlanetColumns.CONTENT_URI,
                            null,
                            null);
                    getBaseContext().getContentResolver().delete(
                            StarshipColumns.CONTENT_URI,
                            null,
                            null);
                    getBaseContext().getContentResolver().delete(
                            MoviesColumns.CONTENT_URI,
                            null,
                            null);

                    //Hacemos la llamada para añadir el contenido de las tablas
                    RefreshBackground downloadMoviesTask = new RefreshBackground();
                    downloadMoviesTask.execute();

                }
            });
            // set negative button: No message
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // cancel the alert box and put a Toast to the user
                    dialog.cancel();
                    Toast.makeText(getApplicationContext(), "You chose a negative answer",
                            Toast.LENGTH_LONG).show();
                }
            });

        AlertDialog alertDialog = alertDialogBuilder.create();
        // show alert
        alertDialog.show();
        return true;
        }
        if (id == R.id.action_search) {
            spinner.setVisibility(View.VISIBLE);
            searchText.setVisibility(View.VISIBLE);
        }

    return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_characters) {
           i = new Intent(this, CharactersActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_planets) {
            i = new Intent(this, PlanetsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_starships) {
            i = new Intent(this, StarShipsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_movies) {
            i = new Intent(this, MoviesActivity.class);
            startActivity(i);
        }else if (id == R.id.nav_news) {
            i = new Intent (this,ComingSoonActivity.class);
            startActivity(i);

           /* try{
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + "sGbxmsDFVnE"));
                startActivity(intent);
            }catch (ActivityNotFoundException ex){
                Intent intent= new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v="+"sGbxmsDFVnE"));
                startActivity(intent);
            }*/

        }else if (id == R.id.nav_settings) {
            //i = new Intent(this, SettingsActivity.class);
            //startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class RefreshBackground extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {

            RetroFit llamadas = new RetroFit();
            llamadas.downloadCharacters(getBaseContext());
            llamadas.downloadPlanetas(getBaseContext());
            llamadas.downloadNaves(getBaseContext());

            RetroFitMovies movie = new RetroFitMovies();
            movie.downloadMovies(getBaseContext());

            return null;
        }
    }
}
