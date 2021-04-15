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
    ArrayList<Integer> mangNgay;
    LinearLayout layoutCha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btn_add);
        txtInput = findViewById(R.id.txt_input);
        txtTenThoiQuen = findViewById(R.id.txt_tenthoiquen);
        layoutCha = findViewById(R.id.parent);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thoiQuen = txtInput.getText().toString();
                count = 0;
                txtTenThoiQuen.setText(thoiQuen + ":"+ " đã hoàn thành " +count+" ngày!");
                khoitaotextbox();
                mangNgay = new ArrayList<Integer>();
            }
        });
    }

    protected void khoitaotextbox(){
        //  Sửa text
        this.gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3);
        layoutCha.addView(gridLayout);

        // Tạo 21 Checkbox
        for(int i=0; i<21;i++){
            CheckBox checkBox = new CheckBox(this);
            checkBox.setPadding(30, 30, 30,30);
            gridLayout.addView(checkBox);

            int finalI = i;
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkBox.isChecked()){
                        mangNgay.add(finalI);
                        txtTenThoiQuen.setText(thoiQuen + " đã hoàn thành " + mangNgay.size() +" ngày!");
                    }
                }
            });
        }
    }
}