package example.healthapp.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.healthapp.R;

public class UperBodyActivity extends AppCompatActivity {
    RecyclerView rv1;
    RecyclerView.LayoutManager layoutManager;
    SingleRow singleRow;
    ArrayList<SingleRow> singleRowArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uper_body);
        rv1 = findViewById(R.id.rv1);
        layoutManager = new LinearLayoutManager(this);
        rv1.setLayoutManager(layoutManager);

        String[] exercise={"TRICEPS DIPS","STAR PUSH-UPS","ARM CIRCLES","SIDE PLANK","SQUATS","CURTSY LUNGES","STAR PUSH-UPS","TRICEPS DIPS","ARM CIRCLES","SQUATS"};
        int[] images={R.drawable.triceps_dips,R.drawable.star_pushup,R.drawable.arm_circles,R.drawable.side_plank,R.drawable.squats,R.drawable.curtsy_lunges,R.drawable.star_pushup,R.drawable.triceps_dips,R.drawable.arm_circles,R.drawable.squats};
        String[] time={"x12","x12","x20","30s","x20","x18","x12","x12","x20","x20"};


        singleRowArrayList = new ArrayList<>();
        for (int i = 0; i < exercise.length; i++) {
            singleRow = new SingleRow(images[i], exercise[i], time[i]);
            singleRowArrayList.add(singleRow);
        }

        MyAdapter adapter1=new MyAdapter(this,singleRowArrayList);
        rv1.setAdapter(adapter1);
    }
}
