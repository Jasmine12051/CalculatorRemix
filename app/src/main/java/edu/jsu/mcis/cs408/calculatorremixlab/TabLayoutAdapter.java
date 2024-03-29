package edu.jsu.mcis.cs408.calculatorremixlab;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    private ArrayList<Fragment> fragments;

    public TabLayoutAdapter(Fragment fragment) {

        super(fragment);

        fragments = new ArrayList<>();

        fragments.add(new TipLayoutFragment());
        fragments.add(new TemperatureLayoutFragment());
        fragments.add(new DistanceLayoutFragment());

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return fragments.get(position);

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}