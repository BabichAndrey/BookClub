package ru.mirea.bookclub.view;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.bookclub.R;
import ru.mirea.bookclub.repository.Repository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository.init(getApplication());
    }
}