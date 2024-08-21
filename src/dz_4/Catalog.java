package dz_4;

/*Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри
коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник*/

import java.util.*;


public class Catalog {

    ArrayList<Employee> list;  // список с сотрудниками

    Catalog(){
        list = new ArrayList<>();
    }

    // Добавить метод, который ищет сотрудника по стажу из списка
    public void SearchByExperience(int experience){
        for (Employee employee : list) {
            if (employee.getExperience() == experience) {
                System.out.println(employee.toString());
            }
        }
    }

    //  метод, который возвращает номер телефона сотрудника по имени
    public void SearchByName(String name){
        for (Employee employee : list) {
            if (Objects.equals(employee.getName(), name)) {
                System.out.println(employee.getPhone_number());
            }
        }
    }
    // метод, который ищет сотрудника по табельному номеру
    public void SearchById(int id){
        for (Employee employee : list) {
            if (employee.getId() == id) {
                System.out.println(employee.toString());
            }
        }
    }

    // Добавить метод добавления нового сотрудника в справочник

    public void newEmployee(int id, String phone_number, String name, int experience){
        list.add(new Employee(id, phone_number, name, experience));
    }

    public void add(Employee e1) {
        list.add(e1);
    }
// возврат нового(последнего) сотрудика
    public Employee getLast() {
        return list.getLast();
    }
}