package Project01.SpartaProject01;

// lv3 도전모드 계산기 만들기

import java.util.ArrayList;
import java.util.Arrays;

public class ArithmeticCalculator<T extends Number> {
    private final ArrayList<ArrayList<String>> save = new ArrayList<>();
    private T num1;
    private T num2;

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

    //저장
    public void addSave(String num1, String num2, String operator, String result) {
        save.add(new ArrayList<>(Arrays.asList(num1, num2, operator, result)));
    }

    //삭제
    public void removeSave(int index) {
        save.remove(index);
    }

    //모두 삭제
    public void clearSave() {
        save.clear();
    }

    //stream, 람다 활용
    public void interResult(double standard) {
        if (save != null && !save.isEmpty()) {
            for (int i = 0; i < save.size(); i++) {
                if (Double.parseDouble(save.get(i).get(3)) > standard) {
                    System.out.println(save.get(i).get(0) + save.get(i).get(2) + save.get(i).get(1) + " = " + save.get(i).get(3));
                }
            }
        }
    }

    public void interResult2(double standard) {
        if (save != null && !save.isEmpty()) {
            save.stream()
                    .filter(s -> Double.parseDouble(s.get(3)) > standard)
                    .forEach(s -> System.out.println(s.get(0) + s.get(2) + s.get(1) + " = " + s.get(3)));
        }
    }

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
                    result = Integer.valueOf((int) Math.pow(num1.intValue(), num2.intValue()));
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

    public void showArr() {
        if (save != null && !save.isEmpty()) {
            for (int i = 0; i < save.size(); i++) {
                System.out.println("[" + i + "] " + save.get(i).get(0) + save.get(i).get(2) + save.get(i).get(1) + " = " + save.get(i).get(3));
            }
        }
    }


    public enum OperatorType {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, REMAINDER, SQUARE
    }


    //해결한 문제
    //제네릭 사용 방안 (S T U)
    //result > 제네릭 문제
    //사칙연산 enum으로 변환하는 문제
    //실수와 정수를 모두 input으로 집어넣는 문제
    //list에 값이 int, double값이 들어가지 않는 문제(제네릭 때문)
    //정규표현식이 제대로 작동되지 않는 문제
}





