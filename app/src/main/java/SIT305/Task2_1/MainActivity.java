package SIT305.Task2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button convertButton;

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

        convertButton = findViewById(R.id.button);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LengthConversionActivity.class);
                startActivity(intent);

            }
        });
    }


}
