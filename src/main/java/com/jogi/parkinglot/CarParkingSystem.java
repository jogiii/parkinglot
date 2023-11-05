package com.jogi.parkinglot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class CarParkingSystem {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLotFactory.createParkingLot(100, false); // Use true for a scalable parking lot
        ChargingStrategy chargingStrategy = new HourlyChargingStrategy();


        String entryTime = "2023-11-05T15:30:00";

        String exitTime = "2023-11-05T18:30:00";


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
// Simulate cars entering the parking lot
        for (int carId = 1; carId <= 105; carId++) {
            if (!parkingLot.isFull()) {
                Car car = new Car(carId, LocalDateTime.parse(entryTime,formatter));
                parkingLot.allocateSlot(car);
                System.out.println("Car " + car.getId() + " entered the parking lot.");
            } else {
                System.out.println("Car park is full. Car " + carId + " cannot enter.");
            }
        }

        Iterator<Car> iterator = parkingLot.getParkedCars().iterator();

            while (iterator.hasNext()){
                Car car = iterator.next();
                car.setExitTime(LocalDateTime.now());
                double charge = chargingStrategy.calculateCharges(car);
                System.out.println("Car " + car.getId() + " exited the parking lot. Charge: £" + charge);
                iterator.remove();
            }
        // Simulate cars leaving the parking lot
//        for (Car car : parkingLot.getParkedCars()) {
//            car.setExitTime(LocalDateTime.now());
//            double charge = chargingStrategy.calculateCharges(car);
//            System.out.println("Car " + car.getId() + " exited the parking lot. Charge: £" + charge);
//
//        }
    }
}
