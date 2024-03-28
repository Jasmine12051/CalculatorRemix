package edu.jsu.mcis.cs408.calculatorremixlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.calculatorremixlab.databinding.TemperatureConverterBinding;

public class TemperatureLayoutFragment extends Fragment {

    // Instances of this class are used for the individual fragments within the tabbed layout

    public static final String ARG_ID = "id";

    private TemperatureConverterBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TemperatureConverterBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

}