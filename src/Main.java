import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IParkingLot parkingLot = null;

        while (true) {
            String input = scanner.nextLine();
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "create_parking_lot":
                    int total = Integer.parseInt(commands[1]);
                    parkingLot = new IParkingLot(total);
                    parkingLot.createParkingLot(total);
                    break;
                case "park":
                    if (parkingLot != null) {
                        String registration = commands[1];
                        String color = commands[2];
                        String type = commands[3];
                        Vehicle vehicle = new Vehicle(registration, type, color);
                        parkingLot.parkVehicle(vehicle);
                    }
                    break;
                case "leave":
                    if (parkingLot != null) {
                        int slots = Integer.parseInt(commands[1]);
                        parkingLot.unparkVehicle(slots);
                    }
                    break;
                case "status":
                    if (parkingLot != null) {
                        parkingLot.status();
                    }
                    break;
                case "type_of_vehicles":
                    if (parkingLot != null) {
                        parkingLot.vehicleByType(commands[1]);
                    }
                    break;
                case "registration_numbers_for_vehicles_with_odd_plate":
                    if (parkingLot != null) {
                        parkingLot.registrationNumberVehicleOddPlate();
                    }
                    break;
                case "registration_numbers_for_vehicles_with_even_plate":
                    if (parkingLot != null) {
                        parkingLot.registrationNumberVehicleEvenPlate();
                    }
                    break;
                case "registration_numbers_for_vehicles_with_colour":
                    if (parkingLot != null) {
                        parkingLot.registrationNumberVehicleWithColor(commands[1]);
                    }
                    break;
                case "slot_numbers_for_vehicles_with_colour":
                    if (parkingLot != null) {
                        parkingLot.slotNumberVehicleWithColor(commands[1]);
                    }
                    break;
                case "slot_number_for_registration_number":
                    if (parkingLot != null) {
                        parkingLot.slotNumberForRegistrationNumber(commands[1]);
                    }
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }
}
