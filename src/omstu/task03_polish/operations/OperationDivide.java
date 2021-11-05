package omstu.task03_polish.operations;

public class OperationDivide implements Operation {
    @Override
    public float executeOperation(float first, float second) throws Exception {
        if (second == 0 || -second == 0)
            throw new Exception("Division by 0");
        return first / second;
    }
}
