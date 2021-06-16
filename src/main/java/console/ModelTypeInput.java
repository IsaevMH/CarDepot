package console;

import domain.ModelType;
import domain.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ModelTypeInput extends ConsoleInput<ModelType> {
    Scanner scanner = new Scanner(System.in);

    @Override
    public ModelType input() {
        System.out.println("Введите наименование модели авто: ");
        String name = scanner.nextLine();
        return new ModelType(name);
    }

    @Override
    public List<ModelType> inputAll() {
        String answer;
        List<ModelType> modelTypes = new ArrayList<>();
        do {
            modelTypes.add(input());
            System.out.print("Продолжить добавление?(yes/no): ");
            answer = scanner.nextLine();
        } while (answer.toLowerCase(Locale.ROOT).contains("yes"));
        return modelTypes;
    }

    @Override
    public long inputIdToRemove() {
        System.out.print("Введите ID модели автомобиля, для его удаления: ");
        long id = scanner.nextLong();
        return id;
    }

    @Override
    public long inputIdToShow() {
        scanner.nextLine();
        System.out.print("Введите ID модели автомобиля, для его демонстрации: ");
        Long id = scanner.nextLong();
        return id;
    }

    @Override
    public ModelType inputDataToChangeObject() {
        System.out.print("Введите наименование модели транспорта: ");
        String name = scanner.nextLine();
        return new ModelType(name);
    }
}
