package task_1;

public class Main {

public static void main(String[] args) {
    // Примеры использования
    int intSumResult = (int) Calculator.sum(5, 3);
    double doubleDivideResult = Calculator.divide(17.8, 2.7);
    int intSubtractResult = (int) Calculator.subtract(25, 5);
    double doubleMultiplyResult = Calculator.multiply(3, 650);

    System.out.println("Сумма: " + intSumResult);
    System.out.println("Результат деления: " + doubleDivideResult);
    System.out.println("Разность: " + intSubtractResult);
    System.out.println("Произведение: " + doubleMultiplyResult);//
}
}
