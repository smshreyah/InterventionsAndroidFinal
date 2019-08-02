package com.example.intervention2.Interventions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.intervention2.UnlockAction.FollowUp;
import com.example.intervention2.R;

import java.util.Random;

public class SoulOp7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul_op7);

        Button btn = (Button)findViewById(R.id.button_sop7_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoulOp7.this, FollowUp.class));
            }
        });

        Button age = (Button)findViewById(R.id.generate_rand_age);
        EditText editText = (EditText)findViewById(R.id.current_age);

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText current = (EditText) findViewById(R.id.current_age);
                Random random = new Random();
                int max = Integer.parseInt(current.getText().toString());
                int num = random.nextInt(max)+3;
                String rand_age = String.valueOf(num);
                current.setText(rand_age);
                current.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        });
    }
}
