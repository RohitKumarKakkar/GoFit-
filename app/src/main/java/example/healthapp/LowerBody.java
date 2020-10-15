package example.healthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import example.healthapp.diet_plan.LowerBodyDietActivity;
import example.healthapp.exercise.LowerBodyActivity;

public class LowerBody extends Activity {
    ImageView lowerBodyText;
    ImageView dietPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lower_body);
        lowerBodyText=findViewById(R.id.lowerBodyText);
        dietPlan=findViewById(R.id.dietPlan);

        lowerBodyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LowerBody.this, LowerBodyActivity.class);
                startActivity(intent);
            }
        });

        dietPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LowerBody.this, LowerBodyDietActivity.class);
                startActivity(intent);
            }
        });
    }
}
