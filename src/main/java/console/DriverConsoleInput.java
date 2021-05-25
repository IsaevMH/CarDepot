package console;

import domain.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverConsoleInput extends ConsoleInput{
    Scanner scanner;

    @Override
    public Driver input() {
        scanner = new Scanner(System.in);
        String name;
        int experience;
        List<String> categories = new ArrayList<>();
        System.out.println("Введите ФИО водителя: ");
        name = scanner.nextLine();
        System.out.println("Введите стаж водителя: ");
        experience = scanner.nextInt();
        String category;
        do {
            System.out.println("Введите категорию(и) вождения: ");
            category = scanner.nextLine();
            categories.add(category);
        } while (category != "");
        return new Driver(name, experience, categories);
    }

    @Override
    public List<Object> inputAll() {
        return null;
    }


}
