package SIT305.Task2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button convertLengthButton;
    Button convertWeightButton;
    Button convertTempButton;

    /* The main activity hosts 3 buttons for the user to select,
    depending on which button clicked, function changes to corresponding activity using Intent class.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertLengthButton = findViewById(R.id.button);
        convertWeightButton = findViewById(R.id.button2);
        convertTempButton = findViewById(R.id.button3);

        convertLengthButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LengthConversionActivity.class);
            startActivity(intent);
        });
        convertWeightButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, WeightConversionActivity.class);
            startActivity(intent);
        });

        convertTempButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, tempConversionActivity.class);
            startActivity(intent);
        });
    }
}

