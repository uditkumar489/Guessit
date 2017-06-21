package com.udit.guessit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.crash.FirebaseCrash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.google.firebase.*;


/*private DatabaseReference mDatabase;
mDatabase = FirebaseDatabase.getInstance().getReference();*/


public class MainActivity extends AppCompatActivity {

    int randomnum ;
    int attempt=0;

    public void atem(int attempts)
    {   attempts++;
        Toast.makeText(this, "Total Attempts - " + attempts, Toast.LENGTH_SHORT).show();
        attempts=0;
        attempt=attempts;
    }

    public void guess(View view)
    {
        EditText guesstext =  (EditText) findViewById(R.id.guesstext);
        int guessint = Integer.parseInt(guesstext.getText().toString());

        if (guessint>randomnum)
        {
            Toast.makeText(this, "think smaller", Toast.LENGTH_SHORT).show();
            attempt++;
        }

        else if (guessint<randomnum)
        {
            Toast.makeText(this, "think bigger", Toast.LENGTH_SHORT).show();
            attempt++;
        }

        else
        {   //attempt++;
            Toast.makeText(this, "Sahi Jwab", Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "Total Attempts - " + attempt, Toast.LENGTH_SHORT).show();
            atem(attempt);

            Toast.makeText(this, "Now Next", Toast.LENGTH_SHORT).show();

            Random rand = new Random();
            randomnum = rand.nextInt(30) + 1;

            Toast.makeText(this, String.valueOf(((randomnum*2)+2)*2) , Toast.LENGTH_SHORT).show();

            //Toast.makeText(this, String.valueOf(attempt) , Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomnum = rand.nextInt(30) + 1;

        Toast.makeText(this, String.valueOf(((randomnum*2)+2)*2) , Toast.LENGTH_SHORT).show();
        //FirebaseCrash.log("Activity created");


    }
}
