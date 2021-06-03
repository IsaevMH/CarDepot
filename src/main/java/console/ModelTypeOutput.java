package console;

import domain.ModelType;
import java.util.List;

public class ModelTypeOutput extends ConsoleOutput<ModelType> {
    @Override
    public void print(ModelType modelType) {
        System.out.println(modelType.toString());
    }

    @Override
    public void printAll(List<ModelType> modelTypes) {
        for (ModelType modelType : modelTypes) {
            System.out.println(modelType.toString());
        }
    }
}
