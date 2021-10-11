package ru.mirea.bookclub.view;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import ru.mirea.bookclub.databinding.BookAddFragmentBinding;
import ru.mirea.bookclub.repository.room.models.Book;
import ru.mirea.bookclub.viewmodel.AddBookViewModel;


public class AddBook extends Fragment {

    private AddBookViewModel addBookViewModel;
    private BookAddFragmentBinding bookAddFragmentBinding;


    public static AddBook newInstance() {
        return new AddBook();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        bookAddFragmentBinding = BookAddFragmentBinding.inflate(getLayoutInflater(), container, false);

        bookAddFragmentBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack();
            }
        });
        bookAddFragmentBinding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bookAddFragmentBinding.bookTitle.getText().toString().isEmpty()) {
                    addBookViewModel.addBook(new Book(bookAddFragmentBinding.bookTitle.getText().toString()
                            ,bookAddFragmentBinding.bookDescription.getText().toString()
                            ,bookAddFragmentBinding.bookAuthor.getText().toString()
                            ,bookAddFragmentBinding.bookType.getText().toString())
                    );
                    Navigation.findNavController(v).popBackStack();
                } else {
                    Toast.makeText(getContext(), "Не все обязательные поля заполнены", Toast.LENGTH_LONG).show();
                }
            }
        });





        return bookAddFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addBookViewModel = new ViewModelProvider(this).get(AddBookViewModel.class);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bookAddFragmentBinding = null;
        addBookViewModel = null;
    }
}
