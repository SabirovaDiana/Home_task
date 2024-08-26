package dz_5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private String name;  // имя
    private int leftFork; // переменные определяющие какую вилку нужно брать
    private int rightFork;
    private int countEat; // совершенное кол-во приемов пищи
    private Random random;  // для генерации случайных значений, с засыпанием
    private CountDownLatch cdl; // кол-во всех фил.
    private Table table;  // стол


    // конструктор
    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl) {
        this.table = table;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        countEat = 0;
        random = new Random();
    }

    public void run(){

        while (countEat < 3){  // пока не поели 3 раза, то думаем-кушаем
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }

        System.out.println(name + " принят пищу ");
        cdl.countDown(); // как только вышли из цикла, то обьект cdl увеличивается на единицу
    }

    // берем мо мтола 2 вилки, если это успешно, то едим
    private void eating() throws InterruptedException{
        if (table.tryGetForks(leftFork, rightFork)) {
            System.out.println(name + " ест спагетти, используя вилки " + leftFork + " и " + rightFork);
            sleep(random.nextLong(3000), 6000);
            table.putForks(leftFork, rightFork);
            System.out.println(name + " покушал, можно и поспать " + "Не забыв при этом вернуть вилки " + leftFork + " и " + rightFork);
        countEat++;
        }
    }

    // спим
    private void thinking() throws InterruptedException {
        sleep(random.nextLong(180, 2000));
    }
}
