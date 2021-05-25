package console;

import java.util.List;

public abstract class ConsoleOutput<T> {
    public abstract void print(T object);
    public abstract void printAll(List<T> objects);
}
