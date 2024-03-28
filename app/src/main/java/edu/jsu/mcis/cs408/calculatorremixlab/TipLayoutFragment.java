package edu.jsu.mcis.cs408.calculatorremixlab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.NumberFormat;
import java.util.Locale;

import edu.jsu.mcis.cs408.calculatorremixlab.databinding.TipCalculatorBinding;

public class TipLayoutFragment extends Fragment {

    // Instances of this class are used for the individual fragments within the tabbed layout

    public static final String ARG_ID = "id";

    private TipCalculatorBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TipCalculatorBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText totalBillInput = binding.totalBillInput;
                EditText tipPercentInput = binding.tipPercentageInput;
                EditText numPeopleInput = binding.numPeopleInput;
                String totalBill = totalBillInput.getText().toString();
                String tipPercent = tipPercentInput.getText().toString();
                String numPeople = numPeopleInput.getText().toString();
                checkInputs(totalBill, tipPercent, numPeople);
            }
        });

    }


    private void calculate(float totalBill, int tipPercent, int numPeople) {

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        float total = ((totalBill * ((float) tipPercent /100)) + totalBill) / numPeople;
        String formattedTotal = currencyFormatter.format(total);
        TextView t = binding.output;
        String outputText = "Total Per Person: " + formattedTotal;
        t.setText(outputText);
    }

    private void checkInputs(String totalBill, String tipPercent, String numPeople){
        if(totalBill.isEmpty() || tipPercent.isEmpty() || numPeople.isEmpty()){
            Log.d("CHECK INPUTS", "ERROR: All inputs not provided!");
        }
        else{
            float totalBillnum = Float.parseFloat(totalBill);
            int tipPercentnum = Integer.parseInt(tipPercent);
            int numPeoplenum = Integer.parseInt(numPeople);
            calculate(totalBillnum,tipPercentnum,numPeoplenum);
        }
    }


}