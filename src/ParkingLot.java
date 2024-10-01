public interface ParkingLot {
    void createParkingLot(int totalSlots);
    void parkVehicle (Vehicle vehicle);
    void unparkVehicle (int slotNumber);
    void status();
    void vehicleByType(String type);
    void registrationNumberVehicleOddPlate();
    void registrationNumberVehicleEvenPlate();
    void registrationNumberVehicleWithColor(String color);
    void slotNumberVehicleWithColor(String color);
    void slotNumberForRegistrationNumber(String registrationNumber);

}
