package ru.ayupov.task;

import java.io.Serializable;

public class Book implements Serializable {
    public static final long serialVersionUID = 12L;
    protected String name;
    protected String author;
    protected String publicationDate;
    protected String pageCount;

    public Book(String name, String author, String publicationDate, String pageCount) {
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return name + ", " +
                "автор " + author + ", " +
                "год издания " + publicationDate + ", " +
                pageCount + " стр.";
    }
}
