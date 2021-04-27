package com.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.carrental.modal.TravelInfo;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

public class FindCarActivity extends AppCompatActivity {

    private final TravelInfo travelinfoObj = new TravelInfo();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_find_car);
        EditText etPickUpLocation = findViewById(R.id.etPickupLocation);
        EditText etPickupDate = findViewById(R.id.etPickupDate);
        EditText etPickUpTime = findViewById(R.id.etPickupTime);

        EditText etDropLocation = findViewById(R.id.etDropLocation);
        EditText etDropOffDate = findViewById(R.id.etDropDate);
        EditText etDropOffTime = findViewById(R.id.etDropTime);

        // Makes only dates from today forward selectable.
        CalendarConstraints constraintsBuilder =
                new CalendarConstraints.Builder()
                        .setValidator(DateValidatorPointForward.now()).build();

        MaterialDatePicker<Long> pickupDatePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select Pickup date")
                        .setCalendarConstraints(constraintsBuilder)
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build();


        etPickupDate.setOnClickListener(v -> {
            pickupDatePicker.show(getSupportFragmentManager(), "Pickup");
        });

        pickupDatePicker.addOnPositiveButtonClickListener(selection -> {
            travelinfoObj.setPickupDate(selection);
            etPickupDate.setText(travelinfoObj.getPickupDate());
        });

        MaterialTimePicker pickUpTimePicker = new MaterialTimePicker.Builder()
                        .setTimeFormat(TimeFormat.CLOCK_12H)
                        .setHour(12)
                        .setMinute(00)
                        .setTitleText("Select Pickup Time")
                        .build();


        etPickUpTime.setOnClickListener(v -> {
            pickUpTimePicker.show(getSupportFragmentManager(), "pickupTime");
        });

        pickUpTimePicker.addOnPositiveButtonClickListener(selection -> {
            etPickUpTime.setText(pickUpTimePicker.getHour() + ":" + pickUpTimePicker.getMinute());
            travelinfoObj.setPickupHour(pickUpTimePicker.getHour());
            travelinfoObj.setPickUpMinute(pickUpTimePicker.getMinute());
        });

        MaterialDatePicker<Long> dropDatePicker =
                MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select Dropoff date")
                        .setCalendarConstraints(constraintsBuilder)
                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                        .build();


        etDropOffDate.setOnClickListener(v -> {
            dropDatePicker.show(getSupportFragmentManager(), "DropOff");
        });

        dropDatePicker.addOnPositiveButtonClickListener(selection -> {
            travelinfoObj.setDropOffDate(selection);
            etDropOffDate.setText(travelinfoObj.getDropOffDate());
        });


        MaterialTimePicker dropOffTimePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(00)
                .setTitleText("Select DropOff Time")
                .build();

        etDropOffTime.setOnClickListener( v-> {
            dropOffTimePicker.show(getSupportFragmentManager(), "dropOffTime");
        });

        dropOffTimePicker.addOnPositiveButtonClickListener(select -> {
            etDropOffTime.setText(dropOffTimePicker.getHour() + ":" + dropOffTimePicker.getMinute());
            travelinfoObj.setDropHour(dropOffTimePicker.getHour());
            travelinfoObj.setDropMinute(dropOffTimePicker.getMinute());
        });

        Button btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(v -> {
            travelinfoObj.setPickupLocation(etPickUpLocation.getText().toString());
            travelinfoObj.setDropOffLocation(etDropLocation.getText().toString());
            if(validateData()) {
                Intent carListIntent = new Intent(this, CarListActivity.class);
                carListIntent.putExtra("travelInfo", travelinfoObj);
                startActivity(carListIntent);
            }
        });
    }

    private Boolean validateData() {
        if(travelinfoObj.getPickupLocation() == null || travelinfoObj.getPickupLocation().isEmpty()) {
            showAlert("Please set Pickup location");
            return false;
        }
        else if(travelinfoObj.getPickupDate() == null) {
            showAlert("Please set Pickup date");
            return false;
        }
        else if(travelinfoObj.getPickupHour() == -1) {
            showAlert("Please set Pickup time");
            return false;
        }
        else if(travelinfoObj.getDropOffLocation() == null || travelinfoObj.getDropOffLocation().isEmpty()) {
            showAlert("Please set Dropoff Location.");
            return false;
        }
        else if(travelinfoObj.getDropOffDate() == null) {
            showAlert("Please set Dropoff date");
            return false;
        }
        else if(travelinfoObj.getDropHour() == -1) {
            showAlert("Please set Dropoff time");
            return false;
        }

        return true;
    }

    private void showAlert(String message) {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton("Ok", (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }
}
