package SIT305.Task2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button convertLengthButton;
    Button convertWeightButton;
    Button convertTempButton;


    //////// TO DO: ///////////
    // 1. Add new layouts for weight and temp conversion
    // 2. add new java activities for new conversion functionaliies.
    // 3. Dont forget to add activity to android manifest.




    //////
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

