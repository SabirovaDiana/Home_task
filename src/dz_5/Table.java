package dz_5;

import java.util.concurrent.CountDownLatch;
// инициализация обьектов
public class Table {
    private final int PHILOSOPHER_COUNT = 5;
    private Fork[] forks;
    private Philosopher[] philosophers;
    private CountDownLatch cdl;   // обьект cdl, чтобы понимать что все философы успешно поели

// в конструкторе идет инициализация обьектов
    public Table(){
    forks = new Fork[PHILOSOPHER_COUNT];
    philosophers = new Philosopher[PHILOSOPHER_COUNT];
    cdl = new CountDownLatch(PHILOSOPHER_COUNT);
    init();
    }
    
    public void run(){
        System.out.println("Начало обсуждения мудрецов ");
    try {
        thinkingProcess();
        cdl.await();
    } catch (InterruptedException e){
        throw new RuntimeException(e);
    }
        System.out.println("Все сыты ");
    }

    // метод, в котором мы пытаемся взять вилки
    public synchronized boolean tryGetForks(int leftFork, int rightFork){
        if(!forks[leftFork].getUsing() && !forks[rightFork].getUsing()){ // если одна вилка не взята и вторая тоже, то мы берем обе.        forks[leftFork].setUsing(true);
        forks[rightFork].setUsing(true);
        return true;
    }
    return false; // если одна из них занята, то false
    }

    // метод положить вилки
    public void putForks(int leftFork, int rightFork){
        forks[leftFork].setUsing(false);
        forks[rightFork].setUsing(false);
    }
    private void  init() {
        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            forks[i] = new Fork();
        }
        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            philosophers[i] = new Philosopher("Философ № " + i,this, i,(i + 1) %PHILOSOPHER_COUNT,cdl);

        }
    }
    private void thinkingProcess() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}

