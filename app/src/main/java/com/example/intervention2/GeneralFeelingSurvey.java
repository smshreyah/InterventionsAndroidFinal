package com.example.intervention2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.intervention2.Interventions.HeartOp1;
import com.example.intervention2.Interventions.HeartOp10;
import com.example.intervention2.Interventions.HeartOp2;
import com.example.intervention2.Interventions.HeartOp3;
import com.example.intervention2.Interventions.HeartOp4;
import com.example.intervention2.Interventions.HeartOp5;
import com.example.intervention2.Interventions.HeartOp6;
import com.example.intervention2.Interventions.HeartOp8;
import com.example.intervention2.Interventions.HeartOp9;
import com.example.intervention2.Interventions.InterventionOp1;
import com.example.intervention2.Interventions.InterventionOp10;
import com.example.intervention2.Interventions.InterventionOp2;
import com.example.intervention2.Interventions.InterventionOp3;
import com.example.intervention2.Interventions.InterventionOp4;
import com.example.intervention2.Interventions.InterventionOp5;
import com.example.intervention2.Interventions.InterventionOp6;
import com.example.intervention2.Interventions.InterventionOp7;
import com.example.intervention2.Interventions.InterventionOp8;
import com.example.intervention2.Interventions.InterventionOp9;
import com.example.intervention2.Interventions.MindOp1;
import com.example.intervention2.Interventions.MindOp10;
import com.example.intervention2.Interventions.MindOp2;
import com.example.intervention2.Interventions.MindOp3;
import com.example.intervention2.Interventions.MindOp4;
import com.example.intervention2.Interventions.MindOp5;
import com.example.intervention2.Interventions.MindOp6;
import com.example.intervention2.Interventions.MindOp7;
import com.example.intervention2.Interventions.MindOp8;
import com.example.intervention2.Interventions.MindOp9;
import com.example.intervention2.Interventions.SoulOp1;
import com.example.intervention2.Interventions.SoulOp10;
import com.example.intervention2.Interventions.SoulOp2;
import com.example.intervention2.Interventions.SoulOp3;
import com.example.intervention2.Interventions.SoulOp4;
import com.example.intervention2.Interventions.SoulOp5;
import com.example.intervention2.Interventions.SoulOp6;
import com.example.intervention2.Interventions.SoulOp7;
import com.example.intervention2.Interventions.SoulOp8;
import com.example.intervention2.Interventions.SoulOp9;

import java.util.Random;

public class GeneralFeelingSurvey extends AppCompatActivity {
    //Pre-intervention survey. Whenever user opens app
    //How are you feeling + sliding bar

    private SeekBar sBar;
    private TextView tView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_feeling_survey);
        sBar = (SeekBar) findViewById(R.id.seekBar_general);
        sBar.setMax(100);

        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.general_button);

        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionAsk.class);
                startActivity(intent);
            }
        });

        Button btn = (Button)findViewById(R.id.general_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomIntervention();
            }
        });

    }

    public void randomIntervention() {
        Random random = new Random();
        int rand = random.nextInt(41);

        if (rand == 0) {
            setContentView(R.layout.activity_intervention_op1);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp1.class);
            startActivity(intent);
        } else if (rand == 1) {
            setContentView(R.layout.activity_intervention_op2);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp2.class);
            startActivity(intent);
        } else if (rand == 2) {
            setContentView(R.layout.activity_intervention_op3);
            //maybe embed pictures into the activity page instead of using link
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp3.class);
            startActivity(intent);
        } else if (rand == 3) {
            setContentView(R.layout.activity_intervention_op4);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp4.class);
            startActivity(intent);
        } else if (rand == 4) {
            //original link did NOT work, proxy link right now
            setContentView(R.layout.activity_intervention_op5);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp5.class);
            startActivity(intent);
        } else if (rand == 5) {
            setContentView(R.layout.activity_intervention_op6);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp6.class);
            startActivity(intent);
        } else if (rand == 6) {
            //original link did NOT work, proxy link right now
            setContentView(R.layout.activity_intervention_op7);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp7.class);
            startActivity(intent);
        } else if (rand == 7) {
            setContentView(R.layout.activity_intervention_op8);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp8.class);
            startActivity(intent);
        } else if (rand == 8) {
            setContentView(R.layout.activity_intervention_op9);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp9.class);
            startActivity(intent);
        } else if (rand == 9) {
            //link is broken, no link is added
            setContentView(R.layout.activity_intervention_op10);
            Intent intent = new Intent(GeneralFeelingSurvey.this, InterventionOp10.class);
            startActivity(intent);
        } else if (rand == 10) {
            setContentView(R.layout.activity_heart_op1);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp1.class);
            startActivity(intent);
        } else if (rand == 11) {
            //check affirmation link
            setContentView(R.layout.activity_heart_op2);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp2.class);
            startActivity(intent);
        } else if (rand == 12) {
            setContentView(R.layout.activity_heart_op3);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp3.class);
            startActivity(intent);
        } else if (rand == 13) {
            setContentView(R.layout.activity_heart_op4);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp4.class);
            startActivity(intent);
        } else if (rand == 14) {
            setContentView(R.layout.activity_heart_op5);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp5.class);
            startActivity(intent);
        } else if (rand == 15){
            //GENERAL SURVEY -- ADD TO NOTIFICATIONS
            setContentView(R.layout.activity_general_feeling_survey);
            Intent intent = new Intent(GeneralFeelingSurvey.this, GeneralFeelingSurvey.class);
            startActivity(intent);
        } else if (rand == 16){
            //GENERAL SURVEY -- ADD TO NOTIFICATIONS
            setContentView(R.layout.activity_heart_op6);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp6.class);
            startActivity(intent);
        } else if (rand == 17){
            setContentView(R.layout.activity_heart_op8);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp8.class);
            startActivity(intent);
        } else if (rand == 18){
            setContentView(R.layout.activity_heart_op8);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp8.class);
            startActivity(intent);
        } else if (rand == 19){
            setContentView(R.layout.activity_heart_op9);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp9.class);
            startActivity(intent);
        } else if (rand == 20){
            setContentView(R.layout.activity_heart_op10);
            Intent intent = new Intent(GeneralFeelingSurvey.this, HeartOp10.class);
            startActivity(intent);
        } else if (rand == 21){
            setContentView(R.layout.activity_mind_op1);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp1.class);
            startActivity(intent);
        } else if (rand == 22){
            setContentView(R.layout.activity_mind_op2);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp2.class);
            startActivity(intent);
        } else if (rand == 23){
            setContentView(R.layout.activity_mind_op3);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp3.class);
            startActivity(intent);
        } else if (rand == 24){
            setContentView(R.layout.activity_mind_op4);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp4.class);
            startActivity(intent);
        } else if (rand == 25){
            setContentView(R.layout.activity_mind_op5);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp5.class);
            startActivity(intent);
        } else if (rand == 26){
            setContentView(R.layout.activity_mind_op6);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp6.class);
            startActivity(intent);
        } else if (rand == 27){
            setContentView(R.layout.activity_mind_op7);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp7.class);
            startActivity(intent);
        } else if (rand == 28){
            setContentView(R.layout.activity_mind_op8);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp8.class);
            startActivity(intent);
        } else if (rand == 29){
            setContentView(R.layout.activity_mind_op9);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp9.class);
            startActivity(intent);
        } else if (rand == 30){
            setContentView(R.layout.activity_mind_op10);
            Intent intent = new Intent(GeneralFeelingSurvey.this, MindOp10.class);
            startActivity(intent);
        } else if (rand == 31){
            setContentView(R.layout.activity_soul_op1);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp1.class);
            startActivity(intent);
        } else if (rand == 32){
            setContentView(R.layout.activity_soul_op2);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp2.class);
            startActivity(intent);
        } else if (rand == 33){
            setContentView(R.layout.activity_soul_op3);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp3.class);
            startActivity(intent);
        } else if (rand == 34){
            setContentView(R.layout.activity_soul_op4);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp4.class);
            startActivity(intent);
        } else if (rand == 35){
            setContentView(R.layout.activity_soul_op5);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp5.class);
            startActivity(intent);
        } else if (rand == 36){
            setContentView(R.layout.activity_soul_op6);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp6.class);
            startActivity(intent);
        } else if (rand == 37){
            setContentView(R.layout.activity_soul_op7);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp7.class);
            startActivity(intent);
        } else if (rand == 38){
            setContentView(R.layout.activity_soul_op8);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp8.class);
            startActivity(intent);
        } else if (rand == 39){
            setContentView(R.layout.activity_soul_op9);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp9.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_soul_op10);
            Intent intent = new Intent(GeneralFeelingSurvey.this, SoulOp10.class);
            startActivity(intent);
        }

    }

}
