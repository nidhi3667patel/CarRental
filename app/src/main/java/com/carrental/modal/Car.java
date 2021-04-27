package com.carrental.modal;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Car implements Parcelable {

    String carName;
    String companyName;
    String imgUrl;
    Double pricePerDay;
    String carType;
    String noOfSeats;
    String transmission;
    String engine;
    String fuelType;
    String topSpeed;

    public String getCarName() {
        return carName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public String getCarType() {
        return carType;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getEngine() {
        return engine;
    }

    public String getNoOfSeats() {
        return noOfSeats;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTopSpeed() {
        return topSpeed;
    }

    public static ArrayList<Car>getList() {

        ArrayList<Car> cars = new ArrayList<>();

        Car bmw3Series = new Car();
        bmw3Series.carName = "BMW 3 Series";
        bmw3Series.carType = "Sedan";
        bmw3Series.companyName = "BMW";
        bmw3Series.pricePerDay = 80.0;
        bmw3Series.noOfSeats = "5 Seats";
        bmw3Series.transmission = "Automatic";
        bmw3Series.imgUrl = "https://imgd.aeplcdn.com/1056x594/n/suk7osa_1474663.jpg?q=85";
        bmw3Series.engine = "2.0 L B48 I4 turbo";
        bmw3Series.fuelType = "Petrol";
        bmw3Series.topSpeed = "235 kmph";
        cars.add(bmw3Series);

        Car hondaCivic = new Car();
        hondaCivic.imgUrl= "https://di-uploads-pod1.dealerinspire.com/hondaoflincoln/uploads/2019/03/2019-Honda-Civic-LX-Platinum-White-Pearl-HERO.png";
        hondaCivic.companyName = "Honda";
        hondaCivic.carName = "Honda Civic";
        hondaCivic.carType = "Sedan";
        hondaCivic.pricePerDay = 60.0;
        hondaCivic.noOfSeats = "5 Seats";
        hondaCivic.transmission = "Automatic";
        hondaCivic.engine = "1.6-litre diesel";
        hondaCivic.fuelType = "Diesel";
        hondaCivic.topSpeed = "130 mph";
        cars.add(hondaCivic);

        Car audi4 = new Car();
        audi4.carName = "Audi A4";
        audi4.companyName = "Audi";
        audi4.transmission = "Automatic";
        audi4.imgUrl = "https://cars.usnews.com/static/images/Auto/izmo/i62379705/2018_audi_a4_angularfront.jpg";
        audi4.engine = "2.0 L 4-cylinder";
        audi4.noOfSeats = "5 Seats";
        audi4.pricePerDay = 90.0;
        audi4.fuelType = "Premium Gasoline";
        audi4.topSpeed = "210kmph";
        cars.add(audi4);

        Car toyotaPrius = new Car();
        toyotaPrius.pricePerDay = 65.0;
        toyotaPrius.companyName = "Toyota";
        toyotaPrius.imgUrl = "https://www.royalsundaram.in/html/files/motor101/car/Toyota-Prius.jpg";
        toyotaPrius.carName = "Toyota Prius";
        toyotaPrius.carType = "Sedan";
        toyotaPrius.noOfSeats = "4 Seats";
        toyotaPrius.transmission = "Manual";
        toyotaPrius.engine = "1.8 L 2ZR-FXE I4 VVT-i";
        toyotaPrius.fuelType = "Unleaded gasoline";
        toyotaPrius.topSpeed = "112mph";
        cars.add(toyotaPrius);

        Car mercedesGLC = new Car();
        mercedesGLC.carName = "Mercedes-Benz GLC";
        mercedesGLC.companyName = "Mercedes-Benz";
        mercedesGLC.carType = "SUV";
        mercedesGLC.imgUrl = "https://www.mercedes-benz.co.in/passengercars/mercedes-benz-cars/models/glc/suv-x253/_jcr_content/image.MQ6.2.2x.20190704153018.png";
        mercedesGLC.pricePerDay = 120.0;
        mercedesGLC.noOfSeats = "5 Seats";
        mercedesGLC.transmission = "Automatic";
        mercedesGLC.engine = "2.0 L 4-cylinder";
        mercedesGLC.fuelType = "Premium Gasoline";
        mercedesGLC.topSpeed = "217 Km/h";
        cars.add(mercedesGLC);

        Car bmwX1 = new Car();
        bmwX1.carName = "BMW X1";
        bmwX1.companyName = "BMW";
        bmwX1.carType = "SUV";
        bmwX1.imgUrl = "https://www.bookyourcar.co.in/uploads/colorimage/65073_2_Alpine%20White%20bmw%20x1.jpg";
        bmwX1.pricePerDay = 100.0;
        bmwX1.noOfSeats = "5 Seats";
        bmwX1.transmission = "Automatic";
        bmwX1.fuelType = "Diesel";
        bmwX1.topSpeed = "220kmph";
        bmwX1.engine = "2.0 L 4-cylinder";
        cars.add(bmwX1);

        Car fordTruck = new Car();
        fordTruck.companyName = "Ford";
        fordTruck.carName = "Ford F-250";
        fordTruck.imgUrl = "https://i.ebayimg.com/images/g/fw8AAOSwD4RcsF1K/s-l1200.webp";
        fordTruck.carType = "Truck";
        fordTruck.pricePerDay = 90.0;
        fordTruck.noOfSeats = "4 Seats";
        fordTruck.transmission = "Manual";
        fordTruck.fuelType = "Unleaded gasoline";
        fordTruck.topSpeed = "170 mph";
        fordTruck.engine = "2.7L V6 EcoBoost";
        cars.add(fordTruck);

        Car gmcSierra = new Car();
        gmcSierra.carType = "Truck";
        gmcSierra.pricePerDay = 80.0;
        gmcSierra.companyName = "GMC";
        gmcSierra.carName = "GMC Sierra 1500";
        gmcSierra.imgUrl = "https://crdms.images.consumerreports.org/c_lfill,w_470,q_auto,f_auto/prod/cars/cr/car-versions/14954-2020-gmc-sierra-1500-sle";
        gmcSierra.noOfSeats = "4 Seats";
        gmcSierra.transmission = "Automatic";
        gmcSierra.fuelType = "Unleaded gasoline";
        gmcSierra.engine = "Diesel I-6 engine";
        gmcSierra.topSpeed = "88 mph";

        cars.add(gmcSierra);

        Car toyotaCamry = new Car();
        toyotaCamry.carName = "Toyota Camry";
        toyotaCamry.companyName = "Toyota";
        toyotaCamry.carType = "Sedan";
        toyotaCamry.pricePerDay = 70.0;
        toyotaCamry.imgUrl = "https://i.ebayimg.com/images/g/TEwAAOSwWepeXilY/s-l1200.webp";
        toyotaCamry.noOfSeats = " 5 Seats";
        toyotaCamry.transmission = "Automatic";
        toyotaCamry.fuelType = "Petrol";
        toyotaCamry.engine = "2.5 L 4-cylinder";
        toyotaCamry.topSpeed = "183 kmph";
        cars.add(toyotaCamry);

        Car fordFocus = new Car();
        fordFocus.carType = "Hatchback";
        fordFocus.companyName = "Ford";
        fordFocus.carName = "Ford Focus";
        fordFocus.pricePerDay = 50.0;
        fordFocus.imgUrl = "https://i.ebayimg.com/images/g/xaYAAOSwK3lcsGA5/s-l1200.webp";
        fordFocus.noOfSeats = "4 Seats";
        fordFocus.transmission = "Manual";
        fordFocus.engine = "1.0-litre three-cylinder";
        fordFocus.fuelType = "Petrol";
        fordFocus.topSpeed = "165 mph";
        cars.add(fordFocus);

        return cars;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.carName);
        dest.writeString(this.companyName);
        dest.writeString(this.imgUrl);
        dest.writeValue(this.pricePerDay);
        dest.writeString(this.carType);
        dest.writeString(this.noOfSeats);
        dest.writeString(this.transmission);
        dest.writeString(this.engine);
        dest.writeString(this.fuelType);
        dest.writeString(this.topSpeed);
    }

    public void readFromParcel(Parcel source) {
        this.carName = source.readString();
        this.companyName = source.readString();
        this.imgUrl = source.readString();
        this.pricePerDay = (Double) source.readValue(Double.class.getClassLoader());
        this.carType = source.readString();
        this.noOfSeats = source.readString();
        this.transmission = source.readString();
        this.engine = source.readString();
        this.fuelType = source.readString();
        this.topSpeed = source.readString();
    }

    public Car() {}

    protected Car(Parcel in) {
        this.carName = in.readString();
        this.companyName = in.readString();
        this.imgUrl = in.readString();
        this.pricePerDay = (Double) in.readValue(Double.class.getClassLoader());
        this.carType = in.readString();
        this.noOfSeats = in.readString();
        this.transmission = in.readString();
        this.engine = in.readString();
        this.fuelType = in.readString();
        this.topSpeed = in.readString();
    }

    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}
