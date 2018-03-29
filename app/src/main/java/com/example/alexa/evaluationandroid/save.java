package com.example.alexa.evaluationandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexa on 29/03/2018.
 */

public class save extends AppCompatActivity
{
    private Button Save;
    private EditText edit;
    private Spinner spin;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);
        Save = findViewById(R.id.save);
        edit = findViewById(R.id.edit);
        spin = findViewById(R.id.spinner);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        list.add("Normal");
        list.add("High");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(save.this, MainActivity.class);
                intent.putExtra("valeur", edit.getText().toString());
                intent.putExtra("priority", spinner.getSelectedItem().toString());
                setResult(save.RESULT_OK, intent);
                finish();
            }
        });
    }
}
