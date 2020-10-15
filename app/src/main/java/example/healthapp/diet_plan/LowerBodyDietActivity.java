package example.healthapp.diet_plan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import example.healthapp.R;
import example.healthapp.diet_plan.Adapter.ViewPagerAdapter5;

public class LowerBodyDietActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter5 viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_body_diet);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        setSupportActionBar(toolbar);
        //Adding Tabs
        tabLayout.addTab(tabLayout.newTab().setText("DAY1"));
        tabLayout.addTab(tabLayout.newTab().setText("DAY2"));
        tabLayout.addTab(tabLayout.newTab().setText("DAY3"));
        tabLayout.addTab(tabLayout.newTab().setText("DAY4"));
        tabLayout.addTab(tabLayout.newTab().setText("DAY5"));
        tabLayout.addTab(tabLayout.newTab().setText("DAY6"));
        tabLayout.addTab(tabLayout.newTab().setText("DAY7"));


        //Adapter
        viewPagerAdapter = new ViewPagerAdapter5(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
