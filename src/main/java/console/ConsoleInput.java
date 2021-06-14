package console;

import java.util.List;

public abstract class ConsoleInput<T> {
    public abstract T input();
    public abstract List<T> inputAll();
    public abstract long inputIdToRemove();
    public abstract long inputIdToShow();
    public abstract T inputDataToChangeObject();
}
