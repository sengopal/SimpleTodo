package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String todo = getIntent().getStringExtra("todo");
        EditText txtView = (EditText) findViewById(R.id.edit_item);
        txtView.setText(todo);

        position = getIntent().getIntExtra("position", 0);

        Button saveBtn = (Button) findViewById(R.id.save_button);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = (EditText) findViewById(R.id.edit_item);
                Intent data = new Intent();
                data.putExtra("todo", etName.getText().toString());
                data.putExtra("position", position);
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes the activity, pass data to parent
            }
        });
    }
}
