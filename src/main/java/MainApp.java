import console.*;
import domain.Driver;
import domain.Dvm2m;
import domain.ModelType;
import domain.Vehicle;
import service.DriverService;
import service.Dvm2mService;
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
        System.out.print("Введите значение от 1 до 4: ");
        int option = in.nextInt();
        return option;
    }
    public static int displayCarsInfo(){
        System.out.println("----------------Автомобиль------------------");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Изменить");
        System.out.println("4. Показать конкретный автомобиль");
        System.out.println("5. Показать все");
        int option = in.nextInt();
        return option;
    }
    public static int displayDriversInfo() {
        System.out.println("----------------Водитель--------------------");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Изменить");
        System.out.println("4. Показать конкретного водителя");
        System.out.println("5. Показать все");
        int option = in.nextInt();
        return option;
    }
    public static int displayModelType() {
        System.out.println("----------------Модель авто.----------------");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Изменить");
        System.out.println("4. Показать конкретную модель");
        System.out.println("5. Показать все");
        int option = in.nextInt();
        return option;
    }
    public static int displayBindings() {
        System.out.println("----------------Привязки------------------");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Изменить");
        System.out.println("4. Показать конкретную привязку");
        System.out.println("5. Показать все");
        int option = in.nextInt();
        return option;
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
                vehicle = vehicleInput.input();
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
                driver = driverInput.input();
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
                modelType = modelInput.input();
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
    private static void selectOptionToDvm2m(int option) {
        Dvm2mService dvm2mService = new Dvm2mService();
        Dvm2mConsoleInput dvm2mInput = new Dvm2mConsoleInput();
        Dvm2mConsoleOutput dvm2mOutput = new Dvm2mConsoleOutput();
        long dvm2mId;
        Dvm2m dvm2m;
        switch (option){
            case 1:
                dvm2m = dvm2mInput.input();
                dvm2mService.addDriverAndCarLink(dvm2m);
                System.out.println("Добавлен");
                break;
            case 2:
                dvm2mId = dvm2mInput.inputIdToRemove();
                dvm2mService.removeDriverAndCarLink(dvm2mId);
                System.out.println("Удален");
                break;
            case 3:
                dvm2m = dvm2mInput.input();
                dvm2mId = dvm2mInput.inputIdToShow();
                dvm2mService.changeDriverAndCarLink(dvm2m, dvm2mId);
                System.out.println("Изменен");
                break;
            case 4:
                dvm2mId = dvm2mInput.inputIdToShow();
                dvm2m = dvm2mService.getDriverAndCarLink(dvm2mId);
                dvm2mOutput.print(dvm2m);
                break;
            case 5:
                List<Dvm2m> dvm2ms = dvm2mService.getDriverAndCarLins();
                dvm2mOutput.printAll(dvm2ms);
                break;
        }
    }

    public static void main(String[] args) {
        int value = displayMainMenu();
        int option = 0;
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
                selectOptionToDvm2m(option);
                break;
            default:
                System.exit(0);
        }
    }
}
