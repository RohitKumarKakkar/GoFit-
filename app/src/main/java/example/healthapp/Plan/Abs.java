package example.healthapp.Plan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import example.healthapp.R;
import example.healthapp.diet_plan.AbsDietActivity;
import example.healthapp.exercise.AbsActivity;

public class Abs extends Activity {
    ImageView AbsText;
    ImageView dietPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abs);
        AbsText=findViewById(R.id.AbsText);
        dietPlan=findViewById(R.id.dietPlan);
        AbsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Abs.this, AbsActivity.class);
                startActivity(intent);

            }
        });

        dietPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Abs.this, AbsDietActivity.class);

                startActivity(i);

            }
        });

    }
}
