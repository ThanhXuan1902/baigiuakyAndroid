package com.example.checkboxmysun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
//import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    EditText txtInput;
    TextView txtTenThoiQuen;
    String thoiQuen;
    GridLayout gridLayout;
    int count;
    ArrayList<Integer> arrayNgay;
    LinearLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Init
        btnAdd = findViewById(R.id.btn_add);
        txtInput = findViewById(R.id.txt_input);
        txtTenThoiQuen = findViewById(R.id.txt_tenthoiquen);
        parent = findViewById(R.id.parent);

//        gridLayout = findViewById(R.id.grid_layout);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thoiQuen = txtInput.getText().toString();
                count = 0;
                txtTenThoiQuen.setText(thoiQuen + ":"+ " đã hoàn thành " +count+" ngày!");
                initTable();
                arrayNgay = new ArrayList<Integer>();

            }
        });
    }

    protected void initTable(){
        this.gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3);
        parent.addView(gridLayout);


        for(int i=0; i<21;i++){
            CheckBox checkBox = new CheckBox(this);
            gridLayout.addView(checkBox);

            int finalI = i;
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkBox.isChecked()){
                        arrayNgay.add(finalI);
//                        int dayCount = arrayNgay.size();
                        txtTenThoiQuen.setText(thoiQuen + " đã hoàn thành " + arrayNgay.size() +" ngày!");
                    }
                }
            });
        }
    }
}