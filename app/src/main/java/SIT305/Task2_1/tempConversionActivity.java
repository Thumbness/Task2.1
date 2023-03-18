package SIT305.Task2_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class tempConversionActivity extends AppCompatActivity {

    Spinner unitSpinner;
    Spinner unitSpinner2;
    Button convertButton;
    EditText userInputText;
    TextView conversionOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_conversion);

        unitSpinner = findViewById(R.id.spinner5);
        unitSpinner2 = findViewById(R.id.spinner6);
        convertButton = findViewById(R.id.button5);
        userInputText = findViewById(R.id.editTextNumberDecimal3);
        conversionOutputText = findViewById(R.id.textView3);
        unitSpinner.setSelection(0);
        unitSpinner2.setSelection(0);

        convertButton.setOnClickListener(view -> {
            String selectedUnit1 = unitSpinner.getSelectedItem().toString();
            String selectedUnit2 = unitSpinner2.getSelectedItem().toString();
            String InputText = userInputText.getText().toString();
            double convertedText = Double.parseDouble(InputText);
            String output = (convertTemperature(convertedText, selectedUnit1, selectedUnit2));
            conversionOutputText.setText(output + " " + selectedUnit2);
        });
    }
        public static String convertTemperature(double userInput, String fromUnit, String toUnit) {
            double result = 0;
            switch (fromUnit) {
                case "Celsius":
                    switch (toUnit) {
                        case "Celsius":
                            result = userInput;
                            break;
                        case "Fahrenheit":
                            result = (userInput * 1.8) + 32;
                            break;
                        case "Kelvin":
                            result = userInput + 273.15;
                            break;
                    }
                    break;
                case "Fahrenheit":
                    switch (toUnit) {
                        case "Celsius":
                            result = (userInput - 32) / 1.8;
                            break;
                        case "Fahrenheit":
                            result = userInput;
                            break;
                        case "Kelvin":
                            result = (userInput - 32) * 5 / 9 + 273.15;
                            break;
                    }
                    break;
                case "Kelvin":
                    switch (toUnit) {
                        case "Celsius":
                            result = userInput - 273.15;
                            break;
                        case "Fahrenheit":
                            result = (userInput - 273.15) * 9 / 5 + 32;
                            break;
                        case "Kelvin":
                            result = userInput;
                            break;
                    }
                    break;
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return decimalFormat.format(result);
        }

}
