package dz_4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Catalog c1 = new Catalog(); // создание каталога
        Employee e1 = new Employee(1,"71234567890","Мария",1); // создание новых сотрудников
        Employee e2 = new Employee(2,"72345678901","Андрей",2);
        Employee e3 = new Employee(3,"73456789012","Виталий",6);
        Employee e4 = new Employee(4,"74567890123", "Елена", 9);
        c1.add(e1); // добавление сотрудников в каталог
        c1.add(e2);
        c1.add(e3);
        c1.add(e4);
        c1.SearchByExperience(9); // поиск по опыту
        System.out.println("");
        c1.SearchByName("Виталий"); // поиск по имени
        System.out.println("");
        c1.SearchById(1); // поиск по табельному номеру
        System.out.println("");
        c1.newEmployee(5,"75678901234","Павел",4); // добавление нового сотррудника
        System.out.println(c1.getLast().toString());
    }
}