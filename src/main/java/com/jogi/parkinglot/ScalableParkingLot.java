package com.jogi.parkinglot;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScalableParkingLot implements ParkingLot {
    private int capacity;
    private List<Car> parkedCars;

    public ScalableParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedCars = new CopyOnWriteArrayList<>();
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

