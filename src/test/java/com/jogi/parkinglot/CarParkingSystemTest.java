package com.jogi.parkinglot;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class CarParkingSystemTest {

    private ParkingLot defaultParkingLot;
    private ParkingLot scalableParkingLot;
    private ChargingStrategy hourlyChargingStrategy;

    @BeforeEach
    public  void setup() {
        defaultParkingLot = new DefaultParkingLot(5);
        scalableParkingLot = new ScalableParkingLot(5);
        hourlyChargingStrategy = new HourlyChargingStrategy();
    }

    @Test
    public void testDefaultParkingLot() {
        // Test allocateSlot and isFull methods
        for (int carId = 1; carId <= 5; carId++) {
            Car car = new Car(carId, LocalDateTime.now());
            defaultParkingLot.allocateSlot(car);
            assertEquals(carId == 5, defaultParkingLot.isFull());
        }

        // Test getParkedCars method
        List<Car> parkedCars = defaultParkingLot.getParkedCars();
        assertEquals(5, parkedCars.size());

        // Test freeSlot method
        Car carToFree = parkedCars.get(0);
        defaultParkingLot.freeSlot(carToFree);
        assertFalse(defaultParkingLot.isFull());
        assertFalse(defaultParkingLot.getParkedCars().contains(carToFree));
    }

    @Test
    public void testScalableParkingLot() {
        // Test allocateSlot and isFull methods
        for (int carId = 1; carId <= 10; carId++) {
            Car car = new Car(carId, LocalDateTime.now());
            scalableParkingLot.allocateSlot(car);
        }

        // Test getParkedCars method
        List<Car> parkedCars = scalableParkingLot.getParkedCars();
        assertEquals(10, parkedCars.size());

        // Test freeSlot method
        Car carToFree = parkedCars.get(0);
        scalableParkingLot.freeSlot(carToFree);
        assertFalse(scalableParkingLot.getParkedCars().contains(carToFree));
    }

    @Test
    public void testHourlyChargingStrategy() {
        // Test calculateCharges method
        Car car1 = new Car(1, LocalDateTime.now().minusHours(2));

        Car car2 = new Car(2, LocalDateTime.now().plusMinutes(30));
        car1.setExitTime(LocalDateTime.now());
        car2.setExitTime(LocalDateTime.now().plusMinutes(90));
        assertEquals(4.0, hourlyChargingStrategy.calculateCharges(car1), 0.001);
        assertEquals(2.0, hourlyChargingStrategy.calculateCharges(car2), 0.001);
    }
}
