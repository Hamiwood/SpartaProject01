package Project01.SpartaProject01;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.Math;

public class Calculator01 {

    private double num1, num2;
    private String operator;

    public double getNum1() {
        return num1;
    }
    public void setNum1(double num1) {
        this.num1 = num1;
    }
    public double getNum2() {
        return num2;
    }
    public void setNum2(double num2) {
        this.num2 = num2;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate(double num1, double num2, String operator) {

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
                return Math.pow(num1, num2);
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator01 cal = new Calculator01();
        final String OPERATION_REG = "[+\\-*/]";
        final String NUMBER_REG = "^[0-9]*$";
        String exit = "";

        while(!exit.equals("exit")){
            System.out.println("연산자를 입력하세요");
            System.out.println("사칙연산(+ - * /), 나머지(%), 제곱(^)");
            String operator = sc.next();
                if(Pattern.matches(OPERATION_REG, operator)||(operator.equals("^")||operator.equals("%"))){
                    cal.setOperator(operator);
                }else {
                    System.out.println("경고!) 주어진 연산자(+ - * / % ^)를 입력하십시오");
                    continue;
                }
            cal.setOperator(operator);
            System.out.println("첫 번째 숫자를 입력하세요");
                String num1 = sc.next();
                if(Pattern.matches(NUMBER_REG, num1)){
                    cal.setNum1(Double.parseDouble(num1));
                }else {
                    System.out.println("경고!) 0을 포함한 양의 정수를 입력하십시오");
                    continue;
                }
            System.out.println("두 번째 숫자를 입력하세요");
                String num2 = sc.next();
                if(Pattern.matches(NUMBER_REG, num2)){
                    cal.setNum2(Double.parseDouble(num2));
                }else {
                    System.out.println("경고!) 0을 포함한 양의 정수를 입력하십시오");
                    continue;
                }
            if((cal.getOperator().equals("/")||cal.getOperator().equals("%"))&&cal.getNum2()==0){
                System.out.println("경고!) 0으로는 나눌 수 없습니다");
            }else{
                System.out.println("결과 값은 '"+Math.round(cal.calculate(cal.getNum1(), cal.getNum2(), cal.getOperator()))+"'입니다");
                System.out.println();
                System.out.println("exit를 입력하면 계산기가 종료됩니다");
                System.out.println("계속하려면 아무 값이나 입력하세요");
                exit = sc.next();
            }

            //해결한 문제
            //1) 잘못된 값을 입력해도 계속 다음의 INPUT을 띄우는 문제
            //2) NUM 값 문자 입력 시 오류가 뜨는 문제
            //3) DOUBLE로 바꾸었더니 소수점이 드러나는 문제
            //4) 1)과 연계됨 >> 모든 값을 받고 이상한 값을 리턴하는 문제
            //EX # 4 M >> 4가 나옴
        }
    }
}
