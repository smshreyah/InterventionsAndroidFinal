package com.example.intervention2.Interventions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.intervention2.UnlockAction.FollowUp;
import com.example.intervention2.R;


public class InterventionOp1 extends AppCompatActivity {

    ImageButton likeButton;
    private boolean liked;
    private boolean isEnable = false;

    private boolean linkClicked = false;

    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention_op1);

        Intent intent = getIntent();
        score = getSharedPreferences("intOp1", MODE_PRIVATE).getInt("intOp1", 0);

        TextView textView = (TextView)findViewById(R.id.button_egg);

        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                score = score + 5;
                linkClicked = true;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://e.ggtimer.com/m/1%20minutes"));
                startActivity(intent);
            } });

        Button btn = (Button)findViewById(R.id.button_intOp1_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = score + 5;
                startActivity(new Intent(InterventionOp1.this, FollowUp.class));
            }
        });

    }

    public boolean isIntOp1LinkClicked(){
        return linkClicked;
    }



}
