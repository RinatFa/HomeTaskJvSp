package org._811286;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final String FILE_JSON = "person.json";

        Person person = new Person("Алексей", "Орлов", 35);
        Person person2 = new Person("Алексей", "Орлов", 35);
        Person person3 = new Person("Алексей", "Орлов", 45);
        Person person4 = new Person("Григорий", "Орлов", 45);
        Person person5;

        PersonApp.saveToFile(FILE_JSON, person);

        File file = new File(FILE_JSON);
        if (file.exists() && !file.isDirectory()) {
            person5 = PersonApp.loadFromFile(FILE_JSON);
            System.out.print("*** from FILE_JSON:\n");
            PersonApp.displayPerson(person5);
        }

        System.out.println();
        System.out.println("toString: " + person.toString());
        System.out.print("Сравнения с 3 объектами: " + person.equals(person2));
        System.out.print(", " + person.equals(person3));
        System.out.println(", " + person.equals(person4));
        System.out.print("hashCode 3 объектов (" + +person.hashCode() + "): ");
        System.out.print("= " + person2.hashCode());
        System.out.print(", " + person3.hashCode());
        System.out.println(", " + person4.hashCode());
    }
}
