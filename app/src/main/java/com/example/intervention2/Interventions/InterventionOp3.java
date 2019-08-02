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

public class InterventionOp3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention_op3);

        Intent intent = getIntent();

        TextView textView = (TextView)findViewById(R.id.change_posture);

        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.google.com/search?q=sitting+good+posture&safe=off&tbm=isch&tbo=u&source=univ&sa=X&ei=aJrPUd_4JejUiwLjoYAQ&ved=0CC0QsAQ&biw=1680&bih=925"));
                startActivity(intent);
            } });

        Button btn = (Button)findViewById(R.id.button_intOp3_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InterventionOp3.this, FollowUp.class));
            }
        });

    }
}