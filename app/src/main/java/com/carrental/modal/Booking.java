package com.carrental.modal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Booking {

    String bookingId = String.format(Locale.getDefault(),
            "%04d", new Random().nextInt(10000));

    TravelInfo travelInfo;
    Car carDetails;
    Customer customerDetails;

    double insuranceAmount = 0;

    public String getBookingId() {
        return bookingId;
    }

    public TravelInfo getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(TravelInfo travelInfo) {
        this.travelInfo = travelInfo;
    }

    public Car getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(Car carDetails) {
        this.carDetails = carDetails;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public double getTotalPrice() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM", Locale.ENGLISH);
        Date firstDate = null;
        Date secondDate = null;
        try {
            firstDate = sdf.parse(travelInfo.getPickupDate());
            secondDate = sdf.parse(travelInfo.getDropOffDate());

            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            return carDetails.pricePerDay * TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)
                    + insuranceAmount ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
