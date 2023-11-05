package com.jogi.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class DefaultParkingLot implements ParkingLot {
    private int capacity;
    private List<Car> parkedCars;

    public DefaultParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedCars = new ArrayList<>(capacity);
    }

    public boolean isFull() {
        return parkedCars.size() >= capacity;
    }

    public void allocateSlot(Car car) {
        parkedCars.add(car);
    }

    public void freeSlot(Car car) {
        parkedCars.remove(car);
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }
}
