package example.healthapp.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.healthapp.R;

public class LowerBodyActivity extends AppCompatActivity {
    RecyclerView rv1;
    RecyclerView.LayoutManager layoutManager;
    SingleRow singleRow;
    ArrayList<SingleRow> singleRowArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_body);
        rv1 = findViewById(R.id.rv1);
        layoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(layoutManager);

        String[] exercise={"CURTSY LUNGES","CRUNCH KICKS","PLIE SQUATS","SIDE LEG RAISES","SIDE LEG LIFT","INNER THIGH LIFT","SIDE LEG RAISE ","BULGARIAN SQUAT","CURTSY LUNGES","SQUATS"};
        int[] images={R.drawable.curtsy_lunges,R.drawable.crunch_kicks,R.drawable.plie_squats,R.drawable.side_leg_raise,R.drawable.side_leg_lift,R.drawable.inner_thigh_lifts,R.drawable.side_leg_raise,R.drawable.bulgarian_split_squat,R.drawable.curtsy_lunges,R.drawable.squats};
        String[] time={"x15","x12","x15","x10","x8","x12","x12","x15","x15","x20"};

        singleRowArrayList = new ArrayList<>();
        for (int i = 0; i < exercise.length; i++) {
            singleRow = new SingleRow(images[i], exercise[i], time[i]);
            singleRowArrayList.add(singleRow);
        }

        MyAdapter adapter1=new MyAdapter(this,singleRowArrayList);
        rv1.setAdapter(adapter1);
    }
}
