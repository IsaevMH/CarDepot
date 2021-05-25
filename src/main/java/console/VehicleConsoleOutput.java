package console;

import domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleConsoleOutput extends ConsoleOutput{

    @Override
    public void print(Object object) {
        if(object instanceof Vehicle) {
            Vehicle vehicle = (Vehicle)object;
            System.out.println(vehicle.toString());
        } else {
            System.out.println("Такого автомобиля не существует.");
        }
    }

    @Override
    public void printAll(List objects) {
        if(objects instanceof Vehicle) {
            List<Vehicle> vehicles = new ArrayList<>();
            for (Object object : objects)
                vehicles.add((Vehicle) object);
            System.out.println(vehicles.toString());
        } else {
            System.out.println("Таких водителей не существует.");
        }
    }
}
