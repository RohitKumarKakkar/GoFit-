package example.healthapp.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.healthapp.R;

public class WeightLooseActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    SingleRow singleRow;
    ArrayList<SingleRow> singleRowArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_loose);
        rv = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        String[] exercise={"STEP-UPS","CRUNCH KICKS","SIDE PLANK","TRICEPS DIPS","SQUATS","CURTSY LUNGES","STAR PUSH-UPS","SIDE PLANK","CRUNCHES","SQUATS"};
        int[] images={R.drawable.step_ups,R.drawable.crunch_kicks,R.drawable.side_plank,R.drawable.triceps_dips,R.drawable.squats,R.drawable.curtsy_lunges,R.drawable.star_pushup,R.drawable.side_plank,R.drawable.crunches,R.drawable.squats};
        String[] time={"x12","x12","30s","x12","x15","x20","x12","30s","x15","x20"};

        singleRowArrayList = new ArrayList<>();
        for (int i = 0; i < exercise.length; i++) {
            singleRow = new SingleRow(images[i], exercise[i], time[i]);
            singleRowArrayList.add(singleRow);
        }

        MyAdapter adapter=new MyAdapter(this,singleRowArrayList);
        rv.setAdapter(adapter);




    }
}
