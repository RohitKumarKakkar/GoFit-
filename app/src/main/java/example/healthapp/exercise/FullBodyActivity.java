package example.healthapp.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.healthapp.R;

public class FullBodyActivity extends AppCompatActivity {

    RecyclerView rv1;
    RecyclerView.LayoutManager layoutManager;
    SingleRow singleRow;
    ArrayList<SingleRow> singleRowArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullbody);
        rv1 = findViewById(R.id.rv1);
        layoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(layoutManager);

        String[] exercise={"DOUBLE CRUNCHE","CRUNCH KICKS","SQUATS","TRICEPS DIPS","WALL PUSH-UPS","CURTSY LUNGES","STAR PUSH-UPS","SIDE PLANK","CRUNCHES","SQUATS"};
        int[] images={R.drawable.elevated_crunches,R.drawable.crunch_kicks,R.drawable.squats,R.drawable.triceps_dips,R.drawable.wall_push_ups,R.drawable.curtsy_lunges,R.drawable.star_pushup,R.drawable.side_plank,R.drawable.crunches,R.drawable.squats};
        String[] time={"x12","x12","x20","x12","x15","x20","x12","30s","x12","x20"};

        singleRowArrayList = new ArrayList<>();
        for (int i = 0; i < exercise.length; i++) {
            singleRow = new SingleRow(images[i], exercise[i], time[i]);
            singleRowArrayList.add(singleRow);
        }

        MyAdapter adapter1=new MyAdapter(this,singleRowArrayList);
        rv1.setAdapter(adapter1);



    }
}
