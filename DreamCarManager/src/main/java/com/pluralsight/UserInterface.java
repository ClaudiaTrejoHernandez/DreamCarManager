package com.pluralsight;

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

    }

    public int displayMenu() { //Helper method to display menu. Can be called in other methods

    }

    private void displayAllVehicles(List<Vehicle> vehicles) {

    }

    private void processGetByPriceRequest() {

    }

    private void processGetByMakeModelRequest() {

    }

    private void processGetByYearRequest() {

    }

    private void processGetByColorRequest() {

    }

    private void processGeyByMileageRequest() {

    }

    private void processGetByVehicleTypeRequest() {

    }

    private void processGetAllVehiclesRequest() {

    }

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {
        
    }
}



