package Project01.SpartaProject01;

import java.util.Scanner;
import java.util.regex.Pattern;

//Lv2 클래스 사용하여 계산기 만들기

public class App02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator02 cal = new Calculator02();
        final String OPERATION_REG = "[+\\-*/]";
        final String NUMBER_REG = "^[0-9]*$";
        String sel = "";

        while (!sel.equals("exit")) {
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
                System.out.println("-----현재까지의 계산 로그-----");
                cal.showArr();

                System.out.println();
                System.out.println("[로그 삭제] remove");
                System.out.println("[로그 전체 삭제] clear");
                System.out.println("[계산기 종료] exit");
                System.out.println("계속 계산하려면 아무 값이나 입력하세요.");
                sel = sc.next();

                switch (sel) {
                    case "remove":
                        System.out.println("-----계산 로그-----");
                        cal.showArr();
                        System.out.println();
                        System.out.println("삭제하실 로그의 번호를 입력하십시오");
                        String input = sc.next();
                        if (Pattern.matches(NUMBER_REG, input) && (cal.getSave().size() > Integer.parseInt(input))) {
                            cal.removeSave(Integer.parseInt(input));
                            System.out.println("-----계산 로그-----");
                            cal.showArr();
                            continue;
                        } else {
                            System.out.println("경고! 입력하신 것이 숫자가 아니거나, 삭제가 가능한 번호가 아닙니다.");
                            System.out.println();
                            continue;
                        }
                    case "clear":
                        cal.clearSave();
                        System.out.println("--모든 로그가 삭제되었습니다!--");
                        System.out.println();
                        continue;
                    case "exit":
                        sel = "exit";
                }

            }
        }
    }
}
