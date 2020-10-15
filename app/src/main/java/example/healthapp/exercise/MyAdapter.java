package example.healthapp.exercise;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.healthapp.R;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<SingleRow> singleRowArrayList;

    public MyAdapter(Context context, ArrayList<SingleRow> singleRowArrayList) {
        this.context = context;
        this.singleRowArrayList = singleRowArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.single_row_layout,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        SingleRow singleRow=singleRowArrayList.get(i);
       String exercise= singleRow.getExcercise();
        int image=singleRow.getImage();
        String time=singleRow.getTime();

        viewHolder.textView.setText(exercise);
        viewHolder.imageView.setImageResource(image);
        viewHolder.textViewTime.setText(time);




    }

    @Override
    public int getItemCount() {

        return singleRowArrayList.size();
    }
     class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textViewTime;


         public MyViewHolder(@NonNull View itemView) {
             super(itemView);

             imageView=itemView.findViewById(R.id.imageView);
             textView=itemView.findViewById(R.id.textView);
             textViewTime=itemView.findViewById(R.id.textViewTime);



         }
     }

}
