package com.example.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAddColor;
    Button btnEditColor;
    Button btnRemoveColor;
    ListView lvColor;
    EditText etColor;
    EditText etIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddColor = findViewById(R.id.btnAddColor);
        btnEditColor = findViewById(R.id.btnEditColor);
        btnRemoveColor = findViewById(R.id.btnRemoveColor);
        lvColor=findViewById(R.id.lvColor);
        etColor=findViewById(R.id.etColor);
        etIndex=findViewById(R.id.etIndex);

        ArrayList<String> colorArray = new ArrayList<String>();
        colorArray.add("Orange");
        colorArray.add("Red");
        ArrayAdapter aaColor = new ArrayAdapter(this, android.R.layout.simple_list_item_1,colorArray);
        lvColor.setAdapter(aaColor);

        btnAddColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addColor = etColor.getText().toString();
                if(etIndex.getText().toString().isEmpty()) {
                    colorArray.add(addColor);
                }else {
                    int addindex = Integer.parseInt(etIndex.getText().toString());
                    colorArray.add(addindex, addColor);
                }
                aaColor.notifyDataSetChanged();
            }
        });

        btnRemoveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etIndex.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter Index Please",Toast.LENGTH_LONG).show();
                }else{
                    colorArray.remove(Integer.parseInt(etIndex.getText().toString()));
                }
                aaColor.notifyDataSetChanged();
            }
        });

        btnEditColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String setColor = etColor.getText().toString();
                if(etIndex.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter Index Please",Toast.LENGTH_LONG).show();
                }else{
                    int setindex = Integer.parseInt(etIndex.getText().toString());
                    colorArray.set(setindex, setColor);
                }
                aaColor.notifyDataSetChanged();
            }
        });

        lvColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                etColor.setText(colorArray.get(position));
                etIndex.setText(String.valueOf(position));
            }
        });


    }
}