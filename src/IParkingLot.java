import java.util.HashMap;
import java.util.Map;

public class IParkingLot implements ParkingLot {
    private int totalSlots;
    private Map<Integer, Vehicle> slotsNumber;

    public IParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.slotsNumber = new HashMap<>();
    }

    @Override
    public void createParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.slotsNumber = new HashMap<>();
        System.out.println("Created a parking lot with "+totalSlots+" slots");
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        for (int i = 1; i <= totalSlots; i++) {
            if (!slotsNumber.containsKey(i)) {
                slotsNumber.put(i, vehicle);
                System.out.println("Allocated slot number: "+ i);
                return;
            }
        }
        System.out.println("Parking lot is full");
    }

    @Override
    public void unparkVehicle(int slotNumber) {
        if (slotsNumber.containsKey(slotNumber)) {
            slotsNumber.remove(slotNumber);
            System.out.println("Slot number "+ slotNumber+ " is free");
        }else{
            System.out.println("Slot number "+ slotNumber+ " is already free");
        }
    }

    @Override
    public void status() {
        System.out.println("Slot No.\tRegistration No\tType\tColor");
        for (Map.Entry<Integer, Vehicle> entry : slotsNumber.entrySet()) {
            Vehicle vehicle = entry.getValue();
            System.out.println(entry.getKey()+"\t"+vehicle.getRegistrationNumber()+"\t"+vehicle.getType()+"\t"+vehicle.getColor());
        }
    }

    @Override
    public void vehicleByType(String type) {
        int count=0;
        for (Vehicle vehicle : slotsNumber.values()) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Override
    public void registrationNumberVehicleOddPlate() {
        for(Vehicle vehicle : slotsNumber.values()) {
            String[] part = vehicle.getRegistrationNumber().split("-");
            int numberPart = Integer.parseInt(part[1]);
            if (numberPart % 2 != 0) {
                System.out.println(vehicle.getRegistrationNumber()+" ");
            }
        }
        System.out.println();
    }

    @Override
    public void registrationNumberVehicleEvenPlate() {
        for(Vehicle vehicle : slotsNumber.values()) {
            String[] part = vehicle.getRegistrationNumber().split("-");
            int numberPart = Integer.parseInt(part[1]);
            if (numberPart % 2 == 0) {
                System.out.println(vehicle.getRegistrationNumber()+" ");
            }
        }
    }

    @Override
    public void registrationNumberVehicleWithColor(String color) {
        for(Vehicle vehicle : slotsNumber.values()) {
            if(vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.println(vehicle.getRegistrationNumber()+" ");
            }
        }
//        System.out.println();
    }

    @Override
    public void slotNumberVehicleWithColor(String color) {
        for(Map.Entry<Integer, Vehicle> entry : slotsNumber.entrySet()) {
            Vehicle vehicle = entry.getValue();
            if(vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.println(entry.getKey()+" ");
            }
        }
        System.out.println();
    }

    @Override
    public void slotNumberForRegistrationNumber(String registrationNumber) {
        for(Map.Entry<Integer, Vehicle> entry : slotsNumber.entrySet()) {
            Vehicle vehicle = entry.getValue();
            if(vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                System.out.println(entry.getKey()+" ");
            }
        }
        System.out.println("Not Found");
    }
}
