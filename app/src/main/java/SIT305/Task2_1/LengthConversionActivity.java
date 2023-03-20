package SIT305.Task2_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class LengthConversionActivity extends AppCompatActivity {

    Spinner unitSpinner;
    Spinner unitSpinner2;
    Button convertButton;
    EditText userInputText;
    TextView conversionOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_conversion);

        unitSpinner = findViewById(R.id.spinner2);
        unitSpinner2 = findViewById(R.id.spinner3);
        convertButton = findViewById(R.id.button);
        userInputText = findViewById(R.id.editTextNumberDecimal);
        conversionOutputText = findViewById(R.id.textView);
        unitSpinner.setSelection(0);
        unitSpinner2.setSelection(0);

        convertButton.setOnClickListener(view -> {
            // Stores selected spinner entries and user input as string
            String selectedUnit1 = unitSpinner.getSelectedItem().toString();
            String selectedUnit2 = unitSpinner2.getSelectedItem().toString();
            String InputText = userInputText.getText().toString();
            // Typecasts user input to double for conversion function
            double convertedText = Double.parseDouble(InputText);
            String output = (convertLength(convertedText, selectedUnit1, selectedUnit2));
            conversionOutputText.setText(output + " " + selectedUnit2);
        });
    }

    // Length conversion function
    public static String convertLength(double userInput, String fromUnit, String toUnit) {
        double result = 0;
        double INCH_TO_CM = 2.54;
        double FOOT_TO_CM = 30.48;
        double YARD_TO_CM = 91.44;
        double MILE_TO_KM = 1.60934;

        switch (fromUnit) {
            case "inch":
                switch (toUnit) {
                    case "centimeter":
                        result = userInput * INCH_TO_CM;
                        break;
                    case "meter":
                        result = userInput * INCH_TO_CM * 10;
                        break;
                    case "kilometer":
                        result = userInput * INCH_TO_CM * 100;
                        break;
                    case "foot":
                        result = userInput / 12;
                        break;
                    case "yard":
                        result = userInput / 36;
                        break;
                    case "mile":
                        result = userInput / 63360;
                        break;
                }
                break;

            case "centimeter":
                switch (toUnit) {
                    case "inch":
                        result = userInput / INCH_TO_CM;
                        break;
                    case "foot":
                        result = userInput / FOOT_TO_CM;
                        break;
                    case "yard":
                        result = userInput / YARD_TO_CM;
                        break;
                    case "mile":
                        result = userInput / (YARD_TO_CM * 1760);
                        break;
                    case "meter":
                        result = userInput / 100;
                        break;
                    case "kilometer":
                        result = userInput / 1000;
                        break;
                }
                break;

            case "foot":
                switch (toUnit) {
                    case "centimeter":
                        result = userInput * FOOT_TO_CM;
                        break;
                    case "meter":
                        result = userInput * FOOT_TO_CM * 10;
                        break;
                    case "kilometer":
                        result = userInput * FOOT_TO_CM * 100;
                        break;
                    case "inch":
                        result = userInput * 12;
                        break;
                    case "yard":
                        result = userInput / 3;
                        break;
                    case "mile":
                        result = userInput / 5280;
                        break;
                }
                break;

            case "yard":
                switch (toUnit) {
                    case "centimeter":
                        result = userInput * YARD_TO_CM;
                        break;
                    case "meter":
                        result = userInput * YARD_TO_CM * 10;
                        break;
                    case "kilometer":
                        result = userInput * YARD_TO_CM * 100;
                        break;
                    case "inch":
                        result = userInput * 36;
                        break;
                    case "foot":
                        result = userInput * 3;
                        break;
                    case "mile":
                        result = userInput / 1760;
                        break;
                }
                break;

            case "mile":
                switch (toUnit) {
                    case "inch":
                        result = userInput * 63360;
                        break;
                    case "centimeter":
                        result = userInput * (MILE_TO_KM / 100);
                        break;
                    case "meter":
                        result = userInput * (MILE_TO_KM / 10);
                        break;
                    case "foot":
                        result = userInput * 5280;
                        break;
                    case "yard":
                        result = userInput * 1760;
                        break;
                    case "kilometer":
                        result = userInput * MILE_TO_KM;
                        break;
                }
                break;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(result);
    }
}

