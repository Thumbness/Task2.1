package SIT305.Task2_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner unitSpinner;
    Spinner unitSpinner2;
    Button convertButton;
    EditText userInputText;
    TextView conversionOutputText;
    private static final double INCH_TO_CM = 2.54;
    private static final double FOOT_TO_CM = 30.48;
    private static final double YARD_TO_CM = 91.44;
    private static final double MILE_TO_KM = 1.60934;
    private static final double POUND_TO_KG = 0.453592;
    private static final double OUNCE_TO_G = 28.3495;
    private static final double TON_TO_KG = 907.185;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unitSpinner = findViewById(R.id.spinner2);
        unitSpinner2 = findViewById(R.id.spinner3);
        convertButton = findViewById(R.id.button);
        userInputText = findViewById(R.id.editTextNumberDecimal);
        conversionOutputText = findViewById(R.id.textView);
        unitSpinner.setSelection(0);
        unitSpinner2.setSelection(0);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedUnit1 = unitSpinner.getSelectedItem().toString();
                String selectedUnit2 = unitSpinner2.getSelectedItem().toString();
                String InputText = userInputText.getText().toString();
                double convertedText = Double.parseDouble(InputText);
                String output = String.valueOf(convertLength(convertedText, selectedUnit1, selectedUnit2));
                Toast.makeText(MainActivity.this, "Hello, " + output + "!", Toast.LENGTH_LONG).show();
                conversionOutputText.setText(output + " " + selectedUnit2);
            }
        });
    }

    // Length conversion function
    public static double convertLength(double userInput, String fromUnit, String toUnit) {
        double result = 0;

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
        return result;
    }
}
