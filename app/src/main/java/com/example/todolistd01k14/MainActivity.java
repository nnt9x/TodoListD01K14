package com.example.todolistd01k14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvTodos;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> todos;

    private TodoDialog todoDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bind Id
        lvTodos = findViewById(R.id.lv_todos);
        // Fake du lieu
        todos = new ArrayList<>();
        todos.add("1. Đi chợ ");
        todos.add("2. Đi làm ");
        // Tao adapter
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todos);
        // Set Adapter cho listview
        lvTodos.setAdapter(arrayAdapter);
    }

    public void showDialogCreateTodo(View view) {
        // Tao dialogTodo
        if(todoDialog == null){
            todoDialog = new TodoDialog(this) {
                @Override
                public void newTodo(String todo) {
                    todos.add(todo);
                    // Thong bao adapter biet du lieu thay doi
                    arrayAdapter.notifyDataSetChanged();
                }
            };
        }

        // Show dialogTodo
        todoDialog.show();
    }
}