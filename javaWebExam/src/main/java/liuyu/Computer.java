package liuyu;

public class Computer {
    private double number1;
    private double number2;
    private double result;
    private String op="+";
    public double getNumber1() {
        return number1;
    }
    public void setNumber1(double number1) {
        this.number1 = number1;
    }
    public double getNumber2() {
        return number2;
    }
    public void setNumber2(double number2) {
        this.number2 = number2;
    }
    public double getResult() {
        if(op.equals("+")){
            result=number1+number2;
        }
        else if(op.equals("-")){
            result=number1-number2;
        }
        else if(op.equals("*")){
            result=number1*number2;
        }
        else if(op.equals("/")){
            result=number1/number2;
        }
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
    public String getOp() {
        return op;
    }
    public void setOp(String op) {
        this.op = op;
    }
}
