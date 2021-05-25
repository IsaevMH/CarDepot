package console;

import domain.Driver;
import domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class DriverConsoleOutput extends ConsoleOutput{
    @Override
    public void print(Object object) {
        if(object instanceof Driver) {
            Driver driver = (Driver)object;
            System.out.println(driver.toString());
        } else {
            System.out.println("Такого водителя не существует.");
        }
    }

    @Override
    public void printAll(List objects) {
        if(objects instanceof Driver) {
            List<Driver> driver = new ArrayList<>();
            for (Object object : objects)
                driver.add((Driver) object);
            System.out.println(driver.toString());
        } else {
            System.out.println("Таких водителей не существует.");
        }
    }
}
