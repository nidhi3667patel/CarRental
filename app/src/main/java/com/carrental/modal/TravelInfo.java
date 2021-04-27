package com.carrental.modal;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TravelInfo implements Parcelable {

    Date pickupDate;
    int pickupHour = -1;
    int pickUpMinute = -1;
    String pickupLocation;
    Date dropOffDate;
    int dropMinute = -1;
    int dropHour = -1;
    String dropOffLocation;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM", Locale.getDefault());

    public String getPickupDate() {
        if(pickupDate!= null)
            return dateFormat.format(pickupDate);
        else
            return null;
    }

    public void setPickupDate(Long pickupDate) {
        this.pickupDate = new Date(pickupDate);
    }

    public String getDropOffDate() {
        if(dropOffDate != null)
            return dateFormat.format(dropOffDate);
        else return null;
    }

    public void setDropOffDate(Long dropOffDate) {
        this.dropOffDate = new Date(dropOffDate);
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public int getDropMinute() {
        return dropMinute;
    }

    public void setDropMinute(int dropMinute) {
        this.dropMinute = dropMinute;
    }

    public int getDropHour() {
        return dropHour;
    }

    public void setDropHour(int dropHour) {
        this.dropHour = dropHour;
    }

    public int getPickupHour() {
        return pickupHour;
    }

    public void setPickupHour(int pickupHour) {
        this.pickupHour = pickupHour;
    }

    public int getPickUpMinute() {
        return pickUpMinute;
    }

    public void setPickUpMinute(int pickUpMinute) {
        this.pickUpMinute = pickUpMinute;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.pickupDate != null ? this.pickupDate.getTime() : -1);
        dest.writeInt(this.pickupHour);
        dest.writeInt(this.pickUpMinute);
        dest.writeString(this.pickupLocation);
        dest.writeLong(this.dropOffDate != null ? this.dropOffDate.getTime() : -1);
        dest.writeInt(this.dropMinute);
        dest.writeInt(this.dropHour);
        dest.writeString(this.dropOffLocation);
    }

    public void readFromParcel(Parcel source) {
        long tmpPickupDate = source.readLong();
        this.pickupDate = tmpPickupDate == -1 ? null : new Date(tmpPickupDate);
        this.pickupHour = source.readInt();
        this.pickUpMinute = source.readInt();
        this.pickupLocation = source.readString();
        long tmpDropOffDate = source.readLong();
        this.dropOffDate = tmpDropOffDate == -1 ? null : new Date(tmpDropOffDate);
        this.dropMinute = source.readInt();
        this.dropHour = source.readInt();
        this.dropOffLocation = source.readString();
    }

    public TravelInfo() {}

    protected TravelInfo(Parcel in) {
        long tmpPickupDate = in.readLong();
        this.pickupDate = tmpPickupDate == -1 ? null : new Date(tmpPickupDate);
        this.pickupHour = in.readInt();
        this.pickUpMinute = in.readInt();
        this.pickupLocation = in.readString();
        long tmpDropOffDate = in.readLong();
        this.dropOffDate = tmpDropOffDate == -1 ? null : new Date(tmpDropOffDate);
        this.dropMinute = in.readInt();
        this.dropHour = in.readInt();
        this.dropOffLocation = in.readString();
    }

    public static final Parcelable.Creator<TravelInfo> CREATOR = new Parcelable.Creator<TravelInfo>() {
        @Override
        public TravelInfo createFromParcel(Parcel source) {
            return new TravelInfo(source);
        }

        @Override
        public TravelInfo[] newArray(int size) {
            return new TravelInfo[size];
        }
    };
}
