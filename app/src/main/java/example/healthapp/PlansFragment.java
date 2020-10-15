package example.healthapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import example.healthapp.Plan.Abs;
import example.healthapp.Plan.FullBody;
import example.healthapp.Plan.WeightLoose;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlansFragment extends Fragment {



    public PlansFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        int[] images={R.drawable.weight_loose,R.drawable.full_body,R.drawable.upper_body,R.drawable.abs_3,R.drawable.lower_body};


        ListView listView= view.findViewById(R.id.listView);

//        listView.setAdapter(new CustomListAdapter(getActivity(),image,));
        CustomListAdapter customListAdapter=new CustomListAdapter(getActivity(),images);
        listView.setAdapter(customListAdapter);
//
        // Inflate the layout for this fragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0) {
                    Intent intent = new Intent(getActivity(), WeightLoose.class);
                    startActivity(intent);
                }
                if(position==1) {
                    Intent intent = new Intent(getActivity(), FullBody.class);
                    startActivity(intent);
                }
                if(position==2) {
                    Intent intent = new Intent(getActivity(), UperBody.class);
                    startActivity(intent);
                }
                if(position==3) {
                    Intent intent = new Intent(getActivity(), Abs.class);
                    startActivity(intent);
                }
                if(position==4) {
                    Intent intent = new Intent(getActivity(), LowerBody.class);
                    startActivity(intent);
                }

            }
        });

        return  view;


    }



}
