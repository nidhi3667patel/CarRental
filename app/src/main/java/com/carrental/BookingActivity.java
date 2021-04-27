package com.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.carrental.modal.Booking;
import com.carrental.modal.Car;
import com.carrental.modal.Customer;
import com.carrental.modal.TravelInfo;


public class BookingActivity extends AppCompatActivity {

    Booking booking = new Booking();
    Customer customer = new Customer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_booking);

        TextView tvBookingId = findViewById(R.id.tvBookingId);
        TextView tvPickupLocation = findViewById(R.id.tvPickUpLocation);
        TextView tvPickupDate = findViewById(R.id.tvPickupDate);
        TextView tvDropLocation = findViewById(R.id.tvDropOffLocation);
        TextView tvDropDate = findViewById(R.id.tvDropOffDate);
        ImageView ivCar = findViewById(R.id.ivCar);
        TextView tvCarName = findViewById(R.id.tvCarName);
        TextView tvPrice = findViewById(R.id.tvPrice);
        EditText etCustomerName = findViewById(R.id.etCustomerName);
        EditText etCustomerEmail = findViewById(R.id.etCustomerEmail);
        EditText etCustomerPhone = findViewById(R.id.etCusotmerMobile);
        TextView tvTotalPrice = findViewById(R.id.tvTotatlPrice);
        CheckBox cbInsurance = findViewById(R.id.cbInsurance);

        tvBookingId.setText(getString(R.string.booking_id, booking.getBookingId()));
        Car carDetails = getIntent().getParcelableExtra("carInfo");
        TravelInfo travelInfo = getIntent().getParcelableExtra("travelInfo");

        booking.setCarDetails(carDetails);
        booking.setTravelInfo(travelInfo);
        booking.setCustomerDetails(customer);

        tvPickupLocation.setText(travelInfo.getPickupLocation());
        tvPickupDate.setText(travelInfo.getPickupDate() +", "
                + travelInfo.getPickupHour() + ":" + travelInfo.getPickUpMinute());
        tvDropLocation.setText(travelInfo.getDropOffLocation());
        tvDropDate.setText(travelInfo.getDropOffDate() + ", "
                + travelInfo.getDropHour() + ":" + travelInfo.getDropMinute());

        Glide.with(this)
                .load(carDetails.getImgUrl())
                .into(ivCar);

        tvCarName.setText(carDetails.getCarName());
        tvPrice.setText("$" + carDetails.getPricePerDay() +" / day");

        tvTotalPrice.setText("$ " + booking.getTotalPrice());

        cbInsurance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    booking.setInsuranceAmount(10);
                } else {
                    booking.setInsuranceAmount(0);
                }
                tvTotalPrice.setText("$ " + booking.getTotalPrice());
            }
        });

        Button btnConfirm = findViewById(R.id.btnConfirmBooking);
        btnConfirm.setOnClickListener(v -> {
            customer.setName(etCustomerName.getText().toString());
            customer.setContactEmail(etCustomerEmail.getText().toString());
            customer.setContactPhone(etCustomerPhone.getText().toString());

            if(validateFields()) {
                new AlertDialog.Builder(this)
                        .setCancelable(false)
                        .setMessage("Your Booking has been confirmed. Have a Safe Travel!!")
                        .setPositiveButton("Okay", (dialog, which) -> {
                            dialog.dismiss();
                            Intent intent = new Intent(this, FindCarActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        })
                        .show();
            }
        });
    }

    private Boolean validateFields() {
        if(customer.getName() == null || customer.getName().isEmpty()) {
            showAlert("Please enter Name");
            return false;
        }
        else if(customer.getContactEmail() == null || customer.getContactEmail().isEmpty()) {
            showAlert("Please enter email");
            return false;
        }
        else if(customer.getContactPhone() == null || customer.getContactPhone().isEmpty()) {
            showAlert("Please enter Phone Number");
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
