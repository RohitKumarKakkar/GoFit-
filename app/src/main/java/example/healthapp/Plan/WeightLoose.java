package example.healthapp.Plan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import example.healthapp.R;
import example.healthapp.diet_plan.WeightDietActivity;
import example.healthapp.exercise.WeightLooseActivity;

public class WeightLoose extends AppCompatActivity {
    ImageView fullBodyImage,dietPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_loose1);

        fullBodyImage = findViewById(R.id.fullBodyImage);
        dietPlan=findViewById(R.id.dietPlan);

        fullBodyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WeightLoose.this, WeightLooseActivity.class);

                startActivity(i);


            }
        });

        dietPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WeightLoose.this, WeightDietActivity.class);

                startActivity(i);

            }
        });



    }




}
