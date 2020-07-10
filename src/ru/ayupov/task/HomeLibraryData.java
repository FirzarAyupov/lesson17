package ru.ayupov.task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HomeLibraryData {

    static void saveData(List<Book> bookList, String fileName) {
        if (!bookList.isEmpty()) {
            try (OutputStream os = new FileOutputStream(fileName);
                 ObjectOutputStream oos = new ObjectOutputStream(os)) {
                oos.writeObject(bookList);
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Не сохранено! Список пуст!");
        }
    }

    static List<Book> loadData(String fileName) {
        if (new File(fileName).exists()) {
            try (InputStream is = new FileInputStream(fileName);
                 ObjectInputStream ois = new ObjectInputStream(is)) {
                return (List<Book>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }
        System.out.println("В библиотеке отсутствуют книги");
        return new ArrayList<>();
    }
}
