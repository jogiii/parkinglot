package com.jogi.parkinglot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyChargingStrategy implements ChargingStrategy {
    @Override
    public double calculateCharges(Car car) {
        LocalDateTime entryTime = car.getEntryTime();
        LocalDateTime exitTime = car.getExitTime();
        long hoursParked = entryTime.until(exitTime, ChronoUnit.HOURS);
        if (entryTime.until(exitTime, ChronoUnit.MINUTES) % 60 != 0) {
            hoursParked++;
        }
        return hoursParked * 2.0;
    }
}