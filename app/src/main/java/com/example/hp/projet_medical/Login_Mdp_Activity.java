package com.example.hp.projet_medical;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;





public class Login_Mdp_Activity extends AppCompatActivity {
    DBConnections db;
    SharedPreferences sharedPref;
    private CheckBox C;
    Button B_conn;
    EditText login;
    EditText mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__mdp_);
        db = new DBConnections(this);


        B_conn = (Button) findViewById(R.id.B_connx);


        login=(EditText)findViewById(R.id.input_Login);
        mdp=(EditText)findViewById(R.id.input_Mdp);

        //code sharedPref Login et mdp
        sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        C = (CheckBox) findViewById(R.id.R_login_info);


        login.setText(sharedPref.getString("data_login", ""));
        mdp.setText(sharedPref.getString("data_mdp", ""));
        C.setChecked(Boolean.parseBoolean(sharedPref.getString("cheked", "false")));


        //Authentificaton
        B_conn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String L=login.getText().toString();
                String M=mdp.getText().toString();
                ArrayList l2 = new ArrayList();
                l2=db.getcompte(L, M);
                int taille = l2.size();


                //Tester les champs de login et mot de passe

                if(taille!=0){


                    //Si les champs correcte

                    ImageView I=(ImageView)findViewById(R.id.img_auth);
                    I.setImageResource(R.drawable.auth_cle);

                    //methode SharedPreference
                    enrg_SharedPreference();


                    Intent myIntent=new Intent(Login_Mdp_Activity.this,Accueil_Cabinet_Activity.class);

                    Bundle b = new Bundle();
                    b.putString("Login1",login.getText().toString());
                    b.putString("Mdp1",mdp.getText().toString());

                    myIntent.putExtras(b);

                    startActivity(myIntent);
                    finish();

                }else{

                    ImageView I=(ImageView)findViewById(R.id.img_auth);
                    I.setImageResource(R.drawable.auth);


                }


            }
        });

    }


    //SharedPreference
    public void enrg_SharedPreference() {

        EditText login=(EditText)findViewById(R.id.input_Login);
        EditText mdp=(EditText)findViewById(R.id.input_Mdp);

        SharedPreferences.Editor myEdit = sharedPref.edit();
        if (C.isChecked()) {
            myEdit.putString("data_login", login.getText().toString());
            myEdit.putString("data_mdp", mdp.getText().toString());
            myEdit.putString("cheked","true");
            myEdit.commit();

        } else {

            myEdit.putString("data_login", "");
            myEdit.putString("data_mdp", "");
            myEdit.putString("cheked","false");
            myEdit.commit();

        }


    }



    //Intent " création du compte "

    public void creer_compte(View view) {

        Intent myIntent=new Intent(this,Traitement_Compte_Activity.class);
        startActivity(myIntent);

    }




}
