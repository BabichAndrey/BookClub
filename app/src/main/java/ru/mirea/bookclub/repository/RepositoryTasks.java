package ru.mirea.bookclub.repository;


import androidx.lifecycle.LiveData;

import ru.mirea.bookclub.repository.room.models.Book;

import java.util.List;

public interface RepositoryTasks {
    LiveData<List<Book>> getAllBooks();
    void addBook(Book book);
    void deleteBook(Book book);
    void deleteAllBooks();
}
