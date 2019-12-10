package com.example.hp.projet_medical;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rendez_Vous_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NotificationManager nmanager;
    static int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez__vous_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //Button Envoyer
    public void B_envoyer(View view) {


        EditText Nom=(EditText)findViewById(R.id.RV_nom);
        EditText Prenom=(EditText)findViewById(R.id.RV_prenom);
        EditText N_tel=(EditText)findViewById(R.id.RV_N_tel);
        EditText Email=(EditText)findViewById(R.id.RV_email);

        try {

            //Notification

            Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.gmail);

            NotificationCompat.Builder N_Build=new NotificationCompat.Builder(this)
                    .setContentTitle(getString(R.string.rendezVous))
                    .setContentText(getString(R.string.nous_vous_contact)+ N_tel.getText().toString())
                    .setSmallIcon(R.drawable.gmail)
                    .setLargeIcon(bmp)
                    .setSound(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.notification_sound));
            nmanager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nmanager.notify(1,N_Build.build());
            id++;

            Toast.makeText(this, getString(R.string.merci)+  Nom.getText().toString() + " " + Prenom.getText().toString(), Toast.LENGTH_SHORT).show();
            Intent myIntent=new Intent(this,Accueil_Cabinet_Activity.class);
            startActivity(myIntent);
            finish();

        }catch (Exception e){

            Toast.makeText(this," "+ e ,Toast.LENGTH_LONG).show();

        }

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
        getMenuInflater().inflate(R.menu.rendez__vous_, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Home) {

            Intent myIntent=new Intent(this,Accueil_Cabinet_Activity.class);
            startActivity(myIntent);
            finish();

        } else if (id == R.id.Deconnecxion) {

            Intent myIntent=new Intent(this,Login_Mdp_Activity.class);
            startActivity(myIntent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
