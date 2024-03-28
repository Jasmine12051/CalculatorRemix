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
        fragments.add(new TemperatureLayoutFragment());

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        //Fragment fragment = new TipLayoutFragment();
        //Fragment fragment1 = new TemperatureLayoutFragment();

        //Bundle args = new Bundle();
        //args.putInt(TipLayoutFragment.ARG_ID, position + 1);
        //args.putInt(TemperatureLayoutFragment.ARG_ID, position + 1);
        //fragment1.setArguments(args);

        return fragments.get(position);

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}