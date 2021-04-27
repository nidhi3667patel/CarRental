package com.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.carrental.modal.Car;
import com.carrental.modal.TravelInfo;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CarListActivity extends AppCompatActivity implements CarsAdapter.CarClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_list);

        TextView tvLocation = findViewById(R.id.tvLocation);
        TextView tvDate = findViewById(R.id.tvDate);
        RecyclerView rvCar = findViewById(R.id.rvCars);

        TravelInfo travelInfo = getIntent().getParcelableExtra("travelInfo");
        tvLocation.setText(travelInfo.getPickupLocation() +" to "+travelInfo.getDropOffLocation());
        tvDate.setText(travelInfo.getPickupDate() + " - " + travelInfo.getDropOffDate());

        rvCar.setLayoutManager(new LinearLayoutManager(this));
        rvCar.setAdapter(new CarsAdapter(Car.getList(), this));
    }

    @Override
    public void bookNowClicked(int position) {
        Intent intent = new Intent(this, BookingActivity.class);
        intent.putExtra("carInfo", Car.getList().get(position));
        intent.putExtra("travelInfo", getIntent().<TravelInfo>getParcelableExtra("travelInfo"));
        startActivity(intent);
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(this, CarDetailActivity.class);
        intent.putExtra("carInfo", Car.getList().get(position));
        intent.putExtra("travelInfo", getIntent().<TravelInfo>getParcelableExtra("travelInfo"));
        startActivity(intent);
    }
}
