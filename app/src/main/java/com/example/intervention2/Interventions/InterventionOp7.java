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

import java.util.Random;

public class InterventionOp7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_intervention_op7);

        Intent intent = getIntent();

        TextView textView = (TextView)findViewById(R.id.funny_cats);

        Button btn = (Button)findViewById(R.id.button_intOp7_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InterventionOp7.this, FollowUp.class));
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);

                Random rand = new Random();
                int link = rand.nextInt(4);
                if (link == 0){
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=CQ85sUNBK7w"));
                }
                else if (link == 1){
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=pOmu0LtcI6Y"));
                }
                else if (link == 2){
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=3dcli9i_pvA"));
                }
                else {
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=XyNlqQId-nk"));
                }
                startActivity(intent);
            } });


    }
}
