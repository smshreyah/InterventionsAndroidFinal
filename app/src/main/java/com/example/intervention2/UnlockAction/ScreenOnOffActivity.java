package com.example.intervention2.UnlockAction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.example.intervention2.GeneralFeelingSurvey;
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
import com.example.intervention2.R;

import java.util.Random;

public class ScreenOnOffActivity extends AppCompatActivity{
    //Required question when user unlocks phone

    private ScreenOnOffReceiver screenOnOffReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_on_off);

        //Random Question and Unlock Bars
        final TextView question = (TextView) findViewById(R.id.general_question_unlock);
        final String[] general_questions = {"Are you feeling (even a little bit) stressed?",
                "Are you feeling calm?"};
        Random random = new Random();
        int rand = random.nextInt(2);
        question.setText(general_questions[rand]);

        SwipeButton swipeButton = (SwipeButton) findViewById(R.id.swipe_btn);
        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                randomIntervention();
            }
        });

        SwipeButton swipeButton_no = (SwipeButton) findViewById(R.id.swipe_btn_no);
        swipeButton_no.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                Intent homeScreen = new Intent(Intent.ACTION_MAIN);
                homeScreen.addCategory(Intent.CATEGORY_HOME);
                homeScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(homeScreen);
            }
        });

    }



    public void randomIntervention() {
        Random random = new Random();
        int rand = random.nextInt(41);

        if (rand == 0) {
            setContentView(R.layout.activity_intervention_op1);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp1.class);
            startActivity(intent);
        } else if (rand == 1) {
            setContentView(R.layout.activity_intervention_op2);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp2.class);
            startActivity(intent);
        } else if (rand == 2) {
            setContentView(R.layout.activity_intervention_op3);
            //maybe embed pictures into the activity page instead of using link
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp3.class);
            startActivity(intent);
        } else if (rand == 3) {
            setContentView(R.layout.activity_intervention_op4);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp4.class);
            startActivity(intent);
        } else if (rand == 4) {
            //original link did NOT work, proxy link right now
            setContentView(R.layout.activity_intervention_op5);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp5.class);
            startActivity(intent);
        } else if (rand == 5) {
            setContentView(R.layout.activity_intervention_op6);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp6.class);
            startActivity(intent);
        } else if (rand == 6) {
            //original link did NOT work, proxy link right now
            setContentView(R.layout.activity_intervention_op7);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp7.class);
            startActivity(intent);
        } else if (rand == 7) {
            setContentView(R.layout.activity_intervention_op8);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp8.class);
            startActivity(intent);
        } else if (rand == 8) {
            setContentView(R.layout.activity_intervention_op9);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp9.class);
            startActivity(intent);
        } else if (rand == 9) {
            //link is broken, no link is added
            setContentView(R.layout.activity_intervention_op10);
            Intent intent = new Intent(ScreenOnOffActivity.this, InterventionOp10.class);
            startActivity(intent);
        } else if (rand == 10) {
            setContentView(R.layout.activity_heart_op1);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp1.class);
            startActivity(intent);
        } else if (rand == 11) {
            //check affirmation link
            setContentView(R.layout.activity_heart_op2);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp2.class);
            startActivity(intent);
        } else if (rand == 12) {
            setContentView(R.layout.activity_heart_op3);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp3.class);
            startActivity(intent);
        } else if (rand == 13) {
            setContentView(R.layout.activity_heart_op4);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp4.class);
            startActivity(intent);
        } else if (rand == 14) {
            setContentView(R.layout.activity_heart_op5);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp5.class);
            startActivity(intent);
        } else if (rand == 15){
            //GENERAL SURVEY -- ADD TO NOTIFICATIONS
            setContentView(R.layout.activity_general_feeling_survey);
            Intent intent = new Intent(ScreenOnOffActivity.this, GeneralFeelingSurvey.class);
            startActivity(intent);
        } else if (rand == 16){
            //GENERAL SURVEY -- ADD TO NOTIFICATIONS
            setContentView(R.layout.activity_heart_op6);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp6.class);
            startActivity(intent);
        } else if (rand == 17){
            setContentView(R.layout.activity_heart_op8);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp8.class);
            startActivity(intent);
        } else if (rand == 18){
            setContentView(R.layout.activity_heart_op8);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp8.class);
            startActivity(intent);
        } else if (rand == 19){
            setContentView(R.layout.activity_heart_op9);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp9.class);
            startActivity(intent);
        } else if (rand == 20){
            setContentView(R.layout.activity_heart_op10);
            Intent intent = new Intent(ScreenOnOffActivity.this, HeartOp10.class);
            startActivity(intent);
        } else if (rand == 21){
            setContentView(R.layout.activity_mind_op1);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp1.class);
            startActivity(intent);
        } else if (rand == 22){
            setContentView(R.layout.activity_mind_op2);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp2.class);
            startActivity(intent);
        } else if (rand == 23){
            setContentView(R.layout.activity_mind_op3);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp3.class);
            startActivity(intent);
        } else if (rand == 24){
            setContentView(R.layout.activity_mind_op4);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp4.class);
            startActivity(intent);
        } else if (rand == 25){
            setContentView(R.layout.activity_mind_op5);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp5.class);
            startActivity(intent);
        } else if (rand == 26){
            setContentView(R.layout.activity_mind_op6);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp6.class);
            startActivity(intent);
        } else if (rand == 27){
            setContentView(R.layout.activity_mind_op7);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp7.class);
            startActivity(intent);
        } else if (rand == 28){
            setContentView(R.layout.activity_mind_op8);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp8.class);
            startActivity(intent);
        } else if (rand == 29){
            setContentView(R.layout.activity_mind_op9);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp9.class);
            startActivity(intent);
        } else if (rand == 30){
            setContentView(R.layout.activity_mind_op10);
            Intent intent = new Intent(ScreenOnOffActivity.this, MindOp10.class);
            startActivity(intent);
        } else if (rand == 31){
            setContentView(R.layout.activity_soul_op1);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp1.class);
            startActivity(intent);
        } else if (rand == 32){
            setContentView(R.layout.activity_soul_op2);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp2.class);
            startActivity(intent);
        } else if (rand == 33){
            setContentView(R.layout.activity_soul_op3);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp3.class);
            startActivity(intent);
        } else if (rand == 34){
            setContentView(R.layout.activity_soul_op4);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp4.class);
            startActivity(intent);
        } else if (rand == 35){
            setContentView(R.layout.activity_soul_op5);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp5.class);
            startActivity(intent);
        } else if (rand == 36){
            setContentView(R.layout.activity_soul_op6);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp6.class);
            startActivity(intent);
        } else if (rand == 37){
            setContentView(R.layout.activity_soul_op7);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp7.class);
            startActivity(intent);
        } else if (rand == 38){
            setContentView(R.layout.activity_soul_op8);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp8.class);
            startActivity(intent);
        } else if (rand == 39){
            setContentView(R.layout.activity_soul_op9);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp9.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_soul_op10);
            Intent intent = new Intent(ScreenOnOffActivity.this, SoulOp10.class);
            startActivity(intent);
        }

    }



}
