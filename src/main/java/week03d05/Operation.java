package week03d05;

public class Operation {

    private int leftOperand;
    private int rightOperand;

    public Operation(int leftOperand, int rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public int getLeftOperand() {
        return leftOperand;
    }

    public int getRightOperand() {
        return rightOperand;
    }

    public int getResult(){
        return getLeftOperand()+ getRightOperand();
    }
}
