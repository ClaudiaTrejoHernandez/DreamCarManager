package com.pluralsight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static Scanner read = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface() {
        init();
    }

    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

    public void display() {
        boolean running = true;
        init(); //Load dealership

        while (running) {
            try {
                int choice = displayMenu();

                switch (choice) {
                    case 1 -> processGetByPriceRequest();
                    case 2 -> processGetByMakeModelRequest();
                    case 3 -> processGetByYearRequest();
                    case 4 -> processGetByColorRequest();
                    case 5 -> processGetByMileageRequest();
                    case 6 -> processGetByVehicleTypeRequest();
                    case 7 -> processGetAllVehiclesRequest();
                    case 8 -> processAddVehicleRequest();
                    case 9 -> processRemoveVehicleRequest();
                    case 10 -> processSellVehicle();
                    case 11 -> processLeaseVehicle();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid Option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Invalid input. Please enter a valid number.\n");
                read.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Unexpected Error: " + e.getMessage());
            }
        }
    }


    public int displayMenu() {  //Helper method to display menu

        System.out.println("\n☁️☁️☁️ === 🚗 Car Dealership Menu 🚗 === ☁️☁️☁️");
        System.out.println("1️⃣  Search by Price 💰");
        System.out.println("2️⃣  Search by Make & Model 🏷️🚙");
        System.out.println("3️⃣  Search by Year 📅");
        System.out.println("4️⃣  Search by Color 🎨");
        System.out.println("5️⃣  Search by Mileage ⏱️");
        System.out.println("6️⃣  Search by Vehicle Type 🚐");
        System.out.println("7️⃣  View All Vehicles 🚘");
        System.out.println("8️⃣  Add a Vehicle ➕🚗");
        System.out.println("9️⃣  Remove a Vehicle ➖🚗");
        System.out.println("🔟  Sell a Vehicle 💵🚗");
        System.out.println("⓫  Lease a Vehicle 📄🔑");
        System.out.println("0️⃣  Exit ❌");
        System.out.print("Please select an option: \n");


        int choice = read.nextInt();
        read.nextLine();
        return choice;
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processGetByPriceRequest() {
        while (true) {
            try {
                System.out.println("Enter minimum price: ");
                double min = read.nextDouble();

                System.out.println("Enter maximum price: ");
                double max = read.nextDouble();
                read.nextLine();

                List<Vehicle> result = dealership.getVehiclesByPrice(min, max);

                if (min > max) {
                    System.out.println("❌ Minimum price cannot be more than maximum price. Please try again.");
                    continue;
                }

                if (result.isEmpty()) {
                    System.out.println("❌ No matches found. Please try again.");
                } else {
                    System.out.println("\n✅ Matching Vehicles:");
                    displayVehicles(result);
                    break;
                }

            }catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter numeric values.");
                read.nextLine();

            }catch (Exception e) {
                System.out.println("❌ Invalid input. Try again.");
                read.nextLine();
            }
        }
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Enter Make: ");
        String make = read.nextLine();

        System.out.println("Enter Model: ");
        String model = read.nextLine();

        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);

        if (results.isEmpty()) {
            System.out.println("❌ No matches found. Please try again.");
        } else {
            System.out.println("\n✅ Matching Vehicles:");
            displayVehicles(results);
        }

    }

    private void processGetByYearRequest() {
        while (true) {
            try {
                System.out.println("Enter minimum Year: ");
                int min = read.nextInt();
                System.out.println("Enter maximum Year: ");
                int max = read.nextInt();
                read.nextLine();

                if (min > max) {
                    System.out.println("❌ Minimum year cannot be more than maximum price. Please try again.");
                    continue;
                }

                List<Vehicle> results = dealership.getVehiclesByYear(min, max);
                displayVehicles(results);
                break;

            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
            }
        }
    }

    private void processGetByColorRequest() {

        while (true) {
            try {
                System.out.println("Enter Color: ");
                String color = read.nextLine();

                List<Vehicle> results = dealership.getVehiclesByColor(color);
                displayVehicles(results);
                break;

            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
            }
        }
    }

    private void processGetByMileageRequest() {
        while (true) {
            try {
                System.out.println("Enter minimum Mileage: ");
                int min = read.nextInt();
                System.out.println("Enter maximum Mileage: ");
                int max = read.nextInt();
                read.nextLine();

                if (min > max) {
                    System.out.println("❌ Minimum mileage cannot be more than maximum mileage. Please try again.");
                    continue;
                }

                List<Vehicle> results = dealership.getVehiclesByMileage(min, max);
                displayVehicles(results);
                break;

            }catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
            }
        }
    }

    private void processGetByVehicleTypeRequest() {
        while (true) {
            try {
                System.out.print("Enter Vehicle Type: ");
                String type = read.nextLine().trim();

                if (type.isBlank()) {
                    System.out.println("❌ Please enter a valid vehicle type.");
                    continue;
                }

                List<Vehicle> results = dealership.getVehiclesByType(type);
                displayVehicles(results);

                if (results.isEmpty()) {
                    System.out.println("🚫 No vehicles found for the specified type.");
                } else {
                    displayVehicles(results);
                }
                break;

            } catch (Exception e) {
                System.out.println("❌ An error occurred. Please try again.");
            }
        }
    }


    private void processGetAllVehiclesRequest() {
        List<Vehicle> results = dealership.getAllVehicles();
        displayVehicles(results);
    }

    private void processAddVehicleRequest() {
        try {
            System.out.println("📥 Enter Vehicle Information:");

            System.out.print("VIN #: ");
            int vin = read.nextInt();
            System.out.println("Year: ");
            int year = read.nextInt();
            read.nextLine();
            System.out.println("Make: ");
            String make = read.nextLine();
            System.out.println("Model: ");
            String model = read.nextLine();
            System.out.println("Vehicle Type: ");
            String vehicleType = read.nextLine();
            System.out.println("Color: ");
            String color = read.nextLine();
            System.out.println("Odometer: ");
            int odometer = read.nextInt();
            read.nextLine();
            System.out.println("Price: ");
            int price = read.nextInt();

            //Create new vehicle from input
            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            //Add it to the dealership inventory
            dealership.addVehicle(newVehicle);

            //Save updated dealership to file
            DealershipFileManager dfm = new DealershipFileManager();
            dfm.saveDealership(dealership);

            System.out.println("\n✅ Vehicle added successfully!");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            read.nextLine();
        }
    }

    private void processRemoveVehicleRequest() {
        try {
            System.out.println("🗑️ Enter the VIN of the vehicle to remove:");
            int vinToRemove = read.nextInt();
            read.nextLine();

            List<Vehicle> allVehicles = dealership.getAllVehicles();
            Vehicle vehicleToRemove = null;

            for (Vehicle v : allVehicles) {
                if (v.getVin() == vinToRemove) {
                    vehicleToRemove = v;
                    break;
                }
            }
            if (vehicleToRemove != null) {
                dealership.removeVehicle(vehicleToRemove);

                //Save updated dealership to file
                DealershipFileManager dfm = new DealershipFileManager();
                dfm.saveDealership(dealership);

                System.out.println("\n✅ Vehicle removed successfully!");
            } else {
                System.out.println("❌ No vehicle found with that VIN.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error removing vehicle: " + e.getMessage());
            read.nextLine();
        }
    }

    private void processSellVehicle() {
        try {
            System.out.println("Enter Vehicle VIN: ");
            int vin = Integer.parseInt(read.nextLine());

            boolean success = dealership.sellVehicle(vin);

            if (success) {
                System.out.println("✅ Vehicle with VIN " + vin + " has been marked as SOLD.");
            } else {
                System.out.println("❌ Vehicle not found or already sold.");
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid VIN format. Please enter a number.");
        }

    }

    private void processLeaseVehicle() {
        

    }
}




