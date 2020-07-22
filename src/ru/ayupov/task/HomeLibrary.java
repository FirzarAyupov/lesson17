package ru.ayupov.task;

import java.util.List;
import java.util.Scanner;

/**
 * Есть набор объектов типа “Книга”. Каждая книга имеет название, автора, год издания. Можно больше, по желанию.
 * <p>
 * Программа должна уметь:
 * <p>
 * ● добавлять книгу в библиотеку. *
 * ● показывать список книг в библиотеке. *
 * ● восстанавливать содержимое библиотеки после перезапуска, используя ObjectInputStream/ObjectOutputStream. *
 * ● показывать соответствующее сообщение в случае ошибок.
 * <p>
 * Важно!
 * <p>
 * ● потоки обязательно должны закрываться *
 * ● отсутствие файла на диске - не ошибка, а частный случай пустой библиотеки.
 */

public class HomeLibrary {
    public static void main(String[] args) {

        List<Book> bookList = HomeLibraryData.loadData("library.dat");

        printBookList(bookList);

        Scanner sc = new Scanner(System.in);

        while (true) {
            mainMenu();
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1:
                        bookList.add(bookAdd());
                        break;
                    case 2:
                        printBookList(bookList);
                        break;
                    case 3:
                        HomeLibraryData.saveData(bookList, "library.dat");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Введено некорректное значение");
                        break;
                }
            } else {
                System.out.println("Введено некорректное значение");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("Меню:");
        System.out.println("1 - добавить книгу");
        System.out.println("2 - вывести список книг");
        System.out.println("3 - сохранить данные");
        System.out.println("4 - выход");
    }

    private static Book bookAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название книги");
        String name = sc.nextLine();
        System.out.println("Введите автора книги");
        String author = sc.nextLine();
        System.out.println("Введите дату публикации книги");
        String publicationDate = sc.nextLine();
        System.out.println("Введите количество страниц книги");
        String pageCount = sc.nextLine();

        return (new Book(name, author, publicationDate, pageCount));
    }

    private static void printBookList(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }


}
