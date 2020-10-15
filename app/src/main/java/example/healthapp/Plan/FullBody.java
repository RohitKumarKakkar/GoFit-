package example.healthapp.Plan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import example.healthapp.R;
import example.healthapp.diet_plan.FullBodyDietActivity;
import example.healthapp.exercise.FullBodyActivity;

public class FullBody extends Activity {
    ImageView fullBodyText;
    ImageView dietPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_body);
        fullBodyText=findViewById(R.id.fullBodyText);
        dietPlan=findViewById(R.id.dietPlan);

        fullBodyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FullBody.this, FullBodyActivity.class);

                startActivity(i);
            }
        });
        dietPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FullBody.this, FullBodyDietActivity.class);

                startActivity(i);

            }
        });
    }
}
