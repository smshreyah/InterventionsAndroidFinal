package com.example.intervention2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterventionAsk extends AppCompatActivity {
    //Random intervention notices

    private Button alertButton_yes;
    private Button alertButton_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention_ask);
        /

        alertButton_yes = (Button) findViewById(R.id.button_ask_yes);
        alertButton_no = (Button) findViewById(R.id.button_ask_no);

        alertButton_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(InterventionAsk.this);

                builder.setCancelable(true);
                builder.setTitle("Remember take breaks!");
                builder.setMessage("You can close the app");

                //somehow save this data
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });

        alertButton_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterventionAsk.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
