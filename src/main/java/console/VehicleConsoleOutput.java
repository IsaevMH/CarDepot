package console;

import domain.Vehicle;
import java.util.List;

public class VehicleConsoleOutput extends ConsoleOutput<Vehicle>{

    @Override
    public void print(Vehicle vehicle) {
        System.out.println(vehicle.toString());
    }

    @Override
    public void printAll(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }
}
