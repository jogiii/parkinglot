# parkinglot
**Assumptions**:

We will use Java 8 for this system.
The system will be a console application.
We won't use a real database but simulate parking slots using data structures.
The system will handle concurrent access for multiple cars entering simultaneously.

**High-Level Design:**

Car Class: Represents a car with attributes like a unique ID, entry time, and exit time.

ParkingLot Interface: Defines the core functionality for managing parking slots. This interface allows for different implementations, making the system pluggable and scalable.

DefaultParkingLot Implementation: An initial implementation of the parking lot, using a list to store parked cars. This is a basic, non-scalable solution.

ScalableParkingLot Implementation: A more advanced implementation that can be scaled horizontally to handle a larger number of cars.

ChargingStrategy Interface: Defines the strategy for calculating parking charges. We use the Strategy pattern to allow different charging strategies.

HourlyChargingStrategy Implementation: An implementation of the charging strategy that charges £2 per hour, rounding up to the nearest hour.

CarParkingSystem Class: Acts as the main class and contains the logic for simulating cars entering and leaving the parking lot.

ParkingLotFactory Class: Implements the Factory pattern to create different types of parking lots based on a given configuration.
