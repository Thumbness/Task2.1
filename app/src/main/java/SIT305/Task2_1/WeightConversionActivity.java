package SIT305.Task2_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class WeightConversionActivity extends AppCompatActivity {

    Spinner unitSpinner;
    Spinner unitSpinner2;
    Button convertButton;
    EditText userInputText;
    TextView conversionOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_conversion_activity);

        unitSpinner = findViewById(R.id.spinner5);
        unitSpinner2 = findViewById(R.id.spinner6);
        convertButton = findViewById(R.id.button5);
        userInputText = findViewById(R.id.editTextNumberDecimal3);
        conversionOutputText = findViewById(R.id.textView3);
        unitSpinner.setSelection(0);
        unitSpinner2.setSelection(0);

        convertButton.setOnClickListener(view -> {
            // Stores selected spinner entries and user input as string
            String selectedUnit1 = unitSpinner.getSelectedItem().toString();
            String selectedUnit2 = unitSpinner2.getSelectedItem().toString();
            String InputText = userInputText.getText().toString();
            // Typecasts user input to double for conversion function
            double convertedText = Double.parseDouble(InputText);
            String output = (convertWeight(convertedText, selectedUnit1, selectedUnit2));
            conversionOutputText.setText(output + " " + selectedUnit2);
        });
    }

    // Length conversion function
    public static String convertWeight(double userInput, String fromUnit, String toUnit) {
        double result = 0;

        double GRAM_TO_KG = 0.001;
        double KG_TO_GRAM = 1000;
        double OUNCE_TO_GRAM = 28.3495;
        double POUND_TO_GRAM = 453.592;
        double TON_TO_GRAM = 907185;

        switch (fromUnit) {
            case "gram/s":
                switch (toUnit) {
                    case "gram/s":
                        result = userInput;
                        break;
                    case "kilogram/s":
                        result = userInput * GRAM_TO_KG;
                        break;
                    case "ounce/s":
                        result = userInput / OUNCE_TO_GRAM;
                        break;
                    case "pound/s":
                        result = userInput / POUND_TO_GRAM;
                        break;
                    case "ton/s":
                        result = userInput / TON_TO_GRAM;
                        break;
                }
                break;
            case "kilogram/s":
                switch (toUnit) {
                    case "gram/s":
                        result = userInput * KG_TO_GRAM;
                        break;
                    case "kilogram/s":
                        result = userInput;
                        break;
                    case "ounce/s":
                        result = userInput * 35.274;
                        break;
                    case "pound/s":
                        result = userInput * 2.20462;
                        break;
                    case "ton/s":
                        result = userInput / 1000;
                        break;
                }
                break;
            case "ounce/s":
                switch (toUnit) {
                    case "gram/s":
                        result = userInput * OUNCE_TO_GRAM;
                        break;
                    case "kilogram/s":
                        result = userInput * OUNCE_TO_GRAM * 1000;
                        break;
                    case "ounce/s":
                        result = userInput;
                        break;
                    case "pound/s":
                        result = userInput / 16;
                        break;
                    case "ton/s":
                        result = userInput / 35274;
                        break;
                }
                break;
            case "pound/s":
                switch (toUnit) {
                    case "gram/s":
                        result = userInput * POUND_TO_GRAM;
                        break;
                    case "kilogram/s":
                        result = userInput * 0.453592;
                        break;
                    case "ounce/s":
                        result = userInput * 16;
                        break;
                    case "pound/s":
                        result = userInput;
                        break;
                    case "ton/s":
                        result = userInput / 2000;
                        break;
                }
                break;
            case "ton/s":
                switch (toUnit) {
                    case "gram/s":
                        result = userInput * TON_TO_GRAM;
                        break;
                    case "kilogram/s":
                        result = userInput * 1000;
                        break;
                    case "ounce/s":
                        result = userInput * 35274;
                        break;
                    case "pound/s":
                        result = userInput * 2000;
                        break;
                    case "ton/s":
                        result = userInput;
                        break;
                }
                break;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(result);
    }
}
