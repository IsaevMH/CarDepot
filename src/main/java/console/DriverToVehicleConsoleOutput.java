package console;

import domain.DriverToVehicle;

import java.util.List;

public class DriverToVehicleConsoleOutput extends ConsoleOutput<DriverToVehicle> {
    @Override
    public void print(DriverToVehicle object) {
        System.out.println(object.toString());
    }

    @Override
    public void printAll(List<DriverToVehicle> objects) {
        for (DriverToVehicle object : objects) {
            System.out.println(object.toString());
        }
    }
}
