package Project01.SpartaProject01;

import java.util.Scanner;
import java.util.regex.Pattern;

// Lv1 클래스 없이 기본적인 연산 수행하는 계산기

public class Calculator01 {

    private int num1, num2;
    private String operator;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator01 cal = new Calculator01();
        final String OPERATION_REG = "[+\\-*/]";
        final String NUMBER_REG = "^[0-9]*$";
        String exit = "";

        while (!exit.equals("exit")) {
            System.out.println("연산자를 입력하세요");
            System.out.println("사칙연산(+ - * /), 나머지(%), 제곱(^)");
            String operator = sc.next();
            if (Pattern.matches(OPERATION_REG, operator) || (operator.equals("^") || operator.equals("%"))) {
                cal.setOperator(operator);
            } else {
                System.out.println("경고!) 주어진 연산자(+ - * / % ^)를 입력하십시오");
                continue;
            }
            cal.setOperator(operator);
            System.out.println("첫 번째 숫자를 입력하세요");
            String num1 = sc.next();
            if (Pattern.matches(NUMBER_REG, num1)) {
                cal.setNum1(Integer.parseInt(num1));
            } else {
                System.out.println("경고!) 0을 포함한 양의 정수를 입력하십시오");
                continue;
            }
            System.out.println("두 번째 숫자를 입력하세요");
            String num2 = sc.next();
            if (Pattern.matches(NUMBER_REG, num2)) {
                cal.setNum2(Integer.parseInt(num2));
            } else {
                System.out.println("경고!) 0을 포함한 양의 정수를 입력하십시오");
                continue;
            }
            if ((cal.getOperator().equals("/") || cal.getOperator().equals("%")) && cal.getNum2() == 0) {
                System.out.println("경고!) 0으로는 나눌 수 없습니다");
            } else {
                System.out.println("결과 값은 '" + cal.calculate(cal.getNum1(), cal.getNum2(), cal.getOperator()) + "'입니다");
                System.out.println();
                System.out.println("exit를 입력하면 계산기가 종료됩니다");
                System.out.println("계속하려면 아무 값이나 입력하세요");
                exit = sc.next();
            }
        }
    }

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

    public int calculate(int num1, int num2, String operator) {

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "%":
                return num1 % num2;
            case "^":
                return (int) Math.pow(num1, num2);
            default:
                return 0;
        }
    }
}
