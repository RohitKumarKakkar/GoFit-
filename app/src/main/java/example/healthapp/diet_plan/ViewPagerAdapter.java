package example.healthapp.diet_plan;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import example.healthapp.diet_plan.TabsFragement.Day1;
import example.healthapp.diet_plan.TabsFragement.Day2;
import example.healthapp.diet_plan.TabsFragement.Day3;
import example.healthapp.diet_plan.TabsFragement.Day4;
import example.healthapp.diet_plan.TabsFragement.Day5;
import example.healthapp.diet_plan.TabsFragement.Day6;
import example.healthapp.diet_plan.TabsFragement.Day7;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final int tabcount;

    public ViewPagerAdapter(FragmentManager fm, int tabcount) {
        super(fm);
        this.tabcount=tabcount;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos){
            case 0:
                Day1 day1=new Day1();
                return day1;
            case 1:
                Day2 day2=new Day2();
                return day2;
            case 2:
                Day3 day3=new Day3();
                return day3;
            case 3:
                Day4 day4=new Day4();
                return day4;
            case 4:
                Day5 day5=new Day5();
                return day5;
            case 5:
                Day6 day6=new Day6();
                return day6;
            case 6:
                Day7 day7=new Day7();
                return day7;
                default:
                    return null;

        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
