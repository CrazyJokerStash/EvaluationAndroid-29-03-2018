package com.example.alexa.evaluationandroid;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Intent data;
    private ListView List;
    private Button ajout;
    private CheckBox CB;
    private ArrayList<String> tab = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List = findViewById(R.id.list);
        ajout = findViewById(R.id.add);
        CB = findViewById(R.id.check);
        tab.add("Aller faire les courses");
        tab.add("Aller chercher son fils");
        data = getIntent();
        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, save.class);
                startActivityForResult(intent, 123);
            }
        });
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, tab);
        List.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123) {
            if (resultCode == save.RESULT_OK) {
                String value = data.getExtras().getString("valeur");
                String priority = data.getExtras().getString("priority");
                if (value != null)
                    tab.add(value);
                if (priority.equals("High"))
                {
                    List.setBackgroundColor(Color.RED);
                }
            }
        }
    }
}
