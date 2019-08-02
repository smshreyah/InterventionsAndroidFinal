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

public class MindOp8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_op8);

        Button btn = (Button)findViewById(R.id.button_mop8_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MindOp8.this, FollowUp.class));
            }
        });

        TextView web = (TextView)findViewById(R.id.different_opinion);

        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                Random rand = new Random();
                int link = rand.nextInt(8);
                if (link == 0){
                    intent.setData(Uri.parse("https://www.google.com/news/search?q=compassionate"));
                } else if (link == 1){
                    intent.setData(Uri.parse("https://www.google.com/news/search?q=awesome"));
                } else if (link == 2){
                    intent.setData(Uri.parse("https://www.google.com/news/search?q=grateful"));
                } else if (link == 3){
                    intent.setData(Uri.parse("https://www.google.com/news/search?q=altruistic"));
                } else if (link == 4){
                    intent.setData(Uri.parse("https://www.google.com/news/search?q=empathetic"));
                } else if (link == 5){
                    intent.setData(Uri.parse("https://www.google.com/news/search?q=forgiving"));
                } else if (link == 6){
                    intent.setData(Uri.parse("https://www.google.com/news/search?q=being%20happier"));
                } else {
                    intent.setData(Uri.parse("https://www.google.com/news/search?q=mindful"));
                }
                startActivity(intent);
            } });
    }
}
