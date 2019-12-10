package com.example.hp.projet_medical;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Information_Cabinet extends AppCompatActivity {
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information__cabinet);

        final Bundle b2=getIntent().getExtras();
        final String Nom_Cabinet=b2.getString("Nom_Cabi");
        final String Adresse_Cabinet=b2.getString("Adresse_Cabi");

        B_affiche();

    }



    //Tableau contient les images de Cabinets
    int index=0;

    //Tableau d'images
    int[] tab_img=new int[]{R.drawable.cabinet1,R.drawable.cabinet2,R.drawable.cabinet3,R.drawable.cabinet4,R.drawable.cabinet5,R.drawable.cabinet6,R.drawable.cabinet7};

    //Afficher les informations

    public void B_affiche() {

        /*Récupération des données */
        final Bundle b2=getIntent().getExtras();
        final String Nom_Cabinet=b2.getString("Nom_Cabi");
        final String Adresse_Cabinet=b2.getString("Adresse_Cabi");

        ratingBar=(RatingBar)findViewById(R.id.myRatingBar);

        TextView Nom_Cab = (TextView) findViewById(R.id.Nom_C);
        TextView Adresse_Cab = (TextView) findViewById(R.id.Adresse_C);
        TextView N_Fix = (TextView) findViewById(R.id.Num_Fix_C);



        // Test pour afficher les images et les informations

        if (Nom_Cabinet.equals(getString(R.string.test1))) {
            ImageView image = (ImageView) findViewById(R.id.image_Info);
            image.setImageResource(tab_img[0]);

            // Récupération des données
            Nom_Cab.setText(Nom_Cabinet);
            Adresse_Cab.setText(Adresse_Cabinet);
            N_Fix.setText("72033145");
            ratingBar.setRating(5);

        }

        if (Nom_Cabinet.equals(getString(R.string.test2))) {
            ImageView image = (ImageView) findViewById(R.id.image_Info);
            image.setImageResource(tab_img[1]);

            // Récupération des données
            Nom_Cab.setText(Nom_Cabinet);
            Adresse_Cab.setText(Adresse_Cabinet);
            N_Fix.setText("72001221");
            ratingBar.setRating(4);
        }


        if (Nom_Cabinet.equals(getString(R.string.test3))) {
            ImageView image = (ImageView) findViewById(R.id.image_Info);
            image.setImageResource(tab_img[2]);

            // Récupération des données
            Nom_Cab.setText(Nom_Cabinet);
            Adresse_Cab.setText(Adresse_Cabinet);
            N_Fix.setText("72553895");
            ratingBar.setRating(3);
        }


        if (Nom_Cabinet.equals(getString(R.string.test4))) {
            ImageView image = (ImageView) findViewById(R.id.image_Info);
            image.setImageResource(tab_img[3]);

            // Récupération des données
            Nom_Cab.setText(Nom_Cabinet);
            Adresse_Cab.setText(Adresse_Cabinet);
            N_Fix.setText("72330021");
            ratingBar.setRating(5);
        }

        if (Nom_Cabinet.equals(getString(R.string.test5))) {
            ImageView image = (ImageView) findViewById(R.id.image_Info);
            image.setImageResource(tab_img[4]);

            // Récupération des données
            Nom_Cab.setText(Nom_Cabinet);
            Adresse_Cab.setText(Adresse_Cabinet);
            N_Fix.setText("72440550");
            ratingBar.setRating(2);
        }

        if (Nom_Cabinet.equals(getString(R.string.test6))) {
            ImageView image = (ImageView) findViewById(R.id.image_Info);
            image.setImageResource(tab_img[5]);

            // Récupération des données
            Nom_Cab.setText(Nom_Cabinet);
            Adresse_Cab.setText(Adresse_Cabinet);
            N_Fix.setText("72787898");
            ratingBar.setRating(1);
        }

        if (Nom_Cabinet.equals(getString(R.string.test7))) {
            ImageView image = (ImageView) findViewById(R.id.image_Info);
            image.setImageResource(tab_img[6]);

            // Récupération des données
            Nom_Cab.setText(Nom_Cabinet);
            Adresse_Cab.setText(Adresse_Cabinet);
            N_Fix.setText("72112211");
            ratingBar.setRating(4);

        }

    }


    //Appel Num Fix de Cabinet
    public void appel(View view) {
        TextView N_Fix = (TextView) findViewById(R.id.Num_Fix_C);

        Uri telNumber = Uri.parse("tel:+"+N_Fix.getText().toString());
        Intent call = new Intent(Intent.ACTION_DIAL, telNumber);
        startActivity(call);

    }




    public void Geolocalisation_Cabinet(View view) {

        ProgressDialog P_Dialog= new ProgressDialog(Information_Cabinet.this);

        P_Dialog.setMessage(getString(R.string.service_nest_pas_dispo));
        P_Dialog.setCancelable(true);
        P_Dialog.show();


    }


    public void RendezVous_Cabinet(View view) {


        Intent myIntent=new Intent(this,Rendez_Vous_Activity.class);
        startActivity(myIntent);
        finish();

    }


    public void Retour(View view) {

        Intent myIntent=new Intent(this,Accueil_Cabinet_Activity.class);
        startActivity(myIntent);
        finish();
    }
}
