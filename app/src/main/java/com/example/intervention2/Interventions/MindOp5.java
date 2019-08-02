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

public class MindOp5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_op5);

        Button btn = (Button)findViewById(R.id.button_mop5_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MindOp5.this, FollowUp.class));
            }
        });

        TextView web = (TextView)findViewById(R.id.goal);

        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&ved=2ahUKEwjp0dedsrTiAhUBc60KHdBsAUwQFjAAegQIBhAC&url=https%3A%2F%2Fshrib.com%2F&usg=AOvVaw1cn5B_lz4ZaVWTtOZFc9xs"));
                startActivity(intent);
            } });
    }

}
