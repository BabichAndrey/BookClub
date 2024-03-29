package ru.mirea.bookclub.repository.room.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int bookId;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private String author;
    @ColumnInfo
    private String type;
    public Book(String title, String description, String author,String type) {
        this.title = title;
        this.description = description;
        this.author = author;

        this.type = type;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
    public String getAuthor() {
        return author;
    }

}
