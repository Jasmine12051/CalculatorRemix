package edu.jsu.mcis.cs408.calculatorremixlab;

import static java.lang.Double.parseDouble;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import edu.jsu.mcis.cs408.calculatorremixlab.databinding.DistanceConverterBinding;

public class DistanceLayoutFragment extends Fragment {
    private DistanceConverterBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DistanceConverterBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        binding.convertButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText milesInput = binding.MilesInput;
                EditText kiloInput = binding.kiloInput;
                String miles = milesInput.getText().toString();
                String kilometers = kiloInput.getText().toString();
                checkInputs(miles, kilometers);
            }
        });
    }

    private void checkInputs(String miles, String kilometers){
        try {
            if (miles.isEmpty() && kilometers.isEmpty()) {
                TextView t = binding.output2;
                t.setText("");
                Context context = requireContext();
                Toast toast = Toast.makeText(context, "All inputs are not provided!", Toast.LENGTH_SHORT);
                toast.show();

            } else if (kilometers.matches("") && !miles.isEmpty()) {
                double milesNum = parseDouble(miles);
                calculateKilometers(milesNum);
            } else if (miles.matches("") && !kilometers.isEmpty()) {
                double kilometersNum = parseDouble(kilometers);
                calculateMiles(kilometersNum);
            } else if (!miles.isEmpty() && !kilometers.isEmpty()) {
                double milesNum = parseDouble(miles);
                calculateKilometers(milesNum);
            }
        }
        catch (NumberFormatException e){
            Context context = requireContext();
            Toast toast = Toast.makeText(context, "THIS IS A NON-NUMERIC value!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void calculateKilometers(double miles) {
        DecimalFormat roundFormatter = new DecimalFormat("#,##0.00");
        double conversion = 1.609 * miles;
        String formattedResult = roundFormatter.format(conversion);
        TextView t = binding.output2;
        String outputText = "Miles to Kilometers: " + formattedResult;
        t.setText(outputText);
    }

    private void calculateMiles(double kilometers) {
        DecimalFormat roundFormatter = new DecimalFormat("#,##0.00");
        double conversion = kilometers / 1.609;
        String formattedResult = roundFormatter.format(conversion);
        TextView t = binding.output2;
        String outputText = "Kilometers to Miles: " + formattedResult;
        t.setText(outputText);
    }

}
