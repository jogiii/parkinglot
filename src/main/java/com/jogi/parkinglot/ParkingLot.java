package com.jogi.parkinglot;

import java.util.List;

public interface ParkingLot {

    boolean isFull();

    void allocateSlot(Car car);

    void freeSlot(Car car);

    List<Car> getParkedCars();
}

