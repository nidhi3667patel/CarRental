package com.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.carrental.modal.Car;
import com.carrental.modal.TravelInfo;

public class CarDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_detail);

        TextView tvCarName = findViewById(R.id.tvCarName);
        TextView tvCarCompany = findViewById(R.id.tvCompanyName);
        ImageView ivCar = findViewById(R.id.ivCar);
        TextView tvCarType = findViewById(R.id.tvCarType);
        TextView tvCarSeats = findViewById(R.id.tvCarSeats);
        TextView tvTransmission = findViewById(R.id.tvCartTransmission);
        TextView tvFuelTYpe = findViewById(R.id.tvCarFuelType);
        TextView tvCarEngine = findViewById(R.id.tvCarEngine);
        TextView tvTopSpeed = findViewById(R.id.tvCarTopSpeed);
        TextView tvPrice = findViewById(R.id.tvPricePerDay);
        Button btnBookNow = findViewById(R.id.btnBookNow);

        Car car = getIntent().getParcelableExtra("carInfo");
        TravelInfo travelDetail = getIntent().getParcelableExtra("travelInfo");

        tvCarName.setText(car.getCarName());
        tvCarCompany.setText(car.getCompanyName());
        Glide.with(this).load(car.getImgUrl()).into(ivCar);
        tvCarType.setText(car.getCarType());
        tvCarSeats.setText(car.getNoOfSeats());
        tvTransmission.setText(car.getTransmission());
        tvFuelTYpe.setText(car.getFuelType());
        tvCarEngine.setText(car.getEngine());
        tvTopSpeed.setText(car.getTopSpeed());
        tvPrice.setText("$" + car.getPricePerDay() + " / day");

        btnBookNow.setOnClickListener(v -> {
            Intent intent = new Intent(this, BookingActivity.class);
            intent.putExtra("carInfo", car);
            intent.putExtra("travelInfo", travelDetail);
            startActivity(intent);
        });

    }
}
