package ru.mirea.bookclub.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import ru.mirea.bookclub.databinding.BookListItemBinding;
import ru.mirea.bookclub.repository.room.models.Book;


public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookListHolder> {

    private List<Book> books;

    public BookListAdapter(List<Book> books) {

        this.books = books;
    }

    @NonNull
    @NotNull
    @Override
    public BookListHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        BookListItemBinding binding = BookListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BookListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookListHolder holder, int position) {
        holder.bookListItemBinding.bookTitleID.setText(books.get(position).getTitle());
        if (books.get(position).getAuthor() != null) {
            holder.bookListItemBinding.bookAuthor.setText(books.get(position).getAuthor());
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public List<Book> getBooks() {
        return books;
    }

    class BookListHolder extends RecyclerView.ViewHolder{
        BookListItemBinding bookListItemBinding;
        public BookListHolder(BookListItemBinding bookListItemBinding) {
            super(bookListItemBinding.getRoot());
            this.bookListItemBinding = bookListItemBinding;
        }
    }
}
