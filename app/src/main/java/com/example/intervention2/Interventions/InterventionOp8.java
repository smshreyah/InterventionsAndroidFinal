package com.example.intervention2.Interventions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intervention2.UnlockAction.FollowUp;
import com.example.intervention2.R;

public class InterventionOp8 extends AppCompatActivity {
//Cannot add videos in app bc YouTube I think, but I can randomize links

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intervention_op8);


        Intent intent = getIntent();

        TextView textView = (TextView)findViewById(R.id.not_so_funny);
        //layout intervention_op8

        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://jokes.cc.com/"));
                startActivity(intent);
            } });

        Button btn = (Button)findViewById(R.id.button_intOp8_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InterventionOp8.this, FollowUp.class));
            }
        });

    }
}
