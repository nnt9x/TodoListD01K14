package com.example.todolistd01k14;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public abstract class TodoDialog extends Dialog {

    private EditText edtTodo;
    private Button btnYes, btnCancel;

    public TodoDialog(@NonNull Context context) {
        super(context);
    }

    // lat gui ve noi tai dialog
    public abstract void newTodo(String todo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_create_todo);

        // BInd Id
        edtTodo = findViewById(R.id.edt_dialog_todo);
        btnYes = findViewById(R.id.btn_dialog_yes);
        btnCancel = findViewById(R.id.btn_dialog_cancel);

        // Su kien onClick
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // An dialog
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lay du lieu tu editText
                String content = edtTodo.getText().toString();
                if(content.isEmpty()){
                    edtTodo.setError("Empty!");
                    return;
                }
                newTodo(content);
                dismiss();
            }
        });
    }

    @Override
    public void dismiss() {
        super.dismiss();
        edtTodo.setText("");
    }
}
