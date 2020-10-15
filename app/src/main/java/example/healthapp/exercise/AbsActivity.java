package example.healthapp.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.healthapp.R;

public class AbsActivity extends AppCompatActivity {
    RecyclerView rv2;
    RecyclerView.LayoutManager layoutManager;
    SingleRow singleRow;
    ArrayList<SingleRow> singleRowArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);
        rv2 = findViewById(R.id.rv2);
        layoutManager = new LinearLayoutManager(AbsActivity.this);
        rv2.setLayoutManager(layoutManager);

        String[] exercise={"STEP-UPS","CRUNCH KICKS","SIDE PLANK","V SIT-UPS","LEG LIFTS","CURTSY LUNGES","STAR PUSH-UPS","SIDE PLANK","CRUNCHES","DOUBLE CRUNCH"};
        int[] images={R.drawable.step_ups,R.drawable.crunch_kicks,R.drawable.side_plank,R.drawable.v_sit_ups,R.drawable.leg_lift,R.drawable.curtsy_lunges,R.drawable.star_pushup,R.drawable.side_plank,R.drawable.crunches,R.drawable.elevated_crunches};
        String[] time={"x12","x12","30s","x15","x10","x20","x12","30s","x15","x8"};

        singleRowArrayList = new ArrayList<>();
        for (int i = 0; i < exercise.length; i++) {
            singleRow = new SingleRow(images[i], exercise[i],time[i]);
            singleRowArrayList.add(singleRow);
        }

        MyAdapter adapter3=new MyAdapter(AbsActivity.this,singleRowArrayList);
        rv2.setAdapter(adapter3);
    }
}
