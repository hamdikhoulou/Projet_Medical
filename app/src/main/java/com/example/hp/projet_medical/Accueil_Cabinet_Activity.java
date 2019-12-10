package com.example.hp.projet_medical;

import android.os.Bundle;
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
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;


public class Accueil_Cabinet_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    protected ListView l ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil__cabinet_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //Appel listView
        l = (ListView)findViewById(R.id.listv);

        //creation ArrayList et HashMap
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;


        //Remplier Hashmap
        map = new HashMap<>();
        map.put("Nom_Cabinet", getString(R.string.cabinet_mohamed_mansour));
        map.put("Adresse_Cabinet", getString(R.string.Tunis_8016));
        map.put("img", String.valueOf(R.drawable.cabinet1));
        listItem.add(map);



        map = new HashMap<>();
        map.put("Nom_Cabinet", getString(R.string.nom_cab2));
        map.put("Adresse_Cabinet", getString(R.string.adresse_cab1));
        map.put("img", String.valueOf(R.drawable.cabinet2));
        listItem.add(map);


        map = new HashMap<>();
        map.put("Nom_Cabinet", getString(R.string.nom_cab3));
        map.put("Adresse_Cabinet", getString(R.string.adresse_cab2));
        map.put("img", String.valueOf(R.drawable.cabinet3));
        listItem.add(map);


        map = new HashMap<>();
        map.put("Nom_Cabinet", getString(R.string.nom_cab4));
        map.put("Adresse_Cabinet", getString(R.string.adresse_cab3));
        map.put("img", String.valueOf(R.drawable.cabinet4));
        listItem.add(map);

        map = new HashMap<>();
        map.put("Nom_Cabinet", getString(R.string.nom_cab5));
        map.put("Adresse_Cabinet", getString(R.string.adresse_cab4));
        map.put("img", String.valueOf(R.drawable.cabinet5));
        listItem.add(map);


        map = new HashMap<>();
        map.put("Nom_Cabinet", getString(R.string.nom_cab6));
        map.put("Adresse_Cabinet", getString(R.string.adresse_cab5));
        map.put("img", String.valueOf(R.drawable.cabinet6));
        listItem.add(map);


        map = new HashMap<>();
        map.put("Nom_Cabinet", getString(R.string.nom_cab7));
        map.put("Adresse_Cabinet", getString(R.string.adresse_cab6));
        map.put("img", String.valueOf(R.drawable.cabinet7));
        listItem.add(map);



        //Creation d'Adapter
        SimpleAdapter adapt= new SimpleAdapter(this.getBaseContext(),listItem,R.layout.l2, new String[]{"img","Nom_Cabinet","Adresse_Cabinet"}, new int[]{R.id.img, R.id.Nom_Cab, R.id.Adresse_Cab});
        l.setAdapter(adapt);


        final Intent myIntent2 = new Intent(this, Information_Cabinet.class);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>) l.getItemAtPosition(position);


                String  Nc=map.get("Nom_Cabinet");
                String  Ac=map.get("Adresse_Cabinet");

                Bundle b2 = new Bundle();
                b2.putString("Nom_Cabi",Nc);
                b2.putString("Adresse_Cabi",Ac);

                myIntent2.putExtras(b2);

                startActivity(myIntent2);


            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.accueil__cabinet_, menu);
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
