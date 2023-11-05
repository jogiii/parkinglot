package com.jogi.parkinglot;

import java.time.LocalDateTime;

public class Car {

    private int id;
    private LocalDateTime entryTime;

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    private LocalDateTime exitTime;

    public Car(int id, LocalDateTime entryTime) {
        this.id = id;
        this.entryTime = entryTime;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
