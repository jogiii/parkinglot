package com.jogi.parkinglot;

public class ParkingLotFactory {

    public static ParkingLot createParkingLot(int capacity, boolean scalable) {
        if (scalable) {
            return new ScalableParkingLot(capacity);
        } else {
            return new DefaultParkingLot(capacity);
        }
    }
}
