package example.healthapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomListAdapter extends BaseAdapter {
    //int[] images={R.drawable.weight_loose,R.drawable.full_body,R.drawable.upper_body,R.drawable.abs_3,R.drawable.lower_body};



    private final Context context;
    private final int[] image;
    LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, int[] image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View rootview, ViewGroup parent) {

        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootview=layoutInflater.inflate(R.layout.custom_list_layout,null);

        ImageView imageView= rootview.findViewById(R.id.imageView);
        imageView.setImageResource(image[position]);
        return rootview;



    }
}
