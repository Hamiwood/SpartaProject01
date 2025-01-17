package Project01.SpartaProject01;

// lv3 도전모드 계산기 만들기

import java.util.ArrayList;
import java.util.Arrays;

public class ArithmeticCalculator<T extends Number> {
    private final ArrayList<ArrayList<String>> save = new ArrayList<>();
    private T num1;
    private T num2;

    //getter setter
    public T getNum1() {
        return num1;
    }

    public void setNum1(T num1) {
        this.num1 = num1;
    }

    public T getNum2() {
        return num2;
    }

    public void setNum2(T num2) {
        this.num2 = num2;
    }

    public ArrayList<ArrayList<String>> getSave() {
        return save;
    }

    //연산 로그 모두 읽어오기
    public void showArr() {
        if (save != null && !save.isEmpty()) {
            for (int i = 0; i < save.size(); i++) {
                System.out.println("[" + i + "] " + save.get(i).get(0) + save.get(i).get(2) + save.get(i).get(1) + " = " + save.get(i).get(3));
            }
        }
    }

    //연산 로그 저장
    public void addSave(String num1, String num2, String operator, String result) {
        save.add(new ArrayList<>(Arrays.asList(num1, num2, operator, result)));
    }

    //입력받은 번호의 연산로그 삭제
    public void removeSave(int index) {
        save.remove(index);
    }

    //연산로그 모두 삭제
    public void clearSave() {
        save.clear();
    }

    //입력 값보다 작은 결과값 도출
    public void interResult(double standard) {
        if (save != null && !save.isEmpty()) {
            save.stream()
                    .filter(s -> Double.parseDouble(s.get(3)) > standard)
                    .forEach(s -> System.out.println(s.get(0) + s.get(2) + s.get(1) + " = " + s.get(3)));
        }
    }

    //연산 메서드
    public T calculate(T num1, T num2, OperatorType operator) {

        String n1 = num1.toString();
        String n2 = num2.toString();
        String op = "";

        if (num1 instanceof Integer && num2 instanceof Integer) {
            Integer result = 0;

            switch (operator) {
                case ADD:
                    result = num1.intValue() + num2.intValue();
                    op = "+";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case SUBTRACT:
                    result = num1.intValue() - num2.intValue();
                    op = "-";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case MULTIPLY:
                    result = num1.intValue() * num2.intValue();
                    op = "*";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case DIVIDE:
                    result = num1.intValue() / num2.intValue();
                    op = "/";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case REMAINDER:
                    result = num1.intValue() % num2.intValue();
                    op = "%";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case SQUARE:
                    result = (int) Math.pow(num1.intValue(), num2.intValue());
                    op = "^";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;

            }

        } else if (num1 instanceof Double || num2 instanceof Double) {
            Double result = 0.0;

            switch (operator) {
                case ADD:
                    result = num1.doubleValue() + num2.doubleValue();
                    op = "+";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case SUBTRACT:
                    result = num1.doubleValue() - num2.doubleValue();
                    op = "-";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case MULTIPLY:
                    result = num1.doubleValue() * num2.doubleValue();
                    op = "*";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case DIVIDE:
                    result = num1.doubleValue() / num2.doubleValue();
                    op = "/";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
                case REMAINDER:
                    result = num1.doubleValue() % num2.doubleValue();
                    op = "%";
                    addSave(n1, n2, op, result.toString());
                    return (T) result;
            }
        }
        return null;
    }

    //연산자 enum
    public enum OperatorType {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, REMAINDER, SQUARE
    }
}





