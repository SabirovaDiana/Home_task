package task_3;
/*
    3.Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
     Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары, а также переопределение метода toString(),
     возвращающее строковое представление пары. Работу сдать в виде ссылки на гит репозиторий.*/

public class Pair_main<T, U> {
    private T first;
    private U second;

    public Pair_main(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Pair_main<Integer, String> pair1 = new Pair_main<>(17, "first");
        Pair_main<Double, Boolean> pair2 = new Pair_main<>(3.14, true);

        System.out.println("Pair 1: " + pair1.toString());
        System.out.println("First value of Pair 2: " + pair2.getFirst());
        System.out.println("Second value of Pair 2: " + pair2.getSecond());
    }
}

//