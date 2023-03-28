package com.example.mobile_app;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvOutput, tvOutput2;
    private ListView history_output;
    private StringBuilder stringBuilder;
    private boolean isDecimalPressed;
    private double num1;
    private double num2;
    private double result;
    private int count = 0;
    private ArrayList<String> history_list = new ArrayList<>();
    private String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history_output = findViewById(R.id.history_output);
        history_output.setAdapter(history_output.getAdapter());
        Button history_button = findViewById(R.id.history_button);
        tvOutput = findViewById(R.id.tv_output);
        tvOutput2 = findViewById(R.id.tv_output2);
        Button btn_output2 = findViewById(R.id.btn_output2);

        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSubtract = findViewById(R.id.btn_subtract);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnDivide = findViewById(R.id.btn_divide);
        Button btnDecimal = findViewById(R.id.btn_decimal);
        Button btnEquals = findViewById(R.id.btn_equals);
        Button btnClear = findViewById(R.id.btn_clear);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btn_output2.setOnClickListener(this);
        history_button.setOnClickListener(this);

        stringBuilder = new StringBuilder();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                stringBuilder.append("0");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_1:
                stringBuilder.append("1");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_2:
                stringBuilder.append("2");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_3:
                stringBuilder.append("3");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_4:
                stringBuilder.append("4");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_5:
                stringBuilder.append("5");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_6:
                stringBuilder.append("6");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_7:
                stringBuilder.append("7");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_8:
                stringBuilder.append("8");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_9:
                stringBuilder.append("9");
                tvOutput.setText(stringBuilder.toString());
                break;
            case R.id.btn_add:
                operator = "+";
                num1 = Double.parseDouble(stringBuilder.toString());
                count = count + 1;
                stringBuilder.setLength(0);
                isDecimalPressed = false;
                break;
            case R.id.btn_subtract:
                operator = "-";
                num1 = Double.parseDouble(stringBuilder.toString());
                count = count + 1;
                stringBuilder.setLength(0);
                isDecimalPressed = false;
                break;
            case R.id.btn_multiply:
                operator = "x";
                num1 = Double.parseDouble(stringBuilder.toString());
                count = count + 1;
                stringBuilder.setLength(0);
                isDecimalPressed = false;
                break;
            case R.id.btn_divide:
                operator = "/";
                num1 = Double.parseDouble(stringBuilder.toString());
                count = count + 1;
                stringBuilder.setLength(0);
                isDecimalPressed = false;
                break;
            case R.id.btn_decimal:
                if (!isDecimalPressed) {
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("0");
                    }
                    stringBuilder.append(".");
                    tvOutput.setText(stringBuilder.toString());
                    isDecimalPressed = true;
                }
                break;
            case R.id.btn_equals:
                if (stringBuilder.length() > 0) {
                    num2 = Double.parseDouble(stringBuilder.toString());
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "x":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 == 0) {
                                tvOutput.setText("Cannot divide by zero");
                            } else {
                                result = num1 / num2;
                            }
                            break;
                    }
                    tvOutput.setText(String.valueOf(result));
                    stringBuilder.setLength(0);
                    stringBuilder.append(result);
                    String calculation = num1 + " " + operator + " " + num2 + " = " + result;
                    history_list.add(calculation);
                    isDecimalPressed = stringBuilder.indexOf(".") > 0;
                }
                break;
            case R.id.btn_clear:
                stringBuilder.setLength(0);
                isDecimalPressed = false;
                tvOutput.setText("");
                break;
            case R.id.btn_output2:
                tvOutput2.setText(String.valueOf(count));
                break;
            case R.id.history_button:
                showHistory();
                break;
        }
    }

    private void showHistory() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Calculation History");

        // Create a ListView to display the calculation history
        ListView listView = new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, history_list);
        listView.setAdapter(adapter);

        builder.setView(listView);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}