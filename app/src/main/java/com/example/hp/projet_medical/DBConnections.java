package com.example.hp.projet_medical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBConnections extends SQLiteOpenHelper {
    public static final String DBName="gestion.db";
    public  static final int Verson=1;
    public DBConnections(Context context){
        super(context,DBName,null,Verson);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    db.execSQL("create table IF NOT EXISTS compte_client(id Integer primary key, Nom TEXT, Prenom TEXT, N_tel Integer, Email TEXT, Mdp TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS compte_client");
        onCreate(db);
    }

//insertion
public void insertion_compte(String nom,String prenom,int num_tel, String email, String mdp){

    SQLiteDatabase db=this.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put("Nom", nom);
    contentValues.put("Prenom", prenom);
    contentValues.put("N_tel", num_tel);
    contentValues.put("Email", email);
    contentValues.put("Mdp", mdp);
db.insert("compte_client",null, contentValues);

}

//get values dans BD

 public ArrayList getAllrecord(){

        ArrayList array_list = new ArrayList();
     SQLiteDatabase db = this.getReadableDatabase();
     Cursor res = db.rawQuery("select * from compte_client", null);
     res.moveToFirst();
     while (res.isAfterLast()==false){
         String LOGIN=res.getString(res.getColumnIndex("Email"));
         String MDP=res.getString(res.getColumnIndex("Mdp"));
         array_list.add(LOGIN+ "\n" + MDP);
         res.moveToNext();
     }
     return  array_list;
 }

    public ArrayList getcompte(String email, String mdp) {
        ArrayList l1 = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from compte_client where Email='" + email + "' and +Mdp='"+mdp+"' ", null);
        res.moveToFirst();
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            String l = res.getString(res.getColumnIndex("Email"));
            String m = res.getString(res.getColumnIndex("Mdp"));
            l1.add(l + "\n" + m + "\n" );
            res.moveToNext();
        }
        return l1;

    }



































}
