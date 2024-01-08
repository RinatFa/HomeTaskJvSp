package org._811286;

import com.google.gson.Gson;

import java.io.*;

public class PersonApp {
    private static final Gson gson = new Gson();

    public static void saveToFile(String fileName, Person person) {
        System.out.println();
        String jsonString = gson.toJson(person);
        System.out.println("*** to FILE_JSON:\n" + jsonString);
        System.out.println();
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(jsonString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person loadFromFile(String fileName) {
        Person person = new Person();
        File file = new File(fileName);
        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(fileName);
                 InputStreamReader streamReader = new InputStreamReader(fileInputStream)) {
                person = gson.fromJson(streamReader, Person.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return person;
    }

    public static void displayPerson(Person person) {
        System.out.println("Имя: " + person.getFirstName());
        System.out.println("Фамилия: " + person.getLastName());
        System.out.println("Возраст: " + person.getAge());
    }
}
