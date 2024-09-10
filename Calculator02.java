package Project01.SpartaProject01;

import java.util.ArrayList;
import java.util.Arrays;

// lv2 클래스 사용하여 계산기 만들기
public class Calculator02 {
    private int num1, num2;
    private String operator;
    private ArrayList<ArrayList<String>> save = new ArrayList<>();

    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public ArrayList<ArrayList<String>> getSave() {
        return save;
    }
    public void setSave(ArrayList<ArrayList<String>> save) {
        this.save = save;
    }

    public void addSave(int num1, int num2, String operator, double result) {
        save.add(new ArrayList<>(Arrays.asList(Integer.toString(num1), Integer.toString(num2), operator, Double.toString(result))));
    }

    //삭제
    public void removeSave(int index) {
        save.remove(index);
    }

    //모두 삭제
    public void clearSave() {
        save.clear();
    }

    public double calculate(int num1, int num2, String operator) {

        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                addSave(num1, num2, operator, result);
                return result;
            case "-":
                result = num1 - num2;
                addSave(num1, num2, operator, result);
                return result;
            case "*":
                result = num1 * num2;
                addSave(num1, num2, operator, result);
                return result;
            case "/":
                result = num1 / num2;
                addSave(num1, num2, operator, result);
                return result;
            case "%":
                result = num1 % num2;
                addSave(num1, num2, operator, result);
                return result;
            case "^":
                result = Math.pow(num1, num2);
                addSave(num1, num2, operator, result);
                return result;
            default:
                return 0;
        }
    }

    //전부 가져오기
    public void showArr() {
        if(save != null && !save.isEmpty()) {
            for (int i = 0; i < save.size(); i++) {
                System.out.println("["+i+"] "+save.get(i).get(0)+save.get(i).get(2)+save.get(i).get(1)+" = "+save.get(i).get(3));
            }
        }
    }

    //해결한 문제
    //arr에 값이 담기지 않는 문제
    //remove >> clear로 넘어가 전체 데이터가 삭제되는 문제
}
