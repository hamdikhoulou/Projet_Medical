package com.example.hp.projet_medical;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Traitement_Compte_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traitement__compte_);
    }



    //méthode pour le Button confirmation

    public void B_confermer(View view) {

        TextView Remarque=(TextView)findViewById(R.id.Remarque_compte);
        TextView OK=(TextView)findViewById(R.id.ok);
        TextView retour=(TextView)findViewById(R.id.retour);
        EditText Nom=(EditText)findViewById(R.id.nom);
        EditText Prenom=(EditText)findViewById(R.id.prenom);
        EditText N_tel=(EditText)findViewById(R.id.N_tel);
        EditText mdp=(EditText)findViewById(R.id.mdp);
        EditText Email=(EditText)findViewById(R.id.email);

        try {
            //CODE BD pour insertion
            DBConnections db = new DBConnections(this);
            db.insertion_compte(Nom.getText().toString(), Prenom.getText().toString(), Integer.parseInt(N_tel.getText().toString()), Email.getText().toString(), mdp.getText().toString());

            //message de Remarque

            Remarque.setText(R.string.compte_creer);
            OK.setText(R.string.ok);
            retour.setText("");
            Toast.makeText(this, getString(R.string.merci) +Nom.getText().toString()+" "+Prenom.getText().toString()+getString(R.string.inscri),Toast.LENGTH_LONG).show();



        }catch (Exception e){

            Toast.makeText(this," "+ e ,Toast.LENGTH_LONG).show();

        }
    }


    //Retour à l'activité
    public void B_ok(View view) {

        Intent myIntent=new Intent(this,Login_Mdp_Activity.class);
        startActivity(myIntent);

    }


    //Retour à l'activité
    public void retour_compte(View view) {

        Intent myIntent=new Intent(this,Login_Mdp_Activity.class);
        startActivity(myIntent);

    }


}
