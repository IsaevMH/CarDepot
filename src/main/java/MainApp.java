import console.*;
import domain.Driver;
import domain.ModelType;
import domain.Vehicle;
import domain.DriverToVehicle;
import service.DriverService;
import service.DriverToVehicleService;
import service.ModelTypeService;
import service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner in = new Scanner(System.in);

    public static int displayMainMenu() {
        System.out.println("-------------Главное меню-------------");
        System.out.println("1. Автомобиль");
        System.out.println("2. Водитель");
        System.out.println("3. Модель авто.");
        System.out.println("4. Привязки");
        System.out.println("5. Выход");
        System.out.print("Введите значение от 1 до 5: ");
        return in.nextInt();
    }

    public static int displayCarsInfo() {
        System.out.println("----------------Автомобиль------------------");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Изменить");
        System.out.println("4. Показать конкретный автомобиль");
        System.out.println("5. Показать все");
        return in.nextInt();
    }

    public static int displayDriversInfo() {
        System.out.println("----------------Водитель--------------------");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Изменить");
        System.out.println("4. Показать конкретного водителя");
        System.out.println("5. Показать все");
        return in.nextInt();
    }

    public static int displayModelType() {
        System.out.println("----------------Модель авто.----------------");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Изменить");
        System.out.println("4. Показать конкретную модель");
        System.out.println("5. Показать все");
        return in.nextInt();
    }

    public static int displayBindings() {
        System.out.println("----------------Привязки------------------");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Изменить");
        System.out.println("4. Показать конкретную привязку");
        System.out.println("5. Показать все");
        return in.nextInt();
    }

    private static void selectOptionToVehicle(int option) {
        VehicleService vehicleService = new VehicleService();
        VehicleConsoleInput vehicleInput = new VehicleConsoleInput();
        VehicleConsoleOutput vehicleOutput = new VehicleConsoleOutput();
        Vehicle vehicle;
        long vehicleId;
        switch (option) {
            case 1:
                vehicle = vehicleInput.input();
                vehicleService.addVehicle(vehicle);
                System.out.println("Добавлен");
                break;
            case 2:
                vehicleId = vehicleInput.inputIdToRemove();
                vehicleService.removeVehicle(vehicleId);
                System.out.println("Удален");
                break;
            case 3:
                vehicle = vehicleInput.inputDataToChangeObject();
                vehicleId = vehicleInput.inputIdToShow();
                vehicleService.changeVehicle(vehicle, vehicleId);
                System.out.println("Изменен");
                break;
            case 4:
                vehicleId = vehicleInput.inputIdToShow();
                vehicle = vehicleService.getVehicle(vehicleId);
                vehicleOutput.print(vehicle);
                break;
            case 5:
                List<Vehicle> vehicles = vehicleService.getAllVehicles();
                vehicleOutput.printAll(vehicles);
                break;
        }
    }

    private static void selectOptionToDriver(int option) {
        DriverService driverService = new DriverService();
        DriverConsoleInput driverInput = new DriverConsoleInput();
        Driver driver;
        long driverId;
        DriverConsoleOutput driverOutput = new DriverConsoleOutput();
        switch (option) {
            case 1:
                driver = driverInput.input();
                driverService.addDriver(driver);
                System.out.println("Добавлен");
                break;
            case 2:
                driverId = driverInput.inputIdToRemove();
                driverService.removeDriver(driverId);
                System.out.println("Удален");
                break;
            case 3:
                driver = driverInput.inputDataToChangeObject();
                driverId = driverInput.inputIdToShow();
                driverService.changeDriver(driver, driverId);
                System.out.println("Изменен");
                break;
            case 4:
                driverId = driverInput.inputIdToShow();
                driver = driverService.getDriver(driverId);
                driverOutput.print(driver);
                break;
            case 5:
                List<Driver> drivers = driverService.getAllDrivers();
                driverOutput.printAll(drivers);
                break;
        }
    }

    private static void selectOptionToModelType(int option) {
        ModelTypeService modelService = new ModelTypeService();
        ModelTypeInput modelInput = new ModelTypeInput();
        ModelTypeOutput modelOuput = new ModelTypeOutput();
        long modelId;
        ModelType modelType;
        switch (option) {
            case 1:
                modelType = modelInput.input();
                modelService.addModelType(modelType);
                System.out.println("Добавлен");
                break;
            case 2:
                modelId = modelInput.inputIdToRemove();
                modelService.removeModelType(modelId);
                System.out.println("Удален");
                break;
            case 3:
                modelType = modelInput.inputDataToChangeObject();
                modelId = modelInput.inputIdToShow();
                modelService.changeModelType(modelType, modelId);
                System.out.println("Изменен");
                break;
            case 4:
                modelId = modelInput.inputIdToShow();
                modelType = modelService.getModelType(modelId);
                modelOuput.print(modelType);
                break;
            case 5:
                List<ModelType> modelTypes = modelService.getAllTypes();
                modelOuput.printAll(modelTypes);
                break;
        }
    }

    private static void selectOptionToDriverToVehicle(int option) {
        DriverToVehicleService driverToVehicleService = new DriverToVehicleService();
        DriverToVehicleConsoleInput driverToVehicleInput = new DriverToVehicleConsoleInput();
        DriverToVehicleConsoleOutput driverToVehicleOutput = new DriverToVehicleConsoleOutput();
        long driverToVehicleId;
        DriverToVehicle driverToVehicle;
        switch (option) {
            case 1:
                driverToVehicle = driverToVehicleInput.input();
                driverToVehicleService.addDriverAndCarLink(driverToVehicle);
                System.out.println("Добавлен");
                break;
            case 2:
                driverToVehicleId = driverToVehicleInput.inputIdToRemove();
                driverToVehicleService.removeDriverAndCarLink(driverToVehicleId);
                System.out.println("Удален");
                break;
            case 3:
                driverToVehicle = driverToVehicleInput.inputDataToChangeObject();
                driverToVehicleId = driverToVehicleInput.inputIdToShow();
                driverToVehicleService.changeDriverAndCarLink(driverToVehicle, driverToVehicleId);
                System.out.println("Изменен");
                break;
            case 4:
                driverToVehicleId = driverToVehicleInput.inputIdToShow();
                driverToVehicle = driverToVehicleService.getDriverAndCarLink(driverToVehicleId);
                driverToVehicleOutput.print(driverToVehicle);
                break;
            case 5:
                List<DriverToVehicle> driverToVehicles = driverToVehicleService.getDriverAndCarLins();
                driverToVehicleOutput.printAll(driverToVehicles);
                break;
        }
    }

    public static void main(String[] args) {
        int option = 0;
        do {
            int value = displayMainMenu();
            switch (value) {
                case 1:
                    option = displayCarsInfo();
                    selectOptionToVehicle(option);
                    break;
                case 2:
                    option = displayDriversInfo();
                    selectOptionToDriver(option);
                    break;
                case 3:
                    option = displayModelType();
                    selectOptionToModelType(option);
                    break;
                case 4:
                    option = displayBindings();
                    selectOptionToDriverToVehicle(option);
                    break;
                default:
                    System.exit(0);
            }
        } while (option != 0) ;
    }
}
