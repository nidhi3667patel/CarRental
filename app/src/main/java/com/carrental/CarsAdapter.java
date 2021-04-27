package com.carrental;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.carrental.modal.Car;

import java.util.ArrayList;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarHolder> {

    private ArrayList<Car> cars;
    private final CarClickListener bookClickListener;

    interface CarClickListener {
        void bookNowClicked(int position);
        void itemClicked(int position);
    }

    public CarsAdapter(ArrayList<Car> cars, CarClickListener bookClickListener ) {
        this.cars = cars;
        this.bookClickListener = bookClickListener;
    }

    class CarHolder extends RecyclerView.ViewHolder {

        private final TextView tvCarName;
        private final TextView tvCompanyName;
        private final TextView tvPricePerDay;
        private final ImageView ivCarImg;

        public CarHolder(@NonNull View itemView) {
            super(itemView);

            tvCarName = itemView.findViewById(R.id.tvCarName);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            tvPricePerDay = itemView.findViewById(R.id.tvPrice);
            ivCarImg = itemView.findViewById(R.id.ivCar);
            Button btnBook = itemView.findViewById(R.id.btnBook);

            btnBook.setOnClickListener(v -> {
                bookClickListener.bookNowClicked(getAdapterPosition());
            });

            itemView.setOnClickListener(v -> {
                bookClickListener.itemClicked(getAdapterPosition());
            });
        }
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_car, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarHolder holder, int position) {
        holder.tvCarName.setText(cars.get(position).getCarName());
        holder.tvCompanyName.setText(cars.get(position).getCompanyName());
        holder.tvPricePerDay.setText(holder.itemView.getContext().getString(R.string.price_day,
                cars.get(position).getPricePerDay()));

        Glide.with(holder.itemView.getContext())
                .load(cars.get(position).getImgUrl())
                .into(holder.ivCarImg);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }


}
