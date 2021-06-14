package console;

import domain.Dvm2m;

import java.util.List;

public class Dvm2mConsoleOutput extends ConsoleOutput<Dvm2m> {
    @Override
    public void print(Dvm2m object) {
        System.out.println(object.toString());
    }

    @Override
    public void printAll(List<Dvm2m> objects) {
        for (Dvm2m object : objects) {
            System.out.println(object.toString());
        }
    }
}
