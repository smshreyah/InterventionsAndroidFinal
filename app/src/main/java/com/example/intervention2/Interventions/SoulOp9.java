package com.example.intervention2.Interventions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.intervention2.UnlockAction.FollowUp;
import com.example.intervention2.R;

public class SoulOp9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul_op9);

        Button btn = (Button)findViewById(R.id.button_sop9_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoulOp9.this, FollowUp.class));
            }
        });

    }
}
