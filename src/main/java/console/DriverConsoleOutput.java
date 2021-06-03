package console;

import domain.Driver;
import java.util.List;

public class DriverConsoleOutput extends ConsoleOutput<Driver>{
    @Override
    public void print(Driver driver) {
        System.out.println(driver.toString());
    }

    @Override
    public void printAll(List<Driver> drivers) {
        for (Driver driver : drivers) {
            System.out.println(driver.toString());
        }
    }
}
