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
        // Meter conversion
        double METER_TO_CM = 100;
        double METER_TO_KM = 10;
        double METER_TO_INCH = 39.3701;
        double METER_TO_FEET = 3.28084;
        double METER_TO_YARDS = 1.09361;
        double METER_TO_MILES = 0.000621371;

        // Kilometer Conversion
        double KM_TO_CM = 100000;
        double KM_TO_INCH = 39370.1;
        double KM_TO_FEET = 3280.84;
        double KM_TO_YARDS = 1093.61;
        double KM_TO_MILES = 0.621371;
        double KM_TO_METERS = 1000;

        // Centimeter Conversion
        double CM_TO_INCH = 0.393701;
        double CM_TO_FEET = 0.0328084;
        double CM_TO_YARDS = 0.0109361;
        double CM_TO_MILES = 0.00000621371;
        double CM_TO_METERS = 0.01;
        double CM_TO_KM = 0.01;

        switch (fromUnit) {
            case "meters":
                switch (toUnit) {
                    case "centimeters":
                        result = userInput * METER_TO_CM;
                        break;
                    case "kilometers":
                        result = userInput * METER_TO_KM;
                        break;
                    case "inches":
                        result = userInput * METER_TO_INCH;
                        break;
                    case "feet":
                        result = userInput * METER_TO_FEET;
                        break;
                    case "yards":
                        result = userInput * METER_TO_YARDS;
                        break;
                    case "miles":
                        result = userInput * METER_TO_MILES;
                        break;
                }
                break;

            case "kilometers":
                switch (toUnit) {
                    case "centimeters":
                        result = userInput * KM_TO_CM;
                        break;
                    case "meters":
                        result = userInput * KM_TO_METERS;
                        break;
                    case "inches":
                        result = userInput * KM_TO_INCH;
                        break;
                    case "feet":
                        result = userInput * KM_TO_FEET;
                        break;
                    case "yards":
                        result = userInput * KM_TO_YARDS;
                        break;
                    case "miles":
                        result = userInput * KM_TO_MILES;
                        break;
                }
                break;
            case "inches":
                switch (toUnit) {
                    case "centimeters":
                        result = userInput * INCH_TO_CM;
                        break;
                    case "meters":
                        result = userInput * INCH_TO_CM * 10;
                        break;
                    case "kilometers":
                        result = userInput * INCH_TO_CM * 100;
                        break;
                    case "feet":
                        result = userInput / 12;
                        break;
                    case "yards":
                        result = userInput / 36;
                        break;
                    case "miles":
                        result = userInput / 63360;
                        break;
                }
                break;

            case "centimeters":
                switch (toUnit) {
                    case "inches":
                        result = userInput * CM_TO_INCH;
                        break;
                    case "feet":
                        result = userInput * CM_TO_FEET;
                        break;
                    case "yards":
                        result = userInput * CM_TO_YARDS;
                        break;
                    case "miles":
                        result = userInput * CM_TO_MILES;
                        break;
                    case "meters":
                        result = userInput * CM_TO_METERS;
                        break;
                    case "kilometers":
                        result = userInput * CM_TO_KM;
                        break;
                }
                break;

            case "feet":
                switch (toUnit) {
                    case "centimeters":
                        result = userInput * FOOT_TO_CM;
                        break;
                    case "meters":
                        result = userInput * FOOT_TO_CM * 10;
                        break;
                    case "kilometers":
                        result = userInput * FOOT_TO_CM * 100;
                        break;
                    case "inches":
                        result = userInput * 12;
                        break;
                    case "yards":
                        result = userInput / 3;
                        break;
                    case "miles":
                        result = userInput / 5280;
                        break;
                }
                break;

            case "yards":
                switch (toUnit) {
                    case "centimeters":
                        result = userInput * YARD_TO_CM;
                        break;
                    case "meters":
                        result = userInput * YARD_TO_CM * 10;
                        break;
                    case "kilometers":
                        result = userInput * YARD_TO_CM * 100;
                        break;
                    case "inches":
                        result = userInput * 36;
                        break;
                    case "feet":
                        result = userInput * 3;
                        break;
                    case "miles":
                        result = userInput / 1760;
                        break;
                }
                break;

            case "miles":
                switch (toUnit) {
                    case "inches":
                        result = userInput * 63360;
                        break;
                    case "centimeters":
                        result = userInput * (MILE_TO_KM / 100);
                        break;
                    case "meters":
                        result = userInput * (MILE_TO_KM / 10);
                        break;
                    case "feet":
                        result = userInput * 5280;
                        break;
                    case "yards":
                        result = userInput * 1760;
                        break;
                    case "kilometers":
                        result = userInput * MILE_TO_KM;
                        break;
                }
                break;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(result);
    }
}

