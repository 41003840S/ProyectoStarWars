package com.example.manuel.starwars;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent i;
    TextView titulo, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titulo = (TextView) findViewById(R.id.mainTitle);
        titulo.setText("Star Wars API");
        descripcion = (TextView) findViewById(R.id.mainDescription);
        descripcion.setText("Podras consultar información acerca de los personajes, planetas y naves de la trilogía de Star Wars");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            RefreshBackground downloadMoviesTask = new RefreshBackground();
            downloadMoviesTask.execute();
            return true;
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
            try{
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + "sGbxmsDFVnE"));
                startActivity(intent);
            }catch (ActivityNotFoundException ex){
                Intent intent= new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v="+"sGbxmsDFVnE"));
                startActivity(intent);
        }
        }else if (id == R.id.nav_settings) {
            i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class RefreshBackground extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {

            RetroFit llamadas = new RetroFit();

            /*llamadas.downloadCharacters(adapter);
            llamadas.downloadPlanetas(adapter);
            llamadas.downloadNaves(adapter);*/

            RetroFitMovies movie = new RetroFitMovies();

            //movie.downloadMovies(adapter);

            return null;
        }
    }
}
