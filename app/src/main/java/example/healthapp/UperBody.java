package example.healthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import example.healthapp.diet_plan.UperBodyDietActivity;
import example.healthapp.exercise.UperBodyActivity;

public class UperBody extends Activity {
    ImageView uperBodyText;
    ImageView dietPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uper_body);

        uperBodyText=findViewById(R.id.uperBodyText);
        dietPlan=findViewById(R.id.dietPlan);
        uperBodyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UperBody.this, UperBodyActivity.class);
                startActivity(intent);
            }
        });
        dietPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UperBody.this, UperBodyDietActivity.class);

                startActivity(i);

            }
        });
    }
}
