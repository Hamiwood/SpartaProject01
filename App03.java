package Project01.SpartaProject01;

import java.util.Scanner;
import java.util.regex.Pattern;

// lv3 도전모드 계산기 만들기

public class App03 {
    public static void main(String[] args) {
        ArithmeticCalculator cal = new ArithmeticCalculator();
        ArithmeticCalculator.OperatorType type = null;
        Scanner sc = new Scanner(System.in);

        final String NUMBER_REG = "^[0-9]*$";//^[0-9]*$
        final String NUMBER_REG2 = "^[0-9]+(.)[0-9]{1,9}$";//^[0-9]+(.)?[0-9]{1,9}$
        String sel = "";

        while (!sel.equals("exit")) {
            System.out.println("연산자를 입력하세요");
            System.out.println("사칙연산(+ - * /), 나머지(%), 제곱(^)");
            String operator = sc.next();

            if (operator.equals("+")) {
                type = ArithmeticCalculator.OperatorType.ADD;
            } else if (operator.equals("-")) {
                type = ArithmeticCalculator.OperatorType.SUBTRACT;
            } else if (operator.equals("*")) {
                type = ArithmeticCalculator.OperatorType.MULTIPLY;
            } else if (operator.equals("/")) {
                type = ArithmeticCalculator.OperatorType.DIVIDE;
            } else if (operator.equals("%")) {
                type = ArithmeticCalculator.OperatorType.REMAINDER;
            } else if (operator.equals("^")) {
                type = ArithmeticCalculator.OperatorType.SQUARE;
            } else {
                System.out.println("경고!) 주어진 연산자(+ - * / % ^)를 입력하십시오");
                continue;
            }

            System.out.println("첫 번째 숫자를 입력하세요");
            String num1 = sc.next();
            if (Pattern.matches(NUMBER_REG, num1)) {
                cal.setNum1(Integer.parseInt(num1));
            } else if (Pattern.matches(NUMBER_REG2, num1)) {
                if (operator.equals("^")) {
                    System.out.println("경고!) 제곱은 실수를 사용할 수 없습니다");
                    continue;
                } else cal.setNum1(Double.parseDouble(num1));
            } else {
                System.out.println("경고!) 숫자의 입력이 잘못되었습니다");
                continue;
            }
            System.out.println("두 번째 숫자를 입력하세요");
            String num2 = sc.next();
            if (Pattern.matches(NUMBER_REG, num2)) {
                cal.setNum2(Integer.parseInt(num2));
            } else if (Pattern.matches(NUMBER_REG2, num2)) {
                if (operator.equals("^")) {
                    System.out.println("경고!) 제곱은 실수를 사용할 수 없습니다");
                    continue;
                } else cal.setNum2(Double.parseDouble(num2));
            } else {
                System.out.println("경고!) 숫자의 입력이 잘못되었습니다");
                continue;
            }
            if ((operator.equals("/") || operator.equals("%")) && cal.getNum2().equals(0)) {
                System.out.println("경고!) 0으로는 나눌 수 없습니다");
            } else {
                System.out.println("결과 값은 '" + cal.calculate(cal.getNum1(), cal.getNum2(), type) + "'입니다");
                System.out.println();
                System.out.println("-----현재까지의 계산 로그-----");
                cal.showArr();

                System.out.println();
                System.out.println("[로그 삭제] remove");
                System.out.println("[로그 전체 삭제] clear");
                System.out.println("[로그 검색] search");
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
                    case "search":
                        System.out.println("숫자를 입력하세요");
                        System.out.println("입력하신 숫자를 기준으로 큰 결과값을 도출한 로그를 출력합니다");
                        double standard = sc.nextDouble();
                        System.out.println("-----입력하신 '" + standard + "'보다 결과 값이 큰 로그입니다-----");
                        cal.interResult2(standard);
                        System.out.println();
                        continue;
                    case "exit":
                        sel = "exit";
                }

            }
        }
    }
}
