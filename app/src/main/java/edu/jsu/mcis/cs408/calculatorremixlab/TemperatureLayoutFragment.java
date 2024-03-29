package edu.jsu.mcis.cs408.calculatorremixlab;

import static java.lang.Double.parseDouble;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText fahrenheitInput = binding.FahrenheitInput;
                EditText celsiusInput = binding.CelsiusInput;
                String fahrenheit = fahrenheitInput.getText().toString();
                String celsius = celsiusInput.getText().toString();
                checkInputs(fahrenheit, celsius);
            }
        });
    }

    private void checkInputs(String fahrenheit, String celsius){
        try {
            if (fahrenheit.isEmpty() && celsius.isEmpty()) {
                Context context = requireContext();
                Toast toast = Toast.makeText(context, "All inputs are not provided!", Toast.LENGTH_SHORT);
                toast.show();

            } else if (celsius.matches("") && !fahrenheit.isEmpty()) {
                double fahrenheitNum = parseDouble(fahrenheit);
                calculateCelsius(fahrenheitNum);
            } else if (fahrenheit.matches("") && !celsius.isEmpty()) {
                double celsiusNum = parseDouble(celsius);
                calculateFahrenheit(celsiusNum);
            } else if (!fahrenheit.isEmpty() && !celsius.isEmpty()) {
                double fahrenheitNum = parseDouble(fahrenheit);
                calculateCelsius(fahrenheitNum);
            }
        }
        catch (NumberFormatException e){
            Context context = requireContext();
            Toast toast = Toast.makeText(context, "THIS IS A NON-NUMERIC value!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void calculateCelsius(double fahrenheit) {
        DecimalFormat roundFormatter = new DecimalFormat("#,##0.00");
        double conversion = ((double) 5 /9) * (fahrenheit - 32);
        String formattedResult = roundFormatter.format(conversion);
        TextView t = binding.output;
        String outputText = "Fahrenheit to Celsius: " + formattedResult;
        t.setText(outputText);
    }

    private void calculateFahrenheit(double celsius) {
        DecimalFormat roundFormatter = new DecimalFormat("#,##0.00");
        double conversion = ((double) 9 /5 * celsius) + 32;
        String formattedResult = roundFormatter.format(conversion);
        TextView t = binding.output;
        String outputText = "Celsius to Fahrenheit: " + formattedResult;
        t.setText(outputText);
    }


}