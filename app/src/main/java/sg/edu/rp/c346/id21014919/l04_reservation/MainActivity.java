package sg.edu.rp.c346.id21014919.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvHeading;
    ImageView IVRestaurant;
    EditText etCustomerName, etPhoneNum, etNumberPax;
    CheckBox cbSmokingArea;
    DatePicker dp;
    TimePicker tp;
    Button btnReserve, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHeading = findViewById(R.id.tvHeading);
        IVRestaurant = findViewById(R.id.IVRestaurant);
        etCustomerName = findViewById(R.id.etCustomerName);
        etPhoneNum = findViewById(R.id.etPhoneNum);
        etNumberPax = findViewById(R.id.etNumberPax);
        cbSmokingArea = findViewById(R.id.cbSmokingArea);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReserve = findViewById(R.id.btnReserve);
        btnReset = findViewById(R.id.btnReset);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = etCustomerName.getText().toString();
                String pax = etNumberPax.getText().toString();
                String phoneNum = etPhoneNum.getText().toString();
                String smokingArea = "";

                if(cbSmokingArea.isChecked() == true){
                    smokingArea = "Smoking Area";
                } else {
                    smokingArea = "Non-Smoking Area";
                }

                tp.setIs24HourView(true);
                int hour = tp.getHour();
                int min = tp.getMinute();
                String newMin = "";
                if(tp.getMinute() < 10) {
                    newMin = "0";
                } else {
                    newMin = "";
                }

                int year = dp.getYear();
                int month = dp.getMonth() + 1;
                int day = dp.getDayOfMonth();

                String msg = smokingArea + " table for "
                        + pax + " under name " + fullName + " on "
                        + day + "/" + month+ "/" + year + " at " + hour
                        + ":" + newMin + min + " reserved";

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etCustomerName.setText("");
                etPhoneNum.setText("");
                etPhoneNum.setText("");
                etNumberPax.setText("");
                cbSmokingArea.setChecked(false);
                tp.setHour(19);
                tp.setMinute(30);
                dp.updateDate(2020, 8, 1);
            }
        });

    }
}