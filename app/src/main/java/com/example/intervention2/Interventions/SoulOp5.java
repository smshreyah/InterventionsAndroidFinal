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

public class SoulOp5 extends AppCompatActivity {
    //broken Link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soul_op5);

        Button btn = (Button)findViewById(R.id.button_sop5_done);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoulOp5.this, FollowUp.class));
            }
        });

        TextView web = (TextView)findViewById(R.id.let_travel);

        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.nationalgeographic.com/travel/features/beautiful-travel-photos-2017/"));
                //http://m.pinterest.com/search/pins/?q=exotic places
                startActivity(intent);
            } });
    }
}
