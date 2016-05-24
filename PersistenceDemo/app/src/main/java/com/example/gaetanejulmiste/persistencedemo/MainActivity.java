package com.example.gaetanejulmiste.persistencedemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gaetanejulmiste.persistencedemo.Models.InputValue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText etPersist;
    //private Button btnPersist;
    //Version 1
    //private SharedPreferences pref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*  Version 1
       pref = PreferenceManager.getDefaultSharedPreferences(this);
        etPersist = (EditText)findViewById(R.id.etPersist);
        onLoad();
        */


        /*
        //Version 2
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        etPersist = (EditText)findViewById(R.id.etPersist);
        onLoad();
        */

        // version 3
        etPersist = (EditText)findViewById(R.id.etPersist);
        onLoad();
    }

      private void onLoad() {
       InputValue val = InputValue.queryMostRecent();
      if (val != null ){
          etPersist.setText(val.text);
      }
    }

    public void onPersist(View v){
        InputValue val = new InputValue(etPersist.getText().toString());
        val.save();
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
    }

/* Version 2
    private void onLoad() {
        BufferedReader input = null;
        try {
            input = new BufferedReader(
                    new InputStreamReader(openFileInput("myValue")));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = input.readLine()) != null) {
                buffer.append(line + "\n");
            }
            String text = buffer.toString();
            etPersist.setText(text);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException io){
            io.printStackTrace();
        }



    }

    //store to disk
    public void onPersist(View v){
        FileOutputStream file = null ;
        try {

            file = openFileOutput("myValue",MODE_PRIVATE);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(file));
       try {
           writer.write(etPersist.getText().toString());
           writer.close();

       }catch (IOException e){
           e.printStackTrace();
       }
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
    }
 */
    /* Version 1
    //retreive
    private void onLoad() {
        String text = pref.getString("text","");
        etPersist.setText(text);
    }

    //store to disk
    public void onPersist(View v){
        SharedPreferences.Editor edit =pref.edit();
        edit.putString("text",etPersist.getText().toString());
        edit.apply();
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
    }
    */
}
