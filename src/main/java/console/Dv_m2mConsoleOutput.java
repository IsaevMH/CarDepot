package console;

import domain.Dv_m2m;

import java.util.List;

public class Dv_m2mConsoleOutput extends ConsoleOutput<Dv_m2m> {
    @Override
    public void print(Dv_m2m object) {
        System.out.println(object.toString());
    }

    @Override
    public void printAll(List<Dv_m2m> objects) {
        for (Dv_m2m object : objects) {
            System.out.println(object.toString());
        }
    }
}
